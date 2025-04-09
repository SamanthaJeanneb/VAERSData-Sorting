import java.io.*;
import java.util.*;

public class SymptomFilter {

    private static List<SYMPTOMDATA> symptomDataList = new ArrayList<>();


    public static void processSymptomData(String inputFile, String outputFile) {
        extractSymptomsFromVAERS(inputFile);
        writeSymptomDataToCSV(outputFile);
    }

    public static void Task3Sort(String outputFile) {
        symptomDataList.sort(Comparator
                .comparing(SYMPTOMDATA::getAgeGroup)
                .thenComparing(SYMPTOMDATA::getSEX, Comparator.nullsLast(String::compareTo))
                .thenComparing(SYMPTOMDATA::getVAX_NAME, Comparator.nullsLast(String::compareTo))
                .thenComparing(SYMPTOMDATA::getSYMPTOM, Comparator.nullsLast(String::compareTo))
        );

        Map<String, HashSet<Integer>> deathsByAgeGroup = new HashMap<>(); //Map instead of counting unique instance, no duplicates

        for (SYMPTOMDATA s : symptomDataList) {
            if ("Y".equalsIgnoreCase(s.getDIED())) {
                String ageGroup = s.getAgeGroup();
                int vaersId = s.getVAERS_ID();
                deathsByAgeGroup.putIfAbsent(ageGroup, new HashSet<>());
                deathsByAgeGroup.get(ageGroup).add(vaersId);
            }
        }

        System.out.println("Death counts per age group:");
        for (Map.Entry<String, HashSet<Integer>> entry : deathsByAgeGroup.entrySet()) {
            System.out.println("Age Range:  " + entry.getKey() + " |  Deaths: " + entry.getValue().size());
        }

        writeSymptomDataToCSV(outputFile);
        System.out.println(outputFile +" Created, Task 3 done, Number of Symptom data: " + symptomDataList.size());
    }

    public static void extractSymptomsFromVAERS(String inputFile) {
        symptomDataList.clear();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length < 51) continue;

                try {
                    int vaersId = Integer.parseInt(values[0]);
                    int ageYrs = parseInt(values[3]);
                    String sex = values[6];
                    String vaxName = values[41];
                    String rptDate = values[7];
                    String died = values[9];
                    String dateDied = values[10];
                    String symptomtext = values[8];

                    String[] symptoms = {values[42], values[44], values[46], values[48], values[50]};

                    for (String symptom : symptoms) {
                        if (!symptom.isEmpty()) {
                            symptomDataList.add(new SYMPTOMDATA(vaersId, ageYrs, sex, vaxName, rptDate, symptom, died, dateDied, symptomtext));
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading VAERS file: " + e.getMessage());
        }
    }

    public static void writeSymptomDataToCSV(String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("VAERS_ID,AGE_YRS,SEX,VAX_NAME,RPT_DATE,SYMPTOM,DIED,DATEDIED,SYMPTOM_TEXT");
            writer.newLine();

            for (SYMPTOMDATA symptomData : symptomDataList) {
                writer.write(symptomData.toCSVString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error extracting symptom data" + e.getMessage());
        }
    }

    private static int parseInt(String value) {
        try {
            return (int) Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long scrambleSort(String inputFile, String outputFile, String outputfile2) {
        extractSymptomsFromVAERS(inputFile);
        Collections.shuffle(symptomDataList);

        Scanner s = new Scanner(System.in);
        System.out.print("number of elements to sort: ");
        int x = s.nextInt();
        s.nextLine();
         symptomDataList = symptomDataList.subList(0, x);
        writeSymptomDataToCSV(outputFile);
        System.out.println("Which sorting algorithm?");
        String sorting = s.nextLine();
        long startTime = System.nanoTime();
        if (sorting.equalsIgnoreCase("I")) {
            sortByInsertionSort();
        } else if (sorting.equalsIgnoreCase("Q")) {
            sortByQuickSort();
        } else if (sorting.equalsIgnoreCase("M")) {
            sortByMergeSort();
        }
        long endTime = System.nanoTime();
        writeSymptomDataToCSV(outputfile2);
        long elapsedTimeMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Sorting took: " + elapsedTimeMillis + " ms");

        return elapsedTimeMillis;
    }

    public static void sortByInsertionSort() {
        for (int i = 1; i < symptomDataList.size(); i++) {
            SYMPTOMDATA key = symptomDataList.get(i);
            int j = i - 1;
            while (j >= 0 && symptomDataList.get(j).getVAERS_ID() > key.getVAERS_ID()) {
                symptomDataList.set(j + 1, symptomDataList.get(j));
                j = j - 1;
            }
            symptomDataList.set(j + 1, key);
        }
        System.out.println("Sorted using Insertion Sort");
    }

    public static void sortByQuickSort() {
        quickSort(0, symptomDataList.size() - 1);
        System.out.println("Sorted using Quick Sort");
    }

    private static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    //random pivot
    private static int partition(int low, int high) {
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        Collections.swap(symptomDataList, randomIndex, high);

        SYMPTOMDATA pivot = symptomDataList.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (symptomDataList.get(j).getVAERS_ID() < pivot.getVAERS_ID()) {
                i++;
                Collections.swap(symptomDataList, i, j);
            }
        }
        Collections.swap(symptomDataList, i + 1, high);
        return i + 1;
    }

    public static void sortByMergeSort() {
        mergeSort(0, symptomDataList.size() - 1);
        System.out.println("Sorted using Merge Sort");
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<SYMPTOMDATA> leftList = new ArrayList<>(n1);
        List<SYMPTOMDATA> rightList = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftList.add(symptomDataList.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(symptomDataList.get(mid + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getVAERS_ID() <= rightList.get(j).getVAERS_ID()) {
                symptomDataList.set(k, leftList.get(i));
                i++;
            } else {
                symptomDataList.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            symptomDataList.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            symptomDataList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}

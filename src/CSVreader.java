import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVreader {

    public static void processVAERSFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        List<VAERSData> vaersDataList = new ArrayList<>();
        List<VAERSSYMPTOMS> vaersSymptomsList = new ArrayList<>();
        List<VAERSVAX> vaersVaxList = new ArrayList<>();

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String filePath = file.getAbsolutePath();

                if (fileName.endsWith("A.csv")) {
                    vaersDataList.addAll(readVAERSData(filePath));
                } else if (fileName.endsWith("S.csv")) {
                    vaersSymptomsList.addAll(readVAERSSYMPTOMS(filePath));
                } else if (fileName.endsWith("X.csv")) {
                    vaersVaxList.addAll(readVAERSVax(filePath));
                }
            }
        }
        covidFilter("VAERS_COVID_DataDecember2024", vaersVaxList, vaersDataList, vaersSymptomsList);
    }

    public static void covidFilter(String outputFile, List<VAERSVAX> vaersVaxList, List<VAERSData> vaersDataList, List<VAERSSYMPTOMS> vaersSymptomsList) {
       //set to remove dups
        Set<Integer> covidVaersIds = new HashSet<>();
        for (VAERSVAX vaersVax : vaersVaxList) {
            if (vaersVax.VAX_NAME.toUpperCase().contains("COVID")) {
                covidVaersIds.add(vaersVax.VAERS_ID);
            }
        }

        System.out.println("Covid vaers: " + covidVaersIds.size());
        Map<Integer, VAERSData> dataMap = new HashMap<>();
        for (VAERSData d : vaersDataList) {
            dataMap.put(d.VAERS_ID, d);
        }

        Map<Integer, VAERSVAX> vaxMap = new HashMap<>();
        for (VAERSVAX v : vaersVaxList) {
            vaxMap.put(v.VAERS_ID, v);
        }

        Map<Integer, VAERSSYMPTOMS> symptomsMap = new HashMap<>();
        for (VAERSSYMPTOMS s : vaersSymptomsList) {
            symptomsMap.put(s.VAERS_ID, s);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("VAERS_ID,RECVDATE,STATE,AGE_YRS,CAGE_YR,CAGE_MO,SEX,RPT_DATE,SYMPTOM_TEXT,DIED,DATEDIED,L_THREAT,ER_VISIT,HOSPITAL,HOSPDAYS,X_STAY,DISABLE,RECOVD,VAX_DATE,ONSET_DATE,NUMDAYS,LAB_DATA,V_ADMINBY,V_FUNDBY,OTHER_MEDS,CUR_ILL,HISTORY,PRIOR_VAX,SPLTTYPE,FORM_VERS,TODAYS_DATE,BIRTH_DEFECT,OFC_VISIT,ER_ED_VISIT,ALLERGIES,VAX_TYPE,VAX_MANU,VAX_LOT,VAX_DOSE_SERIES,VAX_ROUTE,VAX_SITE,VAX_NAME,SYMPTOM1,SYMPTOM2,SYMPTOM3,SYMPTOM4,SYMPTOM5,SYMPTOMVERSION,SYMPTOMVERSION2,SYMPTOMVERSION3,SYMPTOMVERSION4,SYMPTOMVERSION5");
            writer.newLine();

            for (Integer vaersId : covidVaersIds) {
                VAERSData data = dataMap.getOrDefault(vaersId, new VAERSData(vaersId, "", "", 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",""));
                VAERSVAX vax = vaxMap.getOrDefault(vaersId, new VAERSVAX(vaersId, "", "", "", "", "", "", ""));
                VAERSSYMPTOMS symptoms = symptomsMap.getOrDefault(vaersId, new VAERSSYMPTOMS(vaersId, "", "", "", "", "", "", "", "", "", ""));

                writer.write(vaersId + "," + data.toCSVString() + "," + vax.toCSVString() + "," + symptoms.toCSVString());
                writer.newLine();
            }

            System.out.println("Task 1 complete B)");
        } catch (IOException e) {
            System.err.println("Error in task 1 - creating CSV: " + e.getMessage());
        }
    }
    public static List<VAERSData> readVAERSData(String filepath) {
        List<VAERSData> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length < 35) continue;

                try {
                    int vaersId = Integer.parseInt(values[0]);
                    VAERSData record = new VAERSData(vaersId, values[1], values[2], parseInt(values[3]), values[4],
                            values[5], values[6], values[7], values[8], values[9], values[10],
                            values[11], values[12], values[13], values[14], values[15],
                            values[16], values[17], values[18], values[19],
                            values[20], values[21], values[22], values[23], values[24],
                            values[25], values[26], values[27], values[28], values[29],
                            values[30], values[31], values[32],values[33], values[34]
                    );
                    records.add(record);
                } catch (Exception e) {
                    System.err.println("Skipping malformed VAERSData line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading VAERSData file: " + e.getMessage());
        }
        return records;
    }

    public static List<VAERSSYMPTOMS> readVAERSSYMPTOMS(String filepath) {
        List<VAERSSYMPTOMS> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length < 11) continue;

                try {
                    int vaersId = Integer.parseInt(values[0]);
                    VAERSSYMPTOMS record = new VAERSSYMPTOMS(vaersId, values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10]);
                    records.add(record);
                } catch (Exception e) {
                    System.err.println("Skipping malformed VAERSSYMPTOMS line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading VAERSSYMPTOMS file: " + e.getMessage());
        }
        return records;
    }

    public static List<VAERSVAX> readVAERSVax(String filepath) {
        List<VAERSVAX> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length < 7) continue;

                try {
                    VAERSVAX record = new VAERSVAX(
                            parseInt(values[0]), values[1], values[2], values[3],
                            values[4], values[5], values[6], values[7]
                    );
                    records.add(record);
                } catch (Exception e) {
                    System.err.println("Skipping malformed VAERSVAX line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading VAERSVAX file: " + e.getMessage());
        }
        return records;
    }

    private static int parseInt(String value) {
        try {
            return (int) Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

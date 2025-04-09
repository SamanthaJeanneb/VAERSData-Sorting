
/*
    Samantha J. Brown
    CSC 365 Project 1

 */
public class Main {
    public static void main(String[] args) {
        String path = "C:/Users/samra/Documents/Programming Project 1 365/CSVs";
        CSVreader.processVAERSFiles(path);
        String inputFile = "C:/Users/samra/Documents/Programming Project 1 365/VAERS_COVID_DataDecember2024";
        String task3File = "SYMPTOMDATA.csv";
        String outputFile = "SYMPTOMDATAUnsorted.csv";
        String outputFile2 = "SYMPTOMDATAsorted.csv";
        SymptomFilter.scrambleSort(inputFile, outputFile, outputFile2);

       // SymptomFilter.processSymptomData(inputFile, outputFile);
        SymptomFilter.Task3Sort(task3File);

    }
}
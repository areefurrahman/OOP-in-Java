import java.io.*;
import java.util.*;
public class csvreader {
    
    public static void main(String[] args) {
        String inputFilePath = "input.csv"; // Path to the input CSV file
        String outputFilePath = "output.csv"; // Path to the output CSV file

        try {
            // Read input CSV file
            List<String[]> submissions = readCSV(inputFilePath);

            // Write processed data to output CSV file
            writeCSV(outputFilePath, submissions);

            System.out.println("CSV processing completed. Output written to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }

    // Method to read the input CSV file
    private static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> submissions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by '~' to get individual fields
                String[] fields = line.split("~");
                submissions.add(fields);
            }
        }
        return submissions;
    }

    // Method to write the processed data to the output CSV file
    private static void writeCSV(String filePath, List<String[]> submissions) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header row
            bw.write("Time Range,Name,Second Name,Email,Phone,Service,Details");
            bw.newLine();

            // Process each submission and write to the output file
            for (String[] fields : submissions) {
                Map<String, String> submissionData = parseSubmission(fields);
                bw.write(
                        submissionData.get("Time Range") + "," +
                        submissionData.get("Name") + "," +
                        submissionData.get("Second Name") + "," +
                        submissionData.get("Email") + "," +
                        submissionData.get("Phone") + "," +
                        submissionData.get("Service") + "," +
                        submissionData.get("Details")
                );
                bw.newLine();
            }
        }
    }

    // Method to parse a submission and extract relevant data
    private static Map<String, String> parseSubmission(String[] fields) {
        Map<String, String> submissionData = new HashMap<>();
        for (String field : fields) {
            String[] parts = field.split("\\^");
            if (parts.length >= 3) {
                String key = parts[0] + "^" + parts[1];
                String value = parts[2];
                switch (key) {
                    case "selectbox-one^rangetime_val1":
                        submissionData.put("Time Range", value);
                        break;
                    case "text^name_val1":
                        submissionData.put("Name", value);
                        break;
                    case "text^secondname_val1":
                        submissionData.put("Second Name", value);
                        break;
                    case "email^email_val1":
                        submissionData.put("Email", value);
                        break;
                    case "text^phone_val1":
                        submissionData.put("Phone", value.isEmpty() ? "N/A" : value);
                        break;
                    case "selectbox-one^services_val1":
                        submissionData.put("Service", value);
                        break;
                    case "textarea^details_val1":
                        submissionData.put("Details", value);
                        break;
                }
            }
        }
        return submissionData;
    }
}
package utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class ToCSV {
    public void toCSV(List<String[]> leaders) throws IOException {

        // Set path for CSV file
        String fileName = "src/main/resources/leaders.csv";

        // Create new CSV writer
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));

        // Create and write string array for headers
        String[] headers = {"Name", "Position", "Description"};
        writer.writeNext(headers);

        // Write list of leadership info to CSV file
        writer.writeAll(leaders);

        // Close writer
        writer.close();
    }
}

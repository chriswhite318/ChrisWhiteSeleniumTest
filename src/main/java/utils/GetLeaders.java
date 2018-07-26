package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetLeaders {
    public void getLeaders(WebDriver driver) throws IOException {
        String description;
        String name;
        String position;

        DescriptionCleanup descripCleaner = new DescriptionCleanup();
        List<String[]> leaders = new ArrayList<String[]>();
        ToCSV writer = new ToCSV();

        // Create list of Bios
        List<WebElement> elements = driver.findElements(By.className("bio_link"));

        // Iterate through list and get values for name, position, and description
        int i = 1;
        for(WebElement x : elements){

            //Get values from attributes
            name = x.getAttribute("data-title");
            position = x.getAttribute("data-position");
            description = x.getAttribute("data-description");

            // Scrub description of html tags
            description = descripCleaner.cleanUp(description);

            // Set info to string array
            String[] info = new String[3];
            info[0] = name;
            info[1] = position;
            info[2] = description;

            // Add info to list
            leaders.add(info);
        }


        // Send list of leaders to be written to CSV file
        writer.toCSV(leaders);

    }

}

package utils;

import org.jsoup.Jsoup;

public class DescriptionCleanup{


    public String cleanUp(String description){

        return Jsoup.parse(description).text();
    }

}

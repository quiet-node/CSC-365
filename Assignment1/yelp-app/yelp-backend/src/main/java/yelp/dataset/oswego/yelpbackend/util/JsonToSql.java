package yelp.dataset.oswego.yelpbackend.util;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;

import yelp.dataset.oswego.yelpbackend.repositories.BusinessRepository;

public class JsonToSql {
    @Autowired
    private BusinessRepository businessRepository; // repo to store data

    public void toSql(String filename) {
        try {
            // buffrer reader to read lines in json file
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String line = "";

            // loop through the json file
            for (int i = 0; i < 10000; i++) {
                // each line of the file is a json object
                line = br.readLine();

                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

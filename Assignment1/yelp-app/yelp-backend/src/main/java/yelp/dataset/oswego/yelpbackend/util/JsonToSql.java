package yelp.dataset.oswego.yelpbackend.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.JSONObject;
// import org.springframework.beans.factory.annotation.Autowired;

import yelp.dataset.oswego.yelpbackend.models.BusinessModel;
// import yelp.dataset.oswego.yelpbackend.repositories.BusinessRepository;

public class JsonToSql {
    // @Autowired
    // private BusinessRepository businessRepository; // repo to store data

    public void toSql(String filename) {

        try {
            // buffrer reader to read lines in json file
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String line = "";

            // loop through the json file
            for (int i = 0; i < 5; i++) {
                // each line of the file is a json object
                line = br.readLine();

                JSONObject bData = new JSONObject(line); // this is the whole Object for the whole line
                
                // attributes
                String name = bData.get("name").toString();
                String business_id = bData.get("business_id").toString();
                String address = bData.get("address").toString();
                Double stars = bData.getDouble("stars");
                Double reviews = bData.getDouble("review_count");
                Double similarityRate = 99999.0;
                ArrayList<String> bCategories = new ArrayList<String>();

                // get the values for categories-key and push them into an array
                String[] categories = bData.get("categories").toString().split(",");

                // add each category value to bCategories list
                for (int j =0; j<categories.length; j++) {
                    bCategories.add(categories[j]);
                }

                // a BusinessModel instance
                BusinessModel bModel = new BusinessModel(0, name, business_id, address, stars, reviews, similarityRate);

            
                // businessRepository.save(bModel);
                

            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

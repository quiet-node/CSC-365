package yelp.dataset.oswego.yelpbackend.models;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //setters, getters, toString
@AllArgsConstructor
@NoArgsConstructor
public class BusinessModel {
    @Id
    @GeneratedValue
    private int id; // primary key

    String name, business_id, address;
    Double stars, reviews, similarityRate;

    ArrayList<String> categories;

    
    public String getCategories(){
        String res = "";
        for (int i = 0; i<categories.size(); i++) {
            res = res.concat(categories.get(i).toString() + ", ");
        }
        return res;
    }

}

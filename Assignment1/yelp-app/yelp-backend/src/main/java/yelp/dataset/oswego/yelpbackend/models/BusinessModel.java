package yelp.dataset.oswego.yelpbackend.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //setters, getters, toString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="yelp")
public class BusinessModel {
    @Id
    @GeneratedValue
    private long id; // primary key

    String name, business_id, address;
    Double stars, reviews, similarityRate;

    // ArrayList<String> categories;


    // public String getCategories(){
    //     String res = "";
    //     for (int i = 0; i<categories.size(); i++) {
    //         res = res.concat(categories.get(i).toString() + ", ");
    //     }
    //     return res;
    // }

}

// Throw BusinessModel into a database -> make an endpoint to show all the data from the database
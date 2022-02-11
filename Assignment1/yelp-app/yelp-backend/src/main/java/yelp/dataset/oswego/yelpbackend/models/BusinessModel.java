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

    String  business_id, name, address;
    Double stars, reviews, similarityRate;

    ArrayList<String> categories;

    // public BusinessModel(String _name, String _business_id, String _address, Double _stars, Double _reviews) {
    //     name = _name;
    //     business_id = _business_id;
    //     address = _address;
    //     stars = _stars;
    //     reviews = _reviews;
    //     categories = new ArrayList<>();
    //     similarityRate = 99999.0;

    // }

    // public String getCategories(){
    //     String res = "";
    //     for (int i = 0; i<categories.size(); i++) {
    //         res = res.concat(categories.get(i).toString() + ", ");
    //     }
    //     return res;
    // }

}

// Throw BusinessModel into a database -> make an endpoint to show all the data from the database
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
@Data //setters, getters, toString, hashcode
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
}

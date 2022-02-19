package yelp.dataset.oswego.yelpbackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yelp.dataset.oswego.yelpbackend.models.BusinessModel;
import yelp.dataset.oswego.yelpbackend.repositories.BusinessRepository;

@RestController
@RequestMapping("/yelpdata")
@CrossOrigin
public class BusinessController {
    @Autowired
    private BusinessRepository repo; // repo to store data

    @GetMapping("/allbusinesses")
    public List<BusinessModel> getAllBusinesses() {
        return repo.findAll();
    }

    @GetMapping("/{businessName}")
    public List<BusinessModel> getBusinessByName(@PathVariable String businessName) {
        
        return repo.findByName(businessName);
    }

    
}

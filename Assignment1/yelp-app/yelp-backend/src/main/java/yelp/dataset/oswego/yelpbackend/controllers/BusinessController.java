package yelp.dataset.oswego.yelpbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yelp.dataset.oswego.yelpbackend.models.BusinessModel;
import yelp.dataset.oswego.yelpbackend.repositories.BusinessRepository;

@RestController
@RequestMapping("/api")
public class BusinessController {
    @Autowired
    private BusinessRepository businessRepository; // repo to store data

    @GetMapping("/")
    public List<BusinessModel> getB() {
        return businessRepository.findAll();
    }

    @PostMapping("/")
    public BusinessModel addBusiness(@RequestBody BusinessModel business) {
        return businessRepository.save((business));
    }
}

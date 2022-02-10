package yelp.dataset.oswego.yelpbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yelp.dataset.oswego.yelpbackend.models.BusinessModel;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessModel, Integer>  {
    
}

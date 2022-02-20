package yelp.dataset.oswego.yelpbackend.similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import lombok.NoArgsConstructor;
import yelp.dataset.oswego.yelpbackend.hashing.HashTable;
import yelp.dataset.oswego.yelpbackend.models.BusinessModel;

@NoArgsConstructor
public class CosSim {
    

    private double cosSimRate;
    
    // catFilter:string => filter out the "&" and " "
    // For example:
    //      catA = ["Gastropubs"," Food"," Beer Gardens"," Restaurants"," Bars"," American (Traditional)"," Beer Bar"," Nightlife"," Breweries"]
    //      catB = [Restaurant, Beauty & Spa,  Coffee & Tea, Hair Salons, Food]

    // Then catFilter return a HashSet
    //      vector =  [American, Store, Gardens, Coffee, Restaurants, Beer, Nightlife, Gastropubs, Tea, Convenience, Bar, Breweries, (Traditional), Food, Bars]      

    private HashSet<String> catFilter(ArrayList<String> catA, ArrayList<String> catB) {

        HashSet<String> termVector = new HashSet<>();

        // filter catA
        for(String cat : catA) { // EX: cat = "Coffee & Tea"
            cat = cat.trim();
            String[] catArr = cat.split(" "); // catArr = ["Coffee", "&", "Tea"]

            for(String c : catArr) { // c = "Coffee", c="&", c="Tea"
                if (!c.equals("&")){
                    termVector.add(c);
                }
            }
        }

        // filter and add catB to termVector
        for (String cat : catB) {
            cat = cat.trim();
            String[] catArr = cat.split(" ");

            for(String c : catArr) {
                if (!c.equals("&")) {
                    termVector.add(c);
                }
            }
        }

        return termVector;
    }

    // makeVector:HashMap => the whole Vector
    private HashMap<String, Integer> makeVectorDeprecated(HashSet<String> termVector, ArrayList<String> categories) {

        HashMap<String, Integer> vector = new HashMap<>();


        for (String term: termVector){  // loop through termVector
            term = term.trim(); 
           for(String cat : categories) {   // cat can be "Coffee & Tea"
               cat = cat.trim();
               String[] catArr = cat.split(" "); //catArr = ["Coffee", "&", "Tea"]
               for(String c:catArr) { // c = "Coffee", c ="&", c ="Tea"
                   if (term.equals(c)) { 
                       if (vector.get(c) == null) { // if term is not defined, then set it =1 
                            vector.put(term, 1); 
                       } else {
                            vector.put(term, vector.get(term)+1); // ++ if already defined
                       }
                   }
               }
           }
        }


        return vector;
    }

    private HashTable makeVector(HashSet<String> termVector, ArrayList<String> categories) {

        // init a vectoc:hashtable
        HashTable vector = new HashTable(5);

        for (String term: termVector){  // loop through termVector
            term = term.trim(); // clean the term
            for(String cat : categories) {   // cat can be "Coffee & Tea"
               cat = cat.trim();
               String[] catArr = cat.split(" "); //catArr = ["Coffee", "&", "Tea"]
               for(String c:catArr) { // c = "Coffee", c ="&", c ="Tea"
                   if (term.equals(c)) { 
                        vector.add(term);
                   }

                }
            }
        }

        // Each vector is a hashtable
        return vector;
    }

    
    

    // dotProduct:double => how many similimar words
    private double calcDotProduct(ArrayList<String> catA, ArrayList<String> catB) {
        
        // init dotProd:double
        double dotProd = 0;

        // termVector contains all relevant words from catA and catB
        HashSet<String> termVector = catFilter(catA, catB);

        // init vectors:HashTable
        HashTable vectorA = makeVector(termVector, catA);
        HashTable vectorB = makeVector(termVector, catB);

        // loop through termVector
        for(String term : termVector) {
            // dotProd = x1*y1 + x2*y2
            // It masters only when term != null a.k.a term.value > 0
            if (vectorA.getTerm(term) > 0 && vectorB.getTerm(term) > 0) {
                    int valueA = vectorA.getTerm(term);
                    int valueB = vectorB.getTerm(term);

                    int product = valueA * valueB;
                    dotProd += product; 
            }

        }

        return dotProd;        
    }


    // Magnitude of each vector
    private double calcMagnitude(HashSet<String> termVector, HashTable vector) {
        
        double sumFreq = 0.0;
        
        // loop through termVector
        for(String term : termVector) {
            //It master only when term != null a.k.a term.value > 0
            if (vector.getTerm(term) > 0) {
                sumFreq += Math.pow(vector.getTerm(term), 2);
            }
        }

        return Math.sqrt(sumFreq);
    }


    // Magnitude product of the 2 vectors
    private double calcMagProduct(ArrayList<String> catA, ArrayList<String> catB) {

        // termVector contains all relevant words from catA and catB
        HashSet<String> termVector = catFilter(catA, catB);

        // docTermVector:HashMap<String ,Integer> 
        HashTable vectorA = makeVector(termVector, catA);
        HashTable vectorB = makeVector(termVector, catB);

        double magVectorA = calcMagnitude(termVector, vectorA);
        double magVectorB = calcMagnitude(termVector, vectorB);


        return magVectorA * magVectorB;
        
    }


    // calculate simRate 
    public double calcSimRate(BusinessModel businessA, BusinessModel businessB) {
        // Cos(X, Y) = (X.Y) / (||X|| * ||Y||)
        // Pseudo: simRate = Cos(X,Y) = (dotProduct) / (Magnitude vector X * Magnitude vector Y)

        ArrayList<String> catA = businessA.getCategories();
        ArrayList<String> catB = businessB.getCategories();

        double dotProduct = calcDotProduct(catA, catB);
        double magProduct = calcMagProduct(catA, catB);

        this.cosSimRate = dotProduct / magProduct;

        return this.cosSimRate;
    }


}

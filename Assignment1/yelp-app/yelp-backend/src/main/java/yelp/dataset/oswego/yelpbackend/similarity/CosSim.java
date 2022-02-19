package yelp.dataset.oswego.yelpbackend.similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import lombok.NoArgsConstructor;
import yelp.dataset.oswego.yelpbackend.models.BusinessModel;

@NoArgsConstructor
public class CosSim {
    

    
    // catFilter:string => filter out the "&" and " "
    // For example:
    //      catA = ["Gastropubs"," Food"," Beer Gardens"," Restaurants"," Bars"," American (Traditional)"," Beer Bar"," Nightlife"," Breweries"]
    //      catB = [Restaurant, Beauty & Spa,  Coffee & Tea, Hair Salons, Food]

    // Then catFilter return 
    //      res =  [American, Store, Gardens, Coffee, Restaurants, Beer, Nightlife, Gastropubs, Tea, Convenience, Bar, Breweries, (Traditional), Food, Bars]      

    private HashSet<String> catFilter(ArrayList<String> catA, ArrayList<String> catB) {

        HashSet<String> res = new HashSet<>();

        // filter catA
        for(String cat : catA) { // EX: cat = "Coffee & Tea"
            cat = cat.trim();
            String[] catArr = cat.split(" "); // catArr = ["Coffee", "&", "Tea"]

            for(String c : catArr) { // c = "Coffee", c="&", c="Tea"
                if (!c.equals("&")){
                    res.add(c);
                }
            }
        }

        // filter and add catB to res
        for (String cat : catB) {
            cat = cat.trim();
            String[] catArr = cat.split(" ");

            for(String c : catArr) {
                if (!c.equals("&")) {
                    res.add(c);
                }
            }
        }


        return res;
    }

    // makeMatrix:HashMap => the whole matrix
    private HashMap<String, Integer> makeMatrix(HashSet<String> termMatrix, ArrayList<String> categories) {

        HashMap<String, Integer> matrix = new HashMap<>();
        // matrix looks like
        //	            Restaurants	   Beauty   Spas    Coffee 		 Tea
        // matrixA 			1			1		 0        1           0


        for (String term: termMatrix){  // loop through termMatrix
            term = term.trim(); 
           for(String cat : categories) {   // cat can be "Coffee & Tea"
               cat = cat.trim();
               String[] catArr = cat.split(" "); //catArr = ["Coffee", "&", "Tea"]
               for(String c:catArr) { // c = "Coffee", c ="&", c ="Tea"
                   if (term.equals(c)) { 
                       if (matrix.get(c) == null) { // if term is not defined, then set it =1 
                           matrix.put(term, 1); 
                       } else {
                           matrix.put(term, matrix.get(term)+1); // ++ if already defined
                       }
                   }
               }
           }
        }

        return matrix;
    }
    
    

    // dotProduct:double => how many similimar words
    private double calcDotProduct(ArrayList<String> catA, ArrayList<String> catB) {
        
        double dotProd = 0;

        // termMatrix contains all relevant words from catA and catB
        HashSet<String> termMatrix = catFilter(catA, catB);

        // docTermMatrix:HashMap<String ,Integer> 
        HashMap<String, Integer> matrixA = makeMatrix(termMatrix, catA);
        HashMap<String, Integer> matrixB = makeMatrix(termMatrix, catB);

        // loop through termMatrix
        for(String term : termMatrix) {
            // dotProd = x1*y1 + x2*y2
            // It masters only when term != null
            if (matrixA.get(term) != null && matrixB.get(term) != null) { 
                int valueA = matrixA.get(term);
                int valueB = matrixB.get(term);

                int product = valueA * valueB;
                dotProd += product;
            }
            
        }
        return dotProd;        
    }

    // Euclidian distance of each vector



    // calculate simRate 
    public double calcSimRate(BusinessModel businessA, BusinessModel businessB) {
        // Cos(X, Y) = (X.Y) / (||X|| * ||Y||)
        // Pseudo: simRate = Cos(X,Y) = (dotProduct) / (Euclidean vector X * Euclidean vector Y)

        ArrayList<String> catA = businessA.getCategories();
        ArrayList<String> catB = businessB.getCategories();

        double dotProduct = calcDotProduct(catA, catB);


        return 0;
    }


}

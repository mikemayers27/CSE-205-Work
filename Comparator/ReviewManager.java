// Assignment: Assignment 8
// Name: Michael Mayers
// StudentID: 1221983412
// Lecture: M/W/F 12:20-110
// Description: reviewmanager

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Restaurant> reviewList;

     public ReviewManager() {
        reviewList = new ArrayList<>();
    }
     
     public int restaurantExists(String x, String y)
     {
      for(int i = 0; i < reviewList.size(); i++)
      {  
         if(reviewList.get(i).getRestaurantName().equals(x) && reviewList.get(i).getLocation().equals(y))
         {
            return i;
         }
         
      }
      return -1;
     }
     
     public ArrayList<Integer> cuisineExists(String e)
     {
         ArrayList h = new ArrayList<Integer>();
         for(int i = 0; i < reviewList.size(); i++)
         {
               if(reviewList.get(i).getCuisine().getName().equals(e))
               {
                  h.add(i);
               }
            
         }
         if(h.isEmpty())
         {
            h.add(-1);
            
         }
         return h;
         }
     
     
     public Restaurant getRestaurant(int c)
     { 
     return reviewList.get(c);
     }
     
     public boolean removeReview(String aname, String alocation)
     {
      boolean removed = false;
      for(int i = 0; i < reviewList.size(); i++)
      {
         if(reviewList.get(i).getRestaurantName().equals(aname) && reviewList.get(i).getLocation().equals(alocation))
         {
            reviewList.remove(i);
            removed = true;
         }
      }
      return removed;
     }
     
     public void sortByRating()
     {
         ReviewRatingComparator x = new ReviewRatingComparator();
         Sorts.sort(reviewList, x);
     }
     
     public void sortByCuisine()
     {
        ReviewCuisineComparator y = new ReviewCuisineComparator();
        Sorts.sort(reviewList, y);
     }
     
     public String listReviews()
     {
         String x = "";
         for(int i = 0; i < reviewList.size(); i++)
         {
            x += reviewList.get(i).toString();
         }
         return x;
     }
     
     public void closeReviewManager()
     {
         reviewList.clear();
     }
    /**
     * Add a Restaurant object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two restaurants are
     * considered duplicated if they have exactly the same restaurant name and
     * cuisine name.
     * 
     * @param  restaurantName the name of the restaurant
     * @param  stars the number of stars for the restaurant
     * @param  review   the restaurant review
     * @param  priceRange    the integer price range
     * @param  cuisineName  the Cuisine's name
     * @param  location   the restaurant location (street address)
     * @param  signatureDish  most famous dish
     * @return            true if the operation is successful; false otherwise
     */
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, price, location, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }

}
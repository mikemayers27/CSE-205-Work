// Assignment: Assignment 8
// Name: Michael Mayers
// StudentID: 1221983412
// Lecture: M/W/F 12:20-110
// Description: Restaurant
import java.io.Serializable;
public class Restaurant implements Serializable
{
   private static final long serialVersionUID = 205L;
   private String restaurantName;
   private int stars;
   private String review;
   private int priceRange;
   private String location;
   private Cuisine cuisine;
   
   public Restaurant(String restaurantname1, int stars1, String review1, int pricerange1, String location1, Cuisine cuisine1)
   {
      restaurantName = restaurantname1;
      stars = stars1;
      review = review1;
      priceRange = pricerange1;
      location = location1;
      cuisine = cuisine1;
   }
   
   public String getRestaurantName()
   {
      return restaurantName;
   }
   
   public int getStars()
   {
      return stars;
   }
   
   public int getPriceRange()
   {
      return priceRange;
   }
   
   public String getLocation()
   {
      return location;
   }
   
   public String getReview()
   {
      return review;
   }
   
   public Cuisine getCuisine()
   {
      return cuisine;
   }
   
   public String startoString()
   {
      String result = "";
      for(int i = 0; i < this.getStars(); i++)
      {
         result += "*";
      }
      return result;
   }
   
   public String pricetoString()
   {
      String result = "";
      for(int i = 0; i < this.getPriceRange(); i++)
      {
         result += "$";
      }
      return result;
   }
   
   public String toString()
   {
      return restaurantName + " restaurant\n" + this.startoString() + "\t\t" + this.pricetoString() + "\n" +
cuisine.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
   }
   
}
package businessEntity;

//Contains all information about every dish

import java.util.ArrayList;


public class Gerecht {

    private String gerechtGegevens;
    private String gerechtNaam;
    private double gerechtPrijs;
    private int gerechtId;
    private ArrayList<Ingredient> ingredienten;

    public Gerecht(int gerechtId, String gerechtNaam, String gerechtGegevens, double gerechtPrijs)
    {
        this.gerechtId = gerechtId;
        this.gerechtNaam = gerechtNaam;
        this.gerechtGegevens = gerechtGegevens;
        this.gerechtPrijs = gerechtPrijs;
    }
    public  int getGerechtId()
   {
       return gerechtId;
   }
    public String getGerechtNaam()
    {
        return gerechtNaam;
    }

   public String getGerechtGegevens()
   {
       return gerechtGegevens;
   }

   public double getGerechtPrijs()
   {
       return gerechtPrijs;
    }
   public ArrayList<Ingredient> getIngredienten()
   {
       return ingredienten;
   }


   public void setGerechtID(int gerechtId)
   {
       this.gerechtId = gerechtId;
   }
   public void setGerechtNaam(String gerechtNaam)
   {
       this.gerechtNaam = gerechtNaam;
   }
   public void setGerechtGegevens(String gerechtGegevens)
   {
       this.gerechtGegevens = gerechtGegevens;
   }
   public void setGerechtPrijs(double gerechtPrijs)
   {
       this.gerechtPrijs = gerechtPrijs;
   }

   public void addIngredient(Ingredient ingredient)
   {
       ingredienten.add(ingredient);
   }

}

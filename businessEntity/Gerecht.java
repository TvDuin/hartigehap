package businessEntity;

//Contains all information about every dish

public class Gerecht {
    
    private String gerechtGegevens;
    private String gerechtNaam;
    private double gerechtPrijs;
    private int gerechtID;
 
    
    public Gerecht(int gerechtID, String gerechtNaam, String gerechtGegevens, double gerechtPrijs)
    {
        this.gerechtGegevens = gerechtGegevens;
        this.gerechtNaam = gerechtNaam;
        this.gerechtPrijs = gerechtPrijs;     
    }
    
    public String getGerechtNaam()
    {
        return gerechtNaam;
    }
    
   public String getGerechtGegevens()
   {
       return gerechtGegevens;
   }
   public  int getGerechtID()
   {
       return gerechtID;
   }
   public double getGerechtPrijs()
   {
       return gerechtPrijs;
}
}

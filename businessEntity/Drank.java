package businessEntity;
// hoi Hoe gaat ie.
public class Drank {
    private int drankId;
    private String drankNaam;
    private int voorraad;

    public Drank(int drankId, String drankNaam, int voorraad) {
        this.drankId = drankId;
        this.drankNaam = drankNaam;
        this.voorraad = voorraad;
    }

    public int getDrankId() {
        return drankId;
    }

    public String getDrankNaam() {
        return drankNaam;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }
    
    
  
}

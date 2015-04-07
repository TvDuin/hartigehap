package businessEntity;
// hoi Hoe gaat ie.
public class Drank {
    private int drankId;
    private String drankNaam;
    private int voorraad;
    private double prijs;

    public Drank(int drankId, String drankNaam, int voorraad, double prijs) {
        this.drankId = drankId;
        this.drankNaam = drankNaam;
        this.voorraad = voorraad;
        this.prijs = prijs;
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

    public double getPrijs() {
        return prijs;
    }

    public void setDrankId(int drankId) {
        this.drankId = drankId;
    }

    public void setDrankNaam(String drankNaam) {
        this.drankNaam = drankNaam;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }


    
    
  
}

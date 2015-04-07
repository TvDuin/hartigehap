package businessEntity;

//Contains all information about an ingredient

public class Ingredient {

    private int ingredientID;
    private String ingredientNaam;
    private int voorraad;
    
    public Ingredient(int ingredientID, String ingredientNaam, int voorraad) {
            this.ingredientID = ingredientID;
            this.ingredientNaam = ingredientNaam;
            this.voorraad = voorraad;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public String getIngredientNaam() {
        return ingredientNaam;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public void setIngredientNaam(String ingredientNaam) {
        this.ingredientNaam = ingredientNaam;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }
}

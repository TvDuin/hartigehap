package businessEntity;

//Contains all information about every complete order. This class gets instantiated after the data has been retrieved from the database, either by the waiters or the kitchen personell.

import java.util.ArrayList;


public class Bestelling {

  public int id;
  public int tafelId;
  public ArrayList<Gerecht> gerechten;
  public ArrayList<Drank> dranken;

  public Bestelling(int id, int tafelId, ArrayList<Gerecht> gerechten, ArrayList<Drank> dranken) {
    this.id = id;
    this.tafelId = tafelId;
    this.gerechten = gerechten;
    this.dranken = dranken;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTafelId() {
    return tafelId;
  }

  public void set(int tafelId) {
    this.tafelId = tafelId;
  }

  public ArrayList<Gerecht> getGerechten() {
    return gerechten;
  }

  public ArrayList<Drank> getDranken() {
    return dranken;
  }
}

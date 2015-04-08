package businessEntity;

public class Order {
  int id;
  int tafelID;

  public Order(int id, int tafelID){
    this.id = id;
    this.tafelID = tafelID;
  }

  public int getID() {
    return id;
  }

  public int getTafelID() {
    return tafelID;
  }
}

package businessEntity;

//This class contains information about an order and is only used to temporarily store information about an order before it gets send to the database.
//The reason this class is used instead of Bestelling.java is that this class is much more lightweight and more importantly, every order automatically
//gets an ID assigned by the database (AUTO_INCREMENT) which incorporates the whole order, not the individual items as ID's (which is the case here).

public class Order {
  int id; //The ID that the item has E.G. Cola = 12345678 (must be 8 numbers long).
  int type; //Sets the order type; 1 = Drank, 0 = gerecht.
  int tafelID; //Self explanatory.

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

  public int getType() {
    return type;
  }
}

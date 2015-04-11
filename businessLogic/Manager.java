package businessLogic;

import businessEntity.Order;
import dataStorage.BestellingDAO;

//Class that is required for the link between the presentationLayer and the dataStorageLayer

public class Manager {
  BestellingDAO bestelling;

  public Manager() {
    bestelling = new BestellingDAO();
  }

  public void sendOrder(Order o) {  //Method which a=calls the methode addSimpleOrder() of the BestellingDAO class. -> Sends a single order to the database.
    send.addSimpleOrder(o);
  }
}

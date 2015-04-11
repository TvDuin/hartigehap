package businessLogic;

import businessEntity.Order;
import dataStorage.BestellingDAO;

public class Manager {
  BestellingDAO send;

  public Manager() {
    send = new BestellingDAO();
  }

  public void sendOrder(Order o) {
    send.addSimpleOrder(o);
  }
}

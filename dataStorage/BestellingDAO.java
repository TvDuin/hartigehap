package dataStorage;

public class BestellingDAO {
  public BestellingDAO()
  {
    // Nothing to be initialized. This is a stateless class. Constructor
    // has been added to explicitely make this clear.
  }

  public void addBestelling(Bestelling bestelling) { //Method which adds orders to the DB

    DatabaseConnection connection = new DatabaseConnection();
    if(connection.openConnection())
    {
      // If a connection was successfully setup, execute the INSERT statement
      //How to formulate an insert statement????????!!!!.test
      try {
        Statement stmt = connection.createStatement();
        stmt.execute("INSERT INTO bestelling (`bestelId`, `tafelId`) VALUES(" + bestelling.getId() + "," + bestelling.getTafelId + ");");
        
        for(Drank d : bestelling.getDranken()) {
          stmt.execute("INSERT INTO drank_bestelling (`DrankID`, `BestelID`, `hoeveelheid`) VALUES (" + d.getDrankId() + "," + bestelling.getId() + "," + d.get);
        }
      }

      catch(SQLException e) {
      System.out.println(e);
      }

      finally {
        try {
          stmt.close();
          connection.closeConnection();
        }

        catch (Exception e) {
              e.printStackTrace();
        }
      }
    }
  }
}

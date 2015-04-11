package dataStorage;

import businessEntity.Bestelling;
import businessEntity.Drank;
import businessEntity.Gerecht;
import businessEntity.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BestellingDAO {
    public BestellingDAO()
    {
    // Nothing to be initialized. This is a stateless class. Constructor
    // has been added to explicitely make this clear.
    }

    public void addBestelling(Bestelling bestelling) { //The more complex method which adds orders to the DB

           DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the INSERT statement

            connection.executeSQLInsertStatement("INSERT INTO bestelling (`bestelId`, `tafelId`) VALUES(" + bestelling.getId() + "," + bestelling.getTafelId() + ");");

            for(Drank d : bestelling.getDranken()) {
                connection.executeSQLInsertStatement("INSERT INTO drank_bestelling (`DrankID`, `BestelId`, `hoeveelheid`) VALUES (" + d.getDrankId() + "," + bestelling.getId() + ", `1`");
            }

            for(Gerecht g : bestelling.getGerechten()) {
                connection.executeSQLInsertStatement("INSERT INTO gerecht_bestelling (`GerechtID`, `BestelId`, `hoeveelheid`) VALUES (" + g.getGerechtId() + "," + bestelling.getId() + ", `1`");
            }


            //Close DB connection
            connection.closeConnection();
        }

    }

    public void addSimpleOrder(Order o) { //The simplified version of the method above. This method gets called to insert simple orders in to the database.
      DatabaseConnection connection = new DatabaseConnection();
      if(connection.openConnection())
      {
        if(o.getType() == 1) {
          connection.executeSQLInsertStatement("INSERT INTO drank_order (`TafelID`, `DrankID`) VALUES(" + o.getTafelID() + "," + o.getID() + ");");
        }

        else if(o.getType() == 0) {
          connection.executeSQLInsertStatement("INSERT INTO gerecht_order (`TafelID`, `GerechtID`) VALUES(" + o.getTafelID() + "," + o.getID() + ");");
        }
      }

      connection.closeConnection();
    }
}

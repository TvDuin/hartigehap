package dataStorage;

import businessEntity.Bestelling;
import businessEntity.Drank;
import businessEntity.Gerecht;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

            ResultSet resultset = connection.executeSQLSelectStatement("INSERT INTO bestelling (`bestelId`, `tafelId`) VALUES(" + bestelling.getId() + "," + bestelling.getTafelId() + ");");
            
            for(Drank d : bestelling.getDranken()) {
                ResultSet resultset2 = connection.executeSQLSelectStatement("INSERT INTO drank_bestelling (`DrankID`, `BestelId`, `hoeveelheid`) VALUES (" + d.getDrankId() + "," + bestelling.getId() + ", `1`");
            }
        
            for(Gerecht g : bestelling.getGerechten()) {
                ResultSet resultset3 = connection.executeSQLSelectStatement("INSERT INTO gerecht_bestelling (`GerechtID`, `BestelId`, `hoeveelheid`) VALUES (" + g.getGerechtId() + "," + bestelling.getId() + ", `1`");
            }
      
            
            //Close DB connection
            connection.closeConnection();
        }
        
    }
}


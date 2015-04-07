package dataStorage;

import library.domain.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.domain.Loan;
import library.domain.Reservation;

public class DrankDAO {

    public DrankDAO()
    {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public ArrayList<Drank> getAllDrank() { //Method which returns all the stored beverages
      ArrayList<Drank> dranken = new ArrayList<Drank>();

      DatabaseConnection connection = new DatabaseConnection();
      if(connection.openConnection())
      {
          // If a connection was successfully setup, execute the SELECT statement.
          ResultSet resultset = connection.executeSQLSelectStatement(
              "SELECT * FROM drank;");

          if(resultset != null)
          {
              try
              {
                  while(resultset.next()) {
                    dranken.add(new Drank(resultset.getInt("DrankID"), resultset.getString("DrankNaam"), resultset.getInt("Voorraad")));
                  }
              }
              catch(SQLException e)
              {
                  System.out.println(e);
                  member = null;
              }
          }

          //Close DB connection
          connection.closeConnection();
      }

      return dranken;
    }

    public boolean removeDrank(Drank drankDieVerwijderdMoetWorden) { //Returns true if deletion was succesfull, otherwise false.
      boolean result = false;

      if(drankDieVerwijderdMoetWorden != null)
      {
          // First open the database connection.
          DatabaseConnection connection = new DatabaseConnection();
          if(connection.openConnection())
          {
              // Execute delete statement using the given DrankId
              result = connection.executeSQLDeleteStatement(
                  "DELETE FROM drank WHERE DrankID = " + drankDieVerwijderdMoetWorden.getDrankId() + ";");

              // Finished with the connection, so close it.
              connection.closeConnection();
          }
          // else an error occurred leave 'result' to null.
      }

      return result;

    }
}

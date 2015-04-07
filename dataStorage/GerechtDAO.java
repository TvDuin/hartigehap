package dataStorage;

import businessEntity.Gerecht;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerechtDAO {

    public GerechtDAO()
    {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public ArrayList<Gerecht> getAllGerecht() { //Method which returns all the stored beverages
      ArrayList<Gerecht> gerechten = new ArrayList<Gerecht>();

      DatabaseConnection connection = new DatabaseConnection();
      if(connection.openConnection())
      {
          // If a connection was successfully setup, execute the SELECT statement.
          ResultSet resultset = connection.executeSQLSelectStatement(
              "SELECT * FROM gerecht;");

          if(resultset != null)
          {
              try
              {
                  while(resultset.next()) {
                    gerechten.add(new Gerecht(resultset.getInt("GerechtID"), resultset.getString("GerechtNaam"), resultset.getString("GerechtGegevens"), resultset.getDouble("Prijs")));
                  }
              }
              catch(SQLException e)
              {
                  System.out.println(e);
              }
          }

          //Close DB connection
          connection.closeConnection();
      }

      return gerechten;
    }

    public boolean removeDrank(Gerecht gerechtDatVerwijderdMoetWorden) { //Returns true if deletion was succesfull, otherwise false.
      boolean result = false;

      if(gerechtDatVerwijderdMoetWorden != null)
      {
          // First open the database connection.
          DatabaseConnection connection = new DatabaseConnection();
          if(connection.openConnection())
          {
              // Execute delete statement using the given DrankId
              result = connection.executeSQLDeleteStatement(
                  "DELETE FROM gerecht WHERE GerechtID = " + gerechtDatVerwijderdMoetWorden.getGerechtId() + ";");

              // Finished with the connection, so close it.
              connection.closeConnection();
          }
          // else an error occurred leave 'result' to null.
      }

      return result;

    }
}

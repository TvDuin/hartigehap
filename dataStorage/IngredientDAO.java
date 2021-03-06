package dataStorage;

import businessEntity.Ingredient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDAO {

    public IngredientDAO()
    {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public ArrayList<Ingredient> getAllIngredient() { //Method which returns all the stored beverages
      ArrayList<Ingredient> ingredienten = new ArrayList<Ingredient>();

      DatabaseConnection connection = new DatabaseConnection();
      if(connection.openConnection())
      {
          // If a connection was successfully setup, execute the SELECT statement.
          ResultSet resultset = connection.executeSQLSelectStatement(
              "SELECT * FROM ingredient;");

          if(resultset != null)
          {
              try
              {
                  while(resultset.next()) {
                    ingredienten.add(new Ingredient(resultset.getInt("IngredientID"), resultset.getString("IngredientNaam"), resultset.getInt("Voorraad")));
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

      return ingredienten;
    }


}

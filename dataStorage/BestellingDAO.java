package dataStorage;

public class BestellingDAO {
  public BestellingDAO()
  {
      // Nothing to be initialized. This is a stateless class. Constructor
      // has been added to explicitely make this clear.
  }

  public ArrayList<Ingredient> getAllIngredient() { //Method which returns all the stored beverages
    ArrayList<Ingredient> ingredienten = new ArrayList<Ingredient>();

    DatabaseConnection connection = new DatabaseConnection();
    if(connection.openConnection())
    {
        // If a connection was successfully setup, execute the INSERT statement
        //How to formulate an insert statement????????!!!!.test
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
                member = null;
            }
        }

        //Close DB connection
        connection.closeConnection();
    }

    return ingredienten;
  }
}

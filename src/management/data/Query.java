package management.data;

public class Query {
public static final String SelectAllClients = "SELECT * FROM restaurantmanagement.clients";
public static final String SelectAllDishes = "SELECT * FROM restaurantmanagement.dishes";
public static final String AddClient="INSERT INTO restaurantmanagement.clients (login,password,"
		+ "first_name,last_name,email,bill,role_id)"
		+ "VALUES (?,?,?,?,?,?,?)";
public static final String FindClient= "SELECT * FROM restaurantmanagement.clients WHERE login=? and password=?";
public static final String DeleteClient = "DELETE FROM restaurantmanagement.clients WHERE login=?";
public static final String UpdateClient = "UPDATE restaurantmanagement.clients SET login=?, password=?,"
		+ "first_name=?,last_name=?,email=?,bill=?,role_id=? WHERE id=?";
public static final String AddDish="INSERt into restaurantmanagement.dishes (dish_name,nomination,price,time_preparing)"
		+ "VALUES(????)";
public static final String FindDish= "SELECT * FROM restaurantmanagement.dishes WHERE dish_name=?";
public static final String DeleteDish = "DELETE FROM resraurantmanagement.dishes WHERE dish_name=?";
}

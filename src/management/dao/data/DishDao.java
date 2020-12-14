package management.dao.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import management.dao.Dao;
import management.data.Query;
import management.entities.Dish;
import management.connection.ConnectionPool;
public class DishDao extends Dao {
	
	
	public List<Dish> getDishes(){
		String sql = Query.SelectAllDishes;
		Connection con = ConnectionPool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<Dish> items = new ArrayList<Dish>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			logger.trace("All dishes retrieved from database");
			
			while(rs.next()) {
				Dish temp = new Dish();
				temp.setPrice(rs.getInt("price"));
				temp.setDish_name(rs.getString("dish_name"));
				temp.setNomination(rs.getString("nomination"));
				temp.setTime_preparing(rs.getInt("time_preparing"));
				items.add(temp);
			}
			

		}catch (Exception e){
			logger.error("Can't retrieve dishes from database",e);
		}finally {
			close(rs,st,con);
			
		}
		return items;
	}
	public void AddDish(HttpServletRequest request) {
		Dish dish= new Dish(request.getParameter("dish_name"),request.getParameter("nomination"),
				Integer.parseInt(request.getParameter("price")),Integer.parseInt(request.getParameter("time_preparing")));
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.AddDish);
	         ps.setString(1, dish.getDish_name());
	         ps.setString(2, dish.getNomination());
	         ps.setInt(3, dish.getPrice());
	         ps.setInt(4, dish.getTime_preparing()); 
	         int rows = ps.executeUpdate();
	         if (rows==1)
	        	 logger.debug("Dish added");
		} catch (SQLException e) {
			logger.error("Error adding Dish",e);
		}
		finally {
			close(ps,conn);
		}
		
		 
	}
	public boolean CheckDish(HttpServletRequest request) {
		String dish_name = request.getParameter("dish_name");
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.FindDish);
			ps.setString(1, dish_name);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
				logger.debug("Dish existed");
			}
		}catch(Exception e) {
			logger.error("cannot check dish",e);
		}
		finally {
			close(rs,ps,conn);
		}
		return result;
	}
	public Dish GetDish(HttpServletRequest request) {
		String dish_name = request.getParameter("dish_name");
		Dish temp = null;
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.FindDish);
			ps.setString(1, dish_name);
			rs = ps.executeQuery();
			if (rs.next()) {
				temp = new Dish();
				temp.setDish_name(rs.getString("dish_name"));
				temp.setId(rs.getInt("id"));
				temp.setNomination(rs.getString("nomination"));
				temp.setPrice(rs.getInt("price"));
				temp.setTime_preparing(rs.getInt("time_preparing"));
			}
			logger.trace("Dish obtained");
		}catch(Exception e) {
			logger.error("error during finding dish",e);
		}
		finally {
			close(rs,ps,conn);
		}
		return temp;
	}
	public void DeleteDish(HttpServletRequest request) {
		String dish_name = request.getParameter("dish_name");
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.DeleteDish);
			ps.setString(1, dish_name);
			ps.executeUpdate();
			logger.debug("Dish deleted");
		}catch(Exception e) {
			logger.error("error during deleting dish",e);
		}
		finally {
			close(ps,conn);
		}
	}
	

	
}



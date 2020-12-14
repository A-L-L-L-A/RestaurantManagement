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
import management.entities.Client;
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
}
	/*
	public void AddDish(HttpServletRequest request) {
		Dish Dish= new Dish(request.getParameter("login"),request.getParameter("password"),request.getParameter("first_name"),
				request.getParameter("last_name"),request.getParameter("email"),0,Integer.parseInt(request.getParameter("role_id")));
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.AddDish);
	         ps.setString(1, Dish.getLogin());
	         ps.setString(2, Dish.getPassword());
	         ps.setString(3, Dish.getFirst_name());
	         ps.setString(4, Dish.getLast_name());
	         ps.setString(5, Dish.getEmail());
	         ps.setInt(6, Dish.getBill());
	         ps.setInt(7, Dish.getRole_id()); 
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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.FindDish);
			ps.setString(1, login);
			ps.setString(2, password);
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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Dish temp = null;
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.FindDish);
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				temp = new Dish();
				temp.setBill(rs.getInt("bill"));
				temp.setEmail(rs.getString("email"));
				temp.setFirst_name(rs.getString("first_name"));
				temp.setLast_name(rs.getString("last_name"));
				temp.setId(rs.getInt("id"));
				temp.setLogin(rs.getString("login"));
				temp.setPassword(rs.getString("password"));
				temp.setRole_id(rs.getInt("role_id"));
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
		String login = request.getParameter("login");
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.DeleteDish);
			ps.setString(1, login);
			ps.executeUpdate();
			logger.debug("Dish deleted");
		}catch(Exception e) {
			logger.error("error during deleting dish",e);
		}
		finally {
			close(ps,conn);
		}
	}
	
	public void UpdateDish(HttpServletRequest request,int id) {
		Dish dish = new Dish(request.getParameter("login"),request.getParameter("password"),request.getParameter("first_name"),
				request.getParameter("last_name"),request.getParameter("email"),Integer.parseInt(request.getParameter("bill")),Integer.parseInt(request.getParameter("role_id")));
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.UpdateDish);
	         ps.setString(1, dish.getLogin());
	         ps.setString(2, dish.getPassword());
	         ps.setString(3, dish.getFirst_name());
	         ps.setString(4, dish.getLast_name());
	         ps.setString(5, dish.getEmail());
	         ps.setInt(6, dish.getBill());
	         ps.setInt(7, dish.getRole_id()); 
	         ps.setInt(8, id);
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
	
}
*/


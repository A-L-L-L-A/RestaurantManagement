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
import management.connection.ConnectionPool;
public class ClientDao extends Dao {
	
	
	public List<Client> getClients(){
		String sql = Query.SelectAllClients;
		Connection con = ConnectionPool.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<Client> items = new ArrayList<Client>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			logger.trace("All clients retrieved from database");
			
			while(rs.next()) {
				Client temp = new Client();
				temp.setBill(rs.getInt("bill"));
				temp.setEmail(rs.getString("email"));
				temp.setFirst_name(rs.getString("first_name"));
				temp.setLast_name(rs.getString("last_name"));
				temp.setId(rs.getInt("id"));
				temp.setLogin(rs.getString("login"));
				temp.setPassword(rs.getString("password"));
				temp.setRole_id(rs.getInt("role_id"));
				items.add(temp);
			}
			

		}catch (Exception e){
			logger.error("Can't retrieve clients from database",e);
		}finally {
			close(rs,st,con);
			
		}
		return items;
	}
	public void AddClient(HttpServletRequest request) {
		Client Client= new Client(request.getParameter("login"),request.getParameter("password"),request.getParameter("first_name"),
				request.getParameter("last_name"),request.getParameter("email"),0,Integer.parseInt(request.getParameter("role_id")));
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.AddClient);
	         ps.setString(1, Client.getLogin());
	         ps.setString(2, Client.getPassword());
	         ps.setString(3, Client.getFirst_name());
	         ps.setString(4, Client.getLast_name());
	         ps.setString(5, Client.getEmail());
	         ps.setInt(6, Client.getBill());
	         ps.setInt(7, Client.getRole_id()); 
	         int rows = ps.executeUpdate();
	         if (rows==1)
	        	 logger.debug("Client added");
		} catch (SQLException e) {
			logger.error("Error adding Client",e);
		}
		finally {
			close(ps,conn);
		}
		
		 
	}
	public boolean CheckClient(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.FindClient);
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
				logger.debug("Client existed");
			}
		}catch(Exception e) {
			logger.error("cannot check client",e);
		}
		finally {
			close(rs,ps,conn);
		}
		return result;
	}
	public Client GetClient(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client temp = null;
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.FindClient);
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				temp = new Client();
				temp.setBill(rs.getInt("bill"));
				temp.setEmail(rs.getString("email"));
				temp.setFirst_name(rs.getString("first_name"));
				temp.setLast_name(rs.getString("last_name"));
				temp.setId(rs.getInt("id"));
				temp.setLogin(rs.getString("login"));
				temp.setPassword(rs.getString("password"));
				temp.setRole_id(rs.getInt("role_id"));
			}
			logger.trace("Client obtained");
		}catch(Exception e) {
			logger.error("error during finding client",e);
		}
		finally {
			close(rs,ps,conn);
		}
		return temp;
	}
	public void DeleteClient(HttpServletRequest request) {
		String login = request.getParameter("login");
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.DeleteClient);
			ps.setString(1, login);
			ps.executeUpdate();
			logger.debug("Client deleted");
		}catch(Exception e) {
			logger.error("error during deleting client",e);
		}
		finally {
			close(ps,conn);
		}
	}
	
	public void UpdateClient(HttpServletRequest request,int id) {
		Client client = new Client(request.getParameter("login"),request.getParameter("password"),request.getParameter("first_name"),
				request.getParameter("last_name"),request.getParameter("email"),Integer.parseInt(request.getParameter("bill")),Integer.parseInt(request.getParameter("role_id")));
		Connection conn= null;
		PreparedStatement ps= null;
		try {
			conn = ConnectionPool.getConnection();
			ps = conn.prepareStatement(Query.UpdateClient);
	         ps.setString(1, client.getLogin());
	         ps.setString(2, client.getPassword());
	         ps.setString(3, client.getFirst_name());
	         ps.setString(4, client.getLast_name());
	         ps.setString(5, client.getEmail());
	         ps.setInt(6, client.getBill());
	         ps.setInt(7, client.getRole_id()); 
	         ps.setInt(8, id);
	         int rows = ps.executeUpdate();
	         if (rows==1)
	        	 logger.debug("Client added");
		} catch (SQLException e) {
			logger.error("Error adding Client",e);
		}
		finally {
			close(ps,conn);
		}
	}
	
}

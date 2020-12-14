package management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public abstract class Dao {

protected static final Logger logger = Logger.getLogger(Dao.class);

	
	
	protected void close(ResultSet rs, Statement st, Connection con) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(con);
	}

	protected void close(PreparedStatement ps, Connection con) {
		closePreparedStatement(ps);
		closeConnection(con);
	}
	
	protected void close(ResultSet rs, PreparedStatement ps, Connection con) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnection(con);
	}


	private void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("ResultSet", e);
			}
		}
		rs = null;
	}

	private void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				logger.error("Statement", e);
			}
		}
		st = null;
	}

	private void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("Connection", e);
			}
		}
		con = null;
	}
	private void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				logger.error("Statement", e);
			}
		}
		ps = null;
	}
	
}

package daos;

import java.sql.Connection;
import java.sql.SQLException;

import DbUtils.Utils;

public class Dao {
	protected Connection con;
	public Dao() throws Exception {
		con = Utils.getConnection();
	}
	public void close() {
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

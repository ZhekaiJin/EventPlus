package db;

import db.mysql.MySQLConnection;

public class DBConnectionFactory {
	// This should change based on the pipeline.
	//factory pattern only change this line to change the main database we use
	//convenient for only one main database usage : offer differnet option for user to choose database 
	private static final String DEFAULT_DB = "mysql";
	public static DBConnection getConnection (String db) throws IllegalArgumentException {
		switch (db) {
			case "mysql":
				return new MySQLConnection();
			case "mongodb":
				return null; // new connection method for mongodb
			default:
				throw new IllegalArgumentException("Invalid db:" + db);
		}
	}
	public static DBConnection getConnection() throws IllegalArgumentException {
		return getConnection (DEFAULT_DB);
	}
}

package db.mysql;

// setting utility value 

public class MySQLDBUtil {
	private static final String HOSTNAME = "localhost";
	private static final String PORT_NUM = "3307"; // change it to 3306 when deploy
	public static final String DB_NAME = "laiproject";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	public static final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT_NUM + "/" + DB_NAME
	  + "?user=" + USERNAME + "&password=" + PASSWORD + "&autoReconnect=true";

}

package db;

import java.util.List;
import java.util.Set;

import db.mysql.MySQLConnection;
import entity.Item;

public interface DBConnection {
	
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
	/**
	 * Close the connection.
	 */
	public void close();

	/**
	 * Insert the favorite items for a user.
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void setFavoriteItems(String userId, List<String> itemIds);

	/**
	 * Delete the favorite items for a user.
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void unsetFavoriteItems(String userId, List<String> itemIds);

	/**
	 * Get the favorite item id for a user.
	 * 
	 * @param userId
	 * @return itemIds
	 */
	public Set<String> getFavoriteItemIds(String userId);

	/**
	 * Get the favorite items for a user.
	 * 
	 * @param userId
	 * @return items
	 */
	public Set<Item> getFavoriteItems(String userId);

	/**
	 * Gets categories based on item id
	 * 
	 * @param itemId
	 * @return set of categories
	 */
	public Set<String> getCategories(String itemId);

	/**
	 * Search items near a geolocation and a term (optional).
	 * 
	 * @param userId
	 * @param lat
	 * @param lon
	 * @param term
	 *            (Nullable)
	 * @return list of items
	 */
	public List<Item> searchItems(double lat, double lon, String term);

	/**
	 * Save item into db.
	 * 
	 * @param item
	 */
	public void saveItem(Item item);

	/**
	 * Get full name of a user. (This is not needed for main course, just for demo
	 * and extension).
	 * 
	 * @param userId
	 * @return full name of the user
	 */
	public String getFullname(String userId);

	/**
	 * Return whether the credential is correct. (This is not needed for main
	 * course, just for demo and extension)
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean verifyLogin(String userId, String password);
	

}


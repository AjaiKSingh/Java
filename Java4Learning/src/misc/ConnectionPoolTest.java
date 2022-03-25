package misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPoolTest {

	private String dbURL;
	private String uname;
	private String passwd;
	private int maxPoolSize = 10;
	
	private int connectionCount = 0;
	
	//Stack<Object> freePool = new Stack<>(); //in real world scenario: it will be Connection object
	//Set<Object> usedPool = new HashSet<>(); //in real world scenario: it will be Connection object
	
	Stack<Connection> freePool = new Stack<>(); 
	Set<Connection> usedPool = new HashSet<>();
	
	//Default constructor
	public ConnectionPoolTest(String databaseUrl, String userName,
			String password, int maxSize) {
		this.dbURL = databaseUrl; //The connection url
		this.uname = userName; //user name
		this.passwd = password; //password
		this.maxPoolSize = maxSize; //maximum connections
	}
	
	//method to get the connection
	public Connection getConnection() throws SQLException
	{
		Connection conn = null;
		//check if connection exists in available pool, throw exception otherwise
		if(isFull())
			throw new SQLException("The connection pool is full.");
		
		conn = getConnectionFromAvailablePool();
		
		// If there is no free connection, create a new one.
		if (conn == null) {
			conn = createNewConnectionForAvailablePool();
		}
		
		//if there is no action on one connection for some
		// time, the connection is lost. By this, make sure the connection is
		// active. Otherwise reconnect it.
		conn = makeAvailable(conn); //fail safe
	
		return conn;
	}
	
	//Make sure the connection is available now. Otherwise, reconnect it.
	private Connection makeAvailable(Connection conn) throws SQLException {
		if (isConnectionAvailable(conn)) {
			return conn;
		}	
		// If the connection is't available, reconnect it.
		usedPool.remove(conn);
		connectionCount--;
		conn.close();

		conn = createNewConnection();
		usedPool.add(conn);
		connectionCount++;
			
		return conn;
	}

	/**
	 * By running a sql to verify if the connection is available
	 * 
	 * @param conn
	 *            The connection for verification
	 * @return if the connection is available for now.
	 */
	private boolean isConnectionAvailable(Connection conn) {
		try (Statement st = conn.createStatement()) {
			st.executeQuery("Select * form dual");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	//Create a connection for the pool
	private Connection createNewConnectionForAvailablePool() throws SQLException {
		Connection conn = createNewConnection();
		connectionCount ++; //increase the count of created connections in pool
		usedPool.add(conn);
		return conn;
	}

	//Create a new connection
	private Connection createNewConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(dbURL, uname, passwd);
		return conn;
	}

	//Get a connection from the pool. If there is no free connection, return null
	private Connection getConnectionFromAvailablePool() {
		Connection conn = null;
		if(freePool.size() >0)
		{
			conn = freePool.pop();
			usedPool.add(conn);
		}
		return conn;
	}

	private boolean isFull() {
		// Verify if the connection is full
		return ((freePool.size() == 0) && (connectionCount >= maxPoolSize));
	}

	//Return a connection to the pool
	public void releaseConnection(Connection conn) throws SQLException
	{
		if(conn==null)
			throw new NullPointerException(); //When the connection is returned
		
		if (!usedPool.remove(conn)) //it isn't gotten from the pool.
		{
			throw new SQLException(
					"The connection is returned already or it isn't for this pool");
		}
		freePool.push(conn); //put the connection back in available connection pool
		
	}
	
	public static void main(String[] args) throws SQLException {
		//Test
		Connection conn = null;
		String DB_URL = "URL";
		String USER_NAME = "User";
		String PASSWORD = "Password";
		ConnectionPoolTest oConnectionPoolTest = new ConnectionPoolTest(DB_URL, USER_NAME, PASSWORD, 5);
		try
		{
			conn = oConnectionPoolTest.getConnection();
			//do something
			
		}
		finally {
			if(conn!=null)
				oConnectionPoolTest.releaseConnection(conn);
		}

	}

}

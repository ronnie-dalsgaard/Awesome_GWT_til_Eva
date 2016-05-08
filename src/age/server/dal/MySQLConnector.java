package age.server.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * Singleton database connector
 * @author Ronnie Dalsgaard 
 */
public class MySQLConnector {
	private static MySQLConnector instance = null;
	private Connection con;
	
	/**
	 * Creates an instance if none exists
	 * Arguments are read from the properties file
	 * 
	 * @return the instance
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static MySQLConnector getInstance() 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		if(instance == null){
			
			//Load Properties
			Properties props = new Properties();
			try {
				File file = new File("DB.properties");
				props.load(new FileInputStream(file));
				String ip = props.getProperty("ip").trim();
				String port = props.getProperty("port").trim();
				String database = props.getProperty("database").trim();
				String username = props.getProperty("username").trim();
				String password = props.getProperty("password").trim();
				instance = new MySQLConnector(ip, port, database, username, password);
			} catch (IOException e) {
				e.printStackTrace();
				throw new InstantiationException(e.getMessage());
			}			
		}
		return instance;
	}
	
	/**
	 * Constructor is private => Singleton
	 * Connects to the specified database
	 * 
	 * @param ip the ip to connect to
	 * @param port the port to connect on
	 * @param database the name of the database to use
	 * @param username the username to login with
	 * @param password the password to login with
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private MySQLConnector(String ip, String port, String database, String username, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
		con = (Connection) DriverManager.getConnection(url, username, password);
		
	}

	/**
	 * Executes the query on the database
	 * 
	 * @param query the query to be executed
	 * @return a ResultSet containing the rows which fulfills the query
	 * @throws DALException
	 */
	public ResultSet doQuery(String query, String... args) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(query);
		for(int i=0; i < args.length; i++){
			stmt.setString(i+1, args[i]);			
		}
		return stmt.executeQuery(query);
	}
	public ResultSet doQuery(String query) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(query);
		return stmt.executeQuery(query);
	}

	/**
	 * Executes an update on the database
	 * 
	 * @param query the query to be executed
	 * @throws DALException
	 */
	public void doUpdate(String query, String... args) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(query);
		for(int i=0; i < args.length; i++){
			stmt.setString(i+1, args[i]);			
		}
		stmt.executeQuery(query);
	}
	
	/**
	 * 
	 * @param query the query to be executed
	 * @param args variable length array of arguments
	 * @return a ResultSet containing the rows which fulfills the query 
	 * @throws SQLException
	 */
	public ResultSet doFunction(String query, String... args) throws SQLException {
		CallableStatement stmt = con.prepareCall(query);
		for(int i=0; i < args.length; i++){
			stmt.setString(i+1, args[i]);
		}
		return stmt.executeQuery();
	}
	
}
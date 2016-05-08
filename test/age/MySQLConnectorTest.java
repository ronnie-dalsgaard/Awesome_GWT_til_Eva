package age;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import age.server.dal.MySQLConnector;

public class MySQLConnectorTest {

	@Test
	public void propertiesTest(){
		//Load Properties
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File("DB.properties")));
		} catch (IOException e) {
			fail("Exception occured!");
		}
	}
	
	@Test
	public void basicTest() {
		try {
			ResultSet res = MySQLConnector.getInstance().doQuery("SELECT * FROM `age`.`room`;");
			System.out.println(res);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail("Exception occured!");
		}
	}
	
}

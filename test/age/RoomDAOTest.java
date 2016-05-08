package age;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import age.server.dal.MySQLConnector;
import age.server.dal.RoomDAO;
import age.shared.DataException;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public class RoomDAOTest {
	
	@Before
	public void setup() throws Exception {
		MySQLConnector.getInstance().doUpdate("DELETE FROM `room` WHERE `name` = ?;", "Altanen");
	}

	@Test
	public void test() {
		try {
			Area a = new Area(0, "Denmark");
			Building b = new Building(1, "Faraoens Palads", "Julius Caesars vej 7", "1234", a);
			boolean isActive = true;
			RoomDAO dao = new RoomDAO();
			Room expected = new Room(7, "Altanen", b, isActive);
			Room actual = dao.create(new Room("Altanen", b, isActive));
			assertEquals(expected, actual);
		} catch (DataException e) {
			e.printStackTrace();
			fail("Exception ocured!");
		}
	}

	@After
	public void tearDown() throws Exception {
		MySQLConnector.getInstance().doUpdate("DELETE FROM `room` WHERE `name` = ?;", "Altanen");
	}
}

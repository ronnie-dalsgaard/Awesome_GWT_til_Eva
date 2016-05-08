package age.server.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import age.shared.DataException;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public class RoomDAO implements IRoomDAO {
	
	
	
	public static void main(String[] args) {
		try {
			Area a = new Area(0, "Denmark");
			Building b = new Building(1, "Faraoens Palads", "Julius Caesars vej 7", "1234", a);
			boolean isActive = true;
			RoomDAO dao = new RoomDAO();
			System.out.println("New Room:\n"+dao.create(new Room("Altanen", b, isActive)));
		} catch (DataException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Room create(Room room) throws DataException {
		String roomName = room.getName();
		Building building = room.getBuilding();
		boolean isActive = room.isActive();
		try {
			String query = "SELECT createRoom(?, ?, ?) AS `roomId`";
			ResultSet res = MySQLConnector.getInstance()
					.doFunction(query, roomName, Integer.toString(building.getId()), isActive?"1":"0");
			res.next();
			int roomId = res.getInt("roomId");
			return new Room(roomId, roomName, building, isActive);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			throw new DataException(e);
		}
	}

	@Override
	public Room getRoom(int id) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public List<Room> getRoom(String name) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public List<Room> getAllRooms() {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public List<Room> getAllRoomsInBuilding(int buildingId) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public List<Room> getAllRoomsInBuilding(String buildingName) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public Room update(Room room) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void delete(Room room) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void delete(int roomId) {
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
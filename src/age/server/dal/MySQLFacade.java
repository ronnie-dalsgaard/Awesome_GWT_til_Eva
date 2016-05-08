package age.server.dal;

import java.util.List;

import age.shared.DataException;
import age.shared.model.Room;

public class MySQLFacade implements IRoomDAO{
	private IRoomDAO roomDAO = new RoomDAO();

	@Override public Room create(Room room) throws DataException { return roomDAO.create(room); }
	@Override public Room getRoom(int id) { return roomDAO.getRoom(id); }
	@Override public List<Room> getRoom(String name) { return roomDAO.getRoom(name); }
	@Override public List<Room> getAllRooms() { return roomDAO.getAllRooms(); }
	@Override public List<Room> getAllRoomsInBuilding(int buildingId) { return roomDAO.getAllRoomsInBuilding(buildingId); }
	@Override public List<Room> getAllRoomsInBuilding(String buildingName) { return roomDAO.getAllRoomsInBuilding(buildingName); }
	@Override public Room update(Room room) {	return roomDAO.update(room); }
	@Override public void delete(Room room) { roomDAO.delete(room); }
	@Override public void delete(int roomId) { roomDAO.delete(roomId); }

	

}

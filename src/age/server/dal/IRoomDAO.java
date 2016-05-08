package age.server.dal;


import java.util.List;

import age.shared.DataException;
import age.shared.model.Room;

public interface IRoomDAO {

	public Room create(Room room)throws DataException;
	public Room getRoom(int id);
	public List<Room> getRoom(String name);
	public List<Room> getAllRooms();
	public List<Room> getAllRoomsInBuilding(int buildingId);
	public List<Room> getAllRoomsInBuilding(String buildingName);
	public Room update(Room room);
	public void delete(Room room);
	public void delete(int roomId);
}

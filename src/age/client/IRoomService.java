package age.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

@RemoteServiceRelativePath("room")
public interface IRoomService extends RemoteService {
	public Room getRoom(int id);
	public List<Area> getAllAreas();
	public List<Building> getAllBuildings();
	public List<Room> getAllRooms();
}

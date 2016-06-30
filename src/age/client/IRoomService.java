package age.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

@RemoteServiceRelativePath("room")
public interface IRoomService extends RemoteService {
	
	//Room
	public Room createRoom(Room room);
	public Room getRoom(int id);
	public List<Room> getAllRooms();
	public List<Room> getRoomsForBuildning(int buildingId);
	public void updateRoom(Room room);
	public void deleteRoom(int id);
	
	//Building
	public Building createBuilding(Building building);
	public Building getBuilding(int id);
	public List<Building> getAllBuildings();
	public List<Building> getBuildingsForArea(int areaId);
	public void updateBuilding(Building building);
	public void deleteBuilding(int id);
	
	//Area
	public Area createArea(Area area);
	public Area getArea(int id);
	public List<Area> getAllAreas();
	public void updateArea(Area area);
	public void deleteArea(int id);
}

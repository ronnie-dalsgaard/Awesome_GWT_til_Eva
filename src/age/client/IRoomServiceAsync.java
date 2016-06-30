package age.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public interface IRoomServiceAsync {
	
	//Room
	public void createRoom(Room room, AsyncCallback<Room> callback);
	public void getRoom(int id, AsyncCallback<Room> callback);
	public void getAllRooms(AsyncCallback<List<Room>> callback);
	public void getRoomsForBuildning(int buildingId, AsyncCallback<List<Room>> callback);
	public void updateRoom(Room room, AsyncCallback<Void> callback);
	public void deleteRoom(int id, AsyncCallback<Void> callback);
	
	//Building
	public void createBuilding(Building building, AsyncCallback<Building> callback);
	public void getBuilding(int id, AsyncCallback<Building> callback);
	public void getAllBuildings(AsyncCallback<List<Building>> callback);
	public void getBuildingsForArea(int areaId, AsyncCallback<List<Building>> callback);
	public void updateBuilding(Building building, AsyncCallback<Void> callback);
	public void deleteBuilding(int id, AsyncCallback<Void> callback);

	//Area
	public void createArea(Area area, AsyncCallback<Area> callback);
	public void getArea(int id, AsyncCallback<Area> callback);
	public void getAllAreas(AsyncCallback<List<Area>> callback);
	public void updateArea(Area area, AsyncCallback<Void> callback);
	public void deleteArea(int id, AsyncCallback<Void> callback);
}

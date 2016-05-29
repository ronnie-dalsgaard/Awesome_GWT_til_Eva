package age.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public interface IRoomServiceAsync {
	public void getRoom(int id, AsyncCallback<Room> callback);
	public void getAllAreas(AsyncCallback<List<Area>> callback);
	public void getAllBuildings(AsyncCallback<List<Building>> callback);
	public void getAllRooms(AsyncCallback<List<Room>> callback);
	public void getRoomsForBuildning(int buildingId, AsyncCallback<List<Room>> callback);
	public void getBuildingsForArea(int areaId, AsyncCallback<List<Building>> callback);

}

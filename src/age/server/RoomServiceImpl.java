package age.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import age.client.IRoomService;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

@SuppressWarnings("serial")
public class RoomServiceImpl extends RemoteServiceServlet implements IRoomService{
	private RoomDAO dao = new RoomDAO();
	
	//Room
	@Override public Room createRoom(Room room) { return dao.createRoom(room); }
	@Override public Room getRoom(int id) { return dao.getRoom(id); }
	@Override public List<Room> getAllRooms() { return dao.getAllRooms(); }
	@Override public List<Room> getRoomsForBuildning(int buildingId) { return dao.getRoomsForBuildning(buildingId); }
	@Override public void updateRoom(Room room) { dao.updateRoom(room); }
	@Override public void deleteRoom(int id) { dao.deleteRoom(id); }
	
	//Building
	@Override public Building createBuilding(Building building) { return dao.createBuilding(building); }
	@Override public List<Building> getAllBuildings()  { return dao.getAllBuildings(); }
	@Override public List<Building> getBuildingsForArea(int areaId) { return dao.getBuildingsForArea(areaId); }
	@Override public Building getBuilding(int id) { return dao.getBuilding(id); }
	@Override public void updateBuilding(Building building) { dao.updateBuilding(building); }
	@Override public void deleteBuilding(int id) { dao.deleteBuilding(id); }
	
	//Area
	@Override public Area createArea(Area area) { return dao.createArea(area); }
	@Override public Area getArea(int id) { return dao.getArea(id); }
	@Override public List<Area> getAllAreas() { return dao.getAllAreas(); }
	@Override public void updateArea(Area area) { dao.updateArea(area); }
	@Override public void deleteArea(int id) { dao.deleteArea(id); }

}

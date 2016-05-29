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

	@Override
	public Room getRoom(int id) {
		return dao.getRoom(id);		
	}

	@Override
	public List<Area> getAllAreas() {
		return dao.getAllAreas();
	}

	@Override
	public List<Building> getAllBuildings() {
		return dao.getAllBuildings();
	}

	@Override
	public List<Room> getAllRooms() {
		return dao.getAllRooms();
	}

	@Override
	public List<Room> getRoomsForBuildning(int buildingId) {
		return dao.getRoomsForBuildning(buildingId);
	}

	@Override
	public List<Building> getBuildingsForArea(int areaId) {
		return dao.getBuildingsForArea(areaId);
	}

}

package age.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import age.client.IRoomService;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

@SuppressWarnings("serial")
public class RoomServiceImpl extends RemoteServiceServlet implements IRoomService{

	@Override
	public Room getRoom(int id) {
		// TODO - This is just for testing (id is ignored!)
		try { Thread.sleep(2000); } catch (InterruptedException e) { }
		Area a = new Area(0, "Denmark");
		Building b = new Building(1, "Faraoens Palads", "Julius Caesars vej 7", "1234", a);
		boolean isActive = true;
		Room room = new Room(7, "Altanen", b, isActive);
		return room;
	}

}

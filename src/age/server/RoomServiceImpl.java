package age.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import age.client.IRoomService;
import age.shared.model.Room;

@SuppressWarnings("serial")
public class RoomServiceImpl extends RemoteServiceServlet implements IRoomService{

	@Override
	public Room getRoom(int id) {
		RoomDAO dao = new RoomDAO();
		return dao.getRoom(id);		
	}

}

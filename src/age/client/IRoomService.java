package age.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import age.shared.model.Room;

@RemoteServiceRelativePath("room")
public interface IRoomService extends RemoteService {
	public Room getRoom(int id);
}

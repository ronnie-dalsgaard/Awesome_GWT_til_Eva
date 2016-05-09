package age.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import age.shared.model.Room;

public interface IRoomServiceAsync {
	public void getRoom(int id, AsyncCallback<Room> callback);

}

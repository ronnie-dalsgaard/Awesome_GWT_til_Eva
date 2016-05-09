package age.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import age.client.views.RoomView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AGE implements EntryPoint {
	
	public void onModuleLoad() {
		RootPanel.get().add(new RoomView());
	}
}

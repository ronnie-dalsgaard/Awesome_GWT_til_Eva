package age.client.views;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import age.client.IRoomService;
import age.client.IRoomServiceAsync;
import age.shared.model.Building;
import age.shared.model.Room;

public class RoomView extends Composite {
	private static RoomViewUiBinder uiBinder = GWT.create(RoomViewUiBinder.class);
	interface RoomViewUiBinder extends UiBinder<Widget, RoomView> { }
	
	@UiField Label loading_lbl;
	@UiField TextBox roomName_box;
	
	public RoomView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		IRoomServiceAsync roomService = GWT.create(IRoomService.class);

		
//		roomService.getAllBuildings(new AsyncCallback<List<Building>>() {
//			
//			@Override
//			public void onSuccess(List<Building> result) {
//				loading_lbl.setVisible(false);
//				roomName_box.setText(result.toString());
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				loading_lbl.setVisible(false);
//				roomName_box.setText(caught.toString());
//			}
//		});
		
		roomService.getBuildingsForArea(0, new AsyncCallback<List<Building>>() {
			
			@Override
			public void onSuccess(List<Building> result) {
				loading_lbl.setVisible(false);
				roomName_box.setText(result.toString());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				loading_lbl.setVisible(false);
				roomName_box.setText(caught.toString());
			}
		});
	}
}

package age.client.views;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import age.client.IRoomService;
import age.client.IRoomServiceAsync;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public class SelectRoomView extends Composite implements HasText {

	private static SelectRoomViewUiBinder uiBinder = GWT.create(SelectRoomViewUiBinder.class);

	interface SelectRoomViewUiBinder extends UiBinder<Widget, SelectRoomView> {
	}

	@UiField
	Button button;
	@UiField
	Label areaLbl;
	@UiField
	Label buildingLbl;
	@UiField
	Label roomLbl;
	@UiField
	ListBox areaDropDown;
	@UiField
	ListBox buildingDropDown;
	@UiField
	ListBox roomDropDown;
	
	private List<Area> _areas;
	private List<Building> _buildings;
	private List<Room> _rooms;

	
	public SelectRoomView() {
		initWidget(uiBinder.createAndBindUi(this));
		IRoomServiceAsync roomService = GWT.create(IRoomService.class);
		roomService.getAllAreas(new AsyncCallback<List<Area>>() {
			
			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(List<Area> result) {
				SetAreaDropdown(result);
				_areas = result;
			}
		});
		
		areaDropDown.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				buildingDropDown.clear();
				buildingDropDown.addItem("Loading...");
				
//				roomService.getBuildingsForArea(areaId, callback);
			}
		});
		
//		buildingDropDown.addChangeHandler(new ChangeHandler() {

//		@Override
//		public void onChange(ChangeEvent event) {
//			roomDropDown.clear();
//			
//			roomService.getRoomsForBuildning(building, callback);
//			
//			
//		}
//    })
		
		
		button.setText("Klik mig din frækkert");		
		areaLbl.setText("Vælg Area");
		buildingLbl.setText("Vælg bygning");
		roomLbl.setText("Vælg Værelse");
	}


	public SelectRoomView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	
	private void SetAreaDropdown(List<Area> list) {
		roomDropDown.clear();
		buildingDropDown.clear();
		areaDropDown.clear();
		for(Area a: list)
		{
			areaDropDown.addItem(a.getName(), Integer.toString(a.getId()));
		}
	}
	
	private void SetBuildingsDropdown(List<Building> list) {
		roomDropDown.clear();
		buildingDropDown.clear();
		for(Building b: list)
		{
			buildingDropDown.addItem(b.getName(), Integer.toString(b.getId()));
		}
	}
	
	private void SetRoomsDropdown(List<Room> list) {
		roomDropDown.clear();
		for(Room r: list)
		{
			roomDropDown.addItem(r.getName(), Integer.toString(r.getId()));
		}
	}
	
}

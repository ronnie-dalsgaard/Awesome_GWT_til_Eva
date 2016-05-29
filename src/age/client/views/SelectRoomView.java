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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import age.client.IRoomService;
import age.client.IRoomServiceAsync;
import age.shared.model.Area;
import age.shared.model.Building;
import age.shared.model.Room;

public class SelectRoomView extends Composite {

	private final String LoadString = "Loading....";
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
	
	final IRoomServiceAsync roomService = GWT.create(IRoomService.class);
	
	public SelectRoomView() {
		initWidget(uiBinder.createAndBindUi(this));
		areaDropDown.addChangeHandler(new AreaDropDownHanlder());
		buildingDropDown.addChangeHandler(new BuildingDropDownHandler());
		roomDropDown.addChangeHandler(new RoomDropdDownHandler());
		populateAreaDropdown();
		
		button.setText("Klik mig din frækkert");		
		areaLbl.setText("Vælg Område");
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

	
	
	private void populateAreaDropdown() {

		roomService.getAllAreas(new AsyncCallback<List<Area>>() {
			
			@Override
			public void onSuccess(List<Area> result) {
				roomDropDown.clear();
				buildingDropDown.clear();
				areaDropDown.clear();
				button.setEnabled(false);
				for(Area a: result)
				{
					areaDropDown.addItem(a.getName(), Integer.toString(a.getId()));
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
	public void populateBuildingDropDown() {

		int areaId = Integer.parseInt(areaDropDown.getSelectedValue());
		roomService.getBuildingsForArea(areaId, new AsyncCallback<List<Building>>() {
			
			@Override
			public void onSuccess(List<Building> result) {
				buildingDropDown.clear();
				roomDropDown.clear();
				button.setEnabled(false);
				for(Building b : result){
					buildingDropDown.addItem(b.getName(), Integer.toString(b.getId()));
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
	
	public void populateRoomDropDown() {
		int buildingId = Integer.parseInt(buildingDropDown.getSelectedValue());
		roomService.getRoomsForBuildning(buildingId, new AsyncCallback<List<Room>>() {
			
			@Override
			public void onSuccess(List<Room> result) {
				roomDropDown.clear();
				button.setEnabled(!result.isEmpty());
				for(Room r : result){
					roomDropDown.addItem(r.getName(), Integer.toString(r.getId()));
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
		
	}
	
	private class AreaDropDownHanlder implements ChangeHandler
	{

		@Override
		public void onChange(ChangeEvent event) {
			buildingDropDown.clear();
			roomDropDown.clear();
			button.setEnabled(false);
			
			buildingDropDown.addItem(LoadString);
			populateBuildingDropDown();
		}
		
	}

	private class BuildingDropDownHandler implements ChangeHandler
	{

		@Override
		public void onChange(ChangeEvent event) {
			roomDropDown.clear();
			button.setEnabled(false);
			roomDropDown.addItem(LoadString);
			populateRoomDropDown();
		}
	}
	
	private class RoomDropdDownHandler implements ChangeHandler{

		@Override
		public void onChange(ChangeEvent event) {
//			button.setEnabled(false);
			//TODO: Pil valgt værdi ud her og brug til andet views callback
		}
		
	}
}


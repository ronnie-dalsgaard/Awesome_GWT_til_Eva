package age.shared.model;

import java.io.Serializable;

public class Room implements Serializable {
	private static final long serialVersionUID = 6081232388774287698L;
	private int id;
	private String name;
	private Building building;
	private boolean isActive;
	
	public Room(){ }
	
	public Room(int id, String name, Building building, boolean isActive) {
		this.id = id;
		this.name = name;
		this.building = building;
		this.isActive = isActive;
	}
	
	public Room(String name, Building building, boolean isActive) {
		this.id = -1;
		this.name = name;
		this.building = building;
		this.isActive = isActive;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Building getBuilding() { return building; }
	public void setBuilding(Building building) { this.building = building; }
	public boolean isActive() { return isActive; }
	public void setActive(boolean isActive) { this.isActive = isActive; }
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", building=" + building + ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

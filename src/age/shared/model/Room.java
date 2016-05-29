package age.shared.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "room")
public class Room implements Serializable {
	private static final long serialVersionUID = 6081232388774287698L;
	private int id;
	private String name;
	private Building building;
	private boolean isActive;
		
	public Room(){ }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "roomId")
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	@Column(name = "name")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@OneToOne
    @JoinColumn(name = "buildingId")
	public Building getBuilding() { return building; }
	public void setBuilding(Building building) { this.building = building; }
	
	public boolean isActive() { return isActive; }
	public void setActive(boolean isActive) { this.isActive = isActive; }

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", building=" + building.toString() + ", isActive=" + isActive + "]";
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

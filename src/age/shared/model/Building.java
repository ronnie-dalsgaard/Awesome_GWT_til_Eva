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
@Table(name = "building")
public class Building implements Serializable {
	private static final long serialVersionUID = 1304236228402183235L;
	private int id;
	private String name;
	private String adress;
	private String zip;
	private Area area;
	
	public Building() { }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "buildingId")
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	@Column(name = "name")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Column(name = "adress")
	public String getAdress() { return adress; }
	public void setAdress(String adress) { this.adress = adress; }
	
	@Column(name = "zip")
	public String getZip() { return zip; }
	public void setZip(String zip) { this.zip = zip; }
	
	@OneToOne
    @JoinColumn(name = "areaId")
	public Area getArea() { return area; }
	public void setArea(Area area) { this.area = area; }

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", adress=" + adress + ", zip=" + zip + ", area=" + area.toString() + "]";
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
		Building other = (Building) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

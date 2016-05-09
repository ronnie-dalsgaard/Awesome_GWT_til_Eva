package age.shared.model;

import java.io.Serializable;

public class Building implements Serializable {
	private static final long serialVersionUID = 1304236228402183235L;
	private int id;
	private String name;
	private String adress;
	private String zip;
	private Area area;
	
	public Building() { }
	
	public Building(int id, String name, String adress, String zip, Area area) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.zip = zip;
		this.area = area;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getAdress() { return adress; }
	public void setAdress(String adress) { this.adress = adress; }
	public String getZip() { return zip; }
	public void setZip(String zip) { this.zip = zip; }
	public Area getArea() { return area; }
	public void setArea(Area area) { this.area = area; }
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", adress=" + adress + ", zip=" + zip + ", area=" + area + "]";
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

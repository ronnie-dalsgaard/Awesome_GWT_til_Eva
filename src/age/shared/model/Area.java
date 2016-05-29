package age.shared.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area implements Serializable {
	private static final long serialVersionUID = -6582034633775438299L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "areaId")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	public Area() { }

	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + "]";
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
		Area other = (Area) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

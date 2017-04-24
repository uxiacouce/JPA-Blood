package blood.db.pojos;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import blood.db.pojos.Nurse;
@Entity
@Table(name="Hospital")
public class Hospital implements Serializable {
	private static final long serialVersionUID = -8273180762878531017L;
	@Id
	@GeneratedValue(generator="Hospital")
	@TableGenerator(name="Hospital",table="sqlite_secuence", pkColumnName="name" , valueColumnName="seq",pkColumnValue="Hospital")
	private Integer id;
	private String name;
	private String location;
	private Integer range;
	@OneToMany(mappedBy="Hospital")
	private List<Nurse> nurses;
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String name,String location, Integer range) {
		this.name = name;
		this.location = location;
		this.range = range;
		//this.nurses = new ArrayList<Nurse>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Hospital other = (Hospital) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Hospital(Integer id, String name, String location, Integer range ,List<Nurse> nurses) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.range = range;
		//this.nurses = nurses;
	}

	public Hospital(Integer id, String name, String location, Integer range) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.range = range;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getRange() {
		return range;
	}
	public void setRange(Integer range) {
		this.range = range;
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", location=" + location + ", range=" + range + "]";
	}


}

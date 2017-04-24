package blood.db.pojos;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import blood.db.pojos.Patient;
import blood.db.pojos.Hospital;
import blood.db.pojos.*;
@Entity
@Table(name="Nurses")
public class Nurse implements Serializable {
private static final long serialVersionUID = 1857194774423858547L;
	@Id
	@GeneratedValue(generator="Nurses")
	@TableGenerator(name="Nurses", table="sql_sequence", pkColumnName="name", valueColumnName="seq", pkColumnValue="Nurses")
	private Integer id;
	private String name;
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] photo;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hosp_id")
	private Hospital hospital;
	@ManyToMany(mappedBy="nurs-pats")
	private List<Patient> patients;
	
	//modificar constructores lista de pacientes
	public Nurse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Nurse (Integer id, String name, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
	}
	public Nurse (String name, byte[] photo) {
		super();
		this.name = name;
		this.photo = photo;
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
		Nurse other = (Nurse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", hospital=" + hospital + "]";
	}
}

package blood.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import blood.db.pojos.Illnes;
import blood.db.pojos.Cells;
import blood.db.pojos.Molecules;
import blood.db.pojos.Nurse;
import blood.db.pojos.Symptoms;
@Entity
@Table(name="Patient")
public class Patient implements Serializable {
	@Id
	@GeneratedValue(generator="Patient")
	@TableGenerator(name="Patient", table="sql_sequence", pkColumnName="name", valueColumnName="seq", pkColumnValue="Patient")
	private static final long serialVersionUID = -136657724985479318L;
	private Integer id;
	private String name;
	private Integer age;
	private String blood;
	private Boolean smoker;
	private String gender;
	@ManyToMany
	@JoinTable(name="nurs-pats",
	joinColumns={@JoinColumn(name="patient_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="nurse_id", referencedColumnName="id")})
	private List<Nurse> nurses;
	@ManyToMany(mappedBy="pats-symp")
	private List<Symptoms> symptoms;
	@ManyToMany(mappedBy="pats-cells")
	private List<Cells> cells;
	@ManyToMany(mappedBy="pats-mol")
	private List<Molecules> molecules;
	@ManyToMany(mappedBy="pats-ill")
	private List<Illnes> illness;
//rellenar constructores con lsitas de nurse y illnes
	public Patient() {
		super();
		this.symptoms = new ArrayList<>();
		// TODO Auto-generated constructor stub
		this.setCells(new ArrayList<Cells>());
		this.setMolecules(new ArrayList <Molecules>());
	}
	//modificar constructores porque falta clase nurse
	public Patient(String name, Integer age, String blood,Boolean smoker,String gender) {
		this.name = name;
		this.age = age;
		this.blood = blood;
		this.smoker = smoker;
		this.gender= gender;
		this.symptoms = new ArrayList<Symptoms>();
		this.cells = new ArrayList<Cells>();
		this.molecules = new ArrayList<Molecules>();
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
		Patient other = (Patient) obj;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public Boolean getSmoker() {
		return smoker;
	}
	public void setSmoker(Boolean smoker1) {
		this.smoker = smoker1;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Symptoms> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptoms> symptoms) {
		this.symptoms = symptoms;
	}

	public List<Cells> getCells() {
		return cells;
	}

	public void setCells(List<Cells> cells) {
		this.cells = cells;
	}

	public List<Molecules> getMolecules() {
		return molecules;
	}

	public void setMolecules(List<Molecules> molecules) {
		this.molecules = molecules;
	}

	public List<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}
	public List<Illnes> getIllness() {
		return illness;
	}
	public void setIllness(List<Illnes> illness) {
		this.illness = illness;
	}
}

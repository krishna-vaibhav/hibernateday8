package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dac_students",schema="system")
public class Student {
	private Integer studentId;
	private String email;
	// many-to-one bi-dir asso between entities
	private Course myCourse;
	// one-to-one asso between entity n value type
	private Address adr;
	// one-to--many asso between entity & coll of basic value type
	private List<String> phoneNumbers = new ArrayList<>();
	// one to may asso between entity & coll of embeddables
	private List<Vehicle> vehicles = new ArrayList<>();

	public Student() {
		System.out.println("stud constr");
	}

	public Student(String email) {
		super();
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stud_id", nullable = false, updatable = false)
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(length = 20, unique = true)
	// @Basic(fetch=FetchType.LAZY)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne // mandatory --o.w throws org.hib.MappingExc
	@JoinColumn(name = "c_id") // optional BUT reco.
	public Course getMyCourse() {
		return myCourse;
	}

	public void setMyCourse(Course myCourse) {
		this.myCourse = myCourse;
	}

	@Embedded // OPTIONAL
	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address adr) {
		this.adr = adr;
	}

	@ElementCollection // MANDATORY
	@CollectionTable(name = "stud_phones", joinColumns = @JoinColumn(name = "s_id"))
	@Column(name = "phone_no", length = 10)
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@ElementCollection
	@CollectionTable(name = "stud_vehicles", joinColumns = @JoinColumn(name = "st_id"))
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", email=" + email + "]";
	}

}

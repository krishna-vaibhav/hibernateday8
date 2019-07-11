package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="dac_courses",schema="system")
public class Course {
	private Integer courseId;
	private String name;
	private Date beginDate, endDate;
	private double fees;
	//one--many bi dir asso between entities 
	private List<Student> students=new ArrayList<>();

	public Course() {
		System.out.println("in course constr");
	}

	public Course(String name, Date beginDate, Date endDate, double fees) {
		super();
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.fees = fees;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="course_id",nullable=false,updatable=false)
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	@Column(length=20,unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="begin_date")
	@Temporal(TemporalType.DATE)
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	//only for Mysql
	//@Column(columnDefinition="double(7,1)")
	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	//mappedBy --appears on non-owning of association
	//CascadeType.ALL --- cascasde on save/update/delete
	@OneToMany(mappedBy="myCourse",cascade=CascadeType.ALL/*,fetch=FetchType.EAGER*/)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//convenience methods ---OPTIONAL BUT reco in case of bi-dir asso.
	//to add / remove student
	public void addStudent(Student s)
	{
		students.add(s);//link from course ---> student
		 s.setMyCourse(this); 	//link from student --->course
	}
	public void removeStduent(Student s)
	{
		students.remove(s);
		s.setMyCourse(null);
	}
	

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", fees=" + fees + "]";
	}
	

}

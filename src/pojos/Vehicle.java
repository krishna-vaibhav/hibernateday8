package pojos;
import javax.persistence.*;

@Embeddable
public class Vehicle {
	private String regNo;
	private String model;
	private double price;
	public Vehicle() {
		System.out.println("in vehicle constr");
	}
	public Vehicle(String regNo, String model, double price) {
		super();
		this.regNo = regNo;
		this.model = model;
		this.price = price;
	}
	@Column(length=20,unique=true,name="reg_no")
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	@Column(length=20)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", model=" + model + ", price=" + price + "]";
	}
	
	
}

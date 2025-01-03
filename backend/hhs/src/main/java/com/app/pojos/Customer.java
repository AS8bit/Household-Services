package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"systemLog","serviceProviders"})
public class Customer 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@Column(length = 50, unique = true)
	@Length(min = 5,max=50,message = "Invalid Email length")
	private String email;
	
	@Column(length = 20,nullable = false)
	//@JsonIgnore
	private String password;
	
	@Column(name="contact",length =10)
	private String contactNo;
	
	@Column(length =20)
	private Integer houseNo;
	
	@Column(length =20)
	private String street;
	
	@Column(length =20)
	private String area;
	
	@Column(length =20)
	private String landmark;
	
	@OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
	private List<SystemLog> systemLog = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "cust_ServiceProvider", 
	joinColumns = @JoinColumn(name = "customer_id"),
	inverseJoinColumns = @JoinColumn(name = "serviceprovider_id"))
	private List<ServiceProvider> serviceProviders = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public List<SystemLog> getSystemLog() {
		return systemLog;
	}

	public void setSystemLog(List<SystemLog> systemLog) {
		this.systemLog = systemLog;
	}

	public List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + ", houseNo=" + houseNo + ", street=" + street
				+ ", area=" + area + ", landmark=" + landmark + "]";
	}
}

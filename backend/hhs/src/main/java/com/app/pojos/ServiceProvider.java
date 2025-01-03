package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="service_provider")
public class ServiceProvider
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name",length =20)
	private String firstName;
	
	@Column(name="last_name",length =20)
	private String lastName;
	
	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="cost")
	private Integer serviceCost;
	
	@Column(length = 20,unique = true)
	private String email;
	
	@Column(name="contact", length = 10)
	private String contactNo;
	
	private int experience;
	
	private Float rating;
	
	@OneToMany(mappedBy = "vendor")
	private List<SystemLog> systemLog = new ArrayList<>();
	
	@ManyToMany(mappedBy = "serviceProviders")
	private List<Customer> users = new ArrayList<>();

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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(Integer serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public List<SystemLog> getSystemLog() {
		return systemLog;
	}

	public void setSystemLog(List<SystemLog> systemLog) {
		this.systemLog = systemLog;
	}

	public List<Customer> getUsers() {
		return users;
	}

	public void setUsers(List<Customer> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "ServiceProvider [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", serviceType="
				+ serviceType + ", serviceCost=" + serviceCost + ", email=" + email + ", contactNo=" + contactNo
				+ ", experience=" + experience + ", rating=" + rating + "]";
	}
		
}

package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "system_log")
public class SystemLog 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int logNo;
	
	@Column(name = "customer_email")
	private String customerEmail;
	
	@Column(name = "vendor_email")
	private String vendorEmail;
	
	@Column(name = " service_type")
	private String serviceType;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "experience")
	private int experience;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id") 
	private Customer cust;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id") //fk
	private ServiceProvider vendor;


	public int getLogNo() {
		return logNo;
	}


	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getVendorEmail() {
		return vendorEmail;
	}


	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public Customer getCust() {
		return cust;
	}


	public void setCust(Customer cust) {
		this.cust = cust;
	}


	public ServiceProvider getVendor() {
		return vendor;
	}


	public void setVendor(ServiceProvider vendor) {
		this.vendor = vendor;
	}


	@Override
	public String toString() 
	{
		return "SystemLog [logNo=" + logNo + ", customerEmail=" + customerEmail + ", vendorEmail=" + vendorEmail
				+ ", serviceType=" + serviceType + ", cost=" + cost + ", experience=" + experience + ", cust=" + cust
				+ ", vendor=" + vendor + "]";
	}
	
	
}

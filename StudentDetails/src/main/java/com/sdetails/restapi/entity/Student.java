package com.sdetails.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_address")
	private String address;
	
	@Column(name="address_pincode")
	private int pincode;
	
	@Column(name="student_mobilenumber")
	private String mobilenumber;
	
	

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String address, int pincode,String mobilenumber) {
		super();
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.mobilenumber = mobilenumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", pincode=" + pincode
				+ ", mobilenumber=" + mobilenumber + "]";
	}

	
}

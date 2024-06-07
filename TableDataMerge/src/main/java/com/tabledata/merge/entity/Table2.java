package com.tabledata.merge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name = "table2")
	public class Table2 {
	    @Id
	    @GeneratedValue(strategy  = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name="company_name")
	    private String name;
	    
	    @Column(name="company_address")
	    private String address;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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
		
	    
	}
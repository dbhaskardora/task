package com.data.ecommerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name = "TBL_PRODUCT")
	public class Product {
	    @Id @GeneratedValue(strategy  = GenerationType.IDENTITY)
	    private int productId;
	    private String productName;
	    private String productDescription;
	    private BigDecimal productPrice;
	    @Column(columnDefinition = "json")
//	    @Column
	    private String productImages;
	    // getters and setters
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public BigDecimal getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(BigDecimal productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductImages() {
			return productImages;
		}
		public void setProductImages(String productImages) {
			this.productImages = productImages;
		}
	    
	}

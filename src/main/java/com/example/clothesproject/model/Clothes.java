package com.example.clothesproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clothes_info")
public class Clothes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cloth_Id")
	private long clothId;
	@Column(name = "cloth_Name")
	private String clothName;
	@Column(name = "cloth_Price")
	private long clothPrice;
	@Column(name = "cloth_Brand")
	private String clothBrand;

	public long getClothId() {
		return clothId;
	}

	public void setClothId(long clothId) {
		this.clothId = clothId;
	}

	public String getClothName() {
		return clothName;
	}

	public void setClothName(String clothName) {
		this.clothName = clothName;
	}

	public long getClothPrice() {
		return clothPrice;
	}

	public void setClothPrice(long clothPrice) {
		this.clothPrice = clothPrice;
	}

	public String getClothBrand() {
		return clothBrand;
	}

	public void setClothBrand(String clothBrand) {
		this.clothBrand = clothBrand;
	}

	@Override
	public String toString() {
		return "Clothes [clothId=" + clothId + ", clothName=" + clothName + ", clothPrice=" + clothPrice
				+ ", clothBrand=" + clothBrand + "]";
	}

}

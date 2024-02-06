package com.example.clothesproject.dto;

public class ClothesDTO {
	
	private long clothId;
	
	private String clothName;
	
	private long clothPrice;
	
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
		return "ShowDTO [clothId=" + clothId + ", clothName=" + clothName + ", clothPrice=" + clothPrice
				+ ", clothBrand=" + clothBrand + "]";
	}

	public ClothesDTO(long clothId, String clothName, long clothPrice, String clothBrand) {
		super();
		this.clothId = clothId;
		this.clothName = clothName;
		this.clothPrice = clothPrice;
		this.clothBrand = clothBrand;
	}

	public ClothesDTO() {
		super();
	}
	
}

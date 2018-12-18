package com.bookourshow.model;

import org.springframework.beans.factory.annotation.Autowired;


public class City {
	private int cityId;
	private String cityName;

	
	public City() {
		super();
	}
	
	public int getCityId() {
		return cityId;
	}

	@Autowired
	public void setCityId(int cityid) {
		this.cityId = cityid;
	}

	public String getCityName() {
		return cityName;
	}

	public City(int cityid, String cityname) {
		super();
		this.cityId = cityid;
		this.cityName = cityname;
	}
	@Autowired
	public void setCityName(String cityname) {
		this.cityName = cityname;
	}

	@Override
	public String toString() {
		return "City [cityid=" + cityId + ", cityname=" + cityName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cityId;
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (cityId != other.cityId)
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		return true;
	}
	

}

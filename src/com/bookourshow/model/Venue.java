package com.bookourshow.model;

import java.util.List;

public class Venue {
	
	private int venueId;
	private String venueName;
	private Address address;
	private List<Timings> timingList;
	public Venue() {
		super();
	}
	
	public Venue(int venueId, String venueName, Address address) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.address = address;
	}
	
	
	public Venue(int venueId, String venueName, List<Timings> timingList) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.timingList = timingList;
	}

	public int getVenueId() {
		return venueId;
	}
	
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	public String getVenueName() {
		return venueName;
	}
	
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Timings> getTimingList() {
		return timingList;
	}

	public void setTimingList(List<Timings> timingList) {
		this.timingList = timingList;
	}
	
	
	
	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", address=" + address + ", timingList="
				+ timingList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + venueId;
		result = prime * result + ((venueName == null) ? 0 : venueName.hashCode());
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
		Venue other = (Venue) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (venueId != other.venueId)
			return false;
		if (venueName == null) {
			if (other.venueName != null)
				return false;
		} else if (!venueName.equals(other.venueName))
			return false;
		return true;
	}

	

}

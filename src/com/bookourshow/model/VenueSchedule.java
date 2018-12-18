package com.bookourshow.model;

public class VenueSchedule {
	private int venueScheduleId;
	private Screen screen;
	private Venue venue;
	private Timings timings;
	private MovieCategory moviecategory;

	public VenueSchedule() {
		// TODO Auto-generated constructor stub
	}
	
	public VenueSchedule(int venueScheduleId, Screen screen, Venue venue, Timings timings,
			MovieCategory moviecategory) {
		super();
		this.venueScheduleId = venueScheduleId;
		this.screen = screen;
		this.venue = venue;
		this.timings = timings;
		this.moviecategory = moviecategory;
	}

	public int getVenueScheduleId() {
		return venueScheduleId;
	}

	public void setVenueScheduleId(int venueScheduleId) {
		this.venueScheduleId = venueScheduleId;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Timings getTimings() {
		return timings;
	}

	public void setTimings(Timings timings) {
		this.timings = timings;
	}

	public MovieCategory getMoviecategory() {
		return moviecategory;
	}

	public void setMoviecategory(MovieCategory moviecategory) {
		this.moviecategory = moviecategory;
	}

	@Override
	public String toString() {
		return "VenueSchedule [venueScheduleId=" + venueScheduleId + ", timings=" + timings + ", moviecategory="
				+ moviecategory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moviecategory == null) ? 0 : moviecategory.hashCode());
		result = prime * result + ((timings == null) ? 0 : timings.hashCode());
		result = prime * result + venueScheduleId;
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
		VenueSchedule other = (VenueSchedule) obj;
		if (moviecategory == null) {
			if (other.moviecategory != null)
				return false;
		} else if (!moviecategory.equals(other.moviecategory))
			return false;
		if (timings == null) {
			if (other.timings != null)
				return false;
		} else if (!timings.equals(other.timings))
			return false;
		if (venueScheduleId != other.venueScheduleId)
			return false;
		return true;
	}

}

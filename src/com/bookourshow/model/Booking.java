package com.bookourshow.model;

public class Booking {

	private int bookingId;
	private int noOfSeats;
	private User user;
	private VenueSchedule venueSchedule;
	private String bookDate;
	private float amount;
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingId, int noOfSeats, User user, VenueSchedule venueSchedule, String bookDate) {
		super();
		this.bookingId = bookingId;
		this.noOfSeats = noOfSeats;
		this.user = user;
		this.venueSchedule = venueSchedule;
		this.bookDate = bookDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VenueSchedule getVenueSchedule() {
		return venueSchedule;
	}

	public void setVenueSchedule(VenueSchedule venueSchedule) {
		this.venueSchedule = venueSchedule;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", noOfSeats=" + noOfSeats + ", bookDate=" + bookDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDate == null) ? 0 : bookDate.hashCode());
		result = prime * result + bookingId;
		result = prime * result + noOfSeats;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((venueSchedule == null) ? 0 : venueSchedule.hashCode());
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
		Booking other = (Booking) obj;
		if (bookDate == null) {
			if (other.bookDate != null)
				return false;
		} else if (!bookDate.equals(other.bookDate))
			return false;
		if (bookingId != other.bookingId)
			return false;
		if (noOfSeats != other.noOfSeats)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (venueSchedule == null) {
			if (other.venueSchedule != null)
				return false;
		} else if (!venueSchedule.equals(other.venueSchedule))
			return false;
		return true;
	}
	
	
}

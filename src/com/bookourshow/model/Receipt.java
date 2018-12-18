package com.bookourshow.model;

public class Receipt {

	private Booking booking;
	private SeatColumn seatColumn;
	private SeatRow seatRow;
	
	public Receipt() {
		// TODO Auto-generated constructor stub
	}

	public Receipt(Booking booking, SeatColumn seatColumn, SeatRow seatRow) {
		super();
		this.booking = booking;
		this.seatColumn = seatColumn;
		this.seatRow = seatRow;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public SeatColumn getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(SeatColumn seatColumn) {
		this.seatColumn = seatColumn;
	}

	public SeatRow getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(SeatRow seatRow) {
		this.seatRow = seatRow;
	}

	@Override
	public String toString() {
		return "Receipt [seatColumn=" + seatColumn + ", seatRow=" + seatRow + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((seatColumn == null) ? 0 : seatColumn.hashCode());
		result = prime * result + ((seatRow == null) ? 0 : seatRow.hashCode());
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
		Receipt other = (Receipt) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (seatColumn == null) {
			if (other.seatColumn != null)
				return false;
		} else if (!seatColumn.equals(other.seatColumn))
			return false;
		if (seatRow == null) {
			if (other.seatRow != null)
				return false;
		} else if (!seatRow.equals(other.seatRow))
			return false;
		return true;
	}

	
}

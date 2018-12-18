package com.bookourshow.model;

public class SeatPrice {

	private int seatPriceId;
	private Price price;
	private SeatRow seatRow;
	
	public SeatPrice() {
		// TODO Auto-generated constructor stub
	}

	public SeatPrice(int seatPriceId, Price price, SeatRow seatRow) {
		super();
		this.seatPriceId = seatPriceId;
		this.price = price;
		this.seatRow = seatRow;
	}

	public int getSeatPriceId() {
		return seatPriceId;
	}

	public void setSeatPriceId(int seatPriceId) {
		this.seatPriceId = seatPriceId;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public SeatRow getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(SeatRow seatRow) {
		this.seatRow = seatRow;
	}

	@Override
	public String toString() {
		return "SeatPrice [seatPriceId=" + seatPriceId + ", price=" + price + ", seatRow=" + seatRow + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + seatPriceId;
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
		SeatPrice other = (SeatPrice) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seatPriceId != other.seatPriceId)
			return false;
		if (seatRow == null) {
			if (other.seatRow != null)
				return false;
		} else if (!seatRow.equals(other.seatRow))
			return false;
		return true;
	}
	
	
}

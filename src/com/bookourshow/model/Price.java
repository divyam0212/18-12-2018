package com.bookourshow.model;

public class Price {

	private int priceId;
	private String priceCode;
	private float amount;

	public Price() {
		// TODO Auto-generated constructor stub
	}

	public Price(int priceId, String priceCode, float amount) {
		super();
		this.priceId = priceId;
		this.priceCode = priceCode;
		this.amount = amount;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", priceCode=" + priceCode + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((priceCode == null) ? 0 : priceCode.hashCode());
		result = prime * result + priceId;
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
		Price other = (Price) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (priceCode == null) {
			if (other.priceCode != null)
				return false;
		} else if (!priceCode.equals(other.priceCode))
			return false;
		if (priceId != other.priceId)
			return false;
		return true;
	}

	
}

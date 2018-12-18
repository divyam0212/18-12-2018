package com.bookourshow.model;

public class SeatRow {

	private int rowId;
	private String rowCode;
	
	public SeatRow() {
		// TODO Auto-generated constructor stub
	}

	public SeatRow(int rowId, String rowCode) {
		super();
		this.rowId = rowId;
		this.rowCode = rowCode;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getRowCode() {
		return rowCode;
	}

	public void setRowCode(String rowCode) {
		this.rowCode = rowCode;
	}

	@Override
	public String toString() {
		return "SeatRow [rowId=" + rowId + ", rowCode=" + rowCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rowCode == null) ? 0 : rowCode.hashCode());
		result = prime * result + rowId;
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
		SeatRow other = (SeatRow) obj;
		if (rowCode == null) {
			if (other.rowCode != null)
				return false;
		} else if (!rowCode.equals(other.rowCode))
			return false;
		if (rowId != other.rowId)
			return false;
		return true;
	}

	
}

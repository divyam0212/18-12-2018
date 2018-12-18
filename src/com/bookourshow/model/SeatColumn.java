package com.bookourshow.model;

public class SeatColumn {

	private int columnId;
	private String columnCode;
	
	public SeatColumn() {
		// TODO Auto-generated constructor stub
	}

	public SeatColumn(int columnId, String columnCode) {
		super();
		this.columnId = columnId;
		this.columnCode = columnCode;
	}

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	@Override
	public String toString() {
		return "SeatColumn [columnId=" + columnId + ", columnCode=" + columnCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnCode == null) ? 0 : columnCode.hashCode());
		result = prime * result + columnId;
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
		SeatColumn other = (SeatColumn) obj;
		if (columnCode == null) {
			if (other.columnCode != null)
				return false;
		} else if (!columnCode.equals(other.columnCode))
			return false;
		if (columnId != other.columnId)
			return false;
		return true;
	}

	
}

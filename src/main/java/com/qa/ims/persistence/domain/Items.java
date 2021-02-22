package com.qa.ims.persistence.domain;

public class Items {

	private Long IID;
	private String name;
	private Double price;

	public Items(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	public Items(Long IID, String name, Double price) {
		this.setIID(IID);
		this.setName(name);
		this.setPrice(price);
	}

	public Long getIID() {
		return IID;
	}

	public void setIID(Long IID) {
		this.IID = IID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "id:" + IID + " name:" + name + " price:" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((IID == null) ? 0 : IID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Items other = (Items) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (IID == null) {
			if (other.IID != null)
				return false;
		} else if (!IID.equals(other.IID))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}

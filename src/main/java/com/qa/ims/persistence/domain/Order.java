package com.qa.ims.persistence.domain;

public class Order {

	private Long orderID;
	private Long custID;
	private Long Item_ID;
	private Long quantity;

	public Order(Long custID, Long Item_ID, Long quantity) {
		this.setCustID(custID);
		this.setItem_ID(Item_ID);
		this.setQuantity(quantity);
	}

	public Order(Long orderID, Long custID, Long Item_ID, Long quantity) {
		this.setOrderID(orderID);
		this.setCustID(custID);
		this.setItem_ID(Item_ID);
		this.setQuantity(quantity);
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	public Long getItem_ID() {
		return Item_ID;
	}

	public void setItem_ID(Long item_ID) {
		Item_ID = item_ID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "orderID:" + orderID + " custID:" + custID + " itemID" + Item_ID + " quantity:" + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((custID == null) ? 0 : custID.hashCode());
		result = prime * result + ((Item_ID == null) ? 0 : Item_ID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Order other = (Order) obj;
		if (getOrderID() == null) {
			if (other.getOrderID() != null)
				return false;
		} else if (!getOrderID().equals(other.getOrderID()))
			return false;
		if (custID == null) {
			if (other.custID != null)
				return false;
		} else if (!custID.equals(other.custID))
			return false;
		if (Item_ID == null) {
			if (other.Item_ID != null)
				return false;
		} else if (!Item_ID.equals(other.Item_ID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;

		return true;
	}

}

package com.qa.ims.persistence.domain;

public class Order {

	private Long Order_ID;
	private Long customer_ID;
	private Long Item_ID;
	private Long quantity;
	private Double Tcost;

	public Order(Long customer_ID, Long Item_ID, Long quantity) {
		this.setCustID(customer_ID);
		this.setItem_ID(Item_ID);
		this.setQuantity(quantity);
	}

	public Order(Long Order_ID, Long customer_ID, Long Item_ID, Long quantity, Double Tcost) {
		this.setOrderID(Order_ID);
		this.setCustID(customer_ID);
		this.setItem_ID(Item_ID);
		this.setQuantity(quantity);
		this.setCost(Tcost);
	}

	public Long getOrderID() {
		return Order_ID;
	}

	public void setOrderID(Long Order_ID) {
		this.Order_ID = Order_ID;
	}

	public Long getCustID() {
		return customer_ID;
	}

	public void setCustID(Long customer_ID) {
		this.customer_ID = customer_ID;
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
	
	public Double getCost() {
		return Tcost;
	}

	public void setCost(Double cost) {
		this.Tcost = cost;
	}

	@Override
	public String toString() {
		return "orderID:" + Order_ID + " custID:" + customer_ID + " itemID:" + Item_ID + " quantity:" + quantity
				+ " cost:" + Tcost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Order_ID == null) ? 0 : Order_ID.hashCode());
		result = prime * result + ((customer_ID == null) ? 0 : customer_ID.hashCode());
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
		if (customer_ID == null) {
			if (other.customer_ID != null)
				return false;
		} else if (!customer_ID.equals(other.customer_ID))
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

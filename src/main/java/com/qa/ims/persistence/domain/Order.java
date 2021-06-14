package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private String orderStatus;
	private Double orderPrice;
	private Long custID;

	private Long itemID;
	private Long orderQuatitiy;
	private Double unitPrice;
	private Long orderItemsID;
	
	

	public Order(Long orderId, String orderStatus, Double orderPrice, Long custID, Long itemID, Long orderQuatitiy,
			Double unitPrice, Long orderItemsID) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderPrice = orderPrice;
		this.custID = custID;
		this.itemID = itemID;
		this.orderQuatitiy = orderQuatitiy;
		this.unitPrice = unitPrice;
		this.orderItemsID = orderItemsID;
	}



	public Order(String orderStatus, Double orderPrice, Long custID) {
		super();
		this.orderStatus = orderStatus;
		this.orderPrice = orderPrice;
		this.custID = custID;
	}



	public Order(Long orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}

	public Order(Long itemID,  Long orderQuatitiy, Long orderId) {
		super();
		this.orderId = orderId;
		this.itemID = itemID;
		this.orderQuatitiy = orderQuatitiy;
	}

	public Order(Long orderId, Long itemID) {
		super();
		this.orderId = orderId;
		this.itemID = itemID;
	}

	public Order(String orderStatus, Long custID) {
		super();
		this.orderStatus = orderStatus;
		this.custID = custID;
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public Long getOrderQuatitiy() {
		return orderQuatitiy;
	}

	public void setOrderQuatitiy(Long orderQuatitiy) {
		this.orderQuatitiy = orderQuatitiy;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getOrderItemsID() {
		return orderItemsID;
	}

	public void setOrderItemsID(Long orderItemsID) {
		this.orderItemsID = orderItemsID;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + " Order Status: " + orderStatus + " Order Price: £" + orderPrice + " Customer ID: "
				+ custID + " Item ID: " + itemID + " Order Quatitiy: " + orderQuatitiy + " Unit Price: £" + unitPrice
				+ " OrderItems ID: " + orderItemsID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custID == null) ? 0 : custID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderItemsID == null) ? 0 : orderItemsID.hashCode());
		result = prime * result + ((orderPrice == null) ? 0 : orderPrice.hashCode());
		result = prime * result + ((orderQuatitiy == null) ? 0 : orderQuatitiy.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		if (custID == null) {
			if (other.custID != null)
				return false;
		} else if (!custID.equals(other.custID))
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderItemsID == null) {
			if (other.orderItemsID != null)
				return false;
		} else if (!orderItemsID.equals(other.orderItemsID))
			return false;
		if (orderPrice == null) {
			if (other.orderPrice != null)
				return false;
		} else if (!orderPrice.equals(other.orderPrice))
			return false;
		if (orderQuatitiy == null) {
			if (other.orderQuatitiy != null)
				return false;
		} else if (!orderQuatitiy.equals(other.orderQuatitiy))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

	

}

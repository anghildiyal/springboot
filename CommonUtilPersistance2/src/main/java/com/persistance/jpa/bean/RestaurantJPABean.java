package com.persistance.jpa.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurant")
public class RestaurantJPABean {

	@Id
	@Column(name = "restaurant_id")
	private Integer restaurantId;

	@Column(name = "restaurant_name")
	private String restaurantName;



	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	@Override
	public String toString() {
		return "RestaurantJPABean [ restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ "]";
	}

	public RestaurantJPABean( Integer restaurantId, String restaurantName) {
		super();
	
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}

	public RestaurantJPABean() {

	}

}

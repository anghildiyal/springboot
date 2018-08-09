package com.persistance.mongo.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Reservation")
public class ReservationMongoBean implements Serializable {

	@Id
	private Long id;

	
	private String dt;


	private Long userId;

	
	private Long restaurantId;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	// Don't use camelcase columns in DB
	
	private int partySize;

	public ReservationMongoBean() {
	}

	


	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReservationMongoBean [id=" + id + ", dt=" + dt + ", userId=" + userId + ", restaurantId=" + restaurantId
				+ ", partySize=" + partySize + "]";
	}

	public ReservationMongoBean(Long id, String dt, Long userId, Long restaurantId, int partySize) {
		super();
		this.id = id;
		this.dt = dt;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.partySize = partySize;
	}



	

}
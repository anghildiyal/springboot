package com.persistance.jpa.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class ReservationJPABean implements Serializable {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "dt")
	private Timestamp dt;

	@Column(name = "user_id")
	private Long userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantId")
	private RestaurantJPABean restaurantId;

	@Column(name = "party_size")
	private int partySize;

	public ReservationJPABean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDt() {
		return dt;
	}

	public void setDt(Timestamp dt) {
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

	public RestaurantJPABean getRestaurant() {
		return restaurantId;
	}

	public void setRestaurant(RestaurantJPABean restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dt=" + dt + ", userId=" + userId + ", partySize=" + partySize + "]";
	}

	public ReservationJPABean(Long id, Timestamp dt, Long userId, Long restaurantId, int partySize) {
		super();
		this.id = id;
		this.dt = dt;
		this.userId = userId;

		this.partySize = partySize;
	}

}
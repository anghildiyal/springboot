package com.persistance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.persistance.jpa.bean.ReservationJPABean;
import com.persistance.jpa.service.ReservationService;
import com.persistance.mongo.bean.ReservationMongoBean;

@RestController

public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	// ------------ Retrieve all reservations ------------
	@RequestMapping(value = "/reservations/{dbName}/getAll/", method = RequestMethod.GET)
	public List getAllReservations(@PathVariable String dbName) {

		return reservationService.getAllReservations(dbName);

	}

	// ------------ Retrieve a reservation ------------
	@RequestMapping(value = "/reservations/{dbName}/{id}", method = RequestMethod.GET)
	public Object getReservation(@PathVariable String id,@PathVariable String dbName) {
		return reservationService.getReservation(Long.valueOf(id),dbName);
	}

	// ------------ Create a reservation ------------
	@RequestMapping(value = "/reservations/JPA/save", method = RequestMethod.POST)
	
	public void addReservation(@RequestBody ReservationJPABean reservation) {
		reservationService.addReservation(reservation);

	}

	@RequestMapping(value = "/reservations/Mongo/save", method = RequestMethod.POST)
	
	public void addReservationMongo(@RequestBody ReservationMongoBean reservation) {
		reservationService.addReservationMongo(reservation);

	}

	// ------------ Update a reservation ------------
	@RequestMapping(value = "/reservations/JPA/{id}", method = RequestMethod.PUT)
	public void updateReservation(@RequestBody ReservationJPABean reservation, @PathVariable String id) {
		reservationService.updateReservation(Long.valueOf(id), reservation);
	}
	@RequestMapping(value = "/reservations/Mongo/{id}", method = RequestMethod.PUT)
	public void updateReservation(@RequestBody ReservationMongoBean reservation, @PathVariable String id) {
		reservationService.updateReservationMongo(Long.valueOf(id), reservation);
	}

	// ------------ Delete a reservation ------------
	@RequestMapping(value = "/reservations/{dbName}/{id}", method = RequestMethod.DELETE)
	public void deleteReservation(@PathVariable String id,@PathVariable String dbName) {
		reservationService.deleteReservation(Long.valueOf(id),dbName);
	}
	//--------Custom Search -------
	@RequestMapping(value = "/reservations/search/{restId}", method = RequestMethod.GET)
	public ReservationJPABean searchResturantID(@PathVariable Long restId) {
		ReservationJPABean obj= reservationService.searchResturantID(restId);
		return obj;
	}
	//--------Custom Search -------
	@RequestMapping(value = "/reservations/searchUserID/{userID}", method = RequestMethod.GET)
	public ReservationJPABean searchUserID(@PathVariable Long userID) {
		ReservationJPABean obj= reservationService.searchUserID(userID);
		return obj;
	}
}

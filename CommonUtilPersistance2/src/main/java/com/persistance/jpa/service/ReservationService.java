package com.persistance.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.persistance.jpa.bean.ReservationJPABean;
import com.persistance.mongo.bean.ReservationMongoBean;

@Service
public interface ReservationService {

	
	public List getAllReservations(String dbName) ;

	// Retrieves one row from table based on given id
	public Object getReservation(Long id,String dbName) ;

	// Inserts row into table
	public void addReservation(ReservationJPABean reservation) ;
	public void addReservationMongo(ReservationMongoBean reservation);

	// Updates row in table
	public void updateReservation(Long id, ReservationJPABean reservation) ;
	public void updateReservationMongo(Long id, ReservationMongoBean reservation) ;
	

	// Removes row from table
	public void deleteReservation(Long id,String dbName);
	
	//Custom Search
	public ReservationJPABean searchResturantID(Long restID);
	public ReservationJPABean searchUserID(Long userID);
	
}

package com.persistance.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistance.jpa.bean.ReservationJPABean;
import com.persistance.jpa.repository.JPARepository;
import com.persistance.mongo.bean.ReservationMongoBean;
import com.persistance.mongo.repository.ReservationMongoRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationMongoRepository reservationMongoRepo;

	@Autowired
	private JPARepository reservationJpaRepo;

	// Retrieve all rows from table and populate list with objects
	public List getAllReservations(String dbName) {
		List reservations = new ArrayList<>();
		if ("Mongo".equalsIgnoreCase(dbName)) {
			reservationMongoRepo.findAll().forEach(reservations::add);
		} else {

			reservationJpaRepo.findAll().forEach(reservations::add);
		}
		return reservations;
	}

	// Retrieves one row from table based on given id

	public Object getReservation(Long id, String dbName) {
		if ("Mongo".equalsIgnoreCase(dbName)) {
			Optional<ReservationMongoBean> revObj = reservationMongoRepo.findById(id);
			return revObj.isPresent() ? revObj.get() : null;
		} else {
			Optional<ReservationJPABean> revObj = reservationJpaRepo.findById(id);
			return revObj.isPresent() ? revObj.get() : null;
		}
	}

	// Inserts row into table

	public void addReservation(ReservationJPABean reservation) {
		// reservationRepository.save(reservation);
		reservationJpaRepo.save(reservation);
	}

	public void addReservationMongo(ReservationMongoBean reservation) {
		reservationMongoRepo.save(reservation);

	}

	// Updates row in table
	public void updateReservation(Long id, ReservationJPABean reservation) {
		reservationJpaRepo.save(reservation);
	}

	public void updateReservationMongo(Long id, ReservationMongoBean reservation) {
		reservationMongoRepo.save(reservation);
	}

	// Removes row from table
	public void deleteReservation(Long id, String dbName) {
		if ("Mongo".equalsIgnoreCase(dbName))
			reservationMongoRepo.deleteById(id);
		else
			reservationJpaRepo.deleteById(id);
		;
	}
	
	//Serach 
	public ReservationJPABean searchResturantID(Long restId) {
		return reservationJpaRepo.findByRestaurant(restId);
		
		//return reservationJpaRepo.fin
	}

	@Override
	public ReservationJPABean searchUserID(Long userID) {
	
		return reservationJpaRepo.findByUserId(userID);
	}
	

}

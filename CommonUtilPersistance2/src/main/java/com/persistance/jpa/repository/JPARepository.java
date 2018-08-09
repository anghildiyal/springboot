package com.persistance.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.persistance.jpa.bean.ReservationJPABean;

public interface JPARepository extends JpaRepository<ReservationJPABean,Long> { 
	

	@Query(name = "ReservationJPABean.findByRestaurant", nativeQuery = true) 
	public ReservationJPABean findByRestaurant(Long restaurantId );
	
	ReservationJPABean findByUserId(Long userid);
	
}

package com.example.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.appointment.Entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
	
	@Query("from Appointment where date <= :startDate and date >=:endDate")
	List<Appointment> getAllAppoimentBy(@Param("startDate")String startDate,@Param("endDate")String endDate);

}

package com.example.appointment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.Entity.Appointment;
import com.example.appointment.Exception.CustomException;
import com.example.appointment.Service.AppointmentService;
import com.example.appointment.Service.UserService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	
	@Autowired
	private AppointmentService appointmentService;
	
	
	//user can take the appointment if user is present
	@PostMapping("/save")
	public ResponseEntity<Appointment> save(Appointment appointment)throws CustomException{
		return ResponseEntity.ok().body(appointmentService.save(appointment));
	}
	
	
	//get appointment details by his appointment Id
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Appointment>> getAppointment(@PathVariable("id")int id)throws CustomException{
		return ResponseEntity.ok().body(appointmentService.getAppoinment(id));
	}
	
	
	//user can delete appointment
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")int id)throws CustomException{
		appointmentService.deleteAppointment(id);
	}
	
	
	//user can update Appointment
	@PutMapping("/update/{id}")
	public ResponseEntity<Appointment> update(Appointment appointment,@PathVariable("id")int id)throws CustomException{
		return ResponseEntity.ok().body(appointmentService.updateAppointment(appointment, id));
	}
	
	
	//appointment receiver can update status of appointment like if it is CANCEL or CONFIRMED
	@PutMapping("/status/{id}")
	public ResponseEntity<Appointment> updateStatus(Appointment appointment,@PathVariable("id")int id)throws CustomException{
		return ResponseEntity.ok().body(appointmentService.updateAppointmentStatus(appointment, id));
	}
	
	
	//user can get the all the appointments by startdate and end of the date
	@GetMapping("/get/{startDate}/{endDate}")
	public ResponseEntity<List<Appointment>> getAppointmentsBy(@PathVariable("startDate")String startDate,
			@PathVariable("endDate")String endDate){
		return ResponseEntity.ok().body(appointmentService.getAllAppointments(startDate, endDate));
	}
}

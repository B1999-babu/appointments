package com.example.appointment.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.Entity.Appointment;
import com.example.appointment.Entity.User;
import com.example.appointment.Exception.CustomException;
import com.example.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserService userService;
	
	public Appointment save(Appointment appoinment) throws CustomException{
		Optional<User> user=userService.getUserByEmail(appoinment.getUserEmail()); 
		if(!user.isPresent()) {
			throw new CustomException("User not found");
		}
		return appointmentRepository.save(appoinment);
	}
	
	public Optional<Appointment> getAppoinment(int id)throws CustomException{
		Optional<Appointment> appointment=appointmentRepository.findById(id);
		if(!appointment.isPresent()) {
			throw new CustomException("Appoinment not found");
		}
		return appointment;
	}
	
	public List<Appointment> getAllAppointments(String startDate, String endDate){
		return appointmentRepository.getAllAppoimentBy(startDate, endDate);
	}
	
	public void deleteAppointment(int id)throws CustomException {
		 Optional<Appointment> appointment=getAppoinment(id);
		 if(appointment.isPresent()) {
		appointmentRepository.deleteById(id);
		 }
	}
	
	public Appointment updateAppointment(Appointment appointment,int id)throws CustomException {
		 Optional<Appointment> appointmentId=getAppoinment(id);
		 if(appointmentId.isPresent()) 
			 appointment.setId(id);
		return appointmentRepository.save(appointment);
	}
	
	public Appointment getAppoinmentObj(int id){
		Optional<Appointment> appointment=appointmentRepository.findById(id);
		if(appointment.isPresent()) {
			return appointment.get();
		}
		return null;
	}
	
	public Appointment updateAppointmentStatus(Appointment appointment,int id)throws CustomException {
		 Appointment appointmentObj=getAppoinmentObj(id);
		 if(Objects.nonNull(appointmentObj)) 
			 appointmentObj.setStatus(appointment.getStatus());
		 appointmentObj.setReasonForCancellation(appointment.getReasonForCancellation());
		return appointmentRepository.save(appointmentObj);
	}
}

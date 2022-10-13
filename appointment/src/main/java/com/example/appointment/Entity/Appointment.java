package com.example.appointment.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.appointment.Enum.Status;



@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userEmail;
	private String reason;
	private String date;     //appoinment date
	private String appoimentStart;  //appointment needed on start time
	private String appoimentEnd;  //appointment needed on end time
	private String duration;  //duration of appointment needed
	@Enumerated(EnumType.STRING)
	private Status status;
	private String reasonForCancellation;
	@Column(updatable = false, insertable = false)
	private Date createdOn;
	@Column(updatable = false, insertable = false)
	private Date updatedOn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAppoimentStart() {
		return appoimentStart;
	}
	public void setAppoimentStart(String appoimentStart) {
		this.appoimentStart = appoimentStart;
	}
	public String getAppoimentEnd() {
		return appoimentEnd;
	}
	public void setAppoimentEnd(String appoimentEnd) {
		this.appoimentEnd = appoimentEnd;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getReasonForCancellation() {
		return reasonForCancellation;
	}
	public void setReasonForCancellation(String reasonForCancellation) {
		this.reasonForCancellation = reasonForCancellation;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", userEmail=" + userEmail + ", reason=" + reason + ", date=" + date
				+ ", appoimentStart=" + appoimentStart + ", appoimentEnd=" + appoimentEnd + ", duration=" + duration
				+ ", status=" + status + ", reasonForCancellation=" + reasonForCancellation + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
	
	
	
	
}

package com.assignment.springboot.model;

public class FlightBookingCountModel {
	
	private String source_location;
	private String destination_location;
	private String total_Successful_Booking;
	private String total_Cancelled_Booking;
	
	public FlightBookingCountModel() {
		
	}
	
	public FlightBookingCountModel(String source_location, String destination_location, String total_Successful_Booking,
			String total_Cancelled_Booking) {
		super();
		this.source_location = source_location;
		this.destination_location = destination_location;
		this.total_Successful_Booking = total_Successful_Booking;
		this.total_Cancelled_Booking = total_Cancelled_Booking;
	}
	
	public String getSource_location() {
		return source_location;
	}
	public void setSource_location(String source_location) {
		this.source_location = source_location;
	}
	public String getDestination_location() {
		return destination_location;
	}
	public void setDestination_location(String destination_location) {
		this.destination_location = destination_location;
	}
	public String getTotal_Successful_Booking() {
		return total_Successful_Booking;
	}
	public void setTotal_Successful_Booking(String total_Successful_Booking) {
		this.total_Successful_Booking = total_Successful_Booking;
	}
	public String getTotal_Cancelled_Booking() {
		return total_Cancelled_Booking;
	}
	public void setTotal_Cancelled_Booking(String total_Cancelled_Booking) {
		this.total_Cancelled_Booking = total_Cancelled_Booking;
	}
	

}

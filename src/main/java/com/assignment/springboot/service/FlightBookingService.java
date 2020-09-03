package com.assignment.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.assignment.springboot.dao.FlightBookingServiceCountDAO;
import com.assignment.springboot.model.FlightBookingCountModel;
import com.assignment.springboot.model.FlightBookingSuccessCountsonSource;


@Service
public class FlightBookingService {
	
	@Autowired
	FlightBookingServiceCountDAO flightBookingServiceCountDAO;
	
	@Cacheable("listofFlightBookingCount")
	public FlightBookingSuccessCountsonSource getsuccesscountOnSource() {
		List<FlightBookingCountModel> counts= flightBookingServiceCountDAO.getCountOfsuccessfullBookingInSource();
		return new FlightBookingSuccessCountsonSource(counts);
	}

	/*
	 * public Appointment getNewAppointment(String specialistName, String
	 * appointmentDay, String patientName) {
	 * 
	 * return
	 * flightBookingServiceCountDAO.getNewAppointment(specialistName,appointmentDay,
	 * patientName); }
	 * 
	 * public int checkAvailabilityOfBeds(String hospitalName) {
	 * 
	 * return flightBookingServiceCountDAO.getHospitalDetails(hospitalName); }
	 */
}

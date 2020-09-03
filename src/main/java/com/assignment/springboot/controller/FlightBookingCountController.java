package com.assignment.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.springboot.model.FlightBookingSuccessCountsonSource;
import com.assignment.springboot.service.FlightBookingService;

@RestController
public class FlightBookingCountController {
	
	@Autowired
	FlightBookingService flightBookingService;
	
	@GetMapping("/getSuccessBooking/fromSource")
	public FlightBookingSuccessCountsonSource getsuccessCountOnSource() throws Exception{
		return flightBookingService.getsuccesscountOnSource();
		
	}
	
	/*
	 * @GetMapping(
	 * "/newAppointment/{specialistName}/{appointmentDay}/{patientName}") public
	 * ResponseEntity<Appointment> newAppointment(
	 * 
	 * @PathVariable String specialistName,
	 * 
	 * @PathVariable String appointmentDay,
	 * 
	 * @PathVariable String patientName){
	 * 
	 * 
	 * return new
	 * ResponseEntity<Appointment>(flightBookingService.getNewAppointment(
	 * specialistName, appointmentDay,patientName), HttpStatus.OK);
	 * 
	 * }
	 * 
	 * @GetMapping("/noOfBedsAvailable/{hospitalName}") public
	 * ResponseEntity<String> getAvailableNoOfBeds(@PathVariable String
	 * hospitalName) { int availableNoOfBeds =
	 * flightBookingService.checkAvailabilityOfBeds(hospitalName);
	 * 
	 * 
	 * if (availableNoOfBeds==0) { throw new
	 * ApplicationException("beds are not available for Admission"); }
	 * 
	 * return new ResponseEntity<>( "Number of Beds Available is = " +
	 * availableNoOfBeds, HttpStatus.OK); }
	 */

}

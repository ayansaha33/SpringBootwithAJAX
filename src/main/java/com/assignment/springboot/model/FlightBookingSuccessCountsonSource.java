package com.assignment.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class FlightBookingSuccessCountsonSource {
	
	private List<FlightBookingCountModel> listofFlightBookingSuccessCountsonSource;
	
	public FlightBookingSuccessCountsonSource() {}

	public FlightBookingSuccessCountsonSource(List<FlightBookingCountModel> listofFlightBookingCount) {
		super();
		this.listofFlightBookingSuccessCountsonSource = listofFlightBookingCount;
	}

	public List<FlightBookingCountModel> getListofFlightBookingCount() {
		return listofFlightBookingSuccessCountsonSource;
	}

	public void setListofFlightBookingCount(List<FlightBookingCountModel> listofFlightBookingCount) {
		this.listofFlightBookingSuccessCountsonSource = listofFlightBookingCount;
	}

}

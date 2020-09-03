package com.assignment.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"listofFlightBookingSuccessCountsonDestination"
})
public class FlightBookingSuccessCountonDestination {
	
	private List<FlightBookingCountModel> listofFlightBookingSuccessCountsonDestination;
	
	public FlightBookingSuccessCountonDestination() {}

	public FlightBookingSuccessCountonDestination(List<FlightBookingCountModel> listofFlightBookingCount) {
		super();
		this.listofFlightBookingSuccessCountsonDestination = listofFlightBookingCount;
	}

	public List<FlightBookingCountModel> getListofFlightBookingCount() {
		return listofFlightBookingSuccessCountsonDestination;
	}

	public void setListofFlightBookingCount(List<FlightBookingCountModel> listofFlightBookingCount) {
		this.listofFlightBookingSuccessCountsonDestination = listofFlightBookingCount;
	}

}

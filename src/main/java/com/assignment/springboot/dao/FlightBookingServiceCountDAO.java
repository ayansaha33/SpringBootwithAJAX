package com.assignment.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.assignment.springboot.model.FlightBookingCountModel;


@Mapper
public interface FlightBookingServiceCountDAO {

	@Select("SELECT source_location, SUM(successful_booking_count) as 'total_Successful_Booking' FROM pss.Booking_Count where Source_location\r\n" + 
			"in('Kolkata','Mumbai','Chennai','Delhi') group by source_location")
	public List<FlightBookingCountModel> getCountOfsuccessfullBookingInSource();

	public List<FlightBookingCountModel> getNewAppointment(String specialistName, String appointmentDay, String patientName);
	
	public List<FlightBookingCountModel> getHospitalDetails(String hospitalName);
	
	
	

}

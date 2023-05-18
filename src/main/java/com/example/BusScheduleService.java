package com.example;

import java.util.List;

public interface BusScheduleService {
	   void search();
	    String getFrom();
	    void setFrom(String from);
	    String getTo();
	    void setTo(String to);
	    List<BusSchedule> getSchedules();

}

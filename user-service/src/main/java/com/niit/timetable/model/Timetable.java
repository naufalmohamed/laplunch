package com.niit.timetable.model;


import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="TimeTable")
public class Timetable {

	@Id
	private String timetableId;
	private String userEmailId;
	WeekDay weekDay;
	private   List<Menu> itemList;

	
//	public String getTimeTableId() {
//		return timeTableId;
//	}
//	public void setTimeTableId(String timeTableId) {
//		this.timeTableId = timeTableId;
//	}
//	public String getUserEmailId() {
//		return userEmailId;
//	}
//	public void setUserEmailId(String userEmailId) {
//		this.userEmailId = userEmailId;
//	}
	
}

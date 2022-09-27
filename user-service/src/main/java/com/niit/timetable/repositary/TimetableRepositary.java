package com.niit.timetable.repositary;


import com.niit.timetable.model.Timetable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimetableRepositary extends MongoRepository<Timetable, String> {

}

package com.niit.timetable.service;

import java.util.List;
import java.util.UUID;

import com.niit.timetable.model.Menu;
import com.niit.timetable.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.timetable.exceptions.TimeTableAlreadyExistsExceptions;
import com.niit.timetable.exceptions.TimeTableNotFoundExceptions;
import com.niit.timetable.repositary.TimetableRepositary;



@Service
public class TimetableService {
	
	
@Autowired
private final TimetableRepositary timetableRepositary;



private Timetable timetable;
public  TimetableService( TimetableRepositary timetableRepositary) {

	this.timetableRepositary = timetableRepositary;
}
// To get add new items  to weekdays
public void addtimetable(Timetable timetable)   {

	
//	if  (timetableRepositary.existsById(timetable.getUserEmailId())) {
//		throw new TimeTableAlreadyExistsExceptions();
//	}
	UUID uuid = UUID.randomUUID();
	timetable.setTimetableId(String.valueOf(uuid));
	timetableRepositary.save(timetable);

//	throw new TimeTableAlreadyExistsExceptions();


}
// to find all the weekdays 
public List<Timetable> findAllCarts() throws TimeTableNotFoundExceptions {

	
//	MongoRepository<Timetable, String> timetableRepository;
	return timetableRepositary.findAll();

}



 
 
 // To update or save the items using email Id
 public Timetable saveOrUpdate(Timetable timetable) throws TimeTableNotFoundExceptions {

	 Timetable savedMenuModel = timetableRepositary.findById(timetable.getUserEmailId()).get();
		if (timetableRepositary.existsById(timetable.getUserEmailId())) {

//
//			savedMenuModel.setUserEmailId(timetable.getItemList());
//			savedMenuModel.setUserEmailId(timetable.getUserEmailId());
			

			return timetableRepositary.save(timetable);

		}

		throw new TimeTableNotFoundExceptions();
	}

//To find item by using timetable id
 public Timetable findTimetableBytimetableId(String timeTableId) throws TimeTableNotFoundExceptions {

		if (
				timetableRepositary.existsById(timeTableId)) {

			return timetableRepositary.findById(timeTableId).get();
		}

		throw new TimeTableNotFoundExceptions();

	}
 public void deleteById(String timeTableId, int index) throws TimeTableNotFoundExceptions {
		if (timetableRepositary.existsById(timeTableId)) {
			Timetable timetable1=timetableRepositary.findById(timeTableId).get();
			timetable1.getItemList().remove(index);
			timetableRepositary.save(timetable1);

		}

		throw new TimeTableNotFoundExceptions();
	}

 

}

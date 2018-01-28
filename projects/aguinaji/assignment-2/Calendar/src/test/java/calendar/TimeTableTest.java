package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 
	 }
	 @Test
	  public void testGetApptRange()  throws Throwable {
         GregorianCalendar firstDay = new GregorianCalendar(2018, 7,27);
         GregorianCalendar lastDay = new GregorianCalendar(2018,7,29);



		 GregorianCalendar inc50west1 = new GregorianCalendar(2018, 7, 27);
		 GregorianCalendar inc50west2 = new GregorianCalendar(2019,9, 4);
		 GregorianCalendar inc50west3 = new GregorianCalendar(2020,10,2);

		 CalDay calday = new CalDay(inc50west1);
		 CalDay calDay2 = new CalDay(inc50west2);
		 CalDay calDay3 = new CalDay(inc50west3);


		 Appt unityGames = new Appt(8, 1,27, 7,2018,
				 					"Unity Games", "Unity Sports Games");

		 calday.addAppt(unityGames);
		 calDay2.addAppt(unityGames);
		 calDay3.addAppt(unityGames);

		 Appt musicalEvent = new Appt(10, 1,27,7,2018,
				 	                  "Musical","Musical Event");

		 calday.addAppt(musicalEvent);
		 calDay3.addAppt(musicalEvent);

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 appts.add(unityGames);
		 appts.add(musicalEvent);

		 TimeTable timetable = new TimeTable();

         LinkedList<CalDay> eventList = timetable.getApptRange(appts,firstDay,lastDay);

        //for (int i = 0; i < eventList.size(); i++)
          //  System.out.println(eventList.get(i).toString());

        CalDay eventFromList = eventList.get(0);
         assertTrue(eventFromList.getAppts().contains(unityGames));
         assertTrue(eventFromList.getAppts().contains(musicalEvent));

    }
//add more unit tests as you needed
}

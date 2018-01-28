package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void testGetMethods()  throws Throwable  {
		 GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);

		 CalDay calday = new CalDay(inc50west);

		 assertTrue(calday.isValid());
		 assertEquals(27, calday.getDay());
		 assertEquals(7, calday.getMonth());
		 assertEquals(2018, calday.getYear());
	 }

	 @Test
	  public void testAddAppt()  throws Throwable  {
		 GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
		 CalDay calday = new CalDay(inc50west);

		 Appt unityGames = new Appt(8, 1,27, 7,2018,
				 "Unity Games", "Unity Sports Games");
		 calday.addAppt(unityGames);
		 Appt musicalEvent = new Appt(10, 1,27,7,2018,
				 "Musical","Musical Event");
		 calday.addAppt(musicalEvent);

		 LinkedList<Appt> inc50westCalDay = calday.getAppts();

		 // Checks if appointments are in the list of appointments
		 assertTrue(inc50westCalDay.contains(unityGames));
		 assertTrue(inc50westCalDay.contains(musicalEvent));

		 Appt invalidEvent = new Appt(10, 0,0,7,2018,
				 "Musical","Musical Event");
		 calday.addAppt(invalidEvent);
		 assertFalse(calday.getAppts().contains(invalidEvent));

		 Appt service = new Appt(2, 1,27,7,2018,
				 "Service","Service Event");

		 calday.addAppt(service);
		 assertTrue(calday.getAppts().get(0).equals(service));


	 }

	@Test
	public void testToString()  throws Throwable  {
		GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
		CalDay calday = new CalDay(inc50west);

		String inc50westS = calday.toString();

		assertTrue(inc50westS.contains("7/27/2018"));

		Appt unityGames = new Appt(8, 1,27, 7,2018,
				"Unity Games", "Unity Sports Games");

		calday.addAppt(unityGames);
		calday.addAppt(unityGames);
		calday.addAppt(unityGames);

		assertTrue(calday.toString().contains("Unity Games"));

		CalDay calday2 = new CalDay();
		assertTrue(calday2.toString().matches(""));

	}

	@Test
	public void testIterator()	throws Throwable   {
		GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
		CalDay calday = new CalDay(inc50west);

		calday.iterator();

		CalDay calday2 = new CalDay();

		assertEquals(null, calday2.iterator());

	}

	 //add more unit tests as you needed
}

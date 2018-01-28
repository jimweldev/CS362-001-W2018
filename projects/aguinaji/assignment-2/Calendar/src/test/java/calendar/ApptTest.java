package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void testInvalidAppt()   throws Throwable {
		int startHour = 0;
		int startMinute = 0;
		int startDay = 0;
		int startMonth = 7;
		int startYear = 2018;
		String title = "INC Celebration";
		String description = "Celebration for the INC in the West";

		// Construct a new Appointment object with the initial data
	 	Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		// assertions
		 assertFalse(appt.getValid());
		 assertEquals(0, appt.getStartHour());
		 assertEquals(0, appt.getStartMinute());
		 assertEquals(0, appt.getStartDay());
		 assertEquals(7, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("INC Celebration", appt.getTitle());
		 assertEquals("Celebration for the INC in the West", appt.getDescription());

		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());

		 // Test start minute
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());

		 // test start day
		 appt.setStartDay(30);
		 assertFalse(appt.getValid());

	 }

	 @Test
	  public void testSetReccurence()	throws Throwable {
		 int startHour = 0;
		 int startMinute = 0;
		 int startDay = 27;
		 int startMonth = 7;
		 int startYear = 2018;
		 String title = "INC Celebration";
		 String description = "Celebration for the INC in the West";

		 // Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 int[] recurDaysArr={27};
		 appt.setRecurrence(recurDaysArr, appt.RECUR_BY_YEARLY, 2, 4);

		 assertEquals(4, appt.getRecurNumber());
		 assertEquals(3,appt.getRecurBy());
		 assertEquals(2, appt.getRecurIncrement());

		 int[] occurDates = appt.getRecurDays();
		 for(int i = 0; i < occurDates.length; i++) {
			 assertEquals(27, occurDates[i]);
		 }

		 assertTrue(appt.isRecurring());
		 assertFalse(appt2.isRecurring());
	  }

	 @Test
	  public void testToString() throws Throwable {
		 int startHour = 0;
		 int startMinute = 0;
		 int startDay = 27;
		 int startMonth = 7;
		 int startYear = 2018;
		 String title = "INC Celebration";
		 String description = "Celebration for the INC in the West";

		 // Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 String expectedOut = "7/27/2018 at 12:0am ,INC Celebration, Celebration for the INC in the West";

		 assertTrue(appt.toString().contains(expectedOut));

		 // check if an invalid appt will work
		 appt.setStartDay(0);
		 assertEquals(null, appt.toString());

	 }

	@Test
	public void testCompareTo() throws Throwable {
		int startHour = 0;
		int startMinute = 0;
		int startDay = 27;
		int startMonth = 7;
		int startYear = 2018;
		String title = "INC Celebration";
		String description = "Celebration for the INC in the West";

		// Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt2 = new Appt(startHour+5, startMinute+5, startDay-5, startMonth, startYear, title, description);

		assertEquals(0, appt.compareTo(appt));
		assertEquals(-5, appt.compareTo(appt2));



	}
//add more unit tests as you needed
	
}

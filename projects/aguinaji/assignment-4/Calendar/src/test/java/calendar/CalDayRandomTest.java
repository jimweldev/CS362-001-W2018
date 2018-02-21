package calendar;


import org.junit.Before;
import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests CalDay Class.
     */

	public static String RandomGetMethod(Random random){
		String[] methodArray = new String[] {"startHour","startMinute","startDay","startMonth","startYear"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

    /** TEST: public void addAppt(Appt appt) **/
	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random,-1, 24);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
				 if(!appt.getValid())continue;

				 /*if(sizeOfCalDay == 0){
				 	GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
				 	CalDay calDay = new CalDay(inc50west);


				 }*/
				 int newHour = startHour;

				for (int i = 0; i < NUM_TESTS; i++) {
					 GregorianCalendar inc50west = new GregorianCalendar(2018, 7, 27);
					 CalDay calDay = new CalDay(inc50west);
					 Random random2 = new Random(randomseed);
					 String methodName = CalDayRandomTest.RandomGetMethod(random2);
					 //String methodName = "startHour";
					 //int newHour = startHour;

					 if (methodName.equals("startHour")) {
						 newHour = ValuesGenerator.getRandomIntBetween(random2, -1, 24);
						 appt.setStartHour(newHour);
					 } else if (methodName.equals("startMinute")) {
						 int newMinute = ValuesGenerator.getRandomIntBetween(random2, -1, 60);
						 appt.setStartMinute(newMinute);
					 } else if (methodName.equals("startDay")) {
						 int newDay = ValuesGenerator.getRandomIntBetween(random2, 0, 32);
						 appt.setStartDay(newDay);
					 }

					 calDay.addAppt(appt);
					 //calDay.addAppt(appt);
					 //appt.setStartHour(newHour-1);
					 //calDay.addAppt(appt);
					 //appt.setStartHour(newHour+4);
					 //calDay.addAppt(appt);


					 for(int z = 0; z < 20; z++) {
						 //System.out.println("current: " + newHour);
						 if(newHour < 0 || newHour > 23) {
						 	newHour = ValuesGenerator.getRandomIntBetween(random2, 0, 23);
						 	continue;
						 }
						 int BeforeorAfter = ValuesGenerator.getRandomIntBetween(random2, 0, 1);
						 if (BeforeorAfter == 0) {
							 newHour = ValuesGenerator.getRandomIntBetween(random2, 0, newHour-1);
							 appt.setStartHour(newHour);
							 calDay.addAppt(appt);
							 //System.out.println("Before: " + newHour);
						 } else if (BeforeorAfter == 1) {
							 newHour = ValuesGenerator.getRandomIntBetween(random2, newHour+1, 23);
							 appt.setStartHour(newHour);
							 calDay.addAppt(appt);
							 //System.out.println("After: " + newHour);
						 }
					 }

				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");
	 }





	
}

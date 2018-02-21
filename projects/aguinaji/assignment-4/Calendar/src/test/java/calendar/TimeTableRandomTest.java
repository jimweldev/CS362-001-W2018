package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import sun.awt.image.ImageWatched;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	 private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	 private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	@Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 try {
		 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				/*** START OF TESTING ***/
				for(int z=0; z < NUM_TESTS; z++) {
					TimeTable timeTable = new TimeTable();
					LinkedList<Appt> apptList;
					int apptListLength = ValuesGenerator.getRandomIntBetween(random, 0, 10);

					if (apptListLength == 0) {
						apptList = null;
					} else {
						apptList = new LinkedList<Appt>();

						for (int i = 0; i < apptListLength; i++) {
							int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
							int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
							int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
							int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
							int startYear = ValuesGenerator.RandInt(random);
							String title = "Random Event";
							String description = "Random Event Generated";
							//Construct a new Appointment object with the initial data
							Appt appt = new Appt(startHour,
									startMinute,
									startDay,
									startMonth,
									startYear,
									title,
									description);

							apptList.add(appt);
						}
					}

					Appt testAppt;
					int apptExist = ValuesGenerator.getRandomIntBetween(random,0,1);
					if (apptExist == 1) {
						int randIndex = ValuesGenerator.getRandomIntBetween(random, 0, apptListLength);
						if(apptListLength != 0) {
							if (randIndex == apptListLength) {
								int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 33);
								int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 70);
								int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 28);
								int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
								int startYear = ValuesGenerator.RandInt(random);
								String title = "Random Test Event";
								String description = "Random Test Event Generated";
								//Construct a new Appointment object with the initial data
								testAppt = new Appt(startHour,
										startMinute,
										startDay,
										startMonth,
										startYear,
										title,
										description);

								timeTable.deleteAppt(apptList, testAppt);
							} else {
								testAppt = apptList.get(randIndex);
								timeTable.deleteAppt(apptList, testAppt);
							}
						}
					} else if (apptExist == 0) {
						testAppt = null;
						timeTable.deleteAppt(apptList, testAppt);
					}
				}



				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}

		 } catch (Exception e) { }

		 System.out.println("Done testing...");
		 
		 
	 }
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur
	}

	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur
	}

	@Test
	public void randomtest2()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				for(int z=0; z < NUM_TESTS; z++) {
					int randDay = ValuesGenerator.getRandomIntBetween(random,1,30);
					int randMonth = ValuesGenerator.getRandomIntBetween(random,1,11);
					int randDay2 = ValuesGenerator.getRandomIntBetween(random,1,30);
					int randMonth2 = ValuesGenerator.getRandomIntBetween(random,1,11);
					GregorianCalendar firstDay = new GregorianCalendar(2018, randMonth,randDay);
					GregorianCalendar lastDay = new GregorianCalendar(2018,randMonth2,randDay2);

					LinkedList<Appt> appts = new LinkedList<Appt>();

					for (int i = 0; i < ValuesGenerator.getRandomIntBetween(random, 0,20); i++) {
						int startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
						int startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
						int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 31);
						int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int startYear = 2018;
						String title = "Random Event";
						String description = "Random Event Generated";
						//Construct a new Appointment object with the initial data
						Appt appt = new Appt(startHour,
								startMinute,
								startDay,
								startMonth,
								startYear,
								title,
								description);

						int randomRecur = ValuesGenerator.getRandomIntBetween(random, 0, 1);	// 0 = not recurring | 1 = recurring

						if (randomRecur == 1) {
							int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							int recur=TimeTableRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber=TimeTableRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}

						appts.add(appt);
					}

					TimeTable timeTable = new TimeTable();
					try {
						timeTable.getApptRange(appts, firstDay, lastDay);
					} catch (DateOutOfRangeException e) { continue; }
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}

		} catch (Exception e) { }

		System.out.println("Done testing...");


	}
	
}

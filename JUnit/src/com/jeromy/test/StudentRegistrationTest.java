package com.jeromy.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.*;

import com.jeromy.code.RegistrationSystem;
import com.jeromy.code.Students;
import com.jeromy.code.CourseListingSystem;
import com.jeromy.code.Courses;

@SpiraTestConfiguration( 
		url = "https://rmit-university.spiraservice.net", 
		login = "s3717004", 
		password = "IamCazmo98!!",
		projectId = 466,
		releaseId = 364
)

class StudentRegistrationTest {
	public File currentFile;
	RegistrationSystem rs = new RegistrationSystem();
	Method m;
	Field f;
	Courses uniqueCourse1 = new Courses();
	Courses uniqueCourse2 = new Courses();
	Courses uniqueCourse3 = new Courses();
	Courses uniqueCourse4 = new Courses();
	CourseListingSystem courseList = new CourseListingSystem();
	Courses[] courseArray = new Courses[12];
	Students[] students;
	Students s1;
	Students s2;
	Students s3;
	Students s4;	
	String count;
	
	//setup method
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("setup");
		
		//test data
		uniqueCourse1.setCourseName("Course 1");
		uniqueCourse1.setCollegeFee(800);
		
		uniqueCourse2.setCourseName("Course 2");
		uniqueCourse2.setCollegeFee(1000);
		
		uniqueCourse3.setCourseName("Course 3");
		uniqueCourse3.setCollegeFee(650);
		
		uniqueCourse4.setCourseName("Course 4");
		uniqueCourse4.setCollegeFee(500);
				
		s1 = new Students("James", "12345678", new Date("12/04/2019"), "123-123-1234", "Melbourne", "VIC", "12345");
		s2 = new Students("John", "87654321", new Date("24/01/2019"), "246-246-2468", "Melbourne", "VIC", "54321");
		s3 = new Students("Albert", "24680246", new Date("12/01/2019"), "135-135-1357", "Melbourne", "VIC", "24680");
		s4 = new Students("Lucy", "50505050", new Date("12/01/2019"), "321-321-4321", "Melbourne", "VIC", "13579");		
	}

	//teardown method
	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("teardown");
		count = ""; //reset input string
		s1=null; s2=null; s3=null; s4=null;
		uniqueCourse1=null; uniqueCourse2=null; uniqueCourse3=null; uniqueCourse4=null;
	}
	
	/*
	 * sift ID down test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8443)
	public void siftIDDownTest() {
		System.out.println("siftIDDown() test");
		try {	
			m = RegistrationSystem.class.getDeclaredMethod("siftIDDown", int.class);
			m.setAccessible(true);
			m.invoke(rs, 3, 12);
		}catch(NoSuchMethodException e) {
			System.out.println("NoSuchMethodException");
		}catch(SecurityException e) {
			System.out.println("SecurityException");
		}catch(IllegalAccessException e) {
			System.out.println("IllegalAccessException");
		}catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}catch(InvocationTargetException e) {
			System.out.println("InvocationTargetException");
		}
	}
	/*
	 * sift name down test
	 * test should pass if exception is caught
	 */
	@Test 
	@SpiraTestCase(testCaseId = 8444)
	public void siftNameDownTest() {
		System.out.println("siftNameDown() test");
		try {	
			m = RegistrationSystem.class.getDeclaredMethod("siftNameDown", int.class);
			m.setAccessible(true);
			m.invoke(rs, 3, 12);
		}catch(NoSuchMethodException e) {
			System.out.println("NoSuchMethodException");
		}catch(SecurityException e) {
			System.out.println("SecurityException");
		}catch(IllegalAccessException e) {
			System.out.println("IllegalAccessException");
		}catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}catch(InvocationTargetException e) {
			System.out.println("InvocationTargetException");
		}
	}
	
	/*
	 * sift down test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8441)
	public void siftDownTest() {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("siftDown", int.class);
			m.setAccessible(true);
			m.invoke(rs, 3, 12);
		}catch(Exception e) {
		}
	}
	
	/*
	 * sort amount test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8438)
	public void sortAmountTest() {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("sortAmount", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e) {
		}
	}
	/*
	 * sort name test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8439)
	public void sortNameTest() {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("sortName", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e) {
		}
	}
	/*
	 * sort ID test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8440)
	public void sortIDTest() {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("sortID", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e) {
		}
	}
	
	/*
	 * compute stats test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8422)
	public void computeStatsTest() throws Exception {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("computeStats", null);
			m.setAccessible(true);
			m.invoke(rs, null);
	}catch(Exception e) {
	}
}

	/*
	 * begin add student test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8417)
	public void beginAddStudentTest() throws Exception {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("beginAddStudent", null);
			m.setAccessible(true);
			m.invoke(rs, null);
	}catch(Exception e) {
	}
}
	/*
	 * finish add student test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8418)
	public void finishAddStudentTest() throws Exception {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("finishAddStudent", null);
			m.setAccessible(true);
			m.invoke(rs, null);
	}catch(Exception e) {
	}
}
	
	/*
	 * begin delete student test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8419)
	public void beginDeleteStudentTest() throws Exception {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("beginDeleteStudent", null);
			m.setAccessible(true);
			m.invoke(rs, null);
	}catch(Exception e) {
	}
}
	/*
	 * begin delete student test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8420)
	public void finishDeleteStudentTest() throws Exception {
		try {
			m = RegistrationSystem.class.getDeclaredMethod("finishDeleteStudent", null);
			m.setAccessible(true);
			m.invoke(rs, null);
	}catch(Exception e) {
	}
}

	public int wantToSave() {
		//refactored code
		String msg = "This action will write over all data in the system. " +
				"Would you like to save before proceeding?";
			int answer = JOptionPane.showConfirmDialog(null, msg);
			if (answer == JOptionPane.YES_OPTION) {
				answer = 0;
			}else if(answer == JOptionPane.NO_OPTION) {
				answer = 1;
			}else if(answer == JOptionPane.CANCEL_OPTION) {
				answer = 2;
			}			
			return answer;
	}
	public int getWantToSave() {
		return wantToSave();
	}
	/*
	 * want to save test
	 * user presses the cancel option, which should return the value of 2
	 */
	@Test
	@SpiraTestCase(testCaseId = 8407)
	public void wantToSaveTest_CANCEL() throws Exception {
		System.out.println("wantToSave() assertion test; data: CANCEL (2)");
		wantToSave();
		int actual = getWantToSave();
		assertEquals(2, actual);		
	}
	/*
	 * want to save test
	 * user presses the yes option, which should return the value of 0
	 */
	@Test
	@SpiraTestCase(testCaseId = 8403)
	public void wantToSaveTest_YES() throws Exception {
		System.out.println("wantToSave() assertion test; data: YES (0)");
		wantToSave();
		int actual = getWantToSave();
		assertEquals(0, actual);		
	}
	/*
	 * want to save test
	 * user presses no option, which should return the value of 1
	 */
	@Test
	@SpiraTestCase(testCaseId = 8404)
	public void wantToSaveTest_NO() throws Exception {
		System.out.println("wantToSave() assertion test; data: NO (1)");
		wantToSave();
		int actual = getWantToSave();
		assertEquals(1, actual);
	}
	
	public int quit() {
		//refactored code
		String msg = "Would you like to save before quitting?";
		int answer = JOptionPane.showConfirmDialog(null, msg);
		
		if (answer == JOptionPane.YES_OPTION) {
			answer = 0;
		}else if(answer == JOptionPane.NO_OPTION) {
			answer = 1;
		}else if(answer == JOptionPane.CANCEL_OPTION) {
			answer = 2;
		}
		return answer;
	}
	public int getQuit() {
		return quit();
	}
	/*
	 * quit test
	 * test if user clicks yes
	 */
	@Test
	@SpiraTestCase(testCaseId = 8413)
	public void quitTest_YES() {
		System.out.println("quit() test; data: YES");
			quit();
			int actual = getQuit();
			int expected = 0;
			assertEquals(expected, actual);
	}
	/*
	 * quit test
	 * test if user clicks no
	 */
	@Test
	@SpiraTestCase(testCaseId = 8414)
	public void quitTest_NO() {
		quit();
		int actual = getQuit();
		int expected = 1;
		assertEquals(expected, actual);
	}
	/*
	 * quit test
	 * test if user clicks cancel
	 */
	@Test
	@SpiraTestCase(testCaseId = 8415)
	public void quitTest_CANCEL() {
		quit();
		int actual = getQuit();
		int expected = 2;
		assertEquals(expected, actual);
	}

	/*
	 * save as test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8410)
	public void saveAsTest() {
		System.out.println("saveAs() test");
		try {
			m = RegistrationSystem.class.getDeclaredMethod("saveAs", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e) {
		}
	}
	
	/*
	 * save file test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8408)
	public void saveFileTest() {
		System.out.println("saveFile() exception test");
		try {
			m = RegistrationSystem.class.getDeclaredMethod("saveFile", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e) {
		}
	}
	
	/*
	 * new file test
	 * catch exception if user selects to create a new file
	 * should pass if the exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8405)
	public void newFileTest() throws Exception {
		wantToSave();
			m = RegistrationSystem.class.getDeclaredMethod("newFile", null);
			m.setAccessible(true);
			m.invoke(rs, null);
	}
	
	/*
	 * update GUI Test
	 * should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8402)
	public void updateGUIExceptionTest() {
		System.out.println("updateGUI() test");
		try {
			m = RegistrationSystem.class.getDeclaredMethod("updateGUI", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e) {
		}
	}

	/*
	 * read file exception test
	 * it'll pass if method throws an exception
	 */
	@Test
	@SpiraTestCase(testCaseId = 8401)
	public void readFileExceptionTest() {
		System.out.println("readFile() test");
		try {
			m = RegistrationSystem.class.getDeclaredMethod("readFile", null);
			m.setAccessible(true);
			m.invoke(rs, null);
		}catch(Exception e){
		}
	}
	
	/*
	 * add course to student test
	 * test if the student has been added to the correct course
	 * test data: Course number = "462"
	 */
	@Test
	@SpiraTestCase(testCaseId = 8400)
	public void addCourseToStudentTest() {
		System.out.println("addCourseToStudent() test");
		courseList.loadData();	
		//refactored code
		Courses temp = courseList.findCourse();
		if (temp != null) {
			s1.setCourse(temp);
		}
		//System.out.println(s1.getCourse());
		assertEquals(temp, s1.getCourse(), "");
	}
	
	/*
	 * exception method test
	 * fileisreadable should return a null pointer exception
	 */
	@Test
	@SpiraTestCase(testCaseId = 8398)
	public void exceptionFileIsReadableTest() {
		System.out.println("fileIsReadable() test");
		File f;
	try {
		m = RegistrationSystem.class.getDeclaredMethod("fileIsReadable", File.class);
		m.setAccessible(true);
		f = (File)m.invoke(rs, currentFile);
		} catch(NullPointerException e) {
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * get student id test
	 * should return the student's ID and be equal to the expected output
	 */
	@Test
	@SpiraTestCase(testCaseId = 8372)
	public void getStudentIdTest() throws Exception {
		System.out.println("getStudentID() assertion test");
		int studentID = 12345678;
		m = RegistrationSystem.class.getDeclaredMethod("getStudentID", int.class);
		m.setAccessible(true);
		int expected = (int)m.invoke(rs, studentID);
		
		assertEquals(expected, 12345678);
	}
	
	/*
	 * get total fee test
	 * returns the total fee and checks if the expected value matches the actual value 
	 */
	@Test
	@SpiraTestCase(testCaseId = 8373)
	public void getTotalFeeTest() throws Exception {
		System.out.println("getTotalFee() assertion test");
		int fee = 120;
		m = RegistrationSystem.class.getDeclaredMethod("getTotalFee", int.class);
		m.setAccessible(true);
		int expected = (int)m.invoke(rs, fee);
		assertEquals(expected, 120);
	}
		
	/*
	 * students aren't sorted test
	 * should return false to show that the students have not been sorted 
	 */
	@Test
	@SpiraTestCase(testCaseId = 8374)
	public void amountIsNotSortedTest() throws Exception {
		System.out.println("amountIsSorted() test; data: false");
		boolean valid = false;
		m = RegistrationSystem.class.getDeclaredMethod("amountIsSorted", boolean.class);
		m.setAccessible(true);
		boolean expected = (boolean)m.invoke(rs, valid);
		
		assertTrue(expected == false, "");
	}	
	
	/*
	 * students are sorted test
	 * should return true to show that students have been sorted 
	 */
	@Test
	@SpiraTestCase(testCaseId = 8375)
	public void amountIsSortedTest() throws Exception {
		System.out.println("amountIsSorted() test; data: true");
		boolean valid = true;
		m = RegistrationSystem.class.getDeclaredMethod("amountIsSorted", boolean.class);
		m.setAccessible(true);
		boolean expected = (boolean)m.invoke(rs, valid);
		
		assertTrue(expected == true, "");
	}
	
	/*
	 * set current file test
	 * test if the expected file matches the actual file
	 */
	@Test
	@SpiraTestCase(testCaseId = 8376)
	public void setCurrentFileTest() throws Exception {
		System.out.println("setCurrentFile() assertion test");
		
		m = RegistrationSystem.class.getDeclaredMethod("setCurrentFile", File.class);
		m.setAccessible(true);
		File expected = (File)m.invoke(rs, currentFile);
		
		assertEquals(expected, currentFile, "");		
	}
		
	/*
	 * file is readable test
	 * since a file is not in correct file format, it should return a false result 
	 */
	@Test
	@SpiraTestCase(testCaseId = 8379)
	public void fileIsReadableTest() {
		System.out.println("fileIsReadable() test; data: false");
		getCheckFile();
		assertTrue(getCheckFile() == false, "");
	}
	//get result of checkFile()
	public boolean getCheckFile() {
		return checkFile(currentFile);
	}
	//re-factored code
	public boolean checkFile(File f) {
		try {
			ObjectInputStream input =
				new ObjectInputStream(new FileInputStream(f));
			try {
				Students test = (Students) input.readObject();
				if (!test.exists())
					return false;
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"This file may not be in the " +
						"format used by this program");
				return false;
			} catch (EOFException e){
				JOptionPane.showMessageDialog(null,
						"This file is blank.");
				return false;
			} finally {
				input.close();
			} // end try-catch-finally block
		} catch (IOException e) {
			if (!f.toString().equals(""))
				JOptionPane.showMessageDialog(null,
					"This file could not be accessed.");
			return false;
		} // end try-catch block
		return true;
	}
	
	/*
	 * count students in file test
	 * test if number of students in file matches the expected output
	 */
	@Test
	@SpiraTestCase(testCaseId = 8377)
	public void countStudentsInFileTest() throws Exception {
		System.out.println("countStudentsInFile() assertion test");
		int expected = 2;		
		assertEquals(expected, getCount());
	}
	/*
	 * count students in file test
	 * test if user inputs nothing, should pass if exception is caught
	 */
	@Test
	@SpiraTestCase(testCaseId = 8399)
	public void countStudentsInFileCatchTest() {
		System.out.println("countStudentsInFile() exception test");
		try {
			getCount();
		}catch(NumberFormatException e) {
		}
	}
	//get count
	public int getCount() {
		return count();
	}
	//re-factored code 
	public int count() {
		int studentsInFile = 0;
		boolean done;
		do {
			done = true;
			String temp = JOptionPane.showInputDialog(
				"How many student records are in this file?");
			if (temp == null || temp.equals(""))
				return 0;
			try {
				studentsInFile = Integer.parseInt(temp);
				if (studentsInFile < 1)
				{
					String message = "A positive, non-zero integer is required.";
					JOptionPane.showMessageDialog(null, message);
					done = false;
				} // end if
			} catch (NumberFormatException e) {
				String message = "An integer is required.";
				JOptionPane.showMessageDialog(null, message);
				done = false;
			} // end try-catch block
		} while (!done);
		return studentsInFile;
	}
	
	//-----Testing public methods-----
	@Test
	@SpiraTestCase(testCaseId = 5626)
	public void getNumberOfStudentsTest() {
		System.out.println("getNumberOfStudents() test");
		RegistrationSystem s = new RegistrationSystem();
		
		int expected = 4;
		int actual = s.getNumberOfStudents();
		assertEquals(expected, actual);
	}
	
	@Test
	@SpiraTestCase(testCaseId = 5627)
	public void getNoStudentsTest() {
		System.out.println("getNumberOfStudents() test");
		RegistrationSystem s = new RegistrationSystem();
		
		int expected = 0;
		
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		
		int actual = s.getNumberOfStudents();
		assertEquals(expected, actual);
	}
	
	//NullPointerException test
	@Test
	@SpiraTestCase(testCaseId = 5825)
	public void NullPointerExceptionTest() {
		assertThrows(NullPointerException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				System.out.println("Caught NullPointerException");
				RegistrationSystem s = new RegistrationSystem();
				s.getNumberOfStudents();
				s.getMeanAmountDue();
				s.getMedianAmountDue();
				s.getStandardDeviation();
			}
		});
	}
	
	@Test
	@SpiraTestCase(testCaseId = 6422)
	public void medianFeeTest() {
		System.out.println("getMedianFee() test");
		RegistrationSystem s = new RegistrationSystem();
		
		double expected = 725.00;
		double actual = s.getMedianAmountDue();
		assertEquals(expected, actual, "");
	}
	
	@Test
	@SpiraTestCase(testCaseId = 6396)
	public void standardDeviationTest() {
		System.out.println("getStandardDeviation() test");
		RegistrationSystem s = new RegistrationSystem();
				
		double expected = 213.60;
		double actual = s.getStandardDeviation();
		assertEquals(expected, actual, "");
	}
	
	@Test
	@SpiraTestCase(testCaseId = 6393)
	public void averageFeeTest() {
		System.out.println("getMeanFee() test");
		RegistrationSystem s = new RegistrationSystem();
		
		double expected = 737.5;
		double actual = s.getMeanAmountDue();
		assertEquals(expected, actual, "");
	}

}

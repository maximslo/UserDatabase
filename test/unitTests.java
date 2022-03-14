package test;

/*
* Unit Testing Class for Chegg User Database
* done using JUnit framework
* 
* completed by: Maxim Slobodchikov maxims@bu.edu
*/

// import JUnit testing framework
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class unitTests {
    public unitTests(){
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddUserStudent(){
        String name = "John Doe";
        String email = "john@bu.edu";
        String school = "Boston University";

        src.API.addUserStudent(name, email, school);
        // Test if Student user added correctly
        assertEquals("John Doe   john@bu.edu   Boston University", src.Student.getStudents().get(0).toString());
        src.API.clearAll();
        //tests followed by clearAll to avoid User mixups between test cases
    }

    @Test
    public void testAddUserProfessor(){
        String name = "John Doe";
        String email = "john@bu.edu";
        String school = "Boston University";
        String courseTaught = "CS 411";

        // Test if Professor user added correctly
        src.API.addUserProfessor(name, email, school, courseTaught);
        assertEquals("John Doe   john@bu.edu   Boston University   CS 411", src.Student.getStudents().get(0).toString());
    }

    @Test
    public void testDeleteUser() {
        src.API.addUserStudent("John Doe", "john@bu.edu", "Boston University");
        src.API.addUserStudent("Mary Doe", "mary@bu.edu", "Boston University");
        src.API.deleteUser(1); //delete user Mary at index 1
        String output = "";
        for (int i = 0; i < src.Student.getStudents().size(); i++) {
            output = src.Student.getStudents().get(i).toString();
        }
        // Test if user deleted correctly
        assertEquals("John Doe   john@bu.edu   Boston University", output);
        src.API.clearAll();
    }

    @Test
    public void listUsers() {
        src.API.addUserStudent("John Doe", "john@bu.edu", "Boston University");
        src.API.addUserStudent("Mary Doe", "mary@bu.edu", "Boston University");
        
        // Test if users listed correctly
        assertEquals("John Doe   john@bu.edu   Boston UniversityMary Doe   mary@bu.edu   Boston University", src.API.listUsers());
        src.API.clearAll();
    }

    @Test
    public void updateUser() {
        src.API.addUserStudent("John Doe", "john@bu.edu", "Boston University");
        src.API.deleteUser(0);
        src.API.addUserStudent("John Doe", "john@scu.edu", "Santa Clara University");
        String output = src.API.updateUser(0, "John Doe", "john@scu.edu", "Santa Clara University");

        // Test if users updated correctly
        assertEquals("John Doe   john@scu.edu   Santa Clara University", output);
        src.API.clearAll();
    }

    @Test
    public void clearAll() {
        src.API.addUserStudent("John Doe", "john@bu.edu", "Boston University");
        src.API.addUserStudent("Mary Doe", "mary@bu.edu", "Boston University");
        
        src.API.clearAll();

        // Test if all users cleared correctly
        assertEquals("", src.API.listUsers());
    }

    @Test
    public void searchStudents(){
        src.API.addUserStudent("John Doe", "john@bu.edu", "Boston University");
        src.API.addUserProfessor("Dr. Andrew", "drAndrew@bu.edu", "Boston University", "CS 411");
        String output = src.API.searchStudents();

        // Test if search for all Student users functions correctly
        assertEquals("John Doe   john@bu.edu   Boston University", output);
        src.API.clearAll();
    }

    @Test
    public void searchProfessors(){
        src.API.addUserStudent("John Doe", "john@bu.edu", "Boston University");
        src.API.addUserProfessor("Dr. Andrew", "drAndrew@bu.edu", "Boston University", "CS 411");
        String output = src.API.searchProfessors();

        // Test if search for all Professor users functions correctly
        assertEquals("Dr. Andrew   drAndrew@bu.edu   Boston University   CS 411", output);
        src.API.clearAll();
    }

    @Test
    public void searchbySchool(){
        src.API.addUserStudent("John Doe", "john@scu.edu", "Santa Clara University");
        src.API.addUserProfessor("Dr. Andrew", "drAndrew@bu.edu", "Boston University", "CS 411");
        String output = src.API.searchBySchool("Santa Clara University");

        // Test if search by School value functions correctly, using Santa Clara University as example
        assertEquals("John Doe   john@scu.edu   Santa Clara University", output);
        src.API.clearAll();
    }

}

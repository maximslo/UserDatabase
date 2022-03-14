package src;
import java.util.ArrayList;
/*
 * Student.java
 * 
 * Blueprint class for objects that represent a student
 * user which has name, email, and school values.
 * 
 * completed by: Maxim Slobodchikov maxims@bu.edu
 */

public class Student {
    private String name;
    private String email;
    private String school;

    /* ArrayList object created (declaring list of Student type
    * where Professors are simply extensions of that class type) */
    private static ArrayList<Student> students = new ArrayList<Student>();

    /* assigns a value to the field of name */
    public void setName(String newName){
        if (newName == null || newName.length() == 0){
            throw new IllegalArgumentException(); 
        } 
        else {
            name = newName;
        }
    }

    /* assigns a value to the field of email */
    public void setEmail(String newEmail) {
        if (newEmail == null || newEmail.length() == 0){
            throw new IllegalArgumentException(); 
        } 
        else {
            email = newEmail;
        }
    }

    /* assigns a value to the field of school */
    public void setSchool(String newSchool) {
        if (newSchool == null || newSchool.length() == 0){
            throw new IllegalArgumentException(); 
        } 
        else {
            school = newSchool;
        }
    }

    /* accessor methods */
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return school;
    }

    public static ArrayList<Student> getStudents() {
        return students;
      }
    
    public static String getStudentName(int i) {
        return students.get(i).getName();
    }

    public static String getStudentSchool(int i) {
        return students.get(i).getSchool();
    }

    /* toString method */
    public String toString() {
        return (this.name + "   " + this.email + "   " + this.school);
    }

    /* Removing method */
    public static void removeStudent(int i) {
        students.remove(i);
    }

    /* Constructor for class Student for initializing Student objects */
    public Student(String newName, String newEmail, String newSchool) {
        setName(newName);
        setEmail(newEmail);
        setSchool(newSchool);

        students.add(this);
    }
}

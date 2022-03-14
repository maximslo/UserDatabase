package src;
/*
 * Professor.java
 *
 * A blueprint class for objects that represent a
 * professor user which has name, email, school, and
 * course taught values. Extends the student user class.
 * 
 * completed by: Maxim Slobodchikov maxims@bu.edu
 */

public class Professor extends Student {
    private String courseTaught;

    /* assigns a value to the field of course taught */
    public void setCourseTaught(String newCourseTaught){
        if (newCourseTaught == null || newCourseTaught.length() == 0){
            throw new IllegalArgumentException(); 
        } 
        else {
            courseTaught = newCourseTaught;
        }
    }

    /* accessor methods */
    public String getCourseTaught() {
        return courseTaught;
    }

    /* Constructor for class Student for initializing Student objects */
    public Professor(String newName, String newEmail, String newSchool, String newCourseTaught){
        super(newName, newEmail, newSchool);
        setCourseTaught(newCourseTaught);
    }

    /* toString method */
    public String toString() {
        return (getName() + "   " + getEmail() + "   " + getSchool() + "   " + this.courseTaught);
    }
}

    




        
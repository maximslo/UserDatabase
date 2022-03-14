package src;

/*
 * API.java
 *
 * A class containing APIs for adding, updating, listing,
 * deleting, and searcing for users inside the Chegg User
 * Database.
 * 
 * For a more interactive user experience run UI.java.
 * 
 * completed by: Maxim Slobodchikov maxims@bu.edu
 */

public class API {
    /*API to add a student user */
    public static void addUserStudent(String name, String email, String school){
        new Student(name, email, school);
    }  
    /*API to add a professor user */
    public static void addUserProfessor(String name, String email, String school, String courseTaught){
        new Professor(name, email, school, courseTaught);
    }  
    /*API to delete a user */
    public static void deleteUser(int index){
        Student.removeStudent(index);
    }
    /*API to list all users */
    public static String listUsers(){
        String output = "";
        for (int i = 0; i < Student.getStudents().size(); i++) {
            output += Student.getStudents().get(i);
        }   
        return output;
    }

    /* API to update users */
    public static String updateUser(int index, String name, String email, String school){
        String output = "";
        Student.removeStudent(index);
        new Student(name, email, school);
        return output += Student.getStudents().get(index);
    }

    /* API to clear users */
    public static void clearAll() {
        int initialSize = Student.getStudents().size();
        for (int i = 0; i < initialSize; i++) {
                Student.removeStudent(0);
            }
    }

    /* API to find all student users */
    public static String searchStudents() {
        String output = "";
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (!(Student.getStudents().get(i) instanceof Professor)) {
                output += Student.getStudents().get(i);
            }
        }
        return output;
    }

    /* API to find all professor users */
    public static String searchProfessors() {
        String output = "";
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (Student.getStudents().get(i) instanceof Professor) {
                output += Student.getStudents().get(i);
            }
        }
        return output;
    }

    /* API to find all users from specific school*/
    public static String searchBySchool(String schoolID) {
        String output = "";
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (Student.getStudentSchool(i).equals(schoolID)) {
                output += Student.getStudents().get(i);
            }
        }
        return output;
        }
    }


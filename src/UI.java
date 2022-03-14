package src;
import java.util.*;

/*
 * UI.java
 *
 * A class containing a minimal user interface to interact
 * with APIs for adding, updating, listing, deleting, and
 * searcing for users inside the Chegg User Database.
 * 
 * Simply run file and follow instructions in terminal.
 * 
 * completed by: Maxim Slobodchikov maxims@bu.edu
 */

public class UI {
    public static void main(String[] args) {
        System.out.println("Welcome to the Chegg User Database!");
        menu();
    }

    /* Main menu interface */
    public static void menu(){
        Scanner console = new Scanner(System.in);

        System.out.println();
        System.out.println("A) Add a user");
        System.out.println("B) Update a user");
        System.out.println("C) List all users");
        System.out.println("D) Delete a user");
        System.out.println("E) Use the search tool");
        System.out.println("F) Clear all users");
        System.out.println("G) Exit");
        System.out.println();
        System.out.print("What function would you like to use?: ");
 
        String input = console.nextLine();
        

        if ("A".equalsIgnoreCase(input)){
            addUser();
        }
        else if ("B".equalsIgnoreCase(input)){
            updateUser();
        }
        else if ("C".equalsIgnoreCase(input)){
            listUsers();
        }
        else if ("D".equalsIgnoreCase(input)){
            deleteUser();
        }
        else if ("E".equalsIgnoreCase(input)){
            search();
        }
        else if ("F".equalsIgnoreCase(input)){
            clearAll();
        }
        else {
            console.close();
            System.out.println("Job Done.");
        }
    }

    /*API to Add a user */
    public static void addUser(){

        Scanner console = new Scanner(System.in);
        System.out.print("Name: ");
        String name = console.nextLine();

        System.out.print("Email: ");
        String email = console.nextLine();

        System.out.print("School: ");
        String school = console.nextLine();

        System.out.print("Student or professor? ");
        String typeOfUser = console.nextLine();

        if ("student".equalsIgnoreCase(typeOfUser)){
            new Student(name, email, school);
            menu();
        }
        else {
            System.out.print("Course taught: ");
            String courseTaught = console.nextLine();
            new Professor(name, email, school, courseTaught);
            menu();
        }
    }

    /*API to update a user */
    public static void updateUser(){
        Scanner console = new Scanner(System.in);
        System.out.print("Name of user you'd like to update: ");
        String nameID = console.nextLine();

        int track = 0;
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (Student.getStudentName(i).equals(nameID)) {
                Student.removeStudent(i);
                System.out.println("Please enter updated info below.");
                System.out.println();
                addUser();
                track++;
                break;
                }
        }
        
        if (track == 0) {
            System.out.println("Error: there is no user with that name.");
            menu();
        }
    }

    /*API to list all users */
    public static void listUsers(){
        if (Student.getStudents().size() == 0){
            System.out.println("No users have been added yet.");
        }
        for (int i = 0; i < Student.getStudents().size(); i++) {
            System.out.println(Student.getStudents().get(i));
        }
        menu();
    }

    /*API to delete a user */
    public static void deleteUser(){
    
        Scanner console = new Scanner(System.in);
        System.out.print("Name of user you'd like to remove: ");
        String nameid = console.nextLine();
        int track = 0;
        for (int i = 0; i < Student.getStudents().size(); i++) {
            //String temp = Student.getStudents().get(i).toString();
            if (Student.getStudentName(i).equals(nameid)) {
                Student.removeStudent(i);
                System.out.println("User removed.");
                track++;
            }
        }
        if (track == 0) {
            System.out.println("Error: there is no user with that name.");
        }
        menu();
    }

    /* API to clear all users */
    public static void clearAll(){
        int initialSize = Student.getStudents().size();
        for (int i = 0; i < initialSize; i++) {
                Student.removeStudent(0);
            }
        System.out.println("All users cleared.");
        menu();
    }

    /*API of search functions */
    public static void search(){
        System.out.println();
        System.out.println("A) Find users by school");
        System.out.println("B) Find all students");
        System.out.println("C) Find all professors");
        System.out.println("D) Exit to main menu");

        System.out.println();
        System.out.print("What search function would you like to use?: ");

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        if ("A".equalsIgnoreCase(input)){
            searchBySchool();
        }
        else if ("B".equalsIgnoreCase(input)){
            allStudents();
        }
        else if ("C".equalsIgnoreCase(input)){
            allProfessors();
        }
        else {
            menu();
        }
    }

    /* API of searching by school function */
    public static void searchBySchool() {
        Scanner console = new Scanner(System.in);
        System.out.print("Name of school you'd like to find users from: ");
        String schoolID = console.nextLine();
        int track = 0;
        if (Student.getStudents().size() == 0){
            System.out.println("There are no users from this school yet.");
        }
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (Student.getStudentSchool(i).equals(schoolID)) {
                System.out.println(Student.getStudents().get(i));
                track++;
            }
        }
        if (track == 0) {
            System.out.println("There are no users from this school yet.");
        }
        menu();
    }

    /* API of finding all students */
    public static void allStudents() {
        int track = 0;
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (!(Student.getStudents().get(i) instanceof Professor)) {
                System.out.println(Student.getStudents().get(i));
                track++;
            }
        }
        if (track == 0) {
            System.out.println("No students have been added yet.");
        }
        menu();
    }

    /* API of finding all professors */
    public static void allProfessors() {
        int track = 0;
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (Student.getStudents().get(i) instanceof Professor) {
                System.out.println(Student.getStudents().get(i));
                track++;
            }
        }
        if (track == 0) {
            System.out.println("No professors have been added yet.");
        }
        menu();
    }
}


import java.util.InputMismatchException;
import java.util.Scanner;

class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

class Student {
    String name;
    String usn;
    double SGPA;
    Subject[] subject;
    Scanner s;

    Student() {
        subject = new Subject[9];
        for (int i = 0; i < 9; i++) {
            subject[i] = new Subject();
        }
        s = new Scanner(System.in);
    }

    void getStudentDetails() {
        System.out.println("Enter USN: ");
        usn = s.next();
        System.out.println("Enter Name: ");
        name = s.next();
    }

    void getMarks() {
        for (int i = 0; i < 9; i++) {
            while (true) {
                try {
                    System.out.println("Enter marks for subject " + (i + 1) + ": ");
                    subject[i].subjectMarks = s.nextInt();
                    if (subject[i].subjectMarks > 100 || subject[i].subjectMarks < 0) {
                        System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.next(); // Clear the invalid input
                }
            }
            while (true) {
                try {
                    System.out.println("Enter credits for subject " + (i + 1) + ": ");
                    subject[i].credits = s.nextInt();
                    if (subject[i].credits < 0) {
                        System.out.println("Invalid credits. Please enter a non-negative number.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.next(); // Clear the invalid input
                }
            }
            if (subject[i].subjectMarks < 40) {
                subject[i].grade = 0;
            } else if (subject[i].subjectMarks >= 90) {
                subject[i].grade = 10;
            } else if (subject[i].subjectMarks >= 80) {
                subject[i].grade = 9;
            } else if (subject[i].subjectMarks >= 70) {
                subject[i].grade = 8;
            } else if (subject[i].subjectMarks >= 60) {
                subject[i].grade = 7;
            } else if (subject[i].subjectMarks >= 50) {
                subject[i].grade = 6;
            } else {
                subject[i].grade = 5;
            }
        }
    }

    void computeSGPA() {
        double totalCredits = 0;
        double totalGradePoints = 0;
        for (int i = 0; i < 9; i++) {
            totalCredits += subject[i].credits;
            totalGradePoints += subject[i].grade * subject[i].credits;
        }
        SGPA = totalGradePoints / totalCredits;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.getStudentDetails();
        s1.getMarks();
        s1.computeSGPA();
        System.out.println("Name: " + s1.name);
        System.out.println("USN: " + s1.usn);
        System.out.println("SGPA: " + s1.SGPA);
    }
}


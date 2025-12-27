package simpleproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model class for Student
class Student1 {
    private int id;
    private String name;
    private String course;
    private int totalClasses;
    private int attendedClasses;

    public Student1(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void markPresent() {
        totalClasses++;
        attendedClasses++;
    }

    public void markAbsent() {
        totalClasses++;
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) {
            return 0.0;
        }
        return (attendedClasses * 100.0) / totalClasses;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Course: " + course +
               ", Classes: " + attendedClasses + "/" + totalClasses +
               " (" + String.format("%.2f", getAttendancePercentage()) + "%)";
    }
}

// Service class to manage students and attendance
class AttendanceManager {
    private List<Student1> students;
    private Scanner scanner;

    public AttendanceManager(Scanner scanner) {
        this.students = new ArrayList<>();
        this.scanner = scanner;
    }

    public void addStudent() {
        System.out.print("Enter student ID: ");
        int id = readInt();

        if (findStudentById(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        Student1 student = new Student1(id, name, course);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student1 s : students) {
            System.out.println(s);
        }
    }

    public void markAttendanceForClass() {
        if (students.isEmpty()) {
            System.out.println("No students to mark attendance for.");
            return;
        }

        System.out.println("\nMarking attendance for all students.");
        System.out.println("Enter P for Present, A for Absent.");

        for (Student1 s : students) {
            while (true) {
                System.out.print("Student ID " + s.getId() + " (" + s.getName() + "): ");
                String input = scanner.nextLine().trim().toUpperCase();

                if ("P".equals(input)) {
                    s.markPresent();
                    break;
                } else if ("A".equals(input)) {
                    s.markAbsent();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter P or A.");
                }
            }
        }

        System.out.println("Attendance marked for this class.");
    }

    public void viewStudentAttendance() {
        System.out.print("Enter student ID to view attendance: ");
        int id = readInt();

        Student1 s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n--- Attendance Details ---");
        System.out.println(s);
    }

    public void viewDefaulters() {
        System.out.print("Enter minimum required percentage (e.g., 75): ");
        double minPercent = readDouble();

        System.out.println("\n--- Defaulter List (below " + minPercent + "%) ---");
        boolean found = false;
        for (Student1 s : students) {
            if (s.getAttendancePercentage() < minPercent) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No defaulters found.");
        }
    }

    public void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = readInt();

        Student1 s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(s);
        System.out.println("Student removed successfully.");
    }

    private Student1 findStudentById(int id) {
        for (Student1 s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    private int readInt() {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}

// Main application class
public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager(scanner);

        while (true) {
            System.out.println("\n===== Attendance Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Mark Attendance for Class");
            System.out.println("4. View Student Attendance");
            System.out.println("5. View Defaulters");
            System.out.println("6. Remove Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            String choiceLine = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceLine.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number 1-7.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    manager.markAttendanceForClass();
                    break;
                case 4:
                    manager.viewStudentAttendance();
                    break;
                case 5:
                    manager.viewDefaulters();
                    break;
                case 6:
                    manager.removeStudent();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 7.");
            }
        }
    }
}

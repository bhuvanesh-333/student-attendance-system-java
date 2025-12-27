# Java Attendance Management System

A simple Java console-based Attendance Management System to manage students and their attendance using a menu-driven interface and in-memory storage (`ArrayList`).

## Features

- Add new students with ID, name, and course
- View all students with attendance summary
- Mark attendance (Present/Absent) for an entire class
- View attendance details for a specific student
- View defaulters below a given attendance percentage
- Remove a student by ID
- Input validation for numeric choices and IDs

## Tech Stack

- Language: Java (Core Java)
- Paradigm: Object-Oriented Programming
- Data structures: `ArrayList`, custom `Student1` class
- I/O: `Scanner` for console input

## Project Structure

- `Student1`  
  - Model class for a student  
  - Fields: `id`, `name`, `course`, `totalClasses`, `attendedClasses`  
  - Methods: `markPresent()`, `markAbsent()`, `getAttendancePercentage()`, `toString()`

- `AttendanceManager`  
  - Handles all operations on the student list  
  - Methods:  
    - `addStudent()`  
    - `viewAllStudents()`  
    - `markAttendanceForClass()`  
    - `viewStudentAttendance()`  
    - `viewDefaulters()`  
    - `removeStudent()`  
    - helper methods: `findStudentById()`, `readInt()`, `readDouble()`

- `AttendanceSystem` (main class)  
  - Contains `main()` method  
  - Shows menu and calls methods in `AttendanceManager`

## How to Run

1. Make sure Java (JDK) is installed on your system and `javac`/`java` are available in your PATH.

2. Clone this repository:

git clone https://github.com/<your-username>/java-attendance-management-system.git
cd java-attendance-management-system

text

3. Save your Java file as:

AttendanceSystem.java

text

Make sure it contains the classes:
- `Student1`
- `AttendanceManager`
- `AttendanceSystem` (with `public static void main(String[] args)`)

4. Compile the program:

javac AttendanceSystem.java

text

5. Run the program:

java AttendanceSystem

text

6. Use the menu in the console:

- Option 1: Add student  
- Option 2: View all students  
- Option 3: Mark attendance for class (P/A for each student)  
- Option 4: View single student attendance  
- Option 5: View defaulters below given percentage  
- Option 6: Remove student  
- Option 7: Exit

## Example Usage

- Add a few students with unique IDs.
- Run "Mark Attendance for Class" and enter `P` or `A` for each student.
- Check "View All Students" to see updated attendance percentages.
- Use "View Defaulters" with a threshold like `75` to see low-attendance students.

## Possible Improvements

- Persist data to a file or database (e.g., MySQL) instead of in-memory `ArrayList`.
- Add date-wise attendance tracking.
- Add validation for duplicate names or invalid input formats.
- Build a GUI version using JavaFX or Swing.
- Write unit tests using JUnit.

---

This mini project is ideal for beginners to practice core Java, OOP, and console-based application development, and is suitable for showcasing on a GitHub portfolio.

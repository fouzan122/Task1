import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add a student");
            System.out.println("2. Enter grades for a student");
            System.out.println("3. Display student details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Add a new student
                    System.out.print("Enter the student's name: ");
                    String studentName = scanner.nextLine();
                    students.add(new Student(studentName));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Enter grades for a student
                    System.out.print("Enter the student's name: ");
                    String nameForGrades = scanner.nextLine();
                    Student studentForGrades = findStudentByName(students, nameForGrades);
                    if (studentForGrades == null) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Enter the grade (or -1 to stop): ");
                        double grade = scanner.nextDouble();
                        while (grade != -1) {
                            studentForGrades.addGrade(grade);
                            System.out.print("Enter the next grade (or -1 to stop): ");
                            grade = scanner.nextDouble();
                        }
                        System.out.println("Grades entered successfully.");
                    }
                    break;

                case 3:
                    // Display student details (average, highest, lowest grade)
                    System.out.print("Enter the student's name: ");
                    String nameForDetails = scanner.nextLine();
                    Student studentForDetails = findStudentByName(students, nameForDetails);
                    if (studentForDetails == null) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.println("\nStudent: " + studentForDetails.getName());
                        System.out.println("Average Grade: " + studentForDetails.calculateAverage());
                        System.out.println("Highest Grade: " + studentForDetails.getHighestGrade());
                        System.out.println("Lowest Grade: " + studentForDetails.getLowestGrade());
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static Student findStudentByName(ArrayList<Student> students, String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}

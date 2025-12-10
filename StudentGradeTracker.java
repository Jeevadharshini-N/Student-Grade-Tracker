import java.util.ArrayList;
import java.util.Scanner;

// Student class to hold name and grade
class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student Grade");
            System.out.println("2. View All Students");
            System.out.println("3. Show Summary (Average, Highest, Lowest)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume the leftover newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // discard invalid input
                continue;
            }

            // Modern "rule switch" syntax
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    if (sc.hasNextInt()) {
                        int grade = sc.nextInt();
                        sc.nextLine(); // consume newline
                        students.add(new Student(name, grade));
                        System.out.println("Student Added Successfully!");
                    } else {
                        System.out.println("Invalid grade. Please enter a number.");
                        sc.nextLine(); // discard invalid input
                    }
                }

                case 2 -> {
                    System.out.println("\n--- Student List ---");
                    if (students.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s.name + " - " + s.grade);
                        }
                    }
                }

                case 3 -> {
                    if (students.isEmpty()) {
                        System.out.println("No records available to calculate summary.");
                    } else {
                        int sum = 0;
                        int highest = students.get(0).grade;
                        int lowest = students.get(0).grade;

                        for (Student s : students) {
                            sum += s.grade;
                            if (s.grade > highest) highest = s.grade;
                            if (s.grade < lowest) lowest = s.grade;
                        }

                        double average = (double) sum / students.size();

                        System.out.println("\n--- Summary ---");
                        System.out.println("Total Students: " + students.size());
                        System.out.println("Average Score: " + average);
                        System.out.println("Highest Score: " + highest);
                        System.out.println("Lowest Score: " + lowest);
                    }
                }

                case 4 -> {
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
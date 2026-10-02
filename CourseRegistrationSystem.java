import java.util.ArrayList;
import java.util.Scanner;

class Course {

    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    ArrayList<String> students = new ArrayList<>();

    Course(String code, String title, String description,
           int capacity, String schedule) {

        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    boolean registerStudent(String studentId) {

        if (students.contains(studentId)) {
            return false;
        }

        if (students.size() >= capacity) {
            return false;
        }

        students.add(studentId);
        return true;
    }

    boolean removeStudent(String studentId) {
        return students.remove(studentId);
    }

    int availableSlots() {
        return capacity - students.size();
    }
}

public class CourseRegistrationSystem {

    static ArrayList<Course> courses = new ArrayList<>();

    public static void displayCourses() {

        System.out.println("\n===== AVAILABLE COURSES =====");

        for (Course course : courses) {

            System.out.println("\nCourse Code : " + course.code);
            System.out.println("Title       : " + course.title);
            System.out.println("Description : " + course.description);
            System.out.println("Schedule    : " + course.schedule);
            System.out.println("Available   : " + course.availableSlots());
        }
    }

    public static Course findCourse(String code) {

        for (Course course : courses) {

            if (course.code.equalsIgnoreCase(code)) {
                return course;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        courses.add(new Course(
                "CS101",
                "Java Programming",
                "Introduction to Java programming",
                3,
                "Monday 10:00 AM"
        ));

        courses.add(new Course(
                "CS102",
                "Data Structures",
                "Study of data structures and algorithms",
                3,
                "Tuesday 11:00 AM"
        ));

        courses.add(new Course(
                "CS103",
                "Database Management",
                "Introduction to database systems",
                2,
                "Wednesday 2:00 PM"
        ));

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("Student ID   : " + studentId);
            System.out.println("Student Name : " + studentName);

            System.out.println("\n1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:

                    System.out.print("Enter course code: ");
                    String registerCode = sc.nextLine();

                    Course registerCourse = findCourse(registerCode);

                    if (registerCourse == null) {
                        System.out.println("Course not found.");

                    } else if (registerCourse.registerStudent(studentId)) {
                        System.out.println(
                                "Course registered successfully."
                        );

                    } else {
                        System.out.println(
                                "Registration failed. Course may be full "
                                        + "or already registered."
                        );
                    }

                    break;

                case 3:

                    System.out.print("Enter course code: ");
                    String removeCode = sc.nextLine();

                    Course removeCourse = findCourse(removeCode);

                    if (removeCourse == null) {
                        System.out.println("Course not found.");

                    } else if (removeCourse.removeStudent(studentId)) {
                        System.out.println(
                                "Course dropped successfully."
                        );

                    } else {
                        System.out.println(
                                "You are not registered for this course."
                        );
                    }

                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 10000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();
        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade year: ");
        this.gradeYear = in.nextLine();

        setStudentID();
    }

    // Generate an ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in a course
    public void enroll() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = in.nextLine();
            if (!course.equalsIgnoreCase("Q")) {
                courses += course + "\n";
                tuitionBalance += costOfCourse;
            } else {
                break;
            }
        }
    }

    // View Balance
    public void viewBalance() {
        System.out.println("TUITION BALANCE: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Override toString method
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nID: " + (Integer.parseInt(studentID) - (Integer.parseInt(gradeYear) * id)) +
                "\nCourses: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
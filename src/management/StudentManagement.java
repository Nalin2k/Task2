package management;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Student;

public class StudentManagement {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n Student Record Management System");
			System.out.println("1.	Add Student");
			System.out.println("2.	View Student");
			System.out.println("3.	Update Student");
			System.out.println("4.	Delete Student");
			System.out.println("5.	Exit");
			System.out.println("Enter your Choice:	");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				viewStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				System.out.println("Exiting....	");
				System.exit(0);
			default:
				System.out.println("Invalid choice ");
			}
		}
	}

	static void addStudent() {
		System.out.println("Enter ID:	");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name:	");
		String name = sc.nextLine();
		System.out.println("Enter marks:	");
		double marks = sc.nextDouble();
		students.add(new Student(id, name, marks));
		System.out.println("Student Added	");
	}

	static void viewStudent() {
		if (students.isEmpty()) {
			System.out.println("No Records Found	");
		} else {
			for (Student s : students)
				System.out.println(s);
		}
	}

	static void updateStudent() {
		System.out.println("Enter ID to update:	");
		int id = sc.nextInt();
		for (Student s : students) {
			if (s.getId() == id) {
				System.out.println("Enter New Name: ");
				sc.nextLine();
				s.setName(sc.nextLine());
				System.out.println("Enter New Marks: ");
				s.setMarks(sc.nextDouble());
				System.out.println("Record Updated	");
				return;
			}
		}
		System.out.println("Student Not Found	");
	}

	static void deleteStudent() {
		System.out.println("Enter ID to delete:	");
		int id = sc.nextInt();
		for (Student s : students) {
			if (s.getId() == id) {
				students.remove(s);
				System.out.println("Record Deleted	");
				return;
			}
		}
		System.out.println("Student Not Found	");
	}

}

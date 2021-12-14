import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Welcome to StudentManagementApp");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Press 1 to add students");
			System.out.println("Press 2 to delete students");
			System.out.println("Press 3 to display students");
			System.out.println("Press 4 to update students");
			System.out.println("Press 5 to exit application");
			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// add student

				System.out.println("Enter user name :");
				String name = br.readLine();

				System.out.println("Enter user phone no.:");
				String phone = br.readLine();

				System.out.println("Enetr user city");
				String city = br.readLine();

				// create student object to store student
				
				Student st = new  Student(name,phone,city); 
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer)
				{
					System.out.println("Student is added successfully");
				}
				else
				{
					System.out.println("Something went wrong...");
				}
				System.out.println(st);
			} else if (c == 2) {
				// delete student
				System.out.println("Enter student ID to delete");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("Student deleted Succcessfully");
				}
				else
				{
					System.out.println("Something went wrong...");
				}
			} else if (c == 3) {
				// display student
				StudentDao.showAllStudents();
			} else if (c == 4) {
				//update
				boolean f=StudentDao.updateStudent();
				if(f)
				{
					System.out.println("Student updated Succcessfully");
				}
				else
				{
					System.out.println("Something went wrong...");
				}
			} else if(c == 5) {
				// exit
				break;
			}

		}
		System.out.println("Thank you for using my application");
		System.out.println("See you soon ...bye bye");

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Student Management App");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		while(true)
		{
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to DELETE student");
			System.out.println("Press 3 to DISPLAY student");
			System.out.println("Press 4 to EXIT app");
			
			int choice =Integer.parseInt(br.readLine());
			
			if(choice==1)
			{
				// add student
				System.out.println("Enter user name : ");
				String name = br.readLine();
				
				System.out.println("Enter user phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter user city : ");
				String city = br.readLine();
				
				// create student object to store student 
				Student st = new Student(name,phone,city);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer)
				{
					System.out.println("Student is added successfully...!!");
				}
				else
				{
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
				
			}
			else if(choice==2)
			{
				// delete student
				System.out.println("Enter student ID to delete: ");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("Deleted....");
				}
				else
				{
					System.out.println("Something went wrong......");
				}
			}
			else if(choice==3)
			{
				// display student
				StudentDao.showAllStudent();
			}
			else if(choice==4)
			{
				// exit
				break;
			}
			else
			{
			
			}
		}
			System.out.println("Thankyou for using my application......");
			System.out.println("See you soon...bye !!");
		
		
		
		
	}

}

package com.spring.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.springorm.dao.StudentDao;
import com.spring.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
   
    	StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
//    	Student std=new Student(2,"shikha dube","pune");
//    	int res=studentDao.insert(std);
//        System.out.println( "___________Record save____________ "+res );
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("********************Welcome to our application**************************");
        boolean go= true;
        while(go) 
        {
        	System.out.println("Press 1 for add new student : ");
        	System.out.println("Press 2 for display all student : ");
        	System.out.println("Press 3 for display single student : ");
        	System.out.println("Press 4 for delete  student : ");
        	System.out.println("Press 5 for update  student : ");
        	System.out.println("Press 6 for Exit application : ");
        	
        	try {
        		int input=Integer.parseInt(br.readLine());
        		
        		switch (input) {
				case 1:
					//ar
					System.out.println("Enter student id : ");
					int sId=Integer.parseInt(br.readLine());
					
					System.out.println("Enter student name : ");
					String sName=br.readLine();
					
					System.out.println("Enter student City : ");
					String sCity=br.readLine();
					
					Student s=new Student(sId, sName, sCity);
					
					int r=studentDao.insert(s);
					System.out.println(r+" Stdent added ");
					System.out.println("___________________________________________________________________________");
					//ar
					break;
					
				case 2:
					List<Student> allstudents = studentDao.getAllstudents();
					int i=1;
					
					for(Student studentList: allstudents) {
						System.out.println("**************Student no :"+i+"**************");
						System.out.println("Student Id: "+studentList.getStudentId());
						System.out.println("Student name: "+studentList.getStudentName());
						System.out.println("Student City: "+studentList.getStudentCity());
						i++;
					}
					System.out.println("___________________________________________________________________________");
					break;
					
				case 3:
					System.out.println("Provide student id to display its Information");
					int id=Integer.parseInt(br.readLine());
					Student singleSt=studentDao.getStudent(id);
					if(singleSt==null) {
						System.out.println("Please enter valid id , entered id didn't found in our database");
					}
					System.out.println("Student Id: "+singleSt.getStudentId());
					System.out.println("Student name: "+singleSt.getStudentName());
					System.out.println("Student City: "+singleSt.getStudentCity());
					System.out.println("___________________________________________________________________________");
					break;
					
				case 4:
					System.out.println("Provide student id to DELETE its Information");
					int Deleteid = Integer.parseInt(br.readLine());
					//Student deleteStudent = studentDao.getStudent(Deleteid);
					studentDao.deleteData(Deleteid);
					
					break;
					
				case 5:
					System.out.println("Provide student id to UPDATE its Information");
					int updateId = Integer.parseInt(br.readLine());
					Student updateStudentObj =new Student();
					updateStudentObj =studentDao.getStudent(updateId);
					boolean updatefl=true;
					while(updatefl) 
					{
					
					System.out.println("Press 2 to update Name");
					System.out.println("Press 3 to update CITY");
					System.out.println("Press 4 to Exit update Menu");
					int ip=Integer.parseInt(br.readLine());
					
						switch (ip) 
						{
							case 2:
								System.out.println("enter updated name");
								updateStudentObj.setStudentName(br.readLine());
								break;
							case 3:
								System.out.println("enter updated CIty");
								updateStudentObj.setStudentCity(br.readLine());
								break;
							case 4:
								updatefl=false;

							default:
								System.out.println("Please enter valid input");
								break;
						}
					}
					studentDao.updateData(updateStudentObj);
					System.out.println("Stdent data updated successfully");
					System.out.println("___________________________________________________________________________");
					break;
					
				case 6:
					go=false;
					break;

				default:
					break;
				}
        		
        	}
        	catch(Exception e) {
        		System.out.println("Invalid input please try another input ");
        		System.out.println(" "+e);
        		
        	}
        
        }
        
        
        
    }
}

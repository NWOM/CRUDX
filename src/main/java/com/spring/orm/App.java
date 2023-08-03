package com.spring.orm;
import com.spring.orm.entities.Student;
import com.spring.orm.dao.Studentdao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context= new ClassPathXmlApplicationContext("config(1).xml");
       Studentdao studentdao= context.getBean("studentdao", Studentdao.class);
    //   Student student=new Student(1212,"Mr X","Bangalore");
    //  int r=  studentdao.insert(student);
    //  System.out.println(r);
        Scanner sc=new Scanner(System.in);
        boolean go=true;
        while (go) {
            System.out.println("PRESS 1 for add new Student");
            System.out.println("PRESS 2 to display all Students");
            System.out.println("PRESS 3 to get detail for single student");
            System.out.println("PRESS 4 for delete students");
            System.out.println("PRESS 5 to update student");
            System.out.println("PRESS 6 for exit");
            try {
              int choice=  Integer.parseInt(sc.nextLine());
             switch (choice){
                 case 1:
                     //add
                     //taking inputs from student
                     //console based CRUD application
                     System.out.println("Enter user id:");
                     int uid= Integer.parseInt(sc.nextLine());
                     System.out.println("Enter user name");
                     String uname=(sc.nextLine());
                     System.out.println("Enter User city");
                     String ucity=sc.nextLine();
                     //creating student object and saving value
                     Student student=new Student();
                     student.setStudentId(uid);
                     student.setStudentCity(ucity);
                     student.setStudentName(uname);
                     //saving student object to database by calling insert of studentdao
                     int rr=studentdao.insert(student);
                     System.out.println(rr+"student added");

                     break;
                 case 2:
                     //dispaly
                     List<Student> allstudent=studentdao.getAllStudents();
                     for(Student s:allstudent){
                         System.out.println("NAME"+s.getStudentName());
                         System.out.println("ID"+s.getStudentId());
                         System.out.println("NAME"+s.getStudentCity());
                     }
                     break;
                 case 3:
                     System.out.println("Enter user id:");
                     int userid= Integer.parseInt(sc.nextLine());
                     Student student3=studentdao.getStudent(userid);
                     System.out.println("NAME"+student3.getStudentName());
                     System.out.println("ID"+student3.getStudentId());
                     System.out.println("CITY"+student3.getStudentCity());
                     //get single student

                     break;
                 case 4:
                     //delete
                     System.out.println("Enter user id:");
                     int useriddlt= Integer.parseInt(sc.nextLine());
                     studentdao.deleteStudent(useriddlt);
                     System.out.println("dltd");
                     break;
                 case 5:
                     //update
                     System.out.println("ENTER THE ID TO BE UPDATED");
                     int uderidupdt=Integer.parseInt(sc.nextLine());
                     Student existingst=studentdao.getStudent(uderidupdt);

                     if(existingst==null){
                         System.out.println("BACK OFF NIGGA");
                     }else{
                         System.out.println("ENTER THE NAME ");
                         String username=sc.nextLine();
                         System.out.println("ENTER THE CITY TO UPDATE ");
                         String usercity=sc.nextLine();
                         existingst.setStudentCity(usercity);
                         existingst.setStudentName(username);
                         studentdao.updateStudent(existingst);
                         System.out.println("NAME"+existingst.getStudentName());
                         System.out.println("ID"+existingst.getStudentId());
                         System.out.println("CITY"+existingst.getStudentCity());
                     }


                     break;
                 case 6:
                     //exit
                     go=false;
                     break;

             }

            }catch (Exception e){
                System.out.println("INVALID INPUT");
                e.printStackTrace();
            }
        }
        System.out.println("Bye");

    }

}

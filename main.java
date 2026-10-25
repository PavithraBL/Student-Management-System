import java.util.ArrayList;
import java.util.Scanner;

class Student
{
  final int studentId;
  String name;
  String course;
  String skill;

  Student(int id, String name, String course, String skill ){
    this.studentId = id;
    this.name = name;
    this.course = course;
    this.skill = skill;
  }

  void display(){
    System.out.println("Student_Id = " + studentId);
    System.out.println("Name = " + name);
    System.out.println("Course = " + course);
    System.out.println("Skill = " + skill);
    System.out.println();
  }


  public static void main(String [] args){

    ArrayList<Student> student = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    int choice = 1;
    do {
      System.out.print("""  
                        ===== Student Management System =====
                        1. Add Student 
                        2. View Students
                        3. Search Student
                        4. Delete Student
                        5. Update Student
                        6. Exit 

                        Enter your choice: """);
                        choice = sc.nextInt();
                        System.out.println();

          if( choice == 1) {
            boolean exists = true;
            int attempts = 0;
            int studentId = 0;

            while(exists && attempts < 3) {
              System.out.print("Enter the studentId: ");
              studentId = sc.nextInt(); sc.nextLine();
                  attempts++;
                  exists = false;

              for(int i = 0; i < student.size(); i++){
              Student stud = student.get(i);
                if(stud.studentId == studentId){
                    exists = true;
                    System.out.println("Student ID already exists. Please enter a unique ID.\n");
                    break;
                }
              }

              if (exists && attempts < 3) 
                  System.out.println("Attempts remaining: " + (3 - attempts));
            }

            if(!exists){
                  System.out.print("Enter the Name: ");
                  String name = sc.nextLine();

                  System.out.print("Enter the Course: ");
                  String course = sc.nextLine();

                  System.out.print("Enter the Skill: ");
                  String skill = sc.nextLine();
                  System.out.println();

                  Student students = new Student(studentId, name, course, skill);
                  student.add(students); 
                  System.out.println("Student added successfully!...\n");
            }  else {
                  System.out.println("Maximum attempts reached. Returning to main menu.\n"); 
  
          }
        }
                       
                    
          else if (choice == 2){
              if(student.isEmpty()) {
                System.out.println("No students found. Please add a student first.");
                System.out.println("Please choose option 1 to add a student.\n");
              } else {
                  for(Student stud: student)
                    stud.display();
              }
          }

          else if (choice == 3){
              boolean found = false;
              System.out.print("Enter the Student_ID: ");
              int studentId = sc.nextInt();
              for(Student stud: student){
                if(stud.studentId == studentId){
                    found = true;
                    stud.display();
                    break;
                }
              }

              if(!found)
                  System.out.println("Student not found... \n");     
          }

          else if (choice == 4){
              System.out.print("Enter the Student_ID: ");
              int studentId = sc.nextInt();
              boolean found = false;
              for(int i = 0; i < student.size(); i++){
                Student stud = student.get(i);
                  if(stud.studentId == studentId){
                    student.remove(stud);
                    System.out.println("Student deleted successfully!\n");
                    found = true;
                    break;
                  }
              }  
              
              if(!found){
                    System.out.println("Student not found. Please check the Student ID and try again.\n");
                }
          }

          else if (choice == 5){
              System.out.print("Enter the Student Id you want to Update: ");
              int studentId = sc.nextInt(); sc.nextLine();
              boolean found = false;
              for(int i = 0; i < student.size(); i++){
                Student stud = student.get(i);
                  if(stud.studentId == studentId){
                    System.out.println("Enter the updated student details:");
                    System.out.print("Enter the new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the new course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter the new skill: ");
                    String skill = sc.nextLine();
                    stud.name = name;
                    stud.course = course;
                    stud.skill = skill;
                    System.out.println("Student details updated successfully!\n");
                    found = true;
                    break;
                  }
              }

              if(!found){
                    System.out.println("Student not found. Please check the Student ID and try again.\n");
              }  
          }

            
          else if (choice == 6) 
              System.out.println("Exiting Student Management System...\n");
          
          else {
              System.out.println("Invalid choice. Please select an option from 1 to 6.\n");
          }
    } while (choice != 6);

    
    sc.close();
    
  }
}





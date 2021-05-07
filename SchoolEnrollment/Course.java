import java.util.ArrayList;
import java.util.Scanner;

public abstract class Course {
  private ArrayList<Instructor> instructors = new ArrayList<>();
  private ArrayList<Student> students=new ArrayList<>();
  private int credit, studentCounter=0;
  private static final int COURSE_LIMIT=30;
  private String courseName;
  private StaffMembers staffMembers;
  private ArrayList<TeachingAssistants> teachingAssistants= new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  public Course() {}

    //Default contructor was being called and need it to not println and didn't want to move the println.
    public Course(int filler) {
      System.out.println("Please assign the credit:");
      this.credit = Integer.parseInt(scanner.nextLine());
      System.out.println("Please assign the courseName:");
      this.courseName = scanner.nextLine();
      System.out.println("Please assign the staff member(Enter none if there isn't any):");
      this.staffMembers = new StaffMembers(scanner.nextLine());
    }

    public void addInstructor(Instructor i) {
      if (instructors.size() < 1) {
        instructors.add(i);
      } //Can throw same person exception here
    }

    public void addTeachingAssistant(TeachingAssistants i){
      if (teachingAssistants.size() < 3 && !teachingAssistants.contains(i)) {
        teachingAssistants.add(i);
      }
    }

    public void addStudent(Student s) {
      if(!students.contains(s) && studentCounter<COURSE_LIMIT) {
        students.add(s);
        studentCounter++;
      }
    }

    public int getCredit() {
      return credit;
    }

    public String getCourseName() {
      return courseName;
    }

    public StaffMembers getStaffMembers(){
      return staffMembers;
    }

    public String toString() {
      String s = "[";

      for (int i = 0; i < instructors.size(); i++) {
        s += instructors.get(i).toString();
        if (i != instructors.size()-1) {
          s += ", ";
        }
      }

      s += "]";

      String t = "[";

      for (int i = 0; i < teachingAssistants.size(); i++) {
        s += teachingAssistants.get(i).toString();
        if (i != teachingAssistants.size()-1) {
          t += ", ";
        }
      }

      t += "]";

      return String.format("Course Name: %s  Credit hours: %d  Enrollments: %d\nInstructors: %s\nTeacherAssistant: %s\nStaffMember: %s\n",
      courseName, credit, students.size(), s, t, staffMembers);
    }

    public void setCredit(int credit) {
      this.credit = credit;
    }

    public void setName(String name) {
      this.courseName = name;
    }

    public void setStaffMembers(String staffMembers) {
      this.staffMembers = new StaffMembers(staffMembers);
    }

    public abstract String toFileString();
  }

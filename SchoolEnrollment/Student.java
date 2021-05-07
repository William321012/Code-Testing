public class Student extends Person implements Club, Program, PartTime, FullTime {
    private int credit = 0;
    private String club, program;
    java.util.Scanner sc = new java.util.Scanner(System.in);

    public Student(String name) {
        super(name);
    }

    public void addCourse(Course c) {
        if (credit + c.getCredit() <= 18) {
            credit += c.getCredit();
            c.addStudent(this);
        }
    }

    public String toString(){
        return super.getName().toString();
    }

    public void getClub() {
      System.out.println("What club is the student in?");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      club = sc.next();
    }

    public void printClub() {
      System.out.println("Student is in the " + club + "club.");
    }

    public void getProgram() {
      System.out.println("What program is the student in?");
      program = sc.next();
    }

    public void printProgram() {
      System.out.println("Student is in the " + program + "program.");
    }

    public void printPartTime() {
      System.out.println("Student is PartTime.");
    }

    public void printFullTime() {
      System.out.println("Student is FullTime.");
    }
}

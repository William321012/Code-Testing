import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//code doesn't have exceptions for negatives and empty inputs, wasn't added because of how the code was written, would be if and for loops everywhere.

public class Main {

  static Scanner scanner = new Scanner(System.in);
  static ArrayList<Course> list_course = new ArrayList<Course>();
  static ArrayList<Student> list_student = new ArrayList<Student>();
  static ArrayList<Instructor> list_instructor = new ArrayList<Instructor>();
  static ArrayList<TeachingAssistants> list_teachingAssistants = new ArrayList<>();
  static ArrayList<LabTechnicians> list_labTechnicians = new ArrayList<>();
  static ArrayList<String> userInput = new ArrayList<>();
  static ArrayList<String> fileData = new ArrayList<>();
  static boolean trigger=true;

  public static void main(String[] args) {
    readFile();
    while (trigger==true) {
      fileRotation();
      System.out.println();
      System.out.println("1: Add Courses");
      System.out.println("2: Add Student");
      System.out.println("3: Register Class");
      System.out.println("4: Add Instructor");
      System.out.println("5: Assign instructor to course");
      System.out.println("6: Add teaching assistant");
      System.out.println("7: Assign teaching assistant to course");
      System.out.println("8: Add lab technicians");
      System.out.println("9: Assign lab technicians to course");
      System.out.println("10: Display Students");
      System.out.println("11: Display Staff");
      System.out.println("12: List Courses");
      System.out.println("13: Search class");
      System.out.println("0: Quit");
      System.out.println("\nSelect an option: ");
      String choice = scanner.nextLine();
      userInput.add(choice);
      System.out.println();
      readInput(choice);
    }
  }

  public static void readInput(String choice) {
    try {
      switch (choice) {
        case "1":
        add_course();
        fileData.add(list_course.get(list_course.size()-1).toFileString());
        break;

        case "2":
        add_student();
        break;

        case "3":
        register_class();
        break;

        case "4":
        add_instructor();
        break;

        case "5":
        assign_instructor();
        break;

        case "6":
        add_teachingAssistant();
        break;

        case "7":
        assign_teachingAssistant();
        break;

        case "8":
        add_labTechnicians();
        break;

        case "9":
        assign_labTechnicians();
        break;

        case "10":
        display_students();
        break;

        case "11":
        display_staff();
        break;

        case "12":
        display_course_info();
        break;

        case "13":
        try {
          search_class();
          break;
        }catch(NoClassFoundException e){
          System.err.println(e.getMessage());
        }

        case "0":
        trigger=false;
        return;

        default:
        System.out.println("Please Select a Choice Listed.");
        break;
      }
    }catch (NoPersonFoundException e){
      System.err.println(e.getMessage());
    }catch (NoClassFoundException e){
      System.err.println(e.getMessage());
    }catch (ArrayIndexOutOfBoundsException e) {
      System.err.println(e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("\nA Letter was entered for a number.");
    }
  }

  public static void add_course() {
    System.out.println("1.FaceToFaceClasses");
    System.out.println("2.Asynchronous online classes");
    System.out.println("3.Synchronous online classes" );
    System.out.println("4.lecture-only classes");
    System.out.println("5.Hybrid classes");
    System.out.println("6 laboratory-only classes");
    System.out.println("0.exit");

    System.out.println("\nWhich type of course would you like to add?");
    try {
      switch (scanner.nextLine()) {
        case "1":
        System.out.println("\nPlease enter the location of the classroom, followed by when it takes place:");
        String classroomInfo01 = scanner.nextLine();
        FaceToFaceClasses faceToFaceClasses = new FaceToFaceClasses(classroomInfo01);
        list_course.add(faceToFaceClasses);
        userInput.add(classroomInfo01 + " " + faceToFaceClasses.getCredit() + " "
        + faceToFaceClasses.getCourseName() + " " + faceToFaceClasses.getStaffMembers());
        break;

        case "2":
        System.out.println("\nPlease enter the conference information:");
        String aConferenceInfo = scanner.nextLine();
        AsynchronousOnlineClasses asynchronousOnlineClasses= new AsynchronousOnlineClasses(aConferenceInfo);
        list_course.add(asynchronousOnlineClasses);
        userInput.add(aConferenceInfo + " " + asynchronousOnlineClasses.getCredit() + " "
        + asynchronousOnlineClasses.getCourseName() + " " + asynchronousOnlineClasses.getStaffMembers());
        break;

        case "3":
        System.out.println("\nPlease enter when this class occurs:");
        String classTime = scanner.nextLine();
        System.out.println("\nPlease enter the conference information:");
        String sConferenceInfo = scanner.nextLine();
        SynchronousOnlineClasses synchronousOnlineClasses= new SynchronousOnlineClasses(classTime, sConferenceInfo);
        list_course.add(synchronousOnlineClasses);
        userInput.add(classTime + " " + sConferenceInfo + " " + synchronousOnlineClasses.getCredit() + " "
        + synchronousOnlineClasses.getCourseName() + " " + synchronousOnlineClasses.getStaffMembers());
        break;

        case "4":
        System.out.println("\nPlease enter the location of the classroom, followed by when it takes place:");
        String classroomInfo04 = scanner.nextLine();
        LectureOnlyClasses lectureOnlyClasses = new LectureOnlyClasses(classroomInfo04);
        list_course.add(lectureOnlyClasses);
        userInput.add(classroomInfo04 + " " + lectureOnlyClasses.getCredit() + " "
        + lectureOnlyClasses.getCourseName() + " " + lectureOnlyClasses.getStaffMembers());

        case "5":

        System.out.println("\nPlease enter the location of the classroom, followed by when it takes place:");
        String classroomInfo05 = scanner.nextLine();
        System.out.println("\nPlease choose the lab type(#)");
        System.out.println("1.chemistry lab, 2.physics lab, 3.computer lab");

        try {
          int labType01 = scanner.nextInt();
          HybridClasses hybridClasses = new HybridClasses(labType01, classroomInfo05, list_labTechnicians);
          list_course.add(hybridClasses);
          userInput.add(classroomInfo05 + " " + labType01 + " " + hybridClasses.getCredit() + " "
          + hybridClasses.getCourseName() + " " + hybridClasses.getStaffMembers());
          break;
        } catch(Exception e) {
          System.err.println(e.getMessage());
        }

        break;

        case "6":
        System.out.println("1.chemistry lab 2.physics lab 3.computer lab");
        System.out.println("please choose the number");
        try {
          int labType02 = scanner.nextInt();
          LaboratoryOnlyClasses laboratoryOnlyClasses = new LaboratoryOnlyClasses(labType02, list_labTechnicians);
          list_course.add(laboratoryOnlyClasses);
          userInput.add(labType02 + " " + laboratoryOnlyClasses.getCredit() + " "
          + laboratoryOnlyClasses.getCourseName() + " " + laboratoryOnlyClasses.getStaffMembers());
          break;
        }catch(Exception e){
          System.err.println(e.getMessage());
        }

        default:
        System.out.println("Please Select a Choice Listed.");
        break;

        case "0":
        return;
      }
    } catch (NumberFormatException e) {
      System.err.println("Please retry and enter a number for credit.\n");
      add_course();
    }

  }

  public static void add_student() {
    String name;
    System.out.println("Enter the name of the student: ");
    name=scanner.nextLine();
    list_student.add(new Student(name));
    fileData.add("Student " + name);
    userInput.add(name);
  }

  public static void register_class()throws NoClassFoundException,NoPersonFoundException {
    if (list_course.size() == 0){
      throw new NoClassFoundException("Please add the course first");
    }

    if (list_student.size() == 0){
      System.out.println("No student found");
      throw new NoPersonFoundException("Please enter the lab technician first");
    }

    int index_course;
    System.out.println("Select a course:");
    listAll(list_course);
    index_course = Integer.parseInt(scanner.nextLine());

    if (index_course < 0 || index_course > list_course.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound course data");
    }

    int index_student;
    System.out.println("Select a student:");
    listAll(list_student);
    index_student = Integer.parseInt(scanner.nextLine());

    if (index_student < 0 || index_student > list_student.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound course data");
    }

    list_student.get(index_student).addCourse(list_course.get(index_course));
    fileData.add("RegCourse " + index_student + " " + index_course);
    userInput.add(index_student + " " + index_course);
  }

  public static void add_instructor() {
    String name;
    System.out.println("Enter the name of the instructor: ");
    name=scanner.nextLine();
    list_instructor.add(new Instructor(name));
    fileData.add("Instructor " + name);
    userInput.add(name);
  }

  public static void assign_instructor()throws NoClassFoundException,NoPersonFoundException{
    if (list_course.size() == 0){
      throw new NoClassFoundException("Please add the course first");
    }

    if (list_instructor.size() == 0){
      throw new NoPersonFoundException("Please enter the lab technician first");
    }

    int index_course;
    System.out.println("Select a course:");
    listAll(list_course);
    index_course = Integer.parseInt(scanner.nextLine());

    if (index_course < 0 || index_course > list_course.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound course data");
    }

    int index_instructor;
    System.out.println("Select an instructor:");
    listAll(list_instructor);
    index_instructor = Integer.parseInt(scanner.nextLine());

    if (index_instructor < 0 || index_instructor > list_instructor.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound instructor data");
    }

    list_course.get(index_course).addInstructor(list_instructor.get(index_instructor));
    fileData.add("AssignInstructor " + index_course + " " + index_instructor);
    userInput.add(index_course + " " + index_instructor);
  }

  public static void add_teachingAssistant() {
    String name;
    System.out.println("Enter the name of the teaching Assistant: ");
    name=scanner.nextLine();
    list_teachingAssistants.add(new TeachingAssistants(name));
    fileData.add("TeachingAssistant " + name);
    userInput.add(name);
  }

  public static void assign_teachingAssistant()throws NoClassFoundException,NoPersonFoundException {
    if (list_course.size() == 0){
      throw new NoClassFoundException("Please add the course first");
    }

    if (list_instructor.size() == 0){
      throw new NoPersonFoundException("Please enter the lab technician first");
    }



    int index_course;
    System.out.println("Select a course:");
    listAll(list_course);
    index_course = Integer.parseInt(scanner.nextLine());

    if (index_course < 0 || index_course > list_course.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound course data");
    }

    int index_teachingAssistant;
    System.out.println("Select an teachingAssistant:");
    listAll(list_instructor);
    index_teachingAssistant = Integer.parseInt(scanner.nextLine());

    if (index_teachingAssistant < 0 || index_teachingAssistant > list_teachingAssistants.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound instructor data");
    }

    list_course.get(index_course).addTeachingAssistant(list_teachingAssistants.get(index_teachingAssistant));
    fileData.add("AssignTeachingAssistant " + index_course + " " + index_teachingAssistant);
    userInput.add(index_course + " " + index_teachingAssistant);
  }

  public static void add_labTechnicians() {
    String name;
    System.out.println("Enter the name of the lab technician: ");
    name=scanner.nextLine();
    list_labTechnicians.add(new LabTechnicians(name));
    fileData.add("LabTechnician " + name);
    userInput.add(name);
  }

  public static void assign_labTechnicians()throws NoClassFoundException,NoPersonFoundException{
    if (list_course.size() == 0){
      throw new NoClassFoundException("Please add the course first");
    }

    if (list_labTechnicians.size() == 0){
      throw new NoPersonFoundException("Please enter the lab technician first");
    }



    int index_course;
    System.out.println("Select a course:");
    listAll(list_course);
    index_course = Integer.parseInt(scanner.nextLine());

    if (index_course < 0 || index_course > list_course.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound course data");
    }

    int index_labTechnicians;
    System.out.println("Select an lab technician:");
    listAll(list_labTechnicians);
    index_labTechnicians = Integer.parseInt(scanner.nextLine());

    if (index_labTechnicians < 0 || index_labTechnicians > list_labTechnicians.size() - 1) {
      throw new ArrayIndexOutOfBoundsException("Outbound instructor data");
    }

    ((LaboratoryOnlyClasses)(list_course.get(index_course))).addLabTechnicians(list_labTechnicians.get(index_labTechnicians));
    fileData.add("AssignLabTechnician " + index_course + " " + index_labTechnicians);
    userInput.add(index_course + " " + index_labTechnicians);
  }

  public static void display_students() {
    System.out.println("Student List");
    listAll(list_student);
  }

  public static void display_course_info() {
    System.out.println("Course List");
    listAll(list_course);
  }

  public static void display_staff() {
    System.out.println("Staff List");
    System.out.println("Instructors:");
    listAll(list_instructor);
    System.out.println("Teaching Assistants:");
    listAll(list_teachingAssistants);
    System.out.println("Lab Technicians:");
    listAll(list_labTechnicians);
  }

  public static void search_class() throws NoClassFoundException {
    if (list_course.size() == 0) {
      throw new NoClassFoundException("Please add the course first");
    } else if (list_course.size() == 1) {
      System.out.println("There only one course so far:\n");
      System.out.println(list_course.get(0).toString() + "\n");
    }

    System.out.println("Please enter the class you want to search for(Cap Sensitive)");
    String className =  scanner.nextLine();
    userInput.add(className);

    ArrayList<Course> search_course = list_course;
    java.util.Collections.sort(search_course, new NameSort());
    int result = binarySearch(search_course, 0, search_course.size()-1, className);
    if (result != -1) {
      System.out.println("\nClass Found:");
      System.out.println(search_course.get(result).toString());
    } else {
      System.out.println("Class Not Found");
    }
  }

  public static int binarySearch(ArrayList<Course> search_course, int start, int end, String name) {
    if (end >= 1) {
      int mid = start + (end - start)/2;
      if (search_course.get(mid).getCourseName().equals(name)){
        return mid;
      }
      if (search_course.get(mid).getCourseName().compareTo(name) >= 1) {
        return binarySearch(search_course, start, mid - 1, name);
      } else {
        return binarySearch(search_course, mid + 1, end, name);
      }
    }
    return -1;
  }

  public static void listAll(ArrayList list) {
    System.out.println("-----------------------------------------------------------------");
    for (int i = 0; i <list.size(); i++) {
      System.out.printf("%d:   %s\n  ", i, list.get(i).toString());
    }
    System.out.println("-----------------------------------------------------------------");
  }

  public static void readFile() {
    boolean button = true;
    //Didn't add more exception as the mistakes in data can't be fixed on the spot.
    try {
      Scanner input = new Scanner(new File("courseappdata.txt"));
      while (input.hasNextLine() && button == true) {
        String line = input.nextLine();
        if (line.equals("")) {
          line = input.nextLine();
          button = false;
          input.close();
          break;
        }
        fileData.add(line);
        Scanner readLine = new Scanner(line);

        switch (readLine.next()) {
          case "1":
          list_course.add(new FaceToFaceClasses(readLine.nextInt(), readLine.next(), readLine.next(), readLine.next()));
          break;
          case "2":
          list_course.add(new AsynchronousOnlineClasses(readLine.nextInt(), readLine.next(), readLine.next(), readLine.next()));
          break;
          case "3":
          list_course.add(new SynchronousOnlineClasses(readLine.nextInt(), readLine.next(), readLine.next(), readLine.next(), readLine.next()));
          break;
          case "4":
          list_course.add(new LectureOnlyClasses(readLine.nextInt(), readLine.next(), readLine.next(), readLine.next()));
          break;
          case "5":
          list_course.add(new HybridClasses(readLine.nextInt(), readLine.next(), readLine.next(), readLine.nextInt(), readLine.next()));
          break;
          case "6":
          list_course.add(new LaboratoryOnlyClasses(readLine.nextInt(), readLine.next(), readLine.next(), readLine.nextInt()));
          break;
          case "Student":
          list_student.add(new Student(readLine.next()));
          break;
          case "RegCourse":
          list_student.get(readLine.nextInt()).addCourse(list_course.get(readLine.nextInt()));
          break;
          case "Instructor":
          list_instructor.add(new Instructor(readLine.next()));
          break;
          case "AssignInstructor":
          list_course.get(readLine.nextInt()).addInstructor(list_instructor.get(readLine.nextInt()));
          break;
          case "TeachingAssistant":
          list_teachingAssistants.add(new TeachingAssistants(readLine.next()));
          break;
          case "AssignTeachingAssistant":
          list_course.get(readLine.nextInt()).addTeachingAssistant(list_teachingAssistants.get(readLine.nextInt()));
          break;
          case "LabTechnician":
          list_labTechnicians.add(new LabTechnicians(readLine.next()));
          break;
          case "AssignLabTechnician":
          ((LaboratoryOnlyClasses)(list_course.get(readLine.nextInt()))).addLabTechnicians(list_labTechnicians.get(readLine.nextInt()));
          break;
          default:
          break;
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void printToFile() {
    PrintWriter output = null;
    try {
      fileData.remove("UserInputs:");
      output = new PrintWriter("courseappdata.txt");
      for (String data: fileData) {
        output.println(data);
      }
      output.println("\nUserInputs:");
      for (String input: userInput) {
        output.println(input);
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
    } finally {
      output.close();
    }
  }

  public static void fileRotation() { //Doing backups based on time is probably better, but I just did it based on number of data.
    printToFile();
    File file = new File("courseappdata.txt");
    File file2 = new File("courseappdata.bu.1.txt");
    File file3 = new File("courseappdata.bu.2.txt");
    File file4 = new File("courseappdata.bu.3.txt");
    if (!file2.exists() && fileData.size() == 15) {
      printToFile();
      file.renameTo(file2);
      printToFile();
    } else if (!file3.exists() && fileData.size() == 20) {
      printToFile();
      file2.renameTo(file3);
      file.renameTo(file2);
      printToFile();
    } else if (!file4.exists() && fileData.size() == 25) {
      printToFile();
      System.out.println(file3.renameTo(file4));
      file2.renameTo(file3);
      file.renameTo(file2);
      printToFile();
    }
  }
}

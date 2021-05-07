import java.util.ArrayList;

public class HybridClasses extends Course {
  private int labName;
  private String classRoomInfo;
  private ArrayList<LabTechnicians> labTechnicians=new ArrayList<>();

  public HybridClasses(int labName, String classRoomInfo, ArrayList<LabTechnicians> labTechnicians) {
    super(0);
    this.labName = labName;
    this.classRoomInfo = classRoomInfo;
    this.labTechnicians = labTechnicians;
  }

  public HybridClasses(int credit, String name, String staffMembers, int labName, String classRoomInfo) {
    setCredit(credit);
    setName(name);
    setStaffMembers(staffMembers);
    this.labName = labName;
    this.classRoomInfo = classRoomInfo;
  }

  public String getClassInfo() {
    return classRoomInfo;
  }

  public String getLabName() {
    if(labName == 1){
      return "Chemistry lab";
    } else if(labName == 2){
      return "Physics lab";
    } else if(labName == 3){
      return "Computer lab";
    }
    return "None";
  }

  public void addLabtechnicians(LabTechnicians i) {
    if (labTechnicians.size() < 3 && !labTechnicians.contains(i)) {
      labTechnicians.add(i);
    }
  }


  public void getLab() {
    System.out.println("The lab class is"+ labName);
  }

  public String toString(){
    String t = "[";

    for (int i = 0; i < labTechnicians.size(); i++) {
      t += labTechnicians.get(i).toString();
      if (i != labTechnicians.size()-1) {
        t += ", ";
      }
    }

    t += "]";

    return super.toString() + "Lab type: " + getLabName() + " Class Information: " + classRoomInfo + "\nLab Technicians: " + t;
  }

  public String toFileString() {
    return "5 " + getCredit() + " " + getCourseName() + " " + getStaffMembers() + " " + labName + " " + classRoomInfo;
  }
}

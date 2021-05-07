public class FaceToFaceClasses extends Course {
  private String classRoomInfo;

  public FaceToFaceClasses(String classRoomInfo) {
    super(0);
    this.classRoomInfo = classRoomInfo;
  }

  public FaceToFaceClasses(int credit, String name, String staffMembers, String classRoomInfo) {
    setCredit(credit);
    setName(name);
    setStaffMembers(staffMembers);
    this.classRoomInfo = classRoomInfo;
  }

  public String getClassRoomInfo() {
    return classRoomInfo;
  }

  public String toString() {
    return super.toString()+ "ClassRoomInfo: " + classRoomInfo + "\n";
  }

  public String toFileString() {
    return "1 " + getCredit() + " " + getCourseName() + " " + getStaffMembers() + " " + classRoomInfo;
  }
}

public class LectureOnlyClasses extends Course{
    private String classRoomInfo;

    public LectureOnlyClasses(String classRoomInfo){
        super(0);
        this.classRoomInfo=classRoomInfo;
    }

    public LectureOnlyClasses(int credit, String name, String staffMembers, String classRoomInfo) {
      setCredit(credit);
      setName(name);
      setStaffMembers(staffMembers);
      this.classRoomInfo = classRoomInfo;
    }

    public String getClassRoomInfo(){
        return classRoomInfo;
    }
    public String toString(){
        return super.toString()+ "the class information:" + classRoomInfo + "\n";
    }

    public String toFileString() {
      return "4 " + getCredit() + " " + getCourseName() + " " + getStaffMembers() + " " + classRoomInfo;
    }
}

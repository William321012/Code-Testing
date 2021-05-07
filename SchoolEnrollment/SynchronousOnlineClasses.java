public class SynchronousOnlineClasses extends Course {
    private String classTime, sConferenceInfo;
    public SynchronousOnlineClasses(String classTime, String sConferenceInfo) {
        super(0);
        this.classTime=classTime;
        this.sConferenceInfo=sConferenceInfo;
    }

    public SynchronousOnlineClasses(int credit, String name, String staffMembers, String classTime, String classRoomInfo) {
      setCredit(credit);
      setName(name);
      setStaffMembers(staffMembers);
      this.classTime=classTime;
      this.sConferenceInfo=classRoomInfo;
    }

    public String getClassTime() {
        return classTime;
    }

    public String getConferenceInfo() {
      return sConferenceInfo;
    }

    public String toFileString() {
      return "3 " + getCredit() + " " + getCourseName() + " " + getStaffMembers() + " " + classTime +" " + sConferenceInfo;
    }
}

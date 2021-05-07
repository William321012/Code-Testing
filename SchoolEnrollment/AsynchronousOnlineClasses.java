public class AsynchronousOnlineClasses extends Course {
    private String aConferenceInfo;

    public AsynchronousOnlineClasses(String aConferenceInfo) {
        super(0);
        this.aConferenceInfo = aConferenceInfo;
    }

    public AsynchronousOnlineClasses(int credit, String name, String staffMembers, String aConferenceInfo) {
      setCredit(credit);
      setName(name);
      setStaffMembers(staffMembers);
      this.aConferenceInfo = aConferenceInfo;
    }

    public String getConferenceInfo() {
      return aConferenceInfo;
    }

    public String toFileString() {
      return "2 " + getCredit() + " " + getCourseName() + " " + getStaffMembers() + " " + aConferenceInfo;
    }
}

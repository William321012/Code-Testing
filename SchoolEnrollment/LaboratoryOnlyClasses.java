import java.util.ArrayList;

public class LaboratoryOnlyClasses extends Course {
    private int labType;
    private ArrayList<LabTechnicians> labTechnicians=new ArrayList<>();
    public LaboratoryOnlyClasses(int labType, ArrayList<LabTechnicians> labTechnicians){
        super(0);
        this.labType = labType;
        this.labTechnicians = labTechnicians;
    }

    public LaboratoryOnlyClasses(int credit, String name, String staffMembers, int labType) {
      setCredit(credit);
      setName(name);
      setStaffMembers(staffMembers);
      this.labType = labType;
    }

    public String getClassRoomName() {
      if(labType == 1){
        return "Chemistry lab";
      } else if(labType == 2){
        return "Physics lab";
      } else if(labType == 3){
        return "Computer lab";
      }
      return "None";
    }

    public void addLabTechnicians(LabTechnicians i) {
        if (labTechnicians.size() < 3 && !labTechnicians.contains(i)) {
            labTechnicians.add(i);
        }
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
        return super.toString() + "Lab Type: " + getClassRoomName() + "\nLab Technicians: " + t;
    }

    public String toFileString() {
      return "6 " + getCredit() + " " + getCourseName() + " " + getStaffMembers() + " " + labType;
    }
}

public class Lab {
    private LabTechnicians labTechnicians;
    private String labName;
    public Lab(LabTechnicians labTechnicians,String labName){
        this.labTechnicians=labTechnicians;
        this.labName = labName;
    }

    public String getLabName(){
        return labName;
    }
}

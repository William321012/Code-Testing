public class Instructor extends Person{
    public Instructor(String name) {
        super(name);
    }

    public String toString() {
        return super.getName().toString();
    }
}

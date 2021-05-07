public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
      return name;
    }

    // // Because a person isn't considered just person in college, but instead 
    // needs a characteristic like "Student", the toString() method isn't needed for
    // the person class as just the name of a person doesn't mean anything.
    public abstract String toString();
}

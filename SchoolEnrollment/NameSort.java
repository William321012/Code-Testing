import java.util.Comparator;

public class NameSort implements Comparator<Course> {
  public int compare(Course a, Course b)
  {
    return a.getCourseName().compareTo(b.getCourseName());
  }
}

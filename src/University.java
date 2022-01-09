import java.io.Serializable;
import java.util.ArrayList;


public class University implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList students;
    private ArrayList teachers;

    public University(ArrayList student, ArrayList teachers){
        this.students = student;
        this.teachers = teachers;
    }

    public ArrayList getStudents(){return students;}

    public ArrayList getTeachers(){return teachers;}

}

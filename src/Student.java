import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

class Student extends Human implements Serializable {
    private Marks marks = new Marks();

    public Student(String firstName, String lastName, int group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public static void menu(){
        System.out.println("1. Add student");
        System.out.println("2. Show all student");
        System.out.println("3. Changing fields");
        System.out.println("4. Delete students");
        System.out.println("5. Return");
    }

    public static void addStudents(ArrayList students, String name, String surname, int group){
        students.add(new Student(name, surname, group));
    }

    public static void getStudentWithTheBadMark(ArrayList students, ArrayList listWithBadMarks){
        Iterator iterator = students.iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            if(student.marks.getMarkInProg() < 4){
                listWithBadMarks.add(student);
//                students.remove(student);
            }
        }
    }

    public static void showDataBase(ArrayList list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student.getAllInfo());
        }
    }

    public void passEx(int mark){
        marks.setMarkInProg(mark);
    }

    public String getAllInfo(){
        return  "Student{" +
                "name='" + firstName + '\'' +
                ", surName='" + lastName + '\'' +
                ", group=" + group +
                "marks" + marks.getMarkInProg() + '\'' +
                '}';
    }
}

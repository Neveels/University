import java.util.ArrayList;

public class Rector extends Human{

    public Rector(String name, String surname){
        this.firstName = name;
        this.lastName = surname;
    }

    public void getListWithTheBadMarks(ArrayList students, ArrayList listWithBadMarks){
        if(students.isEmpty()){
            System.out.println("Added students!!");
            return;
        }
        Student.getStudentWithTheBadMark(students, listWithBadMarks);
        Student.showDataBase(listWithBadMarks);
    }


}

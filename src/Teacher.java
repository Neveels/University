import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Teacher extends Human implements Serializable {
    private String rank;
    private String subject;

    public Teacher(String name, String surName, String rank, int group, String subject){
        this.firstName = name;
        this.lastName = surName;
        this.rank = rank;
        this.group = group;
        this.subject = subject;
    }

    public static void menu(){
        System.out.println("1. Add new teacher.");
        System.out.println("2. Show teaching staff");
        System.out.println("3. Take the exam.");
        System.out.println("4. Return");
    }


    public static void addTeacher(ArrayList teachers, String name, String surName, String rank, int group, String sub){
        teachers.add(new Teacher(name, surName, rank, group, sub));
    }

    public static void showAllTeacher(ArrayList teachers){
        Iterator iterator = teachers.iterator();
        while (iterator.hasNext()){
            Teacher teacher = (Teacher) iterator.next();
            System.out.println(teacher.getAllInfo());
        }
    }

    public String getSubject() {return subject;}

    public String getRank() {return rank;}

    public void setRank(String rank) {this.rank = rank;}

    public String getAllInfo(){
        return "Teacher{" +
                "name='" + firstName + '\'' +
                ", surName='" + lastName + '\'' +
                ", group=" + group +
                ", rank='" + rank + '\'' +
                '}';
    }

}

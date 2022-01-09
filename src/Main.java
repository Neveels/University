
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Teacher> teachers =  new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Student> listWithBadMarks = new ArrayList();

//        University university = new University(students,teachers);
//        FileOutputStream fileOutputStream
//                = new FileOutputStream("dataBase.txt");
//        ObjectOutputStream objectOutputStream
//                = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(university);
//        objectOutputStream.flush();
//        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("dataBase.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        University university1 = (University) objectInputStream.readObject();
        objectInputStream.close();
        students = university1.getStudents();
        teachers = university1.getTeachers();

        while (true){
            Scanner in = new Scanner(System.in);
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Rector");
            System.out.println("4. Exit");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    workWithStudents(students);
                    break;
                case 2:
                    workWithTeachers(teachers, students);
                    break;
                case 3:
                    workWithRector(students, listWithBadMarks);
                    break;
                case 4:
                    University university = new University(students,teachers);
                    FileOutputStream fileOutputStream
                            = new FileOutputStream("dataBase.txt");
                    ObjectOutputStream objectOutputStream
                            = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(university);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    System.exit(0);
                default:
                    System.out.println("Choose correct number. Try again!!!");
                    break;
            }
        }
    }

    public static void workWithTeachers(ArrayList<Teacher> teachers, ArrayList<Student> students){

        Scanner in = new Scanner(System.in);
        String name, surname;
        while(true){
            Teacher.menu();
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    in.nextLine();
                    System.out.println("Name: ");
                    name = in.nextLine();
                    System.out.println("Surname: ");
                    surname = in.nextLine();
                    System.out.println("Group: ");
                    int group = in.nextInt();
                    System.out.println("Subject: ");
                    in.nextLine();
                    String sub = in.nextLine();
                    System.out.println("Rank: ");
                    String rank = in.nextLine();
                    Teacher.addTeacher(teachers, name, surname, rank, group, sub);
                    break;
                case 2:
                    Teacher.showAllTeacher(teachers);
                    break;
                case 3:
                    Teacher.showAllTeacher(teachers);
                    System.out.println("Choose a teacher: ");
                    int index = in.nextInt();
                    Student.showDataBase(students);
                    System.out.println("Choose a student: ");
//                    int indexStudent = in.nextInt();
                    Student temp = students.get(index - 1);
                    if(teachers.get(index - 1).getGroup() == temp.getGroup()){
                        int mark;
                        do{
                        System.out.println("Input mark = ");
                        mark = in.nextInt();
                        } while(mark < 0 || mark > 10);
                        students.get(index - 1).passEx(mark);
                    } else{
                        System.out.println("You are not teaching this student\n");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choose correct number. Try again!!!");
            }
        }
    }

    public static void workWithStudents(ArrayList<Student> students){
        Scanner in = new Scanner(System.in);
        String firstName, lastName;
        int group;

        while(true){
            Student.menu();
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    in.nextLine();
                    System.out.println("Name:");
                    firstName = in.nextLine();
                    System.out.println("Surname:");
                    lastName = in.nextLine();
                    System.out.println("Group: ");
                    group = in.nextInt();
                    Student.addStudents(students, firstName, lastName, group);
                    in.nextLine();
                    break;
                case 2:
                    Student.showDataBase(students);
                    break;
                case 3:
                    System.out.println("counter of students" + students.size());
                    break;
                case 4:
                    System.out.println("Input number of student who want to remove:");
                    int index = in.nextInt();
                    if (index > 0 && index < students.size()) {students.remove(students.get(index - 1));}
                    else System.out.println("Choose correct number. Try again");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choose correct number");
                    break;
            }
        }
    }

    public static void workWithRector(ArrayList<Student> students, ArrayList<Student> listWithBadMarks){
        Scanner in = new Scanner(System.in);
        Rector rector = new Rector("Jim", "Jim");
        rector.getListWithTheBadMarks(students,listWithBadMarks);
        if(listWithBadMarks.isEmpty()){ System.out.println("Counter off student with bad marks = " + listWithBadMarks.size());}
        System.out.println("Input student who want to delete: ");
        int index = in.nextInt();
        listWithBadMarks.remove(listWithBadMarks.get(index - 1));
//        listWithBadMarks.get(index - 1).getFirstName();
//        listWithBadMarks.clear();

    }
}

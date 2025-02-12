package practice.Immutables.Eighth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Biil struggles with generics");
        Student bob = new Student("Bob", bobsNotes);
        Student bills = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bills));
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        List<Student> studentSecondCopy = List.copyOf(students);

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
//        studentSecondCopy.set(0, new Student("Bonnie", new StringBuilder()));
//        studentSecondCopy.sort(Comparator.comparing(Student::getName));
        bobsNotes.append("bob was one of my first students");

        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 3 of my courses");


        students.forEach(System.out::println);
        System.out.println("-".repeat(50));
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("-".repeat(50));

        studentSecondCopy.forEach(System.out::println);
        System.out.println("-".repeat(50));


    }
}

package Nobilities.ex30;

import java.util.ArrayList;
import java.util.Arrays;

//Zadanie 30: Calculate an average grade of students
public class AverageGrade {

    public static final String[] lines = {
//name, age, city, grade, faculties
            "Kasia,22,Warsaw,76.5,MATHEMATICS,COMPUTER_SCIENCE,PHYSICS,",
            "Basia,25,Warsaw,94.3,PHYSICS",
            "Piotr,19,Krakow,82.5,ART_HISTORY,JOURNALISM",
            "Krzysztof,21,Krakow,72.4,JOURNALISM",
            "Gosia,23,Poznan,99.6,MATHEMATICS,ART_HISTORY",
            "Artur,24,Krakow,71.4,COMPUTER_SCIENCE,PHYSICS",
            "Marcin,20,Warsaw,81.5,JOURNALISM,ART_HISTORY",
            "Marta,21,Poznan,95.8,COMPUTER_SCIENCE,MATHEMATICS"
    };

    public static void main(String[] args) {
        final var students = new ArrayList<Student>();

        for(final var line : lines) {
            students.add(Student.decode(line));
        }

        double gradeSum = 0.0;
        for (Student current : students ) {
            gradeSum += current.grade;
        }
        gradeSum /= students.size();

        System.out.println(gradeSum);
    }
}
class Student{
    public final String name;
    public final int age;
    public final String city;
    public final double grade;
    private final String[] faculty;

    public String[] getFaculty() {
        return faculty;
    }

    private Student(String name, int age, String city, double grade, String[] faculty) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.grade = grade;
        this.faculty = faculty;
    }

    static Student decode(String line) {
        String[] elements = line.split(",");

        return new Student(
                elements[0],
                Integer.valueOf(elements[1]),
                elements[2],
                Double.valueOf(elements[3]),
                Arrays.copyOfRange(elements, 4, elements.length)
        );
    }

}
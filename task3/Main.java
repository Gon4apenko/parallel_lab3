package task3;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Dmytro Honcharenko IT-01"),
                new Student("Clay Thompson IT-02"),
                new Student("Andriy Voytenko IT-03"),
                new Student("Kostya Peshkov IT-04")
        );

        GradingJournal gradingJournal = new GradingJournal(students);

        Teacher lecturer = new Teacher(students, gradingJournal, "Lecturer");
        Teacher assistant1 = new Teacher(students, gradingJournal, "Assistant 1");
        Teacher assistant2 = new Teacher(students, gradingJournal, "Assistant 2");
        Teacher assistant3 = new Teacher(students, gradingJournal, "Assistant 3");

        Thread lecturerThread = new Thread(lecturer);
        Thread assistant1Thread = new Thread(assistant1);
        Thread assistant2Thread = new Thread(assistant2);
        Thread assistant3Thread = new Thread(assistant3);

        lecturerThread.start();
        assistant1Thread.start();
        assistant2Thread.start();
        assistant3Thread.start();

        try {
            lecturerThread.join();
            assistant1Thread.join();
            assistant2Thread.join();
            assistant3Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<Student, Map<Integer, List<Integer>>> grades = gradingJournal.getGrades();

        for (Student student : students) {
            System.out.println(student.getName() + ":");
            Map<Integer, List<Integer>> studentGrades = grades.get(student);
            for (int week = 1; week <= 3; week++) {
                List<Integer> weekGrades = studentGrades.get(week);
                System.out.println("Week " + week + ": " + weekGrades);
            }
            System.out.println();
        }
    }
}
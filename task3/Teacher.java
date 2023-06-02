package task3;

import java.util.List;
import java.util.Random;

class Teacher implements Runnable {
    private List<Student> students;
    private GradingJournal gradingJournal;
    private String teacherName;

    public Teacher(List<Student> students, GradingJournal gradingJournal, String teacherName) {
        this.students = students;
        this.gradingJournal = gradingJournal;
        this.teacherName = teacherName;
    }

    @Override
    public void run() {
        Random random = new Random();
        int weeks = 3; // Кількість тижнів

        for (int week = 1; week <= weeks; week++) {
            for (Student student : students) {
                for (int i = 0; i < 5; i++) {
                    int grade = random.nextInt(101); // Випадкова оцінка від 0 до 100
                    gradingJournal.addGrade(student, grade, teacherName, week);
                    try {
                        Thread.sleep(100); // Затримка між виставленням оцінок
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
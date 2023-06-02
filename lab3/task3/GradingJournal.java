package task3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class GradingJournal {
    private Map<Student, Map<Integer, List<Integer>>> grades;
    private Lock lock;

    public GradingJournal(List<Student> students) {
        this.grades = new HashMap<>();
        for (Student student : students) {
            grades.put(student, new HashMap<>());
        }
        this.lock = new ReentrantLock();
    }

    public void addGrade(Student student, int grade, String teacherName, int week) {
        lock.lock();
        try {
            Map<Integer, List<Integer>> studentGrades = grades.get(student);
            if (!studentGrades.containsKey(week)) {
                studentGrades.put(week, new ArrayList<>());
            }
            List<Integer> weekGrades = studentGrades.get(week);
            weekGrades.add(grade);
            System.out.println("Grade added for student " + student.getName() + " by " + teacherName + ": " + grade + " (Week " + week + ")");
        } finally {
            lock.unlock();
        }
    }

    public Map<Student, Map<Integer, List<Integer>>> getGrades() {
        return grades;
    }
}

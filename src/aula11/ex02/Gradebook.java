package aula11.ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Gradebook {
    private HashSet<Student> students = new HashSet<>();

    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                List<Double> grades = new ArrayList<>();

                for (int i = 1; i < parts.length; i++) {
                    double grade = Double.parseDouble(parts[i]);
                    grades.add(grade);
                }
                addStudent(name, grades);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, List<Double> grades) {
        students.add(new Student(name, grades));
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        students.remove(getStudent(name));
    }

    public double calculateAverageGrade(String name) {
       Student student = getStudent(name);
        if (student == null) {
             return 0;
        } else {
            IGradeCalculator simpleGradeCalculator = new SimpleGradeCalculator();
            return simpleGradeCalculator.calculate(student.getGrades());
        }
    

    }

    public List <Student> getStudents() {
        return new ArrayList<>(students);
    }

  

    public void printAllStudents(){
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student getStudent(String name){
        name = name.toLowerCase();
        for (Student student : students) {
            if (student.getName().toLowerCase().equals(name)) {
                return student;
            }
        }
        return null;
    }

}

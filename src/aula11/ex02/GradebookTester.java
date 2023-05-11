package aula11.ex02;
import java.util.List;
import java.util.ArrayList;

public class GradebookTester {
    public static void main(String[] args) {
        // Create a new Gradebook instance
        Gradebook gradebook = new Gradebook();

        // Load the student data from a text file
        gradebook.load("alunos.txt");

        // Add a new student to the collection
        Student newStudent = new Student("Johny May", new ArrayList<>(List.of(10.0, 15.0, 19.0)));
        gradebook.addStudent(newStudent);

        // Remove a student from the collection
        gradebook.removeStudent("Jane Smith");


        // Retrieve a student from the collection
        Student student = gradebook.getStudent("John Doe");
        System.out.println(student); // apenas para ser usado e não "ficar amarelo"

        // Calculate the average grade for a specific student
        double averageGrade = gradebook.calculateAverageGrade("John Doe");
        // Print the average grade for a specific student (with two decimal places)
        System.out.println(String.format("Average grade for John Doe: %.2f", averageGrade));
        

        // Print a summary of all students in the collection
        gradebook.printAllStudents();
    }
}


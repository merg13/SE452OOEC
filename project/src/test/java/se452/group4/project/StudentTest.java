package se452.group4.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import se452.group4.project.models.Student;

public class StudentTest {
    
    @Test
    public void testToString() {
        var student = new Student();
        var expectedNoError = "Student(name=BB-8)";

        student.setName("BB-8");
        var result = student.toString();
        System.out.println(result);

        assertEquals(expectedNoError, student.toString());
    }
}

package com.tsbonev.Dao;

import com.tsbonev.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    @Autowired
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "John", "Computer Science"));
                put(2, new Student(2, "Mark", "Finance"));
                put(3, new Student(3, "Simon", "Art"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student){

        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}

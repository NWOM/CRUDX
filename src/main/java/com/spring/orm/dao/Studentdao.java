package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Studentdao {
    // It contains all the methods to store student objects
    private HibernateTemplate hibernateTemplate;

    // Save student
    @Transactional // to enable the write operation
    public int insert(Student student) {
        int i = (int) this.hibernateTemplate.save(student);
        return i;
    }

    // Get the single data(object)
    public Student getStudent(int studentId) {// read single data
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    // Get all students(all rows)
    public List<Student> getAllStudents() {// read multiple data
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    // Deleting the data
    public void deleteStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);// to fetch the details of the studentId of that particular student
        this.hibernateTemplate.delete(student);// return void
    }

    // Updating the data
    public void updateStudent(Student student) {
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}

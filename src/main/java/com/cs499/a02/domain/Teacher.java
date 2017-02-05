package com.cs499.a02.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Teacher.
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<Student> teachers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Teacher name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public Teacher subject(String subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Student> getTeachers() {
        return teachers;
    }

    public Teacher teachers(Set<Student> students) {
        this.teachers = students;
        return this;
    }

    public Teacher addTeacher(Student student) {
        this.teachers.add(student);
        student.setTeacher(this);
        return this;
    }

    public Teacher removeTeacher(Student student) {
        this.teachers.remove(student);
        student.setTeacher(null);
        return this;
    }

    public void setTeachers(Set<Student> students) {
        this.teachers = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Teacher teacher = (Teacher) o;
        if (teacher.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", subject='" + subject + "'" +
            '}';
    }
}

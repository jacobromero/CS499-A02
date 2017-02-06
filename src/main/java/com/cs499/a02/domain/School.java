package com.cs499.a02.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A School.
 */
@Entity
@Table(name = "school")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "school")
    @JsonIgnore
    private Set<Student> schoolStudents = new HashSet<>();

    @OneToMany(mappedBy = "school")
    @JsonIgnore
    private Set<Teacher> schoolTeachers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public School name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public School capacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Student> getSchoolStudents() {
        return schoolStudents;
    }

    public School schoolStudents(Set<Student> students) {
        this.schoolStudents = students;
        return this;
    }

    public School addSchoolStudent(Student student) {
        this.schoolStudents.add(student);
        student.setSchool(this);
        return this;
    }

    public School removeSchoolStudent(Student student) {
        this.schoolStudents.remove(student);
        student.setSchool(null);
        return this;
    }

    public void setSchoolStudents(Set<Student> students) {
        this.schoolStudents = students;
    }

    public Set<Teacher> getSchoolTeachers() {
        return schoolTeachers;
    }

    public School schoolTeachers(Set<Teacher> teachers) {
        this.schoolTeachers = teachers;
        return this;
    }

    public School addSchoolTeacher(Teacher teacher) {
        this.schoolTeachers.add(teacher);
        teacher.setSchool(this);
        return this;
    }

    public School removeSchoolTeacher(Teacher teacher) {
        this.schoolTeachers.remove(teacher);
        teacher.setSchool(null);
        return this;
    }

    public void setSchoolTeachers(Set<Teacher> teachers) {
        this.schoolTeachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        School school = (School) o;
        if (school.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "School{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", capacity='" + capacity + "'" +
            '}';
    }
}

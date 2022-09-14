package xyz.leeyangy.pojo;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Date birthday;
    private Integer age;
    private double score;

    public Student() {
    }

    public Student(Integer id, String name, Date birthday, Integer age, double score) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

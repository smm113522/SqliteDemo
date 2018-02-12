package com.kesun.sqlite.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/2/8 0008.
 */
@Entity
public class Student {

    @Id
    private Long id;
    @Property(nameInDb = "STUDENTNUM")
    private String studentNum;
    @Property(nameInDb = "NAME")
    private String name;

    @Keep()
    public Student(Long id, String studentNum, String name) {
        this.id = id;
        this.studentNum = studentNum;
        this.name = name;
    }

    @Keep()
    public Student(String studentNum, String name) {
        this.studentNum = studentNum;
        this.name = name;
    }

    @Keep()
    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNum='" + studentNum + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

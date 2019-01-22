package lib;

import java.util.*;

public interface Course {

    void setName(String name);

    String getName();

    void setID(String ID);

    String getID();

    void setTeacher(String teacher);

    String getTeacher();

    void setMaxNum(int maxNum);

    int getMaxNum();

    void setNowNum(int nowNum);

    int getNowNum();

    void setTime(String time);

    String getTime();

    String getLocation();
}

class offlineCourse implements Course {
    String name;
    String ID;
    String teacher;
    int maxNum;
    int nowNum;
    String location;
    String time;
    public List<Assignment> assignmentList;
    public List<Student> studentlist;

    offlineCourse(String name, String ID, String teacher, int maxNum, int nowNum, String location, String time) {
        setName(name);
        setID(ID);
        setTeacher(teacher);
        setMaxNum(maxNum);
        setNowNum(nowNum);
        setLocation(location);
        setTime(time);
        studentlist = new ArrayList<>();
    }

    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public void setID(String ID) {
        // TODO Auto-generated method stub
        this.ID = ID;
    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return this.ID;
    }

    @Override
    public void setTeacher(String teacher) {
        // TODO Auto-generated method stub
        this.teacher = teacher;
    }

    @Override
    public String getTeacher() {
        // TODO Auto-generated method stub
        return this.teacher;
    }

    @Override
    public void setMaxNum(int maxNum) {
        // TODO Auto-generated method stub
        this.maxNum = maxNum;
    }

    @Override
    public int getMaxNum() {
        // TODO Auto-generated method stub
        return this.maxNum;
    }

    @Override
    public void setNowNum(int nowNum) {
        // TODO Auto-generated method stub
        this.nowNum = nowNum;

    }

    @Override
    public int getNowNum() {
        // TODO Auto-generated method stub
        return this.nowNum;
    }

    @Override
    public void setTime(String time) {
        // TODO Auto-generated method stub
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public String getTime() {
        // TODO Auto-generated method stub
        return this.time;
    }
}

class onlineCourse implements Course {
    String name;
    String ID;
    String teacher;
    int maxNum;
    int nowNum;
    String time;
    String URL;
    List<Assignment> assignmentList;
    public List<Student> studentlist;
    // constructor
    onlineCourse(String name, String ID, String teacher, int maxNum, int nowNum, String URL, String time) {
        setName(name);
        setID(ID);
        setTeacher(teacher);
        setMaxNum(maxNum);
        setNowNum(nowNum);
        setURL(URL);
        setTime(time);
        studentlist = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public void setID(String ID) {
        // TODO Auto-generated method stub
        this.ID = ID;
    }

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return this.ID;
    }

    @Override
    public void setTeacher(String teacher) {
        // TODO Auto-generated method stub
        this.teacher = teacher;
    }

    @Override
    public String getTeacher() {
        // TODO Auto-generated method stub
        return this.teacher;
    }

    @Override
    public void setMaxNum(int maxNum) {
        // TODO Auto-generated method stub
        this.maxNum = maxNum;
    }

    @Override
    public int getMaxNum() {
        // TODO Auto-generated method stub
        return this.maxNum;
    }

    @Override
    public void setNowNum(int nowNum) {
        // TODO Auto-generated method stub
        this.nowNum = nowNum;

    }

    @Override
    public int getNowNum() {
        // TODO Auto-generated method stub
        return this.nowNum;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getLocation() {
        return this.URL;
    }

    @Override
    public void setTime(String time) {
        // TODO Auto-generated method stub
        this.time = time;
    }

    @Override
    public String getTime() {
        // TODO Auto-generated method stub
        return this.time;
    }

}


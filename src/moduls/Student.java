package moduls;

import java.sql.Date;
import java.sql.Timestamp;

public class Student {
    private int id;
    private String full_name;
    private String email;
    private String password;
    private Integer score;
    private Timestamp date;

    public Student() {
    }

    public Student(int id, String full_name, String email, String password, int score) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}

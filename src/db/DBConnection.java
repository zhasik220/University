package db;

import moduls.Admin;
import moduls.Student;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/lab_2",
                            "zhasik",
                            "bitlab123");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT s.id,s.full_name,s.email,s.password, t.score,t.date "+
                            "FROM students s "+
                            "LEFT JOIN testresults t on s.id = t.student_id ORDER BY score DESC ");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Student student=new Student();
                student.setId(result.getInt("id"));
                student.setEmail(result.getString("email"));
                student.setFull_name(result.getString("full_name"));
                student.setPassword(result.getString("password"));
                Integer score = result.getInt("score");
                student.setScore(result.wasNull() ? null : score);
                Timestamp date=result.getTimestamp("date");
                student.setDate(result.wasNull()?null:date);
                students.add(student);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static ArrayList<Admin> getAllAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM admins");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Admin admin = new Admin();
                admin.setId(result.getInt("id"));
                admin.setEmail(result.getString("email"));
                admin.setFull_name(result.getString("full_name"));
                admin.setPassword(result.getString("password"));
                admins.add(admin);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static Student getStudent(String email){
        Student student=null;
        try {
            PreparedStatement statement=connection.prepareStatement
                    ("SELECT * FROM students WHERE email=?");
            statement.setString(1,email);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setEmail(resultSet.getString("email"));
                student.setFull_name(resultSet.getString("full_name"));
                student.setPassword(resultSet.getString("password"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return student;

    }



    public static Admin getAdmin(String email){
        Admin admin=null;
        try {
            PreparedStatement statement=connection.prepareStatement
                    ("SELECT * FROM admins WHERE email=?");
            statement.setString(1,email);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                admin=new Admin();
                admin.setId(resultSet.getInt("id"));
                admin.setEmail(resultSet.getString("email"));
                admin.setFull_name(resultSet.getString("full_name"));
                admin.setPassword(resultSet.getString("password"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return admin;

    }

    public static void addTestResult(int id,int score){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO testresults (student_id, score, date) " +
                    "VALUES (?, ?, NOW())");

            statement.setLong(1,id );
            statement.setInt(2,score);
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Integer getScoreById(int id){
        Integer score=null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT score FROM testresults WHERE student_id = ?");
            statement.setLong(1,id );
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                score=resultSet.getInt("score");
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return score;
    }

    public static void addStudent(Student student){
        try {
            PreparedStatement statement= connection.prepareStatement
                    ("INSERT INTO students (full_name,email,password) " +
                            "VALUES (?,?,?)");
            statement.setString(1,student.getFull_name());
            statement.setString(2, student.getEmail());
            statement.setString(3,student.getPassword());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}

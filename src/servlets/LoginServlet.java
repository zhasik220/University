package servlets;
import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moduls.Admin;
import moduls.Student;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("password");

        if (isValidStudent(login, password)) {
            Student student= DBConnection.getStudent(login);
            request.getSession().setAttribute("userType", student);
            response.sendRedirect("/student");
        } else if (isValidAdmin(login, password)) {
            Admin admin=DBConnection.getAdmin(login);
            request.getSession().setAttribute("userType", admin);
            response.sendRedirect("/admin");
        } else {
            request.setAttribute("error", "Invalid login or password");
            response.sendRedirect("/");
        }
    }

    private boolean isValidStudent(String login, String password) {
        ArrayList<Student> students = DBConnection.getAllStudents();
        return students.stream()
                .anyMatch(student -> student.getEmail().equals(login) && student.getPassword().equals(password));
    }

    private boolean isValidAdmin(String login, String password) {
        ArrayList<Admin> admins=DBConnection.getAllAdmins();
        return admins.stream().anyMatch(admin -> admin.getEmail().equals(login) && admin.getPassword().equals(password));
    }
}

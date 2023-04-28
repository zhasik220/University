package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moduls.Admin;
import moduls.Student;

import java.io.IOException;

@WebServlet(value = "/add_student")
public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (session.getAttribute("userType") instanceof Admin){
            request.getRequestDispatcher("addStudent.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String full_name=request.getParameter("full_name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Student student=new Student();
        student.setFull_name(full_name);
        student.setEmail(email);
        student.setPassword(password);
        DBConnection.addStudent(student);
        response.sendRedirect("/admin");
    }
}

package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moduls.Student;

import java.io.IOException;

@WebServlet(value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (session.getAttribute("userType") instanceof Student){
            Student student= (Student) session.getAttribute("userType");
            session.setAttribute("score", DBConnection.getScoreById(student.getId()));
            request.getRequestDispatcher("student.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/");
        }

    }
}

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

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (session.getAttribute("userType") instanceof Admin){
            Admin admin= (Admin) session.getAttribute("userType");
            request.setAttribute("students", DBConnection.getAllStudents());
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/");
        }

    }
}

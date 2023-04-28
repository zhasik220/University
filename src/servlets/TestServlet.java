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
import java.util.ArrayList;


@WebServlet(value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (session.getAttribute("userType") instanceof Student){
            Student student= (Student) session.getAttribute("userType");
            request.getRequestDispatcher("test.jsp").forward(request,response);
        }
        else {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        if (session.getAttribute("userType") instanceof Student){

            String answer1 = request.getParameter("answer1");
            String answer2 = request.getParameter("answer2");
            String answer3 = request.getParameter("answer3");
            String answer4 = request.getParameter("answer4");
            String answer5 = request.getParameter("answer5");
            String answer6 = request.getParameter("answer6");

            ArrayList<String> userAnswers = new ArrayList<String>();
            userAnswers.add(answer1);
            userAnswers.add(answer2);
            userAnswers.add(answer3);
            userAnswers.add(answer4);
            userAnswers.add(answer5);
            userAnswers.add(answer6);

            ArrayList<String> correctAnswers=new ArrayList<>();
            correctAnswers.add("C");
            correctAnswers.add("B");
            correctAnswers.add("khan_tengri");
            correctAnswers.add("caspian_sea");
            correctAnswers.add("islam");
            correctAnswers.add("atyrau");
            Integer score=0;


            for (int i = 0; i < correctAnswers.size(); i++) {
                if (correctAnswers.get(i).equals(userAnswers.get(i))){
                    score++;
                }
            }

            Student student= (Student) session.getAttribute("userType");
            DBConnection.addTestResult(student.getId(),score);
            session.setAttribute("score",score);
            response.sendRedirect("/student");
        }
        else {
            response.sendRedirect("/");
        }
    }
}

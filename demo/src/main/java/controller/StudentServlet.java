package controller;

import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreatForm(request, response);
                break;
            case  "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showFindAll(request, response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Student student = studentService.findById(id);
    request.setAttribute("student", student);
    RequestDispatcher dispatcher = request.getRequestDispatcher("student/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFindAll(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentService.findAll();
        request.setAttribute("s", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(request, response);
                break;
            case  "edit":
                editStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String country = request.getParameter("country");
        Student student = new Student(id,name,age,country);
        studentService.edit(id, student);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String country = request.getParameter("country");
        Student student = new Student(id, name, age, country);
        studentService.save(id, student);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

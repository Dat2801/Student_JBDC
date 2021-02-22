package service;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/demo",
                        "root",
                        "admin");
            } catch (SQLException throwables) {
                System.out.println("Không có kết nối");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Không có thư viện");
        }
        System.out.println("Kết nối thành công");
        return connection;
    }

    @Override
    public List findAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from students;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                Student student = new Student(id, name, age, country);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    @Override
    public Student save(int id, Student s) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into students(id,name,age,country) values (?,?,?,? )");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, s.getName()); 
            preparedStatement.setInt(3, s.getAge());
            preparedStatement.setString(4,s.getCountry());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return s;
    }

    @Override
    public Student edit(int id, Student s) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update students set name = ?, age = ?, country = ? where id = ?;");
            preparedStatement.setInt(4, id);
            preparedStatement.setString(1, s.getName());
            preparedStatement.setInt(2, s.getAge());
            preparedStatement.setString(3, s.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return s;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                student = new Student(id, name, age, country);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from students where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}

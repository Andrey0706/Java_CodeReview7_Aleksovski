import java.lang.Class;
import java.sql.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataAccess {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/cr7_aleksovski?useTimezone=true&serverTimezone=UTC";


    public DataAccess() throws SQLException, ClassNotFoundException {

        // Load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish connection to database
        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(
                url,
                new SECRET().getUser(),
                new SECRET().getPassworrd());

        connection.setAutoCommit(true);
        connection.setReadOnly(false);

    }

    public void closeDb() throws SQLException {
        System.out.println("Closing connection...");
        connection.close();
    }

    // Get student table data
    public List<Student> getAllRowsStudent() throws SQLException {
        String sql = "SELECT * FROM students";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> list = new ArrayList<>();

        while(resultSet.next()) {
            int id = resultSet.getInt("student_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            int fk_class_id = resultSet.getInt("fk_class_id");
            list.add(new Student(id, name, surname, email, fk_class_id));
        }

        preparedStatement.close();
        return list;
    }

    public List<Classes> getAllRowClasses() throws SQLException {
        String sql = "SELECT * FROM classes";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Classes> list = new ArrayList<>();

        while(resultSet.next()) {
            int class_id = resultSet.getInt("class_id");
            String name = resultSet.getString("class_name");
            list.add(new Classes(class_id, name));
        }

        preparedStatement.close();
        return list;
    }

    public List<WhoTeachesWhat> getAllRowWhoTeachesWhat() throws SQLException {
        String sql = "SELECT * FROM teach";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<WhoTeachesWhat> list = new ArrayList<>();

        while(resultSet.next()) {
            int fk_teacher_id = resultSet.getInt("fk_teacher_id");
            int fk_class_id = resultSet.getInt("fk_class_id");
            list.add(new WhoTeachesWhat(fk_teacher_id, fk_class_id));
        }

        preparedStatement.close();
        return list;
    }

    public List<Teacher> getAllRowTeachers() throws SQLException {
        String sql = "SELECT * FROM teachers";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Teacher> list = new ArrayList<>();

        while(resultSet.next()) {
            int id = resultSet.getInt("teacher_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            list.add(new Teacher(id, name, surname, email));
        }

        preparedStatement.close();
        return list;
    }

    public List<Teach> getAllClassesByTeacher() throws SQLException {
        System.out.println("PLease enter the ID of the teacher you want to see the classes for");
        Scanner scan = new Scanner(System.in);
        int teacherId = scan.nextInt();
        String sql = "SELECT teachers.teacher_id, teachers.name, teachers.surname, classes.class_name FROM teachers\n" +
                "INNER JOIN teach\n" +
                "ON teachers.teacher_id = teach.fk_teacher_id\n" +
                "INNER JOIN classes\n" +
                "ON classes.class_id = teach.fk_class_id\n" +
                "WHERE teach.fk_teacher_id = " + teacherId;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Teach> list = new ArrayList<>();

        while(resultSet.next()) {
            int teacher_id = resultSet.getInt("teacher_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String class_name = resultSet.getString("class_name");
            list.add(new Teach(teacher_id, name, surname, class_name));
        }

        preparedStatement.close();
        return list;

    }

    public List<String> getAllTablesNames() throws SQLException {
        String sql = "SHOW TABLES";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> list = new ArrayList<>();

        while(resultSet.next()) {
            String tableName = resultSet.getString("Tables_in_cr7_aleksovski");
            list.add(tableName);
        }

        preparedStatement.close();
        return list;
    }



    public Connection getConnection() {
        return connection;
    }
}

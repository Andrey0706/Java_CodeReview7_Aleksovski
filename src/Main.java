import javax.xml.transform.Result;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static DataAccess dataAccess;

    public static void main(String[] args) {
        init();
        try {

            boolean toContinue = true;
            String menu = " 1. Print all students\n 2. Print all Teachers\n 3. Print all classes\n 4. Print all classes per specific teacher\n 5. Create Report File\n 0. EXIT";
            while (toContinue) {
                System.out.println("PLease select action");
                System.out.println(menu);
                Scanner scan = new Scanner(System.in);
                int userChoice = scan.nextInt();

                switch (userChoice) {
                    case 1:
                        displayRowsStudents(dataAccess.getAllRowsStudent());
                        break;
                    case 2:
                        displayAllRowTeachers(dataAccess.getAllRowTeachers());
                        break;
                    case 3:
                        getAllRowClasses(dataAccess.getAllRowClasses());
                        break;
                    case 4:
                        displayClasseByTeachersId(dataAccess.getAllClassesByTeacher());
                        break;
                    case 5:
                        createReportFile();
                        break;
                    case 0:
                        toContinue = false;
                        break;
                    default:
                        System.out.println("Unknown command");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    static public void init() {
        try {
            dataAccess = new DataAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void stop() {
        try {
            dataAccess.closeDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void displayRowsStudents(List<Student> list) {

        String tableName = "";
        try {// This is just to read the database (table) meta data!
            Statement stmt = dataAccess.getConnection().createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            tableName = resultSetMetaData.getTableName(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n#####PARSING DATA FROM " + tableName + " TABLE#####\n");
        System.out.println("ID| Name| Surname| Email                   |class_id \n_________________________________________________________\n");
        for (Student item : list) {
            System.out.println(item + "\n");
        }
    }

    static public void displayAllRowTeachers(List<Teacher> list) {
        String tableName = "";
        try {// This is just to read the database (table) meta data!
            Statement stmt = dataAccess.getConnection().createStatement();
            String query = "SELECT * FROM teachers";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            tableName = resultSetMetaData.getTableName(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n#####PARSING DATA FROM " + tableName + " TABLE#####\n");
        System.out.println("ID| Name| Surname| Email \n____________________________________\n");
        for (Teacher item : list) {
            System.out.println(item + "\n");
        }
    }

    static public void getAllRowClasses(List<Classes> list) {
        String tableName = "";
        try {// This is just to read the database (table) meta data!
            Statement stmt = dataAccess.getConnection().createStatement();
            String query = "SELECT * FROM classes";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            tableName = resultSetMetaData.getTableName(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n#####PARSING DATA FROM " + tableName + " TABLE#####\n");
        System.out.println(" ID  | Name \n");
        for (Classes item : list) {
            System.out.println(item + "\n");
        }
    }

    static public void displayClasseByTeachersId(List<Teach> list) {
        String tableName = "";
        try {// This is just to read the database (table) meta data!
            Statement stmt = dataAccess.getConnection().createStatement();
            String query = "SELECT * FROM teach";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            tableName = resultSetMetaData.getTableName(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n#####PARSING DATA FROM " + tableName + " TABLE#####\n");
        if (!list.isEmpty()) {
            System.out.println("ID " + list.get(0).getTeacher_id() + ": Teacher \"" + list.get(0).getName() + " " + list.get(0).getSurname() + "\" teaches:");
        } else {
            System.out.println("Sorry no classes found by that ID");
        }
        for (Teach item : list) {
            System.out.println(item.getClass_name());
        }
    }

    public static void createReportFile() throws SQLException {
        System.out.println("*** CREATING REPORT FILE ***");
        System.out.println("Please enter the name of the table you want to create report file for\n Available tables");
        List<String> tableNamesList = dataAccess.getAllTablesNames();
        for (String tableName : tableNamesList) {
            System.out.println(tableName);
        }

        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();
        if (!tableNamesList.contains(tableName)) {
            System.out.println("You cannot generate report for an inexistent table");
        } else {
            String filename = "ReportTable_" + tableName + ".txt";
            try {

                switch (tableName) {
                    case "classes":
                        createFileClasses(filename);
                        break;
                    case "students":
                        createFileStudents(filename);
                        break;
                    case "teachers":
                        createFileTeachers(filename);
                        break;
                    case "teach":
                        createFileTeach(filename);
                        break;

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public static void createFileStudents(String filename) throws IOException, SQLException {
        File file1 = new File(filename);
        file1.createNewFile();
        FileWriter writer = new FileWriter(filename);
        writer.write("ID| Name| Surname| Email                   |class_id \n_________________________________________________________\n");
        List<Student> classes = dataAccess.getAllRowsStudent();
        for (Student i : classes) {
            writer.write(i.toString());
            writer.write("\n");
        }
        System.out.println("Successfully created report file: " + filename);
        writer.close();
    }

    public static void createFileClasses(String filename) throws IOException, SQLException {
        File file1 = new File(filename);
        file1.createNewFile();
        FileWriter writer = new FileWriter(filename);
        writer.write("ID | Name \n");
        List<Classes> classes = dataAccess.getAllRowClasses();
        for (Classes i : classes) {
            writer.write(i.toString());
            writer.write("\n");
        }
        System.out.println("Successfully created report file: " + filename);
        writer.close();
    }

    public static void createFileTeachers(String filename) throws IOException, SQLException {
        File file1 = new File(filename);
        file1.createNewFile();
        FileWriter writer = new FileWriter(filename);
        writer.write("ID| Name| Surname| Email \n____________________________________\n");
        List<Teacher> classes = dataAccess.getAllRowTeachers();
        for (Teacher i : classes) {
            writer.write(i.toString());
            writer.write("\n");
        }
        System.out.println("Successfully created report file: " + filename);
        writer.close();
    }

    public static void createFileTeach(String filename) throws IOException, SQLException {
        File file1 = new File(filename);
        file1.createNewFile();
        FileWriter writer = new FileWriter(filename);
        writer.write("Teacher_ID | Class_ID \n");
        List<WhoTeachesWhat> classes = dataAccess.getAllRowWhoTeachesWhat();
        for (WhoTeachesWhat i : classes) {
            writer.write(i.toString());
            writer.write("\n");
        }
        System.out.println("Successfully created report file: " + filename);
        writer.close();
    }


}
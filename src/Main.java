import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello world!");

        Class.forName("org.postgresql.Driver");

        Database db = new Database();
        StudentService sr = new StudentService(db);
        try {
            List<Student> list = sr.getAllStudents();
            for(Student st: list)
            {
                System.out.printf("ID: %d, Name : %s, Mobile : %s \n" ,st.getId(),st.getName() ,st.getMobile() );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
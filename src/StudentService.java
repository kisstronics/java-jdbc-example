import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    Database db;
    public StudentService(Database db){
        this.db = db;
    }
    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        ResultSet rs = db.executeQuery(sql);
        try {
            while(rs.next()){
                String name  = rs.getString("name");
                String mobile = rs.getString("mobile");
                Integer id = rs.getInt("id");
                students.add(new Student(id,name,mobile));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Classes {
    DataAccess dataAccess;
    private int class_id;
    private String name;

    public Classes(int class_id, String name) {
        this.class_id = class_id;
        this.name = name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return  class_id +
                " | " + name;
    }
}

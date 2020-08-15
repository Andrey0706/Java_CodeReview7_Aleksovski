public class Teach {

    private int teacher_id;
    private String name;
    private String surname;
    private String class_name;


    public Teach(int teacher_id, String name, String surname, String class_name) {
        this.teacher_id = teacher_id;
        this.name = name;
        this.surname = surname;
        this.class_name = class_name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Teach{" +
                "teacher_id=" + teacher_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}

public class Student {
    private int student_id;
    private String name;
    private String surname;
    private String email;
    private int fk_class_id;

    public Student(int student_id, String name, String surname, String email, int fk_class_id) {
        this.student_id = student_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.fk_class_id = fk_class_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFk_class_id() {
        return fk_class_id;
    }

    public void setFk_class_id(int fk_class_id) {
        this.fk_class_id = fk_class_id;
    }

    @Override
    public String toString() {
        return  student_id + " |" + name + '|' +  surname + '\'' + " | " + email + '\'' + " | " + fk_class_id;
    }
}

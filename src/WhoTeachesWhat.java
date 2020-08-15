public class WhoTeachesWhat {
    private int teacher_id;
    private int fk_class_id;

    public WhoTeachesWhat(int teacher_id, int class_name) {
        this.teacher_id = teacher_id;
        this.fk_class_id = class_name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getClass_name() {
        return fk_class_id;
    }

    public void setClass_name(int class_name) {
        this.fk_class_id = class_name;
    }

    @Override
    public String toString() {
        return "        " + teacher_id +
                "  |   " + fk_class_id;
    }
}

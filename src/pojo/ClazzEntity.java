package pojo;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
public class ClazzEntity {
    private int classId;
    private String classname;
    private int total;
    private int boy;
    private int girl;
    private Set<StudentEntity> students = new HashSet<StudentEntity>(0);

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public int getGirl() {
        return girl;
    }

    public void setGirl(int girl) {
        this.girl = girl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return classId == that.classId && total == that.total && boy == that.boy && girl == that.girl && Objects.equals(classname, that.classname) && Objects.equals(students,that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, classname, total, boy, girl);
    }
}

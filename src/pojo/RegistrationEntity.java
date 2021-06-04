package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class RegistrationEntity {
    private int registrationId;
    private Timestamp time;
    private StudentEntity student;
    private CourseEntity course;

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }


    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationEntity that = (RegistrationEntity) o;
        return registrationId == that.registrationId && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId, time);
    }
}

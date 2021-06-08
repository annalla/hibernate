package pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CourseEntity {
    private int courseId;
    private String coursename;
    private String teacher;
    private int day;
    private int period;
    private int maximum;
    private String room;
    private SubjectEntity subject;
    private SemesterEntity semester;
    private Set<RegistrationEntity> registered = new HashSet<RegistrationEntity>(0);

    public Set<RegistrationEntity> getRegistered() {
        return registered;
    }

    public void setRegistered(Set<RegistrationEntity> registered) {
        this.registered = registered;
    }

    public SemesterEntity getSemester() {
        return semester;
    }

    public void setSemester(SemesterEntity semester) {
        this.semester = semester;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return courseId == that.courseId && day == that.day && period == that.period && maximum == that.maximum && Objects.equals(coursename, that.coursename) && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, coursename, teacher, day, period, maximum);
    }
}

package pojo;

import java.sql.Date;
import java.util.Objects;

public class SemesterEntity {
    private int semesterId;
    private String term;
    private int year;
    private Date startsemester;
    private Date endsemester;

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartsemester() {
        return startsemester;
    }

    public void setStartsemester(Date startsemester) {
        this.startsemester = startsemester;
    }

    public Date getEndsemester() {
        return endsemester;
    }

    public void setEndsemester(Date endsemester) {
        this.endsemester = endsemester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterEntity that = (SemesterEntity) o;
        return semesterId == that.semesterId && year == that.year && Objects.equals(term, that.term) && Objects.equals(startsemester, that.startsemester) && Objects.equals(endsemester, that.endsemester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterId, term, year, startsemester, endsemester);
    }
}

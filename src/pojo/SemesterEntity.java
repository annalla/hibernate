package pojo;

import java.sql.Date;
import java.util.Objects;

public class SemesterEntity {
    private int semesterId;
    private String term;
    private String year;
    private Date startsemester;
    private Date endsemester;
    public boolean ispresent;

    public boolean getIspresent(){
        return ispresent;
    }

    public void setIspresent(boolean ispresent) {
        this.ispresent = ispresent;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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
        return semesterId == that.semesterId && Objects.equals(year, that.year) && Objects.equals(term, that.term) && Objects.equals(startsemester, that.startsemester) && Objects.equals(endsemester, that.endsemester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterId, term, year, startsemester, endsemester);
    }
}

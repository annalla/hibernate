package pojo;

import java.util.Objects;

public class SubjectEntity {
    private int subId;
    private String subjectId;
    private String subjectname;
    private int credit;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return subId == that.subId && credit == that.credit && Objects.equals(subjectId, that.subjectId) && Objects.equals(subjectname, that.subjectname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subId, subjectId, subjectname, credit);
    }
}

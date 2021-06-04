package pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class RegistrationsessionEntity {
    private int registId;
    private Timestamp startdate;
    private Timestamp enddate;


    public int getRegistId() {
        return registId;
    }

    public void setRegistId(int registId) {
        this.registId = registId;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationsessionEntity that = (RegistrationsessionEntity) o;
        return registId == that.registId && Objects.equals(startdate, that.startdate) && Objects.equals(enddate, that.enddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registId, startdate, enddate);
    }
}

package pojo;

import java.sql.Date;
import java.util.Objects;

public class StudentEntity {
    private int studentId;
    private String username;
    private String password;
    private String mssv;
    private String fullname;
    private Date birthday;
    private String address;
    private int gender;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return studentId == that.studentId && gender == that.gender && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(mssv, that.mssv) && Objects.equals(fullname, that.fullname) && Objects.equals(birthday, that.birthday) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, username, password, mssv, fullname, birthday, address, gender);
    }
}

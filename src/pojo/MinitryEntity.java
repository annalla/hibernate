package pojo;

import java.sql.Date;
import java.util.Objects;

public class MinitryEntity {
    private int minitryId;
    private String username;
    private String password;
    private String fullname;
    private Date birthday;
    private String address;
    private int gender;

    public int getMinitryId() {
        return minitryId;
    }

    public void setMinitryId(int minitryId) {
        this.minitryId = minitryId;
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
        MinitryEntity that = (MinitryEntity) o;
        return minitryId == that.minitryId && gender == that.gender && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(fullname, that.fullname) && Objects.equals(birthday, that.birthday) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minitryId, username, password, fullname, birthday, address, gender);
    }
}

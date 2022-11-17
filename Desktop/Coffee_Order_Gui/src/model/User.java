package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class User {

    private String username, password, fullName, address, phoneNumber;
    private LocalDate dateOfBirth;
    
    public User() {
    }

    public User(String username, String password, String fullName, String dateOfBirth, String address, String phoneNumber) throws DateTimeParseException {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Date getDateSql() throws ParseException{
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    

}

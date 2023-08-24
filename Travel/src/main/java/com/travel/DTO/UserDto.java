package com.travel.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.DTO.BookingDto;

import java.util.List;

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String Gender;
    @JsonIgnore
    private List<BookingDto> bookings;

    public List<BookingDto> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDto> bookings) {
        this.bookings = bookings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }


}

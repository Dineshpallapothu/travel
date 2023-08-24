package com.travel.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.Entitties.User;

public class BookingDto {
    private String From;
    private String To;
    private String Status;
    private String Stateoftravel;
    private int user_id;

    @JsonIgnore
    private UserDto us;
    // private String bookingName;

//    //public String getBookingName() {
//        return bookingName;
//    }

//    public void setBookingName(String bookingName) {
//        this.bookingName = bookingName;
//    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStateoftravel() {
        return Stateoftravel;
    }

    public void setStateoftravel(String stateoftravel) {
        Stateoftravel = stateoftravel;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public UserDto getUs() {
        return us;
    }

    public void setUs(UserDto us) {
        this.us = us;
    }


}

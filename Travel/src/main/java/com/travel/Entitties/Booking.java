package com.travel.Entitties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @Column(name = "Booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name = "From_adr")
    private String From;

    @Column(name = "To_adr")
    private String To;

    @Column(name = "Starts_date")
    private LocalDate Startdate;

    @Column(name = "Booking_Status")
    private String Status;

    @Column(name = "State_of_travel")
    private String Stateoftravel;

    @Column(name = "User_id")
    private int user_id;

//    @Column(name = "Booking_name")
//    private String bookingName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id", insertable = false, updatable = false)
    @JsonIgnore
    private User us;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
//
//    //public String getBookingName() {
//        return bookingName;
//    }

//    public void setBookingName(String bookingName) {
//        this.bookingName = bookingName;
//    }

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }


    @JsonIgnore
    public User getUsers() {
        return us;
    }

    @JsonIgnore
    public void setUsers(User users) {
        this.us = users;
    }

    public int getId() {
        return bookingId;
    }

    public void setId(int id) {
        this.bookingId = id;
    }

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

    public LocalDate getStartdate() {
        return Startdate;
    }

    public void setStartdate(LocalDate startdate) {
        Startdate = startdate;
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

    public int getUserid() {
        return user_id;
    }

    public void setUserid(int userid) {
        user_id = userid;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + bookingId +
                ", From='" + From + '\'' +
                ", To='" + To + '\'' +
                ", Startdate='" + Startdate + '\'' +
                ", Status='" + Status + '\'' +
                ", Stateoftravel='" + Stateoftravel + '\'' +
                ", Userid=" + user_id +
                '}';
    }
}
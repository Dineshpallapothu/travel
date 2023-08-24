package com.travel.service;

import com.travel.DTO.BookingDto;
import com.travel.Entitties.Booking;
import com.travel.Entitties.User;
import com.travel.exception.NoBookingFound;
import com.travel.exception.NoBookingFoundException;
import com.travel.exception.NoUsersFoundException;
import com.travel.exception.ObjectNoVAlidException;
import com.travel.repo.BokkingrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    BokkingrRepo bokkingrRepo;


    public List<BookingDto> getall(){
        List<Booking>  bookings=bokkingrRepo.findAllBookings();
        if(bookings.isEmpty()){
            throw new NoUsersFoundException();
        }else {
            return bookings.stream().map(this::convert).collect(Collectors.toList());
        }
    }

    public BookingDto getbooking(int id){
        Booking booking=bokkingrRepo.findbooking(id);
        if(booking==null){
            throw new NoBookingFoundException(id);
        }
        else{
            return convert(booking);
        }
    }
    public List<BookingDto> getuserbooking(int id){
        List<Booking> bookings=bokkingrRepo.getuserBookings(id);
        if(bookings.isEmpty()){
            throw new NoUsersFoundException();
        }else {
            return bookings.stream().map(this::convert).collect(Collectors.toList());
        }
    }
    public BookingDto createbooking(BookingDto bookingDto){
        if(bookingDto==null){
            throw new ObjectNoVAlidException();
        }
        else{
            Booking booking=new Booking();
            booking.setStartdate(LocalDate.now());
//            booking.setBookingName(bookingDto.getBookingName());
            booking.setFrom(bookingDto.getFrom());
            booking.setTo(bookingDto.getTo());
            booking.setStateoftravel(bookingDto.getStateoftravel());
            booking.setStatus(bookingDto.getStatus());
            booking.setUser_id(bookingDto.getUser_id());
            bokkingrRepo.save(booking);
            return convert(booking);
        }
    }
    public BookingDto update(int id, BookingDto bookingDto){

            if(bookingDto==null){
                throw new ObjectNoVAlidException();
            }
            else{
                Booking booking=bokkingrRepo.findbooking(id);
                if(booking==null){
                    throw new NoBookingFoundException(id);
                }
                else{
//                    booking.setBookingName(bookingDto.getBookingName());
                    booking.setFrom(bookingDto.getFrom());
                    bokkingrRepo.save(booking);
                    return convert(booking);
                }

            }

    }
    public BookingDto removebooking(int id){
        Booking booking =bokkingrRepo.findbooking(id);
        if(booking==null){
            throw new NoBookingFoundException(id);
        }
        else {
            bokkingrRepo.delete(booking);
            return convert(booking);
        }
    }
    public BookingDto findetsils(int id){
        Booking bu=bokkingrRepo.findetils(id);
        if (bu == null) {
            throw new ObjectNoVAlidException();
        }
        else
        {
            return convert(bu);
        }

    }
    public BookingDto findetsilsflight(int id){
        Booking bu=bokkingrRepo.findetilsflight(id);
        if (bu == null) {
            throw new ObjectNoVAlidException();
        }
        else
        {
            return convert(bu);
        }

    }
    public BookingDto findetsilstrain(int id){
        Booking bu=bokkingrRepo.findetilstrain(id);
        if (bu == null) {
            throw new ObjectNoVAlidException();
        }
        else
        {
            return convert(bu);
        }

    }

    public BookingDto convert(Booking booking){
        BookingDto bookingDto=new BookingDto();
//        bookingDto.setBookingName(booking.getBookingName());
        bookingDto.setFrom(booking.getFrom());
        bookingDto.setStateoftravel(booking.getStateoftravel());
        bookingDto.setTo(booking.getTo());
        bookingDto.setUser_id(booking.getUser_id());
        bookingDto.setStatus(booking.getStatus());
        return bookingDto;
    }

}

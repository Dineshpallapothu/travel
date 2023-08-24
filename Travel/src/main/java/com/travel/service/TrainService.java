package com.travel.service;

import com.travel.DTO.BusDto;
import com.travel.DTO.TrainDto;
import com.travel.Entitties.Bus;
import com.travel.Entitties.Train;
import com.travel.exception.NoBusException;
import com.travel.exception.NoBusFoundEXception;
import com.travel.exception.ObjectNoVAlidException;
import com.travel.repo.BusRepo;
import com.travel.repo.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainService {
    @Autowired
    TrainRepo trainRepo;


    public List<TrainDto> getll(){
        List<Train> buses =trainRepo.findalltrain();
        if(buses.isEmpty()){
            throw new NoBusException();
        }
        else {
            return buses.stream().map(this::ccnvert).collect(Collectors.toList());
        }
    }
    public TrainDto getbybookings(int id){
        Train train =trainRepo.findbypnrId(id);
        if(train==null){
            throw new NoBusFoundEXception(id);
        }
        else{
            return ccnvert(train);
        }
    }
    public TrainDto createtrain(TrainDto trainDto){
        int seats=trainDto.getBookingSeatNo();
        int available=trainDto.getBookingSeatNo();
        if(trainDto==null||(seats<0&&seats>50)||(available>50&&available<0)){
            throw  new ObjectNoVAlidException();
        }
        else {
            Train train=new Train();
            train.setTrainNo(trainDto.getTrainNo());
            train.setBookingId(trainDto.getBookingId());
            train.setSeatsAvailability(trainDto.getSeatsAvailability());
            train.setBookingSeatNo(trainDto.getBookingSeatNo());
            trainRepo.save(train);
            return ccnvert(train);
        }
    }
    public TrainDto updatetrain(int id,TrainDto trainDto){
        int seats=trainDto.getBookingSeatNo();
        int available=trainDto.getSeatsAvailability();
        if(trainDto==null||(seats<0&&seats>50)||(available>50&&available<0)){
            throw  new ObjectNoVAlidException();
        }
        else {
            Train train=trainRepo.findbypnrId(id);
            if(train==null){
                throw  new NoBusFoundEXception(id);
            }
            else {
                train.setBookingSeatNo(trainDto.getBookingSeatNo());
                trainRepo.save(train);
                return ccnvert(train);
            }

        }
    }
    public TrainDto removetrain(int id){
        Train train =trainRepo.findbypnrId(id);
        if(train==null){
            throw new NoBusException();
        }
        else {
            trainRepo.delete(train);
            return ccnvert(train);
        }
    }

    public TrainDto ccnvert(Train  train){
        TrainDto trainDto=new TrainDto();
        trainDto.setTrainNo(train.getTrainNo());
        trainDto.setBookingSeatNo(train.getBookingSeatNo());
        trainDto.setBookingId(train.getBookingId());
        trainDto.setSeatsAvailability(train.getSeatsAvailability());
        return trainDto;
    }
}

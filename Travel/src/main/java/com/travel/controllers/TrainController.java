package com.travel.controllers;

import com.travel.DTO.BusDto;
import com.travel.DTO.TrainDto;
import com.travel.service.BusService;
import com.travel.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/train")
public class TrainController {
    @Autowired
    TrainService trainService;

    @GetMapping("/all")
    public List<TrainDto> getalltrain() {
        return trainService.getll();
    }

    @GetMapping("/bus/booking")
    public TrainDto gettrainBooking(@RequestParam("id") int id) {
        return trainService.getbybookings(id);
    }

    @PostMapping("/create")
    public TrainDto creattrain(@RequestBody TrainDto trainDto) {
        return trainService.createtrain(trainDto);
    }

    @PutMapping("/update")
    public TrainDto update(@RequestParam("id") int id, @RequestBody TrainDto trainDto) {
        return trainService.updatetrain(id, trainDto);
    }

    @DeleteMapping("/remove")
    public TrainDto remove(@RequestParam("id") int id) {
        return trainService.removetrain(id);
    }
}

package com.emanuel.vet.sistema.controller;

import com.emanuel.vet.sistema.domains.schedule.Schedule;
import com.emanuel.vet.sistema.dtos.ScheduleDTO;
import com.emanuel.vet.sistema.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/newschedule")
    public ResponseEntity<Schedule> createSchedule(@RequestBody @Valid ScheduleDTO schedule) throws Exception {

        Schedule newSchedule = this.scheduleService.createSchedule(schedule);

        return new ResponseEntity<>(newSchedule, HttpStatus.CREATED);
    }

    @GetMapping("/allschedules")
    public ResponseEntity<Schedule> getAllSchedules(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<Schedule> allSchedules = this.scheduleService.findAllSchedules(pageable);

        return new ResponseEntity(allSchedules, HttpStatus.OK);
    }

    @GetMapping("/findschedule/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable(value = "id")Long id) throws Exception {

        Optional<Schedule> schedulesById = Optional.ofNullable(this.scheduleService.findById(id));

        return new ResponseEntity(schedulesById, HttpStatus.OK);
    }
}

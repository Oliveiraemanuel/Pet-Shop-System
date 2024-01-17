package com.emanuel.vet.sistema.service;

import com.emanuel.vet.sistema.domains.pet.Pet;
import com.emanuel.vet.sistema.domains.schedule.Schedule;
import com.emanuel.vet.sistema.domains.vet.Vet;
import com.emanuel.vet.sistema.dtos.ScheduleDTO;
import com.emanuel.vet.sistema.producer.ScheduleProducer;
import com.emanuel.vet.sistema.repositories.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PetService petService;

    @Autowired
    private VetService vetService;

    @Autowired
    private ScheduleProducer scheduleProducer;

    @Transactional
    public void saveSchedule(Schedule schedule){
        this.scheduleRepository.save(schedule);
    }

    @Transactional
    public void deleteSchedule(Schedule schedule){
        this.scheduleRepository.delete(schedule);
    }

    public Schedule createSchedule(ScheduleDTO schedule) throws Exception {

        Pet pet = petService.findById(schedule.petId()).orElseThrow(() -> new Exception("Pet não encontrado"));
        Vet vet = vetService.findById(schedule.vetId()).orElseThrow(() -> new Exception("Vet não encontrado"));

        var newSchedule = new Schedule();
        newSchedule.setPet(pet);
        newSchedule.setVet(vet);
        newSchedule.setAgendamento(schedule.agendamento());

        saveSchedule(newSchedule);

        scheduleProducer.publishMessageEmail(newSchedule);

        return newSchedule;
    }

    public Page<Schedule> findAllSchedules(Pageable pageable){
        return this.scheduleRepository.findAll(pageable);
    }

    public Schedule findById(Long id) throws Exception {
        return this.scheduleRepository.findById(id).orElseThrow(() -> new Exception("Id não encontrado"));
    }
}

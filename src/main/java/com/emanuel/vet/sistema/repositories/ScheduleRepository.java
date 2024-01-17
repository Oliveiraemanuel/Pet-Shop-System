package com.emanuel.vet.sistema.repositories;

import com.emanuel.vet.sistema.domains.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

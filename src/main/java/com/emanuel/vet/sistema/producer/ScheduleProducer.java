package com.emanuel.vet.sistema.producer;

import com.emanuel.vet.sistema.domains.schedule.Schedule;
import com.emanuel.vet.sistema.dtos.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScheduleProducer {
    final RabbitTemplate rabbitTemplate;

    public ScheduleProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(Schedule schedule){

        var emailDTO = new EmailDTO();

        emailDTO.setTo(schedule.getPet().getOwner().getEmail());
        emailDTO.setSubject(schedule.getPet().getOwner().getFirstName() + ", o " + schedule.getPet().getName() + " tem uma consulta");
        emailDTO.setText("Sua consulta será no dia e hora: " + schedule.getAgendamento() + "com o vet " +schedule.getVet().getFirstName() + "!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}

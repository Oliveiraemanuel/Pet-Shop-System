package com.emanuel.vet.sistema.producer;

import com.emanuel.vet.sistema.domains.vet.Vet;
import com.emanuel.vet.sistema.dtos.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PetProducer {

    final RabbitTemplate rabbitTemplate;

    public PetProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(Vet vet){

        var emailDTO = new EmailDTO();

        emailDTO.setTo(vet.getEmail());
        emailDTO.setSubject("Seja Bem Vindo, " + vet.getFirstName() + "!");
        emailDTO.setText("Você é muito valioso para nós");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}

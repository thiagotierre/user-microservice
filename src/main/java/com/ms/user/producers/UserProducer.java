package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}") //exchange do tipo default: chave routing key é o mesmo nome da fila
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {

    var emailDto = new EmailDto(
            userModel.getUserId(),
            userModel.getEmail(),
            "Cadastro realizado com sucesso!",
            userModel.getName().concat(", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!"));

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}

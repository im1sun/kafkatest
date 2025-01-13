package emuce.kafka.json;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "testTopic", groupId = "groupId", containerFactory = "kafkaListener")
    public void consume(Chatmessage message){
        System.out.println("name = " + message.getSender());
        System.out.println("consume message = " + message.getContext());
        System.out.println("message = " + message);
    }

}

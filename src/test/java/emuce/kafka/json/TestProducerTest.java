package emuce.kafka.json;

import emuce.kafka.hello.TestProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestProducerTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    void test() {
        Chatmessage chatmessage = new Chatmessage("emuce", "I love you");
        kafkaProducerService.sendMessage(chatmessage);
    }


}

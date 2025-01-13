package emuce.kafka.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestProducerTest {

    @Autowired
    private TestProducer testProducer;

    @Test
    void test() {
        testProducer.create();
    }


}

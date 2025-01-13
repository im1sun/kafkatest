package emuce.kafka.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaAdminController {

    private final KafkaAdminService kafkaAdminService;

    public KafkaAdminController(KafkaAdminService kafkaAdminService) {
        this.kafkaAdminService = kafkaAdminService;
    }

    @PostMapping("/topics")
    public String createTopic(@RequestParam String topicName, @RequestParam int partitions, @RequestParam short replicationFactor) {
        kafkaAdminService.createTopic(topicName, partitions, replicationFactor);
        return "Topic created: " + topicName;
    }

    @DeleteMapping("/topics/{topicName}")
    public String deleteTopic(@PathVariable String topicName) {
        kafkaAdminService.deleteTopic(topicName);
        return "Topic deleted: " + topicName;
    }

    @GetMapping("/topics")
    public String listTopics() {
        kafkaAdminService.listTopics();
        return "Check logs for the list of topics";
    }

    @GetMapping("/topics/{topicName}")
    public String describeTopic(@PathVariable String topicName) {
        kafkaAdminService.describeTopic(topicName);
        return "Check logs for topic description: " + topicName;
    }
}

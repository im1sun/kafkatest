package emuce.kafka.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaAdminService {

    private final AdminClient adminClient;



    public KafkaAdminService(@Value("${spring.kafka.bootstrap-servers}") String bootstrapServers) {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        this.adminClient = AdminClient.create(config);
    }

    // 1. 토픽 생성
    public void createTopic(String topicName, int partitions, short replicationFactor) {
        NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
        try {
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic created successfully: " + topicName);
        } catch (Exception e) {
            System.err.println("Failed to create topic: " + e.getMessage());
        }
    }

    // 2. 토픽 삭제
    public void deleteTopic(String topicName) {
        try {
            adminClient.deleteTopics(Collections.singletonList(topicName)).all().get();
            System.out.println("Topic deleted successfully: " + topicName);
        } catch (Exception e) {
            System.err.println("Failed to delete topic: " + e.getMessage());
        }
    }

    // 3. 모든 토픽 조회
    public void listTopics() {
        try {
            Set<String> topics = adminClient.listTopics().names().get();
            System.out.println("Topics: " + topics);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Failed to list topics: " + e.getMessage());
        }
    }

    // 4. 특정 토픽 정보 조회
    public void describeTopic(String topicName) {
        try {
            Map<String, TopicDescription> descriptions = adminClient.describeTopics(Collections.singletonList(topicName)).all().get();
            descriptions.forEach((name, description) -> System.out.println("Description for " + name + ": " + description));
        } catch (Exception e) {
            System.err.println("Failed to describe topic: " + e.getMessage());
        }
    }

    // 자원 정리
    public void closeAdminClient() {
        adminClient.close();
    }
}

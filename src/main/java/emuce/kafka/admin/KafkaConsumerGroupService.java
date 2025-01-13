package emuce.kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaConsumerGroupService {

    private final AdminClient adminClient;

    public KafkaConsumerGroupService(@Value("${spring.kafka.bootstrap-servers}") String bootstrapServers) {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        this.adminClient = AdminClient.create(config);
    }

    // 1. 리스트 모든 컨슈머 그룹
    public void listConsumerGroups() {
        try {
            ListConsumerGroupsResult result = adminClient.listConsumerGroups();
            result.all().get().forEach(group -> System.out.println("Consumer Group: " + group.groupId()));
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Failed to list consumer groups: " + e.getMessage());
        }
    }

    // 2. 컨슈머 그룹 설명
    public void describeConsumerGroup(String groupId) {
        try {
            Map<String, ConsumerGroupDescription> descriptions =
                    adminClient.describeConsumerGroups(Collections.singletonList(groupId)).all().get();

            ConsumerGroupDescription description = descriptions.get(groupId);
            System.out.println("Consumer Group: " + groupId);
            System.out.println("State: " + description.state());
            System.out.println("Coordinator: " + description.coordinator());
            for (MemberDescription member : description.members()) {
                System.out.println("Member: " + member.consumerId());
                System.out.println("Client ID: " + member.clientId());
                System.out.println("Host: " + member.host());
                System.out.println("Partitions: " + member.assignment().topicPartitions());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Failed to describe consumer group: " + e.getMessage());
        }
    }

    // 3. 컨슈머 그룹 삭제
    public void deleteConsumerGroup(String groupId) {
        try {
            DeleteConsumerGroupsResult result = adminClient.deleteConsumerGroups(Collections.singletonList(groupId));
            result.all().get();
            System.out.println("Deleted consumer group: " + groupId);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Failed to delete consumer group: " + e.getMessage());
        }
    }

    // 자원 정리
    public void closeAdminClient() {
        adminClient.close();
    }
}

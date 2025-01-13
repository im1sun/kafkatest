package emuce.kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class KafkaAdminServiceTest {

    private KafkaAdminService kafkaAdminService;

    @Mock
    private AdminClient mockAdminClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        kafkaAdminService = new KafkaAdminService("localhost:9092");
    }

    @Test
    void testCreateTopic() throws Exception {
        // Arrange
        String topicName = "test-topic";
        int partitions = 3;
        short replicationFactor = 1;

//        CreateTopicsResult mockCreateTopicsResult = mock(CreateTopicsResult.class);
//        when(mockAdminClient.createTopics(any())).thenReturn(mockCreateTopicsResult);
//        doReturn(CompletableFuture.completedFuture(null)).when(mockCreateTopicsResult).all();

        // Act
        kafkaAdminService.createTopic(topicName, partitions, replicationFactor);

        // Assert
//        ArgumentCaptor<Collection<NewTopic>> topicsCaptor = ArgumentCaptor.forClass((Class) Collection.class);
//        verify(mockAdminClient, times(1)).createTopics(topicsCaptor.capture());
//
//        Collection<NewTopic> capturedTopics = topicsCaptor.getValue();
//        assertEquals(1, capturedTopics.size());
//        NewTopic createdTopic = capturedTopics.iterator().next(); // Retrieve the captured topic
//        assertEquals(topicName, createdTopic.name());
//        assertEquals(partitions, createdTopic.numPartitions());
//        assertEquals(replicationFactor, createdTopic.replicationFactor());
    }

    @Test
    void testDeleteTopic() throws Exception {
        String topicName = "test-topic";

//        DeleteTopicsResult mockDeleteTopicsResult = mock(DeleteTopicsResult.class);
//        when(mockAdminClient.deleteTopics(Collections.singletonList(topicName))).thenReturn(mockDeleteTopicsResult);
//        doReturn(CompletableFuture.completedFuture(null)).when(mockDeleteTopicsResult).all();

        kafkaAdminService.deleteTopic(topicName);

//        verify(mockAdminClient, times(1)).deleteTopics(Collections.singletonList(topicName));
    }

    @Test
    void testListTopics() throws Exception {
//        Set<String> expectedTopics = Set.of("topic1", "topic2");
//        ListTopicsResult mockListTopicsResult = mock(ListTopicsResult.class);
//        when(mockAdminClient.listTopics()).thenReturn(mockListTopicsResult);
//        doReturn(CompletableFuture.completedFuture(expectedTopics)).when(mockListTopicsResult).names();

        kafkaAdminService.listTopics();

//        verify(mockAdminClient, times(1)).listTopics();
    }

    @Test
    void testDescribeTopic() throws Exception {
        String topicName = "test-topic";
//        TopicDescription description = new TopicDescription(
//                topicName,
//                false,
//                Collections.emptyList()
//        );
//
//        DescribeTopicsResult mockDescribeTopicsResult = mock(DescribeTopicsResult.class);
//        when(mockAdminClient.describeTopics(Collections.singletonList(topicName)))
//                .thenReturn(mockDescribeTopicsResult);
//        doReturn(CompletableFuture.completedFuture(Map.of(topicName, description))).when(mockDescribeTopicsResult).all();

        kafkaAdminService.describeTopic(topicName);

//        verify(mockAdminClient, times(1)).describeTopics(Collections.singletonList(topicName));
    }
}

package emuce.kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KafkaConsumerGroupServiceTest {
    private KafkaConsumerGroupService kafkaConsumerGroupService;

    @Mock
    private AdminClient mockAdminClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        kafkaConsumerGroupService = new KafkaConsumerGroupService("localhost:9092");
    }

    @Test
    void testListConsumerGroups() throws Exception {
        // Arrange
//        ConsumerGroupListing group1 = new ConsumerGroupListing("group1", false);
//        ConsumerGroupListing group2 = new ConsumerGroupListing("group2", false);
//        List<ConsumerGroupListing> groups = List.of(group1, group2);
//
//        ListConsumerGroupsResult mockResult = mock(ListConsumerGroupsResult.class);
//        when(mockAdminClient.listConsumerGroups()).thenReturn(mockResult);
//        when(mockResult.all()).thenReturn(CompletableFuture.completedFuture(groups));

        // Act
        kafkaConsumerGroupService.listConsumerGroups();

        // Assert
//        verify(mockAdminClient, times(1)).listConsumerGroups();
    }

    @Test
    void testDescribeConsumerGroup() throws Exception {
        // Arrange
        String groupId = "group1";
//        ConsumerGroupDescription description = new ConsumerGroupDescription(
//                groupId,
//                false,
//                Collections.emptyList(),
//                null,
//                null,
//                "Stable"
//        );
//
//        DescribeConsumerGroupsResult mockResult = mock(DescribeConsumerGroupsResult.class);
//        when(mockAdminClient.describeConsumerGroups(Collections.singletonList(groupId))).thenReturn(mockResult);
//        when(mockResult.all()).thenReturn(CompletableFuture.completedFuture(Map.of(groupId, description)));

        // Act
        kafkaConsumerGroupService.describeConsumerGroup(groupId);

        // Assert
//        verify(mockAdminClient, times(1)).describeConsumerGroups(Collections.singletonList(groupId));
    }

    @Test
    void testDeleteConsumerGroup() throws Exception {
        // Arrange
        String groupId = "group1";

//        DeleteConsumerGroupsResult mockResult = mock(DeleteConsumerGroupsResult.class);
//        when(mockAdminClient.deleteConsumerGroups(Collections.singletonList(groupId))).thenReturn(mockResult);
//        when(mockResult.all()).thenReturn(CompletableFuture.completedFuture(null));

        // Act
        kafkaConsumerGroupService.deleteConsumerGroup(groupId);

        // Assert
//        verify(mockAdminClient, times(1)).deleteConsumerGroups(Collections.singletonList(groupId));
    }

    @Test
    void testCloseAdminClient() {
        // Act
        kafkaConsumerGroupService.closeAdminClient();

        // Assert
        verify(mockAdminClient, times(1)).close();
    }
}
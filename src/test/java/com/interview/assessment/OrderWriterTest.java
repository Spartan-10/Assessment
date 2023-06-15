package com.interview.assessment;

import com.interview.assessment.entity.Order;
import com.interview.assessment.repository.OrderRepository;
import com.interview.assessment.service.OrderWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.batch.item.Chunk;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderWriterTest {

    @Mock
    private OrderRepository orderRepositoryMock;

    @InjectMocks
    private OrderWriter orderWriter;

    @Test
    public void testWrite() throws Exception {
        Order order1 = new Order(1, "example@example.com", "1234567890", "US", "10.0");
        Order order2 = new Order(2, "test@test.com", "9876543210", "IN", "5.0");

        Chunk<Order> chunk = new Chunk<>();
        chunk.add(order1);
        chunk.add(order2);

        orderWriter.write(chunk);

        verify(orderRepositoryMock, times(1)).saveAll(chunk);
    }
}

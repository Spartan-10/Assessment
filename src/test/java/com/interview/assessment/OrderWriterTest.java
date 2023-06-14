package com.interview.assessment;

import com.interview.assessment.entity.Order;
import com.interview.assessment.repository.OrderRepository;
import com.interview.assessment.service.OrderWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.item.Chunk;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@SpringBootTest
@TestPropertySource(properties = "spring.batch.job.enabled=false")
public class OrderWriterTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderWriter orderWriter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        orderWriter = new OrderWriter(orderRepository);
    }

    @Test
    public void testWrite() throws Exception {
        List<Order> orders = createSampleOrders();

        Chunk<Order> chunk = new Chunk<>(orders);

        orderWriter.write(chunk);

        verify(orderRepository, times(1)).saveAll(chunk);
    }

    private List<Order> createSampleOrders() {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order();
        order1.setId(1);
        order1.setEmail("email1@email.com");
        order1.setPhone_number("(237) 123456789");
        order1.setParcelWeight("10.5");
        orders.add(order1);

        Order order2 = new Order();
        order2.setId(2);
        order2.setEmail("email2@email.com");
        order2.setPhone_number("251 987654321");
        order2.setParcelWeight("8.2");
        orders.add(order2);

        return orders;
    }
}

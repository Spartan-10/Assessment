package com.interview.assessment;

import com.interview.assessment.entity.Order;
import com.interview.assessment.service.OrderReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.batch.item.file.FlatFileItemReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderReaderTest {

    @Mock
    private FlatFileItemReader<Order> readerMock;

    @InjectMocks
    private OrderReader orderReader;

    @Test
    public void testRead() throws Exception {
        Order order1 = new Order(1, "example@example.com", "1234567890", "US", "10.0");
        Order order2 = new Order(2, "test@test.com", "9876543210", "IN", "5.0");

        // Configure readerMock behavior
        when(readerMock.read()).thenReturn(order1, order2, null);

        Order result1 = orderReader.read();
        Order result2 = orderReader.read();
        Order result3 = orderReader.read();

        // Verify the interactions with readerMock
        verify(readerMock, times(3)).read();

        // Verify the expected results
        assertEquals(order1, result1);
        assertEquals(order2, result2);
        assertNull(result3);
    }
}

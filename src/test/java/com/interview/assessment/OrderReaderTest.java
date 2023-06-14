package com.interview.assessment;

import com.interview.assessment.entity.Order;
import com.interview.assessment.service.OrderReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig
@SpringBootTest
@TestPropertySource(properties = "spring.batch.job.enabled=false")
public class OrderReaderTest {

    private OrderReader orderReader;

    @BeforeEach
    public void setup() {
        orderReader = new OrderReader();
    }

    @Test
    public void testRead() throws Exception {
        // Read the first item
        Order item1 = orderReader.read();
        assertNotNull(item1);
        assertEquals(1, item1.getId());
        assertEquals("email1@email.com", item1.getEmail());
        assertEquals("237 209993809", item1.getPhone_number());
        assertEquals("24.45", item1.getParcelWeight());

        // Read the second item
        Order item2 = orderReader.read();
        assertNotNull(item2);
        assertEquals(2, item2.getId());
        assertEquals("email2@email.com", item2.getEmail());
        assertEquals("258 852828436", item2.getPhone_number());
        assertEquals("1.33", item2.getParcelWeight());

        // Read the third item
        Order item3 = orderReader.read();
        assertNotNull(item3);
        assertEquals(3, item3.getId());
        assertEquals("email3@email.com", item3.getEmail());
        assertEquals("256 217813782", item3.getPhone_number());
        assertEquals("15.16", item3.getParcelWeight());

    }
}

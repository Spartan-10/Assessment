package com.interview.assessment;

import com.interview.assessment.entity.Order;
import com.interview.assessment.service.OrderProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderProcessorTest {

        private OrderProcessor orderProcessor = new OrderProcessor();

        @Test
        public void testProcess_withCameroonNumber() throws Exception {
            Order order = new Order();
            order.setPhone_number("237 673401144");

            Order processedOrder = orderProcessor.process(order);

            assertEquals("Cameroon", processedOrder.getCountry());
        }

        @Test
        public void testProcess_withEthiopiaNumber() throws Exception {
            Order order = new Order();
            order.setPhone_number("251 987654321");

            Order processedOrder = orderProcessor.process(order);

            assertEquals("Ethiopia", processedOrder.getCountry());
        }

        @Test
        public void testProcess_withMoroccoNumber() throws Exception {
            Order order = new Order();
            order.setPhone_number("212 555555555");

            Order processedOrder = orderProcessor.process(order);

            assertEquals("Morocco", processedOrder.getCountry());
        }

        @Test
        public void testProcess_withMozambiqueNumber() throws Exception {
            Order order = new Order();
            order.setPhone_number("258 876543210");

            Order processedOrder = orderProcessor.process(order);

            assertEquals("Mozambique", processedOrder.getCountry());
        }

        @Test
        public void testProcess_withUgandaNumber() throws Exception {
            Order order = new Order();
            order.setPhone_number("256 123456789");

            Order processedOrder = orderProcessor.process(order);

            assertEquals("Uganda", processedOrder.getCountry());
        }

        @Test
        public void testProcess_withUnknownNumber() throws Exception {
            Order order = new Order();
            order.setPhone_number("123 4567890");

            Order processedOrder = orderProcessor.process(order);

            assertEquals("Unknown", processedOrder.getCountry());
        }

}

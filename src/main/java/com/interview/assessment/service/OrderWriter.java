package com.interview.assessment.service;

import com.interview.assessment.entity.Order;
import com.interview.assessment.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderWriter implements ItemWriter<Order> {

    private OrderRepository orderRepository;

    @Override
    public void write(Chunk<? extends Order> order) throws Exception {
        orderRepository.saveAll(order);
    }
}

package com.interview.assessment.service;

import com.interview.assessment.entity.Order;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class OrderProcessor implements ItemProcessor<Order, Order> {

    @Override
    public Order process(Order order) throws Exception {
        String phoneNumber = order.getPhone_number();

        // Regular expressions for country matching
        String cameroonRegex = "237 ?[2368]\\d{7,8}$";
        String ethiopiaRegex = "251 ?[1-59]\\d{8}$";
        String moroccoRegex = "212 ?[5-9]\\d{8}$";
        String mozambiqueRegex = "258 ?[28]\\d{7,8}$";
        String ugandaRegex = "256 ?\\d{9}$";

        String country;
        if (Pattern.matches(cameroonRegex, phoneNumber)) {
            country = "Cameroon";
        } else if (Pattern.matches(ethiopiaRegex, phoneNumber)) {
            country = "Ethiopia";
        } else if (Pattern.matches(moroccoRegex, phoneNumber)) {
            country = "Morocco";
        } else if (Pattern.matches(mozambiqueRegex, phoneNumber)) {
            country = "Mozambique";
        } else if (Pattern.matches(ugandaRegex, phoneNumber)) {
            country = "Uganda";
        } else {
            // Handle cases where the phone number does not match any country
            country = "Unknown";
        }

        order.setCountry(country);

        return order;
    }
}

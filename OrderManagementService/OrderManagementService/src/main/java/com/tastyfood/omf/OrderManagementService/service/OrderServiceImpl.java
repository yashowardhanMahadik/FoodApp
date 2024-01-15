package com.tastyfood.omf.OrderManagementService.service;

import com.tastyfood.omf.OrderManagementService.model.FoodItem;
import com.tastyfood.omf.OrderManagementService.model.OrderDetail;
import com.tastyfood.omf.OrderManagementService.repository.OrderRepository;
import com.tastyfood.omf.OrderManagementService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class OrderServiceImpl implements OrderService{

    private RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    OrderServiceImpl(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository=restaurantRepository;
    }

    @Override
    public OrderDetail getOrder(Long orderId, Long userId) {
        try {

            return orderRepository.findByOrderIdAndUserId(orderId, userId);
        } catch (Exception e) {
            // print error msg
        }
        return null;

    }
    @Override
    public OrderDetail getOrder(Long orderId) {
        try {
            return orderRepository.findByOrderId(orderId);
        } catch (Exception e) {
            // print error msg
        }
        return null;

    }

    @Override
    public void addOrder(OrderDetail orderDetail) {
        String[] foodItems = orderDetail.getFoodItems().trim().split(",");
        Arrays.stream(foodItems).forEach(foodItem -> {

                    FoodItem item = foodItemService.getFoodItemByID(Long.parseLong(foodItem));
                    item.setSupply(item.getSupply() - 1);
                    foodItemService.saveItem(item);
                }
        );

        orderRepository.save(orderDetail);
    }

    @Override
    public Boolean updateOrder(OrderDetail orderDetail, String paymentMode) {

        double amount = 0;
        if (orderDetail.getFoodItems().trim().length() > 1) {
            amount = Arrays.stream(orderDetail.getFoodItems().trim().split(",")).map(item ->
                    foodItemService.getFoodItemByID(Long.parseLong(item))).mapToDouble(foodItem -> foodItem.getPrice()).sum();
        }
        orderDetail.setAmountToBePaid(amount);
        orderRepository.save(orderDetail);

        return true;
    }

    @Override
    public boolean cancelOrder(Long orderId) {
        try {
            orderRepository.deleteById(orderId);
            return true;
        } catch (Exception e) {
            // print message
        }
        return false;
    }
    @Override
    public boolean sendNotification(long orderId) {
        // fetch order details
        // use notification service by email or push notifications
        return true;
    }
}

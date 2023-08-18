package com.diyo.nrms.service;

import com.diyo.nrms.entity.Orders;
import com.diyo.nrms.exception.NotFoundException;
import com.diyo.nrms.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void addOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    public void addOrdersList(List<Orders> orders) {
        ordersRepository.saveAll(orders);
    }

    public List<Orders> findOrdersByOrOrderDishName(String ordersname) {
        return ordersRepository.findOrdersByOrOrderDishName(ordersname);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrdersById(Long ordersId) throws NotFoundException {
        Optional<Orders> ordersOptional = ordersRepository.findById(ordersId);
        if (ordersOptional.isPresent()) {
            return ordersOptional.get();
        } else {

            throw new NotFoundException("No record found!" + ordersId);
        }
    }

    public String updateOrdersPutMethod(Orders orders) {
        Optional<Orders> customerOptional = ordersRepository.findById(orders.getOrderId());
        if (customerOptional.isPresent()) {
            ordersRepository.save(orders);
            return ("Order data has been updated!");
        } else {
            return ("No order data found!");
        }
    }

    public String updateOrdersPatchMethod(Orders orders) {
        Optional<Orders> customerOptional = ordersRepository.findById(orders.getOrderId());
        if (customerOptional.isPresent()) {
            Orders existingCustomerData = customerOptional.get();
            if (orders.getOrderDishName() != null) {
                existingCustomerData.setOrderDishName(orders.getOrderDishName());
            }
            if (orders.getOrderDishPrice() != null) {
                existingCustomerData.setOrderDishPrice(orders.getOrderDishPrice());
            }
            if (orders.getOrderQuantityOfDish() != null) {
                existingCustomerData.setOrderQuantityOfDish(orders.getOrderQuantityOfDish());
            }
            if (orders.getOrderReady() != null) {
                existingCustomerData.setOrderReady(orders.getOrderReady());
            }
            if (orders.getOrderDelivered() != null) {
                existingCustomerData.setOrderDelivered(orders.getOrderDelivered());
            }
            ordersRepository.save(existingCustomerData);
            return "Order data patched!";
        } else {
            return "The order you are trying to update does not exist in our record!";
        }
    }

    public String deleteOrdersById(Long orderId) {
        ordersRepository.deleteById(orderId);
        return "Customer record deleted";
    }
}

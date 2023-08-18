
package com.diyo.nrms.controller;

import com.diyo.nrms.entity.Orders;
import com.diyo.nrms.exception.NotFoundException;
import com.diyo.nrms.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @PostMapping("/addorders")
    public ResponseEntity<String> addOrder(@RequestBody Orders orders){
        ordersService.addOrders(orders);
        return ResponseEntity.ok("Order placed!");
    }
    @PostMapping("/addorderlist")
    public ResponseEntity<String> addOrdersList(@RequestBody List<Orders> orders){
        ordersService.addOrdersList(orders);
        return ResponseEntity.ok("Customer list added!");
    }

    @GetMapping("/searchorderbyname/{ordersname}")
        public List<Orders> findOrdersByOrOrderDishName(@PathVariable("ordersname")String ordersname) {
        return ordersService.findOrdersByOrOrderDishName(ordersname);
        }
        @GetMapping("/dataout")
        public ResponseEntity<List<Orders>> getAllOrders(){
            return ResponseEntity.ok(ordersService.getAllOrders());
        }

        @PutMapping//put by Id
        public  ResponseEntity<String>updateOrdersPutMethod(@RequestBody Orders orders){
            return ResponseEntity.ok(ordersService.updateOrdersPutMethod(orders));
        }

        @PatchMapping
        public ResponseEntity<String> updateOrdersPatchMethod(@RequestBody Orders orders){
            return ResponseEntity.ok(ordersService.updateOrdersPatchMethod(orders));
        }

        @DeleteMapping("/{ordersId}")
        public ResponseEntity<String> deleteOrdersById(@PathVariable("ordersId") Long ordersId){
            return ResponseEntity.ok(ordersService.deleteOrdersById(ordersId));
        }

        @GetMapping("/{ordersId}")
        public ResponseEntity<Orders> getOrdersById(@PathVariable("ordersId")Long ordersId)throws NotFoundException
        {
            return ResponseEntity.ok(ordersService.getOrdersById(ordersId));
        }
}


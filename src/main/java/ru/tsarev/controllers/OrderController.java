package ru.tsarev.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsarev.entities.*;
import ru.tsarev.security.CustomUserDetails;
import ru.tsarev.services.OfferService;
import ru.tsarev.services.OrderService;
import ru.tsarev.services.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OfferService bookService;
    @Autowired
    private UserService userService;

    public OrderController(OrderService orderService, OfferService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }
    private NumberOfItems numberOfItems = new NumberOfItems(1);


    @PostMapping("/shoppingCartPost")
    public String getNumberOfItems(@ModelAttribute NumberOfItems numberOfItems) {
        this.numberOfItems = numberOfItems;
        return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart")
    public String getShoppingCart(Model model) {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        order.setOrderItems(orderItems);
        for (int i = 0; i < numberOfItems.getNumber(); i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(new Offer());
            order.addOrderItem(orderItem);
        }
        model.addAttribute("numberOfItems", numberOfItems);
        model.addAttribute("order", order);
        return "shoppingCart";
    }

    @PostMapping("/add-order")
    public String addNewOrder(@ModelAttribute Order order, @ModelAttribute OrderItem orderItems,
                              @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        order.setOrderDate(currentDate.format(formatter));
        order.setUser(customUserDetails.getUser());
        order.setState("оформлен");
        for (OrderItem orderItem : order.getOrderItems()) {
            orderService.saveOrderItem(orderItem);
        }
        orderService.saveOrder(order);
        return "redirect:account";
    }

    @GetMapping("/")
    public String getStart() {
        return "redirect:catalog";
    }

    @GetMapping("/catalog")
    public String getCatalog(Model model) {
        model.addAttribute("numberOfItems", numberOfItems);
        model.addAttribute("bookList", bookService.findAll());
        return "catalog";
    }

    @GetMapping("/account")
    public String getAccount(Model model , @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        Long id = customUserDetails.getUser().getId();
        model.addAttribute("numberOfItems", numberOfItems);
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("orders", orderService.getOrdersByUserId(id));
        return "account";
    }
}

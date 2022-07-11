package shop.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dto.response.OrderResponseDto;
import shop.model.ShoppingCart;
import shop.model.User;
import shop.service.OrderService;
import shop.service.ShoppingCartService;
import shop.service.UserService;
import shop.service.mapper.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(UserService userService,
                           OrderService orderService,
                           OrderMapper orderMapper,
                           ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrderResponseDto> getHistory(Authentication authentication) {
        User user = userService.findUserByEmail(authentication.getName()).orElseThrow(
                () -> new RuntimeException("User with email "
                        + authentication.getName() + " not found"));
        return orderService.findAllByUser(user).stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication auth) {
        User user = userService.findUserByEmail(auth.getName()).orElseThrow(
                () -> new RuntimeException("User with email " + auth.getName() + " not found"));
        ShoppingCart shoppingCart = shoppingCartService.findByUser(user);
        return orderMapper.toDto(orderService.completeOrder(shoppingCart));
    }
}

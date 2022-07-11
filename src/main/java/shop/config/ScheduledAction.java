package shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import shop.service.ShoppingCartService;

@Configuration
@EnableScheduling
public class ScheduledAction {
    private static final Long LIFE_PERIOD = 60 * 10 * 1000L;
    private final ShoppingCartService shoppingCartService;

    public ScheduledAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void checkShoppingCart() {
        shoppingCartService.findAllByTimeIsLessThen(System.currentTimeMillis() - LIFE_PERIOD)
                .forEach(e -> {
                    System.out.println(e.getUser());
                    shoppingCartService.clear(e);
                });
    }
}

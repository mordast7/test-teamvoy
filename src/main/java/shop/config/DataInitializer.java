package shop.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import shop.model.Goods;
import shop.model.Order;
import shop.model.Product;
import shop.model.Role;
import shop.model.User;
import shop.service.GoodsService;
import shop.service.ProductService;
import shop.service.RoleService;
import shop.service.UserService;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final ProductService productService;
    private final GoodsService goodsService;

    public DataInitializer(UserService userService,
                           RoleService roleService,
                           ProductService productService,
                           GoodsService goodsService) {
        this.userService = userService;
        this.roleService = roleService;
        this.productService = productService;
        this.goodsService = goodsService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.save(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.save(userRole);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("zxcqwe");
        admin.setRole(adminRole);
        userService.save(admin);

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("qwezxc");
        user.setRole(userRole);
        userService.save(user);

        Product iphone = new Product();
        iphone.setName("iPhone");
        iphone.setPrice(BigDecimal.valueOf(999));
        productService.save(iphone);

        Goods goods = new Goods();
        goods.setQuantity(22L);
        goods.setProduct(iphone);
        goodsService.save(goods);
    }
}

package shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Long quantity;
    @ColumnDefault("false")
    private boolean existAtShoppingCart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public boolean isExistAtShoppingCart() {
        return existAtShoppingCart;
    }

    public void setExistAtShoppingCart(boolean existAtShoppingCart) {
        this.existAtShoppingCart = existAtShoppingCart;
    }

    @Override
    public String toString() {
        return "Goods{"
                + "id=" + id
                + ", product=" + product
                + ", quantity=" + quantity
                + ", existAtShoppingCart=" + existAtShoppingCart
                + '}';
    }
}

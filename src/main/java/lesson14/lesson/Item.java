package lesson14.lesson;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "item")
public class Item {

    public Item(Integer total){
        this.total = total;
    }

    public Item(Integer total, Set<Cart> carts){
        this.total = total;
        this.carts = carts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "total")
    @NotNull
    private Integer total;

    @ManyToMany
    @JoinTable(name = "cart_item",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"))
    private Set<Cart> carts;
}

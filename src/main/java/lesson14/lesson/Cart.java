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
@Table(name = "cart")
public class Cart {

    public Cart(Integer total, String name){
        this.total = total;
        this.name = name;
    }

    public Cart(Integer total, String name, Set<Item> items){
        this.total = total;
        this.name = name;
        this.items = items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "total")
    @NotNull
    private Integer total;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(name = "cart_item",
        joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Set<Item> items;
}

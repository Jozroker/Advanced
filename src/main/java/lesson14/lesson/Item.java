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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "total")
    @NotNull
    private Integer total;

    @ManyToMany
    @JoinColumn(name = "cart_id")
    private Set<Cart> carts;
}

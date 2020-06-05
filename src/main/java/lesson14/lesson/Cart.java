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
    @JoinColumn(name = "item_id")
    private Set<Item> items;
}

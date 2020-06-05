package lesson14.lesson;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class CartRepository {

    private final SessionFactory sf;

    public void save(Cart cart) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (cart.getItems() != null) {
                ItemRepository ir = new ItemRepository(sf);
                cart.getItems().forEach(ir::save);
            }
            session.save(cart);
            transaction.commit();
        }
    }
}

package lesson14.lesson;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class ItemRepository {

    private final SessionFactory sf;

    public void save(Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (item.getCarts() != null) {
                CartRepository cr = new CartRepository(sf);
                item.getCarts().forEach(cr::save);
            }
            session.save(item);
            transaction.commit();
        }
    }
}

package lesson15.lesson;

import lesson15.lesson.entity.Post;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class PostRepository {

    private final SessionFactory sf;

    public Optional<Post> findById(Long id) {
        Optional<Post> postOptional = Optional.empty();
        try {
            TypedQuery<Post> query = sf.openSession().createQuery("from Post " +
                    "where id = ?1", Post.class);
            query.setParameter(1, id);
            postOptional = Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {}
        return postOptional;
    }

}

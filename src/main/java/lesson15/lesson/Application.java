package lesson15.lesson;

import lesson15.lesson.entity.Comment;
import lesson15.lesson.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.getTransaction();

        Comment comment1 = new Comment();
        comment1.setAuthorName("Author1");
        Comment comment2 = new Comment();
        comment2.setAuthorName("Author2");

        Post post = new Post();
        post.setTitle("New Post With Comments");
        Post postWithoutComments = new Post();
        postWithoutComments.setTitle("Post Without Comments");

        post.addComment(comment1);
        post.addComment(comment2);

        session.save(post);
        session.save(postWithoutComments);

        PostRepository pr = new PostRepository(sf);

        Optional<Post> result1 = pr.findById(10L);
        Optional<Post> result2 = pr.findById(postWithoutComments.getId());
        Optional<Post> result3 = pr.findById(post.getId());

        List<Optional> posts = new ArrayList<>(Arrays.asList(result1, result2,
                result3));

        posts.forEach(opt -> {
            if (opt.isPresent()) {
                System.out.println(opt.get());
            }
        });

    }
}

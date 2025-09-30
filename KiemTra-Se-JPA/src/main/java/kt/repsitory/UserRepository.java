package kt.repsitory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import kt.entity.User;

public class UserRepository extends BaseRepository {

  public User findByUsername(String username) {
    return tx(em -> {
      try {
        return em.createQuery("select u from User u left join fetch u.role left join fetch u.seller where u.username=:u", User.class)
            .setParameter("u", username)
            .getSingleResult();
      } catch (NoResultException e) {
        return null;
      }
    });
  }

  public User save(User u) {
    return tx(em -> {
      if (u.getUserId() == null) {
        em.persist(u);
        return u;
      } else {
        return em.merge(u);
      }
    });
  }
}
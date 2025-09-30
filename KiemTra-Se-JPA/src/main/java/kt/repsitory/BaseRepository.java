package kt.repsitory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kt.config.JPAUtil;

import java.util.function.Function;

public class BaseRepository {
  protected <T> T tx(Function<EntityManager, T> work) {
    EntityManager em = JPAUtil.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      T res = work.apply(em);
      tx.commit();
      return res;
    } catch (RuntimeException e) {
      if (tx.isActive()) tx.rollback();
      throw e;
    } finally {
      em.close();
    }
  }
}
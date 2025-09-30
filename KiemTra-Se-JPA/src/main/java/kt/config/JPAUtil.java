package kt.config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
  private static EntityManagerFactory emf;

  public static synchronized void init() {
    if (emf == null) {
      emf = Persistence.createEntityManagerFactory("PU");
    }
  }

  public static EntityManager getEntityManager() {
    if (emf == null) init();
    return emf.createEntityManager();
  }

  public static void close() {
    if (emf != null && emf.isOpen()) emf.close();
  }
}
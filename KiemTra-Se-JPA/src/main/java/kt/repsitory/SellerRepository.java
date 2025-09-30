package kt.repsitory;

import jakarta.persistence.NoResultException;
import kt.entity.Seller;

import java.util.List;

public class SellerRepository extends BaseRepository {
  public List<Seller> findAllWithProducts() {
    return tx(em -> em.createQuery(
        "select distinct s from Seller s left join fetch s.products p left join fetch p.category order by s.sellerId", Seller.class)
      .getResultList());
  }

  public Seller findById(Integer id) {
    return tx(em -> {
      try {
        return em.createQuery("select s from Seller s where s.sellerId=:id", Seller.class)
            .setParameter("id", id)
            .getSingleResult();
      } catch (NoResultException e) {
        return null;
      }
    });
  }
}
package kt.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Seller")
public class Seller {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sellerId")
  private Integer sellerId;

  @Column(name = "sellername", length = 50, nullable = false)
  private String sellerName;

  @Column(name = "images", length = 500)
  private String images;

  @Column(name = "status")
  private Integer status;

  @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
  private List<Product> products;

  // getters/setters
  public Integer getSellerId() { return sellerId; }
  public void setSellerId(Integer sellerId) { this.sellerId = sellerId; }
  public String getSellerName() { return sellerName; }
  public void setSellerName(String sellerName) { this.sellerName = sellerName; }
  public String getImages() { return images; }
  public void setImages(String images) { this.images = images; }
  public Integer getStatus() { return status; }
  public void setStatus(Integer status) { this.status = status; }
  public List<Product> getProducts() { return products; }
  public void setProducts(List<Product> products) { this.products = products; }
}
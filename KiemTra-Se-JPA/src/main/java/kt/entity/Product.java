package kt.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "productId")
  private Integer productId;

  @Column(name = "productName", length = 200)
  private String productName;

  @Column(name = "productCode")
  private Long productCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoryId")
  private Category category;

  @Column(name = "description", length = 500)
  private String description;

  @Column(name = "price")
  private Float price;

  @Column(name = "amount")
  private Integer amount;

  @Column(name = "stock")
  private Integer stock;

  @Column(name = "images", length = 500)
  private String images;

  @Column(name = "wishlist")
  private Integer wishlist;

  @Column(name = "status")
  private Integer status;

  @Column(name = "createDate")
  private LocalDate createDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sellerId")
  private Seller seller;

  // getters/setters
  public Integer getProductId() { return productId; }
  public void setProductId(Integer productId) { this.productId = productId; }
  public String getProductName() { return productName; }
  public void setProductName(String productName) { this.productName = productName; }
  public Long getProductCode() { return productCode; }
  public void setProductCode(Long productCode) { this.productCode = productCode; }
  public Category getCategory() { return category; }
  public void setCategory(Category category) { this.category = category; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public Float getPrice() { return price; }
  public void setPrice(Float price) { this.price = price; }
  public Integer getAmount() { return amount; }
  public void setAmount(Integer amount) { this.amount = amount; }
  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }
  public String getImages() { return images; }
  public void setImages(String images) { this.images = images; }
  public Integer getWishlist() { return wishlist; }
  public void setWishlist(Integer wishlist) { this.wishlist = wishlist; }
  public Integer getStatus() { return status; }
  public void setStatus(Integer status) { this.status = status; }
  public LocalDate getCreateDate() { return createDate; }
  public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }
  public Seller getSeller() { return seller; }
  public void setSeller(Seller seller) { this.seller = seller; }
}
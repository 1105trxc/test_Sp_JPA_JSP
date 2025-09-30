package kt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "categoryId")
  private Integer categoryId;

  @Column(name = "categoryName", length = 200)
  private String categoryName;

  @Column(name = "images", length = 500)
  private String images;

  @Column(name = "status")
  private Integer status;

  // getters/setters
  public Integer getCategoryId() { return categoryId; }
  public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
  public String getCategoryName() { return categoryName; }
  public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
  public String getImages() { return images; }
  public void setImages(String images) { this.images = images; }
  public Integer getStatus() { return status; }
  public void setStatus(Integer status) { this.status = status; }
}

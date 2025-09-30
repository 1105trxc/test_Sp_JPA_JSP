package kt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRole {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "roleId")
  private Integer roleId;

  @Column(name = "roleName", length = 50, nullable = false)
  private String roleName;

  // getters/setters
  public Integer getRoleId() { return roleId; }
  public void setRoleId(Integer roleId) { this.roleId = roleId; }
  public String getRoleName() { return roleName; }
  public void setRoleName(String roleName) { this.roleName = roleName; }
}
package se452.group4.project.security.userRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se452.group4.project.security.enums.UserRoleType;

@Data
@Entity
@NoArgsConstructor
@Builder
@Table(name = "user_roles")
public class UserRole { 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private UserRoleType name;

  UserRole(Integer id, UserRoleType name) {
    this.id = id;
    this.name = name;
  }
}

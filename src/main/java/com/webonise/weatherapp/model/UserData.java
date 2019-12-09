package com.webonise.weatherapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserData extends AuditModel {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator = "user_generator")
  @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
  private Long id;

  private String username;
  private String uniqueId;

  public String getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "UserData [id=" + id + ", username=" + username + ", uniqueId=" + uniqueId + "]";
  }
}

package com.webonise.weatherapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {

  @Id
  @GeneratedValue(generator = "city_generator")
  @SequenceGenerator(name = "city_generator", sequenceName = "city_sequence")
  private long id;
  private String cityname;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "userdata_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private UserData userData;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCityname() {
    return cityname;
  }

  public void setCityname(String cityname) {
    this.cityname = cityname;
  }

  public UserData getUserData() {
    return userData;
  }

  public void setUserData(UserData userData) {
    this.userData = userData;
  }

  @Override
  public String toString() {
    return "City [id=" + id + ", cityname=" + cityname + ", userData=" + userData + "]";
  }
}

package ch.nblotti.achilleus.security;

import java.util.List;

public class Credentials {

  private String email;
  private List<String> roles;

  public Credentials() {
  }

  public Credentials(String email, List<String> roles) {
    this.email = email;
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }
}

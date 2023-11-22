package com.example.demo.DTO;

import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.model.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
  @NotBlank(message = "the  name must not be empty")
  private String name;

  @NotBlank(message = "the email must not be empty")
  @Email(message = "this email is invalid")
  private String email;
  @NotBlank(message = "password is required")
  @Size(min = 6, max = 16, message = "the length of the password is invalid")
  private String password;

  public User toUser() {
    User user = new User();
    user.setEmail(email);
    user.setName(name);
    user.setPassword(password);
    // user.setRole(Role.ROLE_ADMIN);
    return user;
  }

  public Customer toCustomer() {
    Customer user = new Customer();
    user.setEmail(email);
    user.setName(name);
    user.setPassword(password);
    user.setRole(Role.ROLE_CUSTOMER);
    return user;
  }
}

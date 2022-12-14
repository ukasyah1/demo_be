package com.example.demo_be.vo;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class User {
   @NonNull
   @NotBlank
   private String username;
   @NonNull
   @NotBlank
   private String password;

}

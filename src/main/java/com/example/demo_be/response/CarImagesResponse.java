package com.example.demo_be.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarImagesResponse {

   private String carImages;
   private Date createdDt;
   private String changedBy;
   private Date changedDt;
   private Boolean deletedFlag;
}

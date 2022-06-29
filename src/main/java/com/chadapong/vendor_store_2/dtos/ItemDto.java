package com.chadapong.vendor_store_2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

  private  @NonNull String name;
  private  @NonNull String description;
  private  int  amount;
  
} 
package com.chadapong.vendor_store_2.helpers;

import lombok.Data;

@Data
public class ServiceResponseModel <T> {
  private T payload;
  private String message;
}

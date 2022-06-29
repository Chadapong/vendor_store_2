package com.chadapong.vendor_store_2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.chadapong.exceptions.ApplicationException;
import com.chadapong.models.Item;
import com.chadapong.vendor_store_2.dtos.ItemDto;
import com.chadapong.vendor_store_2.helpers.ServiceResponseModel;
import com.chadapong.vendor_store_2.services.ItemManagement;

@RestController
public class VendorStoreController {
  @Autowired
  ItemManagement itemManagementDao;

  @PostMapping("/vendor-store")
  public ResponseEntity<?> createItem(@RequestBody ItemDto model) throws ApplicationException {
    ServiceResponseModel<Item> returnItem = itemManagementDao.createItem(model);
    if (returnItem.getPayload() != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(returnItem);
    }
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, returnItem.getMessage());
  }

  @DeleteMapping("/vendor-store/{name}")
  public ResponseEntity<?> deleteItem(@PathVariable String name) throws ApplicationException{
    ServiceResponseModel<ItemDto> returnItem = itemManagementDao.deleteItem(name);
    if (returnItem.getPayload() != null) {
      return ResponseEntity.status(HttpStatus.OK).body(returnItem);
    }
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, returnItem.getMessage());
  }

  @PutMapping("/vendor-store")
  public ResponseEntity<?> editItem(@RequestBody ItemDto model) {
    ServiceResponseModel<ItemDto> returnItem = itemManagementDao.editItem(model);
    if (returnItem.getPayload() != null) {
      return ResponseEntity.status(HttpStatus.OK).body(returnItem);
    }
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, returnItem.getMessage());
  }

  @GetMapping("/vendor-store/{name}")
  public ResponseEntity<?> getItemByName(@PathVariable String name) throws Exception  {

    ServiceResponseModel<ItemDto> returnItem = itemManagementDao.getItemByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(returnItem);

  }

  @GetMapping("/vendor-store")
  public ResponseEntity<?> getAllITem() {
    ServiceResponseModel<List<ItemDto>> returnItem = itemManagementDao.getAllItem();
    if (returnItem.getPayload() != null) {
      return ResponseEntity.status(HttpStatus.OK).body(returnItem);
    }
    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, returnItem.getMessage());
  }

}

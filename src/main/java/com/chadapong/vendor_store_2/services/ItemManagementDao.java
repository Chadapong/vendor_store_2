package com.chadapong.vendor_store_2.services;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chadapong.vendor_store_2.helpers.*;
import com.chadapong.vendor_store_2.mappers.ItemMapper;
import com.chadapong.exceptions.ApplicationException;
import com.chadapong.models.Item;
import com.chadapong.repositories.ItemRepository;
import com.chadapong.vendor_store_2.dtos.ItemDto;

@Service
public class ItemManagementDao implements ItemManagement {

  @Autowired
  ItemRepository itemRepository;

  @Autowired
  ItemMapper itemMapper;

  @Override
  public ServiceResponseModel<Item> createItem(ItemDto model) throws ApplicationException {
    ServiceResponseModel<Item> responseModel = new ServiceResponseModel<>();

    Item isExistItem = itemRepository.findItemByName(model.getName());
    if (isExistItem == null) {
      Item newItem = new Item(UUID.randomUUID(), model.getName(), model.getDescription(), model.getAmount());
      responseModel.setPayload(newItem);
      responseModel.setMessage("successful add item");
      itemRepository.save(newItem);
      return responseModel;
    }
    throw new ApplicationException(String.format("Item name %s is already existed", model.getName()));

  }

  @Override
  public ServiceResponseModel<ItemDto> deleteItem(String name) throws ApplicationException{
    ServiceResponseModel<ItemDto> serviceResponseModel = new ServiceResponseModel<ItemDto>();

    Item isExistItem = itemRepository.findItemByName(name);
    if (isExistItem != null) {
      ItemDto itemDto = new ItemDto(isExistItem.getName(), isExistItem.getDescription(), isExistItem.getAmount());
      serviceResponseModel.setPayload(itemDto);
      serviceResponseModel.setMessage("delete item name: " + isExistItem.getName() + " successfully");
      itemRepository.delete(isExistItem);
      return serviceResponseModel;
    }
    throw new ApplicationException(String.format("Item name %s is not existed", name));

  }

  @Override
  public ServiceResponseModel<ItemDto> editItem(ItemDto model) {
    ServiceResponseModel<ItemDto> serviceResponseModel = new ServiceResponseModel<>();

    Item isExistItem = itemRepository.findItemByName(model.getName());
    if (isExistItem != null) {
      isExistItem.setAmount(model.getAmount());
      itemRepository.save(isExistItem);
      ItemDto itemDto = new ItemDto(isExistItem.getName(), isExistItem.getDescription(), isExistItem.getAmount());
      serviceResponseModel.setPayload(itemDto);
      serviceResponseModel.setMessage("update item name: " + model.getName() + " successfully");
      return serviceResponseModel;
    }
    serviceResponseModel.setMessage("fail to updat item name: " + model.getName());
    return serviceResponseModel;

  }

  @Override
  public ServiceResponseModel<List<ItemDto>> getAllItem() {
    ServiceResponseModel<List<ItemDto>> serviceResponseModel = new ServiceResponseModel<>();
    try {
      List<Item> itemList = itemRepository.findAllDto();
      if (itemList.size() > 0) {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        for (Item item : itemList) {
          ItemDto itemDto = itemMapper.toDto(item);
          itemDtoList.add(itemDto);
        }
        serviceResponseModel.setPayload(itemDtoList);
        serviceResponseModel.setMessage("get items successfully");
        return serviceResponseModel;
      }
      serviceResponseModel.setMessage("fail to get items");
      return serviceResponseModel;
    } catch (Exception e) {
      serviceResponseModel.setMessage(e.getMessage());
      return serviceResponseModel;
    }
  }

  @Override
  public ServiceResponseModel<ItemDto> getItemByName(String name)throws ApplicationException {

    ServiceResponseModel<ItemDto> serviceResponseModel = new ServiceResponseModel<>();
    Item isExistItem = itemRepository.findItemByName(name);
    if (isExistItem != null) {
      ItemDto itemDto = itemMapper.toDto(isExistItem);
      serviceResponseModel.setMessage("get item successfully");
      serviceResponseModel.setPayload(itemDto);
      return serviceResponseModel;
    }
    throw new ApplicationException(String.format("item name %s is not exist", name));

  }

}

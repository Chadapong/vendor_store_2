package com.chadapong.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chadapong.models.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item,UUID> {

  @Query("SELECT i FROM Item i WHERE i.name=?1")
  Item findItemByName(@Param("name") String name);

  @Query("SELECT i FROM Item i")
  List<Item> findAllDto();
}

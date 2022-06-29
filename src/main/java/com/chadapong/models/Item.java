package com.chadapong.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="items")
public class Item {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name ="uuid2",strategy = "uuid2")
  @Type(type = "uuid-char")
  @Column(name = "itemId",updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
  @Setter(AccessLevel.NONE)
  private  UUID itemId;
  @Column(nullable = false, name = "name")
  private  String name;
  @Column(name= "description",nullable = false)
  private String description;
  @Column(name="amount",nullable = false)
  private int amount;
}

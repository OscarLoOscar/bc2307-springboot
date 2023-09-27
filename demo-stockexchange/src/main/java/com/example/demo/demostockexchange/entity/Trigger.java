package com.example.demo.demostockexchange.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Trigger")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Trigger implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "customerId")
  private Long customerId;

  @Column(name = "stockId")
  private Long stockId;

  @Column(name = "type")
  private String type;// 'Buy , Sell'

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "threshold")
  private Double threshold;

  @Column(name = "condition")
  private String condition;

  // getters and setters omitted for brevity
}

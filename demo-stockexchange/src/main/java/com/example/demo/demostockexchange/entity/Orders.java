package com.example.demo.demostockexchange.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  Long customerId;

  Long stockId;

  String type; // 'BUY','SELL'

  Double price;

  @Column(name = "status")
  private String status;//'Placed' , 'Accepted' , 'Reject'

  @Column(name = "quantity")
  private Integer quantity;

  @JsonFormat(locale = "zh", timezone = "GMT+8",
      pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat
  @Column(name = "placedAt")
  private Date placedAt;

}

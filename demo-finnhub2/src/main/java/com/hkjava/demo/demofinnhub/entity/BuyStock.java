package com.hkjava.demo.demofinnhub.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nonnull;
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
@Table(name = "BUY_STOCK")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BuyStock implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Nonnull
  private String stockNum;

  @Nonnull
  private String stockName;

  @Nonnull
  private String stockSector;

  @Nonnull
  @JsonFormat(locale = "zh", timezone = "GMT+8",
      pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat
  private LocalDateTime buyTime = LocalDateTime.now();

  @Nonnull
  private Float price;

  @Nonnull
  private Double volume;

  @Nonnull
  private Double bidPrice;

  private String buyDetail;

  @Nonnull
  private String accountNumber;

  @Nonnull
  private String accountName;

  @Nonnull
  @Column(name = "Approve_Status", columnDefinition = "VARCHAR(1)") // "A","I"
  private Character approve;

  @Nonnull
  @Column(name = "Paid_Status", columnDefinition = "VARCHAR(1)") // "Y","N"
  private Character isPaid;

  @JsonFormat(locale = "zh", timezone = "GMT+8",
      pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat
  private Date addtime;

}

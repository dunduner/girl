package com.jp.girl.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {
   @Id
   @GeneratedValue
   private Integer id;

/*
@NotEmpty :不能为null，且Size>0  用在集合类上面
@NotNull:不能为null，但可以为empty,没有Size的约束  用在基本类型上
@NotBlank:只用于String,不能为null且trim()之后size>0   用在String上面

*/
   @NotBlank(message = "cupSize必传")
   private  String cupSize;

   @Min(value = 18,message = "未成年少女禁止入内")
   //NotNull
   //Max
   //Length
   private  Integer age;


   @NotNull(message = " 金额必传")
   private Double money;


   public Girl() {
   }

   @Override
   public String toString() {
      return "Girl{" +
              "id=" + id +
              ", cupSize='" + cupSize + '\'' +
              ", age=" + age +
              ", money=" + money +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getCupSize() {
      return cupSize;
   }

   public void setCupSize(String cupSize) {
      this.cupSize = cupSize;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public Double getMoney() {
      return money;
   }

   public void setMoney(Double money) {
      this.money = money;
   }
}

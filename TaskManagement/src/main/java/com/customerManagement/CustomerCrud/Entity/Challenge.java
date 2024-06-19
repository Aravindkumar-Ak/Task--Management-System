package com.customerManagement.CustomerCrud.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "monthly_challenges")
public class Challenge {
   @Column(name = "Id",length = 20)
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @Column(name="month_name",length = 50)
   private String month;
   @Column(name="challenge_name",length = 100)
   private String challenge;


}

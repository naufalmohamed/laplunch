package com.paymentservice.model;


import lombok.*;


import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;

    private int orderId=0;

    private String userEmailId;

    private float totalPrice;

    private String status="initiated";

    private String razorpayOrderId="ToBeGenerated";

}

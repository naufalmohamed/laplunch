package com.menuservice.Subscription.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "subscriptiondetails")
public class SubscriptionModel {

    @Id
    private int subscriptionId;
    private String subscriptionTitle;
   private String description;
   private SubscriptionPlansEnum subscriptionPlan;

   private Double subscriptionPrice;
   private String photo;

   private  int validity;


}

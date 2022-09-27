package com.menuservice.Subscription.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "subscribedplandetails")
public class SubscribedPlansModel {
        @Id
        private String emailId;

        private String userName;
        private String subscriptionTitle;
        private SubscriptionPlansEnum subscriptionPlan;
        private  String description;
        private  String subscriptionId;
        private  Double subscriptionPrice;
        private  String photo;
        private  int validity;
        private String purchaseDate;


    }



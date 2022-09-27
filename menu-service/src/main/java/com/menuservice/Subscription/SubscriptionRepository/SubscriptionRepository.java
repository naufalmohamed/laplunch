package com.menuservice.Subscription.SubscriptionRepository;

import com.menuservice.Subscription.Model.SubscriptionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<SubscriptionModel,Integer> {
}

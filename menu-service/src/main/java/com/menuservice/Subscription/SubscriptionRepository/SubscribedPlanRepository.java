package com.menuservice.Subscription.SubscriptionRepository;

import com.menuservice.Subscription.Model.SubscribedPlansModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscribedPlanRepository extends MongoRepository<SubscribedPlansModel,String> {


}

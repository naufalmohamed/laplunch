package com.menuservice.Subscription.service;

import com.menuservice.Subscription.Model.SubscribedPlansModel;
import com.menuservice.Subscription.SubscriptionRepository.SubscribedPlanRepository;
import com.menuservice.Subscription.exception.SubscriptionAlreadyExistsException;
import com.menuservice.Subscription.exception.SubscriptionNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribedPlanService {

    @Autowired
    public SubscribedPlanRepository subscribedPlanRepository;

    //THis method contains service for addsubscribedplan
    public void addSubscribedPlans(SubscribedPlansModel subscribedPlanModel) throws SubscriptionAlreadyExistsException {

        this.subscribedPlanRepository.insert(subscribedPlanModel);
    }

    //THis method contains service for getting subscribedplan details
    public SubscribedPlansModel getSubscribedPlansByEmail(String emailId) throws  SubscriptionNotExistsException{

        if (subscribedPlanRepository.existsById(emailId)) {

            return subscribedPlanRepository.findById(emailId).get();
        }

        throw new SubscriptionNotExistsException();

    }






}

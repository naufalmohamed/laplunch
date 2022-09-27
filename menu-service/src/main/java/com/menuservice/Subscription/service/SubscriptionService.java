package com.menuservice.Subscription.service;


import com.menuservice.Subscription.Model.SubscriptionModel;
import com.menuservice.Subscription.SubscriptionRepository.SubscriptionRepository;
import com.menuservice.Subscription.exception.SubscriptionAlreadyExistsException;
import com.menuservice.Subscription.exception.SubscriptionNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    public SubscriptionRepository subscriptionRepository;

    public void addSubscription(SubscriptionModel subscriptionModel) throws SubscriptionAlreadyExistsException {

    this.subscriptionRepository.insert(subscriptionModel);

    }
    //This service used to update subscriptiondetails
    public String updateSubscriptionDetails(SubscriptionModel subscriptionModel) throws SubscriptionNotExistsException{

        if(subscriptionRepository.existsById(subscriptionModel.getSubscriptionId())){

            subscriptionRepository.save(subscriptionModel);

            return "Update Success!!";
        }
        throw new SubscriptionNotExistsException();
    }

    public List<SubscriptionModel> getAllSubscriptionDetails() throws SubscriptionNotExistsException{

        if (subscriptionRepository.count() == 0) {
            throw new SubscriptionNotExistsException();
        }
        return subscriptionRepository.findAll();

    }

    public void deleteSubscription(int subscriptionId) throws SubscriptionNotExistsException{

        if (!subscriptionRepository.existsById(subscriptionId)) {

//		   menuRepository.deleteById(itemId);
            throw new SubscriptionNotExistsException();
        }

//		throw new MenuNotFoundException();
        subscriptionRepository.deleteById(subscriptionId);
    }

    }
//   public List<SubscriptionModel> getAllSubscriptionDetails(){
//
//    }
//
//    public getSubscriptionDetailsBtId(){
//
//    }
//

//
//    public deleteSubscription(){
//
//    }


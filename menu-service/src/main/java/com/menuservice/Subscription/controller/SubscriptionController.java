package com.menuservice.Subscription.controller;

import com.menuservice.Subscription.Model.SubscribedPlansModel;
import com.menuservice.Subscription.Model.SubscriptionModel;
import com.menuservice.Subscription.exception.SubscriptionAlreadyExistsException;
import com.menuservice.Subscription.exception.SubscriptionNotExistsException;
import com.menuservice.Subscription.service.SubscribedPlanService;
import com.menuservice.Subscription.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class SubscriptionController {

    public SubscriptionService subscriptionService;

    public SubscriptionModel subscriptionModel;


    public SubscribedPlansModel subscribedPlanModel;

    public SubscribedPlanService subscribedPlanService;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //consists controller mappings for subscriptionplan

    public SubscriptionController(SubscriptionService subscriptionService,SubscribedPlanService subscribedPlanService) {

        this.subscriptionService = subscriptionService;
        this.subscribedPlanService=subscribedPlanService;
    }

    //Method for posting subscriptionplans
    @PostMapping
    public ResponseEntity<?> addSubscription(@RequestBody SubscriptionModel subscriptionModel){

        try {
            subscriptionService.addSubscription(subscriptionModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SubscriptionAlreadyExistsException e) {

            return new ResponseEntity<>("Subscriptiondetails already exists!!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Subscriptiondetails already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Method for updating subscriptionplans
    @PutMapping
    public ResponseEntity<?>  updateSubscriptionDetails(@RequestBody SubscriptionModel subscriptionModel){

        try {

            subscriptionService.updateSubscriptionDetails(subscriptionModel);
            return new ResponseEntity<>("Update success!!", HttpStatus.OK);

        } catch (SubscriptionNotExistsException e) {

            return new ResponseEntity<>("Subscriptiondetails not found!!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong we will be back soon !!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Method for deleting subscriptionplans
    @GetMapping
    public ResponseEntity<Object> getAllSubscriptionDetails(){
        try {
            return ResponseEntity.ok(subscriptionService.getAllSubscriptionDetails());
        } catch (SubscriptionNotExistsException e) {
            return new ResponseEntity<Object>("Empty repository!!", HttpStatus.CONFLICT);
        }
    }
//
//    public getSubscriptionDetailsBtId(){
//
//    }
//

//
    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<?>  deleteSubscription(@PathVariable int subscriptionId){

        try {

            subscriptionService.deleteSubscription(subscriptionId);
            return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);

        } catch (SubscriptionNotExistsException e) {



            return new ResponseEntity<>("Delete unsuccessfull!!", HttpStatus.CONFLICT);
        } catch (Exception e) {

            return new ResponseEntity<>("Something went wrong!!", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //this methods contais mappings for subscribedplans
    @PostMapping("/addPlan")
    public ResponseEntity<?> addSubscribedPlans(@RequestBody SubscribedPlansModel subscribedPlanModel){

        try {
            subscribedPlanService.addSubscribedPlans(subscribedPlanModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SubscriptionAlreadyExistsException e) {

            return new ResponseEntity<>("SubscriptionPlanDetails already exists!!", HttpStatus.CONFLICT);}
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong!!!", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<Object> getSubscribedPlansByEmail(@PathVariable String emailId) {

        try {

            return new ResponseEntity<Object>(subscribedPlanService.getSubscribedPlansByEmail(emailId), HttpStatus.OK);

        } catch (SubscriptionNotExistsException e) {

            return new ResponseEntity<Object>("SubscriptionPlanDetails not found!!", HttpStatus.CONFLICT);
        } catch (Exception e) {

            return new ResponseEntity<Object>("Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }}

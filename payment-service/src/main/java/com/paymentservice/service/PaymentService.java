package com.paymentservice.service;

import com.paymentservice.exceptions.PaymentAlreadyExistsException;
import com.paymentservice.exceptions.PaymentNotFoundException;
import com.paymentservice.model.PaymentModel;
import com.paymentservice.repository.PaymentRepository;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentModel addPayment(PaymentModel paymentModel) throws PaymentAlreadyExistsException, RazorpayException {
        if(!paymentRepository.existsById(paymentModel.getPaymentId())){
            RazorpayOrderService razorpayOrderService=new RazorpayOrderService(); //tightly coupled
            String razorpayOrderId=razorpayOrderService.newRazorpayOrder(paymentModel);
            paymentModel.setRazorpayOrderId(razorpayOrderId);

            paymentRepository.save(paymentModel);
        }
        else {
            throw new PaymentAlreadyExistsException();
        }
        return paymentModel;
    }

    public PaymentModel getPaymentByPaymentId(int paymentId) throws PaymentNotFoundException {
        if(paymentRepository.findById(paymentId).isPresent()){
            return paymentRepository.findById(paymentId).get();
        }
        else{
            throw new PaymentNotFoundException();
        }
    }

    public List<PaymentModel> getPayments() throws PaymentNotFoundException {
        if(paymentRepository.findAll().isEmpty()){
            throw new PaymentNotFoundException();
        }
        else{
            return paymentRepository.findAll();
        }
    }

    public void updatePayment(PaymentModel paymentModel) throws PaymentNotFoundException {
        if(paymentRepository.findById(paymentModel.getPaymentId()).isPresent()){
            PaymentModel newModel= paymentRepository.findById(paymentModel.getPaymentId()).get();
            newModel.setOrderId(paymentModel.getOrderId());
            newModel.setTotalPrice(paymentModel.getTotalPrice());
            newModel.setStatus(paymentModel.getStatus());

            paymentRepository.save(newModel);
        }
        else{
            throw new PaymentNotFoundException();
        }
    }

    public void deletePayment(int paymentId) throws PaymentNotFoundException {
        if(paymentRepository.existsById(paymentId)){
            paymentRepository.deleteById(paymentId);
        }
        else{
            throw new PaymentNotFoundException();
        }
    }
    public List<PaymentModel> getPaymentsByEmailId(String userEmailId) throws PaymentNotFoundException {
        List<PaymentModel> allPayments=this.paymentRepository.findAll();
        List<PaymentModel> userPayments=new ArrayList<PaymentModel>();

       for(PaymentModel pm:allPayments){
           try {
               if(pm.getUserEmailId().equals(userEmailId)){
                   userPayments.add(pm);
               }
           } catch(NullPointerException e){
               e.getMessage();
           }
       }
       if(userPayments.isEmpty()){
           throw new PaymentNotFoundException();
       }
       return userPayments;
    }
}

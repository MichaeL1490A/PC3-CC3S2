//package Solid.LSP;

import java.util.ArrayList;
import java.util.List;

public class PaymentHelper {
    List<PreviousPayment> previouspayments = new ArrayList<>();
    List<NewPayment> newpayments = new ArrayList<>();
    public void addPreviousPayment(PreviousPayment user){
        previouspayments.add(user);
    }
    public void addNewPayment(NewPayment user){
        newpayments.add(user);
    }
    public void showPreviousPayments(){
        for(PreviousPayment previouspayment: previouspayments){
            previouspayment.previousPaymentInfo();
            System.out.println("------");
        }
    }
    public void processNewPayments(){
        for(NewPayment newpayment: newpayments){
            newpayment.newPayment();
            System.out.println("------");
        }
    }
}

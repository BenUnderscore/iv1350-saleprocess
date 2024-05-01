package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.dto.RunningStatus;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void startSale(){
        controller.startSale();
    }

    public void scanOneItem(String itemID){
        RunningStatus status = controller.registerItems(itemID, 1);
    }

    public void endSale(){
        int totalPrice = controller.endSale();
    }

    public void registerPayment(int amount){  
        int change = controller.registerPayment(amount);
    }


}
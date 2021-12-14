package application;

import java.util.Map;

public class Calulate {
    private double offerValue;

    public double getOfferValue() {
        return offerValue;
    }

    public void calculateOffer(Suitcase suitcase, double pickSuitcase, int round){
        for(Map.Entry<Integer, Double> entry : suitcase.getSuitcase().entrySet()){
            offerValue+=entry.getValue();
        }
        offerValue=offerValue+pickSuitcase;
        offerValue=offerValue/(suitcase.getSuitcase().size()+1);
        offerValue=offerValue*round/10;
    }
}

package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Suitcase {
    Map<Integer, Double> suitcase=new HashMap<Integer, Double>();

    public Map<Integer, Double> getSuitcase() {
        return suitcase;
    }

    public Map<Integer, Double> fillSuitcase(){
        double[] values={0.01, 1,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000 };
        Random rand=new Random();
        int suitcaseNumber;
            for (int i=0; i<26;i++){
                do {
                    suitcaseNumber = rand.nextInt(26);
                }
                while(suitcase.get(suitcaseNumber)!=null);
                suitcase.put(suitcaseNumber,values[i]);
                }
        return suitcase;
    }

    public void printSuite() {
        for (Map.Entry<Integer,Double> keyvalue : suitcase.entrySet()) {
            System.out.print("["+(keyvalue.getKey()+1)+"]");
        }
        System.out.println();
    }

    public boolean isSuitcaseTaken(int index) {
        return suitcase.get(index)==null;
    }
    public void removeSuitecase(int index) {
       suitcase.remove(index);

    }

    public int lastSuitcaseNumber(){
        int lastSuitcase = -1;
        for (Map.Entry<Integer,Double> keyvalue : suitcase.entrySet()){
            lastSuitcase = keyvalue.getKey();
        }
        return lastSuitcase;
    }
    public double lastSuitcaseValue(){
        double lastSuitcase = -1;
        for (Map.Entry<Integer,Double> keyvalue : suitcase.entrySet()){
            lastSuitcase = keyvalue.getValue();
        }
        return lastSuitcase;
    }
}

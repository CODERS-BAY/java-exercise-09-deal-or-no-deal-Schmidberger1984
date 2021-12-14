package application;

public class Main {

    public static void main(String[] args) {
        Suitcase suitcase = new Suitcase();
        Calulate cal = new Calulate();
        int[] takeSuitcaseRound = {6,5,4,3,2,1,1,1,1};
        boolean breakGame = false;
        int takeSuitcase=2;


        suitcase.fillSuitcase();
        suitcase.printSuite();
        System.out.println("Deal or no Deal?");
        int choose=Console.input("Please choose your suitcase 1-26 with your price: ");
        int pickSuitcaseNumber = choose;
        pickSuitcaseNumber++;
        double pickSuitcaseVaule=suitcase.getSuitcase().get(choose);
        suitcase.removeSuitecase(choose);
        suitcase.printSuite();
        for (int i = 0; i <9;i++){
            for (int j = 0; j < takeSuitcaseRound[i];j++){
                boolean again=false;
                do {
                    choose=Console.input("Pick a suitcase to eliminate form the game:");
                    if (suitcase.isSuitcaseTaken(choose)!=true){
                        System.out.println("Case "+takeSuitcase+" was eliminated.");
                        System.out.println("It contains "+suitcase.getSuitcase().get(choose)+"$");
                        suitcase.removeSuitecase(choose);
                        takeSuitcase++;
                        again=false;
                    } else {
                        System.out.println("Suitace is taken");
                        again=true;
                    }
                }while(again==true);
            }
            cal.calculateOffer(suitcase, pickSuitcaseVaule,i+1);
            System.out.println("Offer: "+cal.getOfferValue());
            System.out.println("Do you accept the offer?");
            if (Console.abort().equals("y")) {
                breakGame=true;
                break;
            }
            else suitcase.printSuite();
        }
        if (breakGame==false){
            Console.lastQuestion(suitcase,pickSuitcaseNumber,pickSuitcaseVaule);
        } else{
            System.out.println("\nCongratulations, you won "+cal.getOfferValue()+"$.");
        }
        System.out.println("\n$$$$$$$$ Thank you for playing DEAL OR NO DEAL $$$$$$$$\n" +"Please try again at another time, bye bye!");
    }
}

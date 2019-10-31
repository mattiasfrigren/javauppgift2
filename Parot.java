package Java2;

import java.util.ArrayList;
import java.util.Scanner;
// denna klass fungerar på samma sätt som Dog och Elephant. förutom att de finns en land()metod.
class Parot extends Animals {
    ArrayList tempParot;
    boolean fly;
    int seeds;
    String flying;
    Scanner givename = new Scanner(System.in);

    protected Parot() {
        parotValues();
    }

    protected void parotValues() {
        sound = "Kaaahh! Kaaahhhh!!";
        weight = randomInt(randlow = 500, randhigh = 4000);
        height = randomInt(randlow = 50, randhigh = 200);
        eat = randomInt(randlow = 7, randhigh = 12);
        age = randomInt(randlow = 1, randhigh = 34675);
        System.out.println("name your Parot: ");
        name = givename.next() +" the Parot";
        birthDate =1;
        printMe();
    }
    // land() anropas för att sätta en parot till att landa  ifrån fly() metoden.
    protected boolean land () {
        fly = false;
        flying = "is not flying";
        return fly;
    }
    protected boolean fly(int tempParotage) {
        if (tempParotage % 2 == 0 || tempParotage % 3 ==0) {
            fly = true;
            flying = "is flying!";
        } else {
            land();
        }
        return fly;
    }

    protected int moreseeds() {
        seeds = (seeds + (int) (Math.random() * (30 - eat) + eat));
       if (seeds>30) {
           seeds=30;
       }
        return seeds;
    }

    protected ArrayList daysCountParot(int days, ArrayList<Parot> parotCheck) {
        int tempParotBirthDate;
        tempParot = parotCheck;
        parotCheck =daysCountAnimals(days, tempParot);
        for (int j = 0; j < parotCheck.size(); j++) {
            int tempAge= (parotCheck.get(j).age-days);

            for (int i = 1; i <= days; i++) {
                if (seeds < eat) {
                    moreseeds();
                }
                tempParotBirthDate = parotCheck.get(j).birthDate;
                parotCheck.get(j).birthDate++;
                tempAge++;
                seeds = seeds - eat;
                fly(tempParotBirthDate);
                System.out.println(parotCheck.get(j).name + " Has " + seeds + " seeds left, and " + flying + " on day: " +tempParotBirthDate +" age is now: " + tempAge);
            }
            seeds = 0;
        }
        return parotCheck;
    }

    protected void printBestAnimal(ArrayList bestParot) {
        animalSortByAge(bestParot);
    }
    protected void printAllParots(ArrayList parotPrint) {

        printValues(parotPrint);
    }
}



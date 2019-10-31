package Java2;
import java.util.ArrayList;
import java.util.Scanner;
// denna klassen fungerar på samma sätt som Dog och parrot.
class Elephant extends Animals {
    ArrayList tempElephant;
    boolean bath = true;
    int elephantFood;
    String bath1;
    Scanner givename = new Scanner(System.in);

    protected Elephant() {
        ElephantValues();
    }
    
    protected void ElephantValues() {
        sound = " 'trunk sounds' ";
        weight = randomInt(randlow = 4000000, randhigh = 7000000);
        height = randomInt(randlow = 200, randhigh = 400);
        eat = randomInt(randlow = 30, randhigh = 50);
        age = randomInt(randlow = 1, randhigh = 25500);
        System.out.println("name your Elephant: ");
        name = givename.next() + " the Elephant";
        birthDate =1;
        printMe();
    }

    protected boolean newbath(int days) {
        if (days % 2 == 0) {
            bath = false;
            bath1="does not bath";
        } else {
            bath = true;
            bath1="is having a bath";
        }
        return bath;
    }

    protected int moreelephantFood() {
        elephantFood = (elephantFood + (int) (Math.random() * (100 - eat) + eat));
        if (elephantFood>100) {
            elephantFood =100;
        }
        return elephantFood;
    }

    protected ArrayList daysCountElephant(int days, ArrayList<Elephant> elephantCheck) {
        int tempElephantBirthDate;
        tempElephant = elephantCheck;
        elephantCheck =daysCountAnimals(days, tempElephant);
        for (int j = 0; j < elephantCheck.size(); j++) {
            int tempAge= (elephantCheck.get(j).age-days);
            for (int i = 1; i <= days; i++) {
                if (elephantFood < eat) {
                    moreelephantFood();
                }
                tempElephantBirthDate = elephantCheck.get(j).birthDate;
                elephantCheck.get(j).birthDate++;
                tempAge++;
                elephantFood = elephantFood - eat;
                newbath(tempElephantBirthDate);
                System.out.println(elephantCheck.get(j).name + " Has " + elephantFood + " bananas left, and " + bath1 + " on day: " +tempElephantBirthDate +" age is now: " + tempAge);
            }
            elephantFood = 0;
        }
        return elephantCheck;
    }

    protected void printBestAnimal(ArrayList bestElephant) {

        animalSortByAge(bestElephant);
    }

    protected void printAllElephants(ArrayList ElephantPrint) {

        printValues(ElephantPrint);
    }
}



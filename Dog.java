package Java2;

import java.util.ArrayList;
import java.util.Scanner;

class Dog extends Animals {
    // Dog klassen har en tempDog arraylist som vi kommer använda oss av. och även en String chew för att printout ska bli lättare att
    //  förstå.
    ArrayList tempDog;
    boolean chewToy = true;
    int dogFood;
    String chew;
    Scanner givename = new Scanner(System.in);

    protected Dog() {
        dogValues();
    }
// här är alla värden som en Dog kommer få när vi lägger till den i Arraylisten<Dog>.
    protected void dogValues() {
        sound = "voff voff";
        weight = randomInt(randlow = 1000, randhigh = 35000);
        height = randomInt(randlow = 30, randhigh = 100);
        eat = randomInt(randlow = 23, randhigh = 42);
        age = randomInt(randlow = 1, randhigh = 4380);
        System.out.println("name your dog: ");
        name = givename.next() +" the Dog";
        birthDate =1;
        printMe();
    }
// här sätter vi chewToy och chew till olika värden beroende på vilken dag det är. den går i grund för birthDate variabeln.
    protected boolean newChewToy(int tempdogage) {
            if (tempdogage % 5 == 0) {
                chewToy = false;
                chew = "Chewtoy is broken";
            } else {
                chewToy = true;
                chew = "has a Chewtoy";
            }
        return chewToy;
    }
// här räknar vi ut så varje unik Dog får sin dogFood. den plusar på från dagen innan så värdet följer med. blir maten för mycket
    // ser vi till att ställa om den till maxvärdet.
    protected int moreDogFood() {
        dogFood = (dogFood + (int) (Math.random() * (50 - eat) + eat));
        if (dogFood>50) {
            dogFood =50;
        }
        return dogFood;
    }
/*här räknar vi ut varje dag som går. vi sätter tempDog att få samma värde som Arraylist <Dog>. och skapar en variabel tempDogBirthDate
* som vi kommer använda för att räkna ut boolean effekten korrekt.  först räknar vi ut den nya åldern genom att skicka in tempDog och
* antalet dagar till daysCountAnimals och ge det nya värdet till orginal Arraylisten. sedan sätter vi tempAge så den får värdet
* av åldern som var innan vi räkna ut den nya åldern. detta gör vi för att vi ska få en korrekt utskrift när vi printar ut allt.
* TempDogBirthDate får värdet av Birthdate som vi sedan skickar in i boolean metoden. gör "++" på de variablerna som behövs för varje
* Dog och skriver sedan ut det. när vi har skrivit ut alla dagar för en enskilld Dog sätter vi dogFood till 0 igen så den nya Dog
* inte använder sig av samma dogFood som den förra. */
    protected ArrayList daysCountDog(int days, ArrayList<Dog> dogCheck) {
        int tempDogBirthDate;
        tempDog = dogCheck;
        dogCheck =daysCountAnimals(days, tempDog);
        for (int j = 0; j < dogCheck.size(); j++) {
            int tempAge= (dogCheck.get(j).age-days);

            for (int i = 1; i <= days; i++) {
                if (dogFood < eat) {
                    moreDogFood();
                }
                tempDogBirthDate = dogCheck.get(j).birthDate;
                dogCheck.get(j).birthDate++;
                tempAge++;
                dogFood = dogFood - eat;
                newChewToy(tempDogBirthDate);

                System.out.println(dogCheck.get(j).name + " Has " + dogFood + " dogfood left, and " + chew + " on day: " +tempDogBirthDate +" age is now: " + tempAge);
            }
            dogFood = 0;
        }
        return dogCheck;
    }
// här anropar vi metoden animalSortByAge i animal för att hitta bästa hunden.
    protected void printBestAnimal(ArrayList bestDog) {
        animalSortByAge(bestDog);
    }
    protected void printAllDogs(ArrayList dogPrint) {
// här anropar vi metoden printValues i animal för att skriva ut alla hundar.
        printValues(dogPrint);
    }
}



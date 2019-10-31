package Java2;
import java.util.ArrayList;

class Animals {
    /* vår anmial klass med alla variabler. vi använder ExceptionSecure även här för att unvika error.
    * randlow och randhigh använder vi oss av för att få fram respektiven variabel för varje djur.
    * birthDate är variabeln vi använder för att se till så varje individuelt objekts boolean körs för sig själv. */
    ExceptionSecure secureAnimal = new ExceptionSecure();
    String sound;
    String name;
    int weight;
    int height;
    int eat;
    int age;
    int randlow;
    int randhigh;
    int birthDate;
// detta är våran randomizer för att få fram ett korekt värde av alla attributer djuren har.
    protected int randomInt(int randlow, int randhigh) {
        int resualt2 = (int) ((Math.random() * (randhigh - randlow) + randlow));
        return resualt2;
    }

    protected void animalSortByWeight(ArrayList<Animals> animalArr) {
        for (int i = 0; i < animalArr.size(); i++) {
            int m = i;
            for (int j = i + 1; j < animalArr.size(); j++) {
                if (animalArr.get(m).age > animalArr.get(j).weight) {
                    m = j;
                }
            }
            Animals temp = animalArr.get(i);
            animalArr.set(i, animalArr.get(m));
            animalArr.set(m, temp);
                 }
    }

    //Sorterar efter höjd
    protected void animalSortByHeight(ArrayList<Animals> animalArr) {
        for (int i = 0; i < animalArr.size(); i++) {
            int m = i;
            for (int j = i + 1; j < animalArr.size(); j++) {
                if (animalArr.get(m).height > animalArr.get(j).height) {
                    m = j;
                }
            }
            Animals temp = animalArr.get(i);
            animalArr.set(i, animalArr.get(m));
            animalArr.set(m, temp);
        }
        int lastindex = animalArr.size() - 1; //sista platsen i listan
        for (int k = 0; k < lastindex; k++) {
            if (animalArr.get(lastindex).height == animalArr.get(k).height) {
                animalSortByWeight(animalArr);

            }
        }
        System.out.println(animalArr.get(lastindex).age + ", " + animalArr.get(lastindex).name + " is the most amazing animal of them all!");
    }

    /* här sorterar vi efter ålder för att få fram "bästa" djuret av varje Arraylist. vi börjar med att loopa igenom hela Arraylistan
    * sätter variabeln m till samma värde som i har. sedan går vi in i andra for loopen.  */
    protected void animalSortByAge(ArrayList<Animals> animalArr) {

        for (int i = 0; i < animalArr.size(); i++) {

            int m = i;
            for (int j = i + 1; j < animalArr.size(); j++) {
                if (animalArr.get(m).age > animalArr.get(j).age) {
                    m = j;
                }
            }
            Animals temp = animalArr.get(i);
            animalArr.set(i, animalArr.get(m));
            animalArr.set(m, temp);
        }
        int lastindex = animalArr.size() - 1;
        for (int k = 0; k < lastindex; k++) {
            if (animalArr.get(lastindex).age == animalArr.get(k).age) {
                animalSortByHeight(animalArr);
            }
        }
        System.out.println(animalArr.get(lastindex).age + ", " + animalArr.get(lastindex).name + " is the most amazing animal of them all!");
    }
/* här har vi en metod vars syfte är att äkna ut age för alla djur. och sedan returna hela Arraylistan tillbaka.
* vi har även en check för att se till så listan inte blir tom. för då kan man stöta på error.*/
    protected ArrayList daysCountAnimals(int dayC, ArrayList<Animals> animalcheck) {
        for (int j = 0; j < animalcheck.size(); j++) {

            for (int i = 1; i <= dayC; i++) {
                animalcheck.get(j).age++;

                if (animalcheck.get(j).age > randhigh) {
                    System.out.println(animalcheck.get(j).name + " has died how tragic! ");
                    animalcheck.remove(j);
                }
                if (animalcheck.isEmpty()) {
                    break;
                }
            }
        }
        return animalcheck;
    }
    protected void printMe() {
        // en metod för att skriva ut djuren efter att de skapats.
        System.out.println(name+" " +age +" " + weight +" " +height +" "+eat);
    }

    protected void printValues(ArrayList<Animals> animalArrPrint) {
// här skriver vi ut alla djuren i samma Arraylist med sina unika attributer.
        for (int i = 0; i < animalArrPrint.size(); i++) {
           System.out.println(animalArrPrint.get(i).sound + " says " + animalArrPrint.get(i).name + " and is " +animalArrPrint.get(i).weight
                   + " gram heavy " +animalArrPrint.get(i).age + " days old, " +animalArrPrint.get(i).eat +
                   " eats this much and is " +animalArrPrint.get(i).height+ " cm tal! " );
        }
    }
}



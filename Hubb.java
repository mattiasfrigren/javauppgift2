package Java2;
import java.util.ArrayList;

class Hubb {
    /*här skapar vi 3 objket av djur klasserna som vi kommer använda oss av för att anropa olika metoder. vi skapar även 3st
    * Arraylister för varje djurklass. för att inte skriva en massa onödiga rader och undvika buggar med Scanner i denna klass
    * har vi även skapat en ExceptionSecure klass som vi använder för att undvika error. den klassen kör vi vår Scanner i
    * och kommer undivka error medellande plus att det blir inte speicllt rörigt i våran kod varje gång vi vill ha
    * ett input ifrån användaren. */
    ExceptionSecure secure = new ExceptionSecure();
    private Elephant elfant;
    int choice;
    int daysToSend;
    private Dog hund;
    private Parot perra;
    ArrayList<Elephant> animalElephantArr = new ArrayList<>();
    ArrayList<Dog> animalDogArr = new ArrayList<>();
    ArrayList<Parot> animalParotArr = new ArrayList<>();

    protected Hubb() {
        System.out.println("System online");
        zooMeny();
    }
/* här är våran zoo meny. vi andropar en metod som visar upp de olika valen man kan göra och sedan anropar vi Scannern i
* vår ExceptionSecure klass. vi har 2 sätt att unvika errors i vår meny när man inte har något djur i nån av Arraylistorna.
* för kollar vi om alla Arraylistorna är tomma via "checkIFArraysEmpty(). sedan tittar vi specifikt på varje Arraylist
* för att vara säkra om att de inte är tomma. på detta sättet så undviker vi error medellande."*/
    protected void zooMeny() {
        while (true) {
            showMenyAgain();
             choice = secure.secureChoice();
            switch (choice) {
                case 1:
                    randomAnimal();
                    break;
                case 2:
                    checkIfArraysEmpty();
                   if (animalDogArr.size()!=0){hund.printAllDogs(animalDogArr);}
                   if (animalElephantArr.size()!=0){elfant.printAllElephants(animalElephantArr);}
                   if (animalParotArr.size()!=0){perra.printAllParots(animalParotArr);}
                    break;
                case 3:
                    checkIfArraysEmpty();
                   if (animalDogArr.size()!=0) {hund.printBestAnimal(animalDogArr);}
                   if (animalElephantArr.size()!=0){elfant.printBestAnimal(animalElephantArr);}
                   if (animalParotArr.size()!=0){perra.printBestAnimal(animalParotArr);}
                    break;
                case 4:
                    checkIfArraysEmpty();
                    daysToGo();
                    if (animalElephantArr.size()!=0){animalElephantArr = elfant.daysCountElephant(daysToSend,animalElephantArr);}
                    if (animalDogArr.size()!=0){animalDogArr = hund.daysCountDog(daysToSend, animalDogArr);}
                    if (animalParotArr.size()!=0){animalParotArr = perra.daysCountParot(daysToSend,animalParotArr);}
                    break;
                case 5:
                    System.out.println("exit the program..");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid number. Try again please");
                    continue;
            }
        }
    }

    protected int daysToGo() {
        // här hämtar vi antalet dagar som vi väljer att skicka in "daysCount() metoderna.
        System.out.println("how many days do you wanna see?");
        daysToSend = secure.secureChoice();
        return daysToSend;
    }
    protected void showMenyAgain () {
        // våran meny som skrivs ut till användaren varje gång man kommer till zoomeny() igen.
        System.out.println(" welcome to the zoo! \n choose in the meny pls \n 1. Get a new animal \n 2. Print animals \n 3. Best animal \n 4. see days");
        System.out.println(" 5. Exit\n ");
    }
    protected void checkIfArraysEmpty(){
        // här tittar vi igenom alla Arraylistorna för att skriva ut om alla listorna är tomma.
        if (animalParotArr.isEmpty() && animalElephantArr.isEmpty() && animalDogArr.isEmpty()) {
            System.out.println("no animals in the zoo");
            zooMeny();
        }

    }
    protected void randomAnimal () {
        // här randomar vi fram en Arraylist som kommer vi sedan väljer att skapa ett djur objket i.
        int randomAnimal =(int) Math.floor(Math.random()*3);
        if (randomAnimal==0) {
            animalDogArr.add(hund=new Dog());
        }
        else if (randomAnimal ==1) {
            animalElephantArr.add(elfant = new Elephant());
        }
        else if (randomAnimal==2) {
            animalParotArr.add(perra = new Parot());
        }
    }
}

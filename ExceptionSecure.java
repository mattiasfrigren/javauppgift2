package Java2;
import java.util.InputMismatchException;
import java.util.Scanner;
/* vi valde att skapa denna klassen för att unvika att ha massa olika try/catch metoder överallt. på detta sätt blir
* koden mycket snyggare och lättare att följa. vi nollställer choice varje gång vi anropar metoden för att undvika error.*/
class ExceptionSecure {
    int choice;
    Scanner menu;
    protected int secureChoice () {
        choice=0;
        try {
            menu = new Scanner(System.in);
            choice = menu.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please try with digits.");
        }
        return choice;
    }
}

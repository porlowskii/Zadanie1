package UserInterface;

import Factoring.Factoring;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private Factoring factoring = new Factoring();

    public UserInterface() {
        this.scan=new Scanner(System.in);
    }
    public void start() {
        System.out.println("Write table size and which one number from the end you want");
        System.out.println("Format: number(space)number");
        System.out.println("Example:X X");
        //first input line
        while (true) {
            String input;
            input = String.valueOf(scan.nextLine());
            if (!factoring.firstLine(input).equals("Correct")) {
                System.out.println(factoring.firstLine(input));
                continue;
            }
            break;
        }

        //second input line
        System.out.println("Write "+factoring.getTableSize()+" numbers for add to table");
        while (true) {
            String inputTable = String.valueOf(scan.nextLine());
            if (!factoring.secondLine(inputTable).equals("Correct")) {
                System.out.println(factoring.secondLine(inputTable));
                continue;
            }
            break;
        }

        System.out.println(factoring.getTableSize() + " " + factoring.getWhichOneMax() + " " + factoring.getTable());
        System.out.println("Your looking for number is: "+factoring.getLookingForNumber());
    }
}
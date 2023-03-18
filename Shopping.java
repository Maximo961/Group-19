import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String choice;
        String done = "yes";
        String removal;
        int direction;
        Books[] cart = {new Books()};
        ArrayList<String> List = new ArrayList<String>();
        ArrayList<Double> Price = new ArrayList<Double>();
        Books Shoppingcart = new Books();
        Books Hp_Prisoner = new Books("Jk Rowling", "Fantasy", 19.99, "penguin Publishing",
                65.50, "Hp");
        Books LOTR_FELLOWSHIP = new Books("J.R.R Tolkein", "Fantasy", 30.00, "Penguin",
                90.45, "Lotr");
        Books DRESDEN_FILES = new Books("Bob Ruth", "Fantasy", 30.00, "Penguin",
                90.45, "Df");
        while (done.equalsIgnoreCase("yes")) {
            System.out.println("What books would you like to purchase");
            System.out.println(Hp_Prisoner.getTitle() + " " + Hp_Prisoner.getPrice() + "\n" + LOTR_FELLOWSHIP.getTitle() + " " + LOTR_FELLOWSHIP.getPrice() +
                    "\n" + DRESDEN_FILES.getTitle() + " " + DRESDEN_FILES.getPrice());
            choice = input.next();
            if (choice.equalsIgnoreCase("Hp")) {
                List.add(Hp_Prisoner.getTitle());
                Price.add(Hp_Prisoner.getPrice());
            } else if (choice.equalsIgnoreCase("LOTR")) {
                List.add(LOTR_FELLOWSHIP.getTitle());
                Price.add(LOTR_FELLOWSHIP.getPrice());
            } else if (choice.equalsIgnoreCase("DF")) {
                List.add(DRESDEN_FILES.getTitle());
                Price.add(DRESDEN_FILES.getPrice());
            }

            System.out.println("Will you add anything else?");
            done = input.next();
        }
            System.out.println("These are the lists of books you have decides to purchase today " + List);
            total(Price);
            System.out.println("\nDo you wish to remove any books from your cart? ");
            choice = input.next();
            if(choice.equalsIgnoreCase("Yes")) {
                System.out.println("Which book do you wish to remove?");
                removal = input.next();
                direction = List.indexOf(removal);
                System.out.println(direction);
                List.remove(removal);
                Price.remove(direction);
            }
        System.out.println("this is your new total");
            total(Price);
    }
    public static void total(ArrayList<Double> price) {
        double total =0;
         for(int i =0;i < price.size(); i++) {
             total +=price.get(i);
         }
        System.out.printf("%,.2f",total);
    }

    }

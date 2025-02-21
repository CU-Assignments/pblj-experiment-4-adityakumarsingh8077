import java.util.*;

class CardCollectionSystem {
    private Set<String> cards = new HashSet<>();

    public void addCard(String card) {
        if (cards.contains(card)) {
            System.out.println("Error: Card \"" + card + "\" already exists.");
        } else {
            cards.add(card);
            System.out.println("Card added: " + card);
        }
    }

    public void findCardsBySuit(String suit) {
        boolean found = false;
        for (String card : cards) {
            if (card.toLowerCase().contains(suit.toLowerCase())) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            System.out.println("All Cards:");
            for (String card : cards) {
                System.out.println(card);
            }
        }
    }

    public void removeCard(String card) {
        if (cards.remove(card)) {
            System.out.println("Card removed: " + card);
        } else {
            System.out.println("Error: Card \"" + card + "\" not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollectionSystem system = new CardCollectionSystem();

        while (true) {
            System.out.println("\n1. Add Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Remove a Card");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter card (e.g., Ace of Spades): ");
                        String newCard = scanner.nextLine();
                        system.addCard(newCard);
                        break;
                    case 2:
                        System.out.print("Enter suit to search (e.g., Hearts): ");
                        String suit = scanner.nextLine();
                        system.findCardsBySuit(suit);
                        break;
                    case 3:
                        system.displayAllCards();
                        break;
                    case 4:
                        System.out.print("Enter card to remove: ");
                        String cardToRemove = scanner.nextLine();
                        system.removeCard(cardToRemove);
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); 
            }
        }
    }
}

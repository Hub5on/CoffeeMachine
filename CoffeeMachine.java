package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void buyOption(String choice) {
        switch (choice) {
            case "1":
                if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups -= 1;
                    printMessage("I have enough resources, making you a coffee!");
                    printActionPrompt();
                } else if (water < 250) {
                    printMessage("Sorry, not enough water!");
                } else if (coffeeBeans < 16) {
                    printMessage("Sorry, not enough coffee beans!");
                } else if (cups < 1) {
                    printMessage("Sorry, not enough disposable cups!");
                }
                break;
            case "2":
                if (water >= 350 && coffeeBeans >= 20 && milk >= 75 && cups >= 1) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups -= 1;
                    printMessage("I have enough resources, making you a coffee!");
                    printActionPrompt();
                } else if (water < 350) {
                    printMessage("Sorry, not enough water!");
                } else if (coffeeBeans < 20) {
                    printMessage("Sorry, not enough coffee beans!");
                } else if (milk < 75) {
                    printMessage("Sorry, not enough milk!");
                } else if (cups < 1) {
                    printMessage("Sorry, not enough disposable cups!");
                }
                break;
            case "3":
                if (water >= 200 && coffeeBeans >= 12 && milk >= 100 && cups >= 1) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups -= 1;
                    printMessage("I have enough resources, making you a coffee!");
                    printActionPrompt();
                } else if (water < 200) {
                    printMessage("Sorry, not enough water!");
                } else if (coffeeBeans < 12) {
                    printMessage("Sorry, not enough coffee beans!");
                } else if (milk < 100) {
                    printMessage("Sorry, not enough milk!");
                } else if (cups < 1) {
                    printMessage("Sorry, not enough disposable cups!");
                }
                break;
            case "back":
                printActionPrompt();
                break;
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printActionPrompt() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void fillOption(int addedWater, int addedMilk, int addedCoffeeBeans, int addedCups) {
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        cups += addedCups;
    }

    public void takeOption() {
        System.out.println("I gave you $" + money + "\n");
        money = 0;
    }

    public void status() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice = scanner.nextLine();
                    coffeeMachine.buyOption(choice);
                    break;

                case "fill":
                    System.out.println("\nWrite how many ml of water do you want to add:");
                    int addedWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int addedMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int addedCoffeeBeans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int addedCups = scanner.nextInt();
                    coffeeMachine.fillOption(addedWater, addedMilk, addedCoffeeBeans, addedCups);
                    break;

                case "take":
                    coffeeMachine.takeOption();
                    break;

                case "remaining":
                    coffeeMachine.status();
                    break;

                case "exit":
                    exit = true;
                    break;
            }
        }
    }
}

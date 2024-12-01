import java.util.Scanner;
import java.util.Set;
import database.*;
import fileIO.*;



public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            FileIO.readFile(args);
            // private static FileIO FileIO = new FileIO();

            while(true){
                showMenu();
                String choice = scanner.nextLine().trim();
                switch(choice){
                    case "1":
                        System.out.println("Search Players");
                        searchPlayers();
                        break;
                    case "2":
                        System.out.println("Search clubs");
                        SearchByClub();

                        break;
                    case "3":
                        System.out.println("Add Player");
                        addPlayer();
                        break;
                    case "4":
                        System.out.println("Exit System");
                        // scanner.close();
                        FileIO.saveData();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        showMenu();
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }

    //main menu
    private static void showMenu() {
        
        System.out.println("Menu:");
        System.out.println("1. Search Players");
        System.out.println("2. Search Clubs");
        System.out.println("3. Add Player");
        System.out.println("4. Exit System");
        System.out.print("Enter your choice: ");
    }

    //sub menu 1
    public static void searchPlayers() {
        
        System.out.println("1. By Name");
        System.out.println("2. By Club and Country");
        System.out.println("3. By Position");
        System.out.println("4. By Salary Range");
        System.out.println("5. Country-wise player count");
        System.out.println("6. Back to main menu");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine();
        
        switch(choice){
            case "1":
                System.out.println("Search Players by Name");
                System.out.print("Enter Player Name: ");
                String playerName = scanner.nextLine();
                Player p = FileIO.getPlayerByName(playerName);
                if(p != null){
                    print(p);
                }
                
                break;


            case "2":
                System.out.println("Search Players by Club and Country");
                System.out.print("Enter Country Name: ");
                String countryName = scanner.nextLine();
                System.out.print("Enter Club Name (Type ANY to display all players): ");
                String clubName = scanner.nextLine();
                Set<Player> players = FileIO.getPlayerByClubAndCountry(clubName, countryName);
                if(players != null){
                    printset(players);
                }
                break;



            case "3":
                System.out.println("Search Players by Position");
                System.out.print("Enter Position: ");
                String position = scanner.nextLine();
                players = FileIO.getPlayerByPosition(position);
                if(players != null){
                    printset(players);
                }
        
                break;


            case "4":
                System.out.println("Search Players by Salary Range");
                System.out.print("Enter Minimum Salary: ");
                String minSalary = scanner.nextLine();
                System.out.print("Enter Maximum Salary: ");
                String maxSalary = scanner.nextLine();
                try {
                    players = FileIO.getPlayerBySalaryRange(Integer.parseInt(minSalary), Integer.parseInt(maxSalary));
                    if(players != null){
                    printset(players);
                }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary input. Please enter valid numbers.");
                }

                
                break;


            case "5":
                System.out.println("Country-wise player count");
                // System.out.print("Enter Country Name: ");
                // String country = scanner.nextLine();
                FileIO.countryWisePlayerCount();
                break;
            case "6":
                System.out.println("Back to main menu");
                showMenu();
                break;
            default:
                System.out.println("Invalid choice");
                searchPlayers();
        }
        

        // scanner.close();
    }
    public static void SearchByClub(){
        
        System.out.println("Search by Club");
        System.out.println("1. Players with maximum salary of a club");
        System.out.println("2. Players with maximum age of a club");
        System.out.println("3. Players with maximum height of a club");
        System.out.println("4. Total yearly salary of a club");
        System.out.println("5. Back to main menu");
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                System.out.print("Enter Club Name: ");
                String clubName = scanner.nextLine();
                Set<Player> players = FileIO.getPlayersWithMaxSalaryInClub(clubName);
                System.out.println("Players with maximum salary in " + clubName);
                printset(players);
                break;
            case "2":
                System.out.print("Enter Club Name: ");
                clubName = scanner.nextLine();
                players = FileIO.getPlayersWithMaxAgeInClub(clubName);
                System.out.println("Players with maximum age in " + clubName);
                printset(players);
                break;
            case "3":
                System.out.print("Enter Club Name: ");
                clubName = scanner.nextLine();
                players = FileIO.getPlayersWithMaxHeightInClub(clubName);
                System.out.println("Players with maximum height in " + clubName);
                printset(players);
                break;
            case "4":
                System.out.print("Enter Club Name: ");
                clubName = scanner.nextLine();
                int totalSalary = FileIO.getTotalSalaryInClub(clubName);
                if(totalSalary == 0){
                    System.out.println("No such club exists");
                    break;
                }
                System.out.println("Total yearly salary of " + clubName + " is " + totalSalary);
                break;
            case "5":
                System.out.println("Back to main menu");
                showMenu();
                break;
            default:
                System.out.println("Invalid choice");
                
                SearchByClub();
                break;
        }
        
    }

    public static double getNumber(){
        try {
            String numberStr = scanner.nextLine();
            double number = Double.parseDouble(numberStr);
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            getNumber();
            return -1;
        }
    }

    public static boolean addPlayer(){
        
        System.out.print("Enter Player Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Country Name: ");
        String country = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = (int)getNumber();

        System.out.print("Enter Height: ");
        double height = getNumber();

        System.out.print("Enter Club Name: ");
        String club = scanner.nextLine();

        System.out.print("Enter Position: ");
        String position = scanner.nextLine();

        System.out.print("Enter Number: ");
        int number = (int)getNumber();

        System.out.print("Enter Weekly Salary: ");
        int weeklySalary = (int)getNumber();

        Player p = new Player(name, country, age, height, club, position, number, weeklySalary);
        FileIO.addPlayer(p);
        if(FileIO.addPlayer(p)){
            System.out.println("Player added successfully");
            print(p);
            return true;
        }
        System.out.println("Player already exists");
        
        return false;
    }
    public static void print(Player p){

        System.out.println(p);
        // System.out.println("Player Details:");
        // System.out.println("Name: " + p.getName());
        // System.out.println("Country: " + p.getCountry());
        // System.out.println("Age: " + p.getAge());
        // System.out.println("Height: " + p.getHeight());
        // System.out.println("Club: " + p.getClub());
        // System.out.println("Position: " + p.getPosition());
        // System.out.println("Number: " + (p.getNumber()==-1?"":p.getNumber()));
        // System.out.println("Weekly Salary: " + p.getWeeklySalary());
        
        // System.out.println();
    }
    public static void printset(Set<Player> set){
        for(Player p : set){
            // System.out.println(p);
            print(p);
        }
    }
}
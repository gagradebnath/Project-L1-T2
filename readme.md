# Java Term Project Part 1

This project is a Java-based application for managing and searching player data. The application allows users to search for players by various criteria, add new players, and save the data to a file.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Files](#files)
- [Classes](#classes)
- [Methods](#methods)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/Java_Term_Project_Part_1.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Java_Term_Project_Part_1/finalProj
    ```
3. Compile the Java files:
    ```sh
    javac -d bin src/*.java
    ```
4. Run the application:
    ```sh
    java -cp bin Main
    ```

## Usage

The application provides a menu-driven interface for interacting with the player database. The main menu options include:
1. Search Players
2. Search Clubs
3. Add Player
4. Exit System

### Search Players

You can search players by:
- Name
- Club and Country
- Position
- Salary Range
- Country-wise player count

### Search Clubs

You can search clubs by:
- Players with maximum salary
- Players with maximum age
- Players with maximum height
- Total yearly salary

### Add Player

You can add a new player by providing details such as name, country, age, height, club, position, number, and weekly salary.

## Files

- `Main.java`: Contains the main class and the menu-driven interface.
- `Player.java`: Defines the `Player` class with attributes and methods.
- `PlayerDB.java`: Manages the player database using various collections.
- `FileIO.java`: Handles reading from and writing to files.
- `Searching.java`: Provides methods for searching players based on different criteria.
- `players.txt`: Contains the initial player data.

## Classes

### Main

The `Main` class contains the main method and the menu-driven interface for interacting with the application.

### Player

The `Player` class represents a player with attributes such as name, country, age, height, club, position, number, and weekly salary.

### PlayerDB

The `PlayerDB` class manages the player database using various collections such as maps and sets.

### FileIO

The `FileIO` class handles reading from and writing to files.

### Searching

The `Searching` class provides methods for searching players based on different criteria.

## Methods

### Main

- `main(String[] args)`: The main method that starts the application.
- `showMenu()`: Displays the main menu.
- `searchPlayers()`: Displays the player search menu.
- `searchByClub()`: Displays the club search menu.
- `addPlayer()`: Adds a new player to the database.
- `print(Player p)`: Prints player details.
- `printSet(Set<Player> set)`: Prints a set of players.

### Player

- `getName()`: Returns the player's name.
- `setName(String name)`: Sets the player's name.
- `getCountry()`: Returns the player's country.
- `setCountry(String country)`: Sets the player's country.
- `getAge()`: Returns the player's age.
- `setAge(int age)`: Sets the player's age.
- `getHeight()`: Returns the player's height.
- `setHeight(double height)`: Sets the player's height.
- `getClub()`: Returns the player's club.
- `setClub(String club)`: Sets the player's club.
- `getPosition()`: Returns the player's position.
- `setPosition(String position)`: Sets the player's position.
- `getNumber()`: Returns the player's number.
- `setNumber(int number)`: Sets the player's number.
- `getWeeklySalary()`: Returns the player's weekly salary.
- `setWeeklySalary(int weeklySalary)`: Sets the player's weekly salary.
- `toString()`: Returns a string representation of the player.

### PlayerDB

- `addPlayer(Player p)`: Adds a player to the database.
- `removePlayer(String name)`: Removes a player from the database.
- `getPlayer(String name)`: Returns a player by name.
- `getPlayersByClub(String club)`: Returns players by club.
- `getPlayersByCountry(String country)`: Returns players by country.
- `getPlayersByPosition(String position)`: Returns players by position.
- `getPlayersBySalary(int salary)`: Returns players by salary.

### FileIO

- `readFile(String[] args)`: Reads player data from a file.
- `saveData()`: Saves player data to a file.

### Searching

- `getPlayerByName(String name)`: Returns a player by name.
- `getPlayerByClubAndCountry(String club, String country)`: Returns players by club and country.
- `getPlayerByPosition(String position)`: Returns players by position.
- `getPlayerBySalaryRange(int minSalary, int maxSalary)`: Returns players by salary range.
- `countryWisePlayerCount()`: Prints the country-wise player count.
- `getPlayersWithMaxSalaryInClub(String club)`: Returns players with maximum salary in a club.
- `getPlayersWithMaxAgeInClub(String club)`: Returns players with maximum age in a club.
- `getPlayersWithMaxHeightInClub(String club)`: Returns players with maximum height in a club.
- `getTotalSalaryInClub(String club)`: Returns the total yearly salary of a club.

Feel free to explore the code and modify it as per your requirements. Happy coding!
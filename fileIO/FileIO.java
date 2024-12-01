package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import database.*;
import search.*;

public class FileIO extends searching{
   private static final String INPUT_FILE_NAME = "database/players.txt";
   private static final String OUTPUT_FILE_NAME = "out.txt";

   public static void readFile(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));

       while (true) {
           String line = br.readLine();
           if (line == null) break;
           Player p = createPlayer(line);
         //   System.out.println(p);
           playerDB.addPlayer(p);            
       }
       br.close();
   }

   public static void saveData() throws Exception {
       BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
       for (Player p : playerDB.players.values()) {
           bw.write(p.toString());
           bw.write(System.lineSeparator());
       }
       bw.close();
   }


   //create Player object from line
   private static Player createPlayer(String line){
       String[] parts = line.split(",");
           String name = parts[0].trim();
           String country = parts[1].trim();
           int age = Integer.parseInt(parts[2].trim());
           double height = Double.parseDouble(parts[3].trim());
           String club = parts[4].trim();
           String position = parts[5].trim();
           int number = parts[6].trim().isEmpty() ? -1 : Integer.parseInt(parts[6].trim());
           int weeklySalary = Integer.parseInt(parts[7].trim());
           Player p = new Player(name, country, age, height, club, position, number, weeklySalary);
           return p;
   }
}
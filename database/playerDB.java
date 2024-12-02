package database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class playerDB{
    public static Map<String, Player> players=new HashMap<>();
	public static Map<String, Set<Player>> clubs=new HashMap<>();
    public static Map<String, Set<Player>> countries=new HashMap<>();
    public static Map<String, Set<Player>> positions=new HashMap<>();
    public static Map<Integer, Set<Player>> salaries=new HashMap<>();

    //add player to database
    public static boolean addPlayer(Player p) {

        //if Player already exists, return false
		if(players.containsKey(p.getName())){
            return false;
        }
        players.put(p.getName(), p);

        //if club does not exist, create a new set
        if(!clubs.containsKey(p.getClub())){
            clubs.put(p.getClub(), new HashSet<>());
        }
        clubs.get(p.getClub()).add(p);

        //if country does not exist, create a new set
        if(!countries.containsKey(p.getCountry())){
            countries.put(p.getCountry(), new HashSet<>());
        }
        countries.get(p.getCountry()).add(p);

        //if position does not exist, create a new set
        if(!positions.containsKey(p.getPosition())){
            positions.put(p.getPosition(), new HashSet<>());
        }
        positions.get(p.getPosition()).add(p);

        //if salary does not exist, create a new set
        if(!salaries.containsKey(p.getWeeklySalary())){
            salaries.put(p.getWeeklySalary(), new HashSet<>());
        }
        salaries.get(p.getWeeklySalary()).add(p);

		return true;
	}

    //remove player from database
    public static boolean removePlayer(String name) {
        if(!players.containsKey(name)){
            return false;
        }
        Player p = players.get(name);
        players.remove(name);
        clubs.get(p.getClub()).remove(p);
        countries.get(p.getCountry()).remove(p);
        positions.get(p.getPosition()).remove(p);
        salaries.get(p.getWeeklySalary()).remove(p);
        return true;
    }


    //get player by name
    public static Player getPlayer(String name){
        if(!players.containsKey(name)){
            System.out.println("No such player exists");
            return null;
        }
        return players.get(name);
    }
    //get player by club
    public static Set<Player> getPlayersByClub(String club){
        if(!clubs.containsKey(club)){
            System.out.println("No such club exists");
            return null;
        }
        return clubs.get(club);
    }
    //get player by country
    public static Set<Player> getPlayersByCountry(String country){
        if(!countries.containsKey(country)){
            System.out.println("No such country exists");
            return null;
        }
        return countries.get(country);
    }
    //get player by position
    public static Set<Player> getPlayersByPosition(String position){
        if(!positions.containsKey(position)){
            System.out.println("No such position exists");
            return null;
        }
        return positions.get(position);
    }
    //get player by salary
    public static Set<Player> getPlayersBySalary(int salary){
        if(!salaries.containsKey(salary)){
            System.out.println("No such salary exists");
            return null;
        }
        return salaries.get(salary);
    }

    //get nearest possible key value from map
    public static int getPlayerCount(Set<Player> set){
        return set.size();
    }

    

}
   

package search;

import java.util.Set;
import java.util.HashSet;

import database.*;

public class searching extends playerDB{


    //player stuff...............................

    final public static Player getPlayerByName(String name) {
        if(playerDB.players.containsKey(name)){
            return playerDB.players.get(name);
        }
        System.out.println("No such Player with this name");
        return null;
    }
    

    //search Player by club and country

	final public static Set<Player> getPlayerByClubAndCountry(String club, String country) {

        if(club.trim().toLowerCase().equals("all") && playerDB.countries.containsKey(country)){
            return playerDB.countries.get(country);
        }
        else{
            if(playerDB.clubs.containsKey(club) && playerDB.countries.containsKey(country)){
                Set<Player> clubPlayers=playerDB.clubs.get(club);
                Set<Player> countryPlayers=playerDB.countries.get(country);
                Set<Player> result=new HashSet<>();
                for(Player p : countryPlayers){
                    if(clubPlayers.contains(p)){
                        result.add(p);
                    }
                }
                return result;
            }
        }
        // if((playerDB.clubs.containsKey(club)||club.trim().toLowerCase().equals("all")) && playerDB.countries.containsKey(country)){
        //     Set<Player> clubPlayers=playerDB.clubs.get(club);
        //     Set<Player> countryPlayers=playerDB.countries.get(country);
        //     Set<Player> result=new HashSet<>();
        //     for(Player p : countryPlayers){
        //         if(clubPlayers.contains(p)||club.trim().toLowerCase().equals("all")){
        //             result.add(p);
        //         }
        //     }
        //     return result;
        // }
        System.out.println("No such Player with this country and club");
        return new HashSet<Player>();
	}


    //search Player by position

    final public static Set<Player> getPlayerByPosition(String position) {
        if(playerDB.positions.containsKey(position)){
            return playerDB.positions.get(position);
        }
        System.out.println("No such Player with this position");
        return new HashSet<>();
    }

    //search Player by salary range

	final public static Set<Player> getPlayerBySalaryRange(int minSalary, int maxSalary) {
        Set<Player> result=new HashSet<>();
        for(int i=minSalary;i<=maxSalary;i++){
            if(playerDB.salaries.containsKey(i)){
                result.addAll(playerDB.salaries.get(i));
            }
        }
        if(result.size()>0){
            return result;
        }
        System.out.println("No such Player with this salary range");
        return result;
	}

    //country wise Player count

    final public static void countryWisePlayerCount() {
        for(String country : playerDB.countries.keySet()){
            System.out.println(country+" : "+playerDB.countries.get(country).size());
        }
        return;
    }



    //club stuff..........................

    final public static Set<Player> getPlayersWithMaxSalaryInClub(String club){
        Set<Player> playersInClub = get(club);
        int maxSalary = -1;
        Set<Player> result = new HashSet<>();
        for(Player p : playersInClub){
            if(p.getWeeklySalary() > maxSalary){
                maxSalary = p.getWeeklySalary();
            }
        }
        for(Player p : playersInClub){
            if(p.getWeeklySalary() == maxSalary){
                result.add(p);
            }
        }
        return result;
   }

   final public static Set<Player> getPlayersWithMaxAgeInClub(String club){
        Set<Player> playersInClub = get(club);
        int maxAge = -1;
        Set<Player> result = new HashSet<>();
        for(Player p : playersInClub){
            if(p.getAge() > maxAge){
                maxAge = p.getAge();
            }
        }
        for(Player p : playersInClub){
            if(p.getAge() == maxAge){
                result.add(p);
            }
        }
        return result;
   }

   final public static Set<Player> getPlayersWithMaxHeightInClub(String club){
        Set<Player> playersInClub = get(club);
        double maxHeight = -1;
        Set<Player> result = new HashSet<>();
        for(Player p : playersInClub){
            if(p.getHeight() > maxHeight){
                maxHeight = p.getHeight();
            }
        }
        for(Player p : playersInClub){
            if(p.getHeight() == maxHeight){
                result.add(p);
            }
        }
        return result;
   }

   final public static int getTotalSalaryInClub(String club){
        Set<Player> playersInClub = get(club);
        int totalSalary = 0;
        for(Player p : playersInClub){
            totalSalary += p.getWeeklySalary()*52;
        }
        return totalSalary;
   }

   private static Set<Player> get(String club){
        if(playerDB.clubs.containsKey(club)){
            return playerDB.clubs.get(club);
        }
        System.out.println("No such club");
        return new HashSet<>();
   }


}
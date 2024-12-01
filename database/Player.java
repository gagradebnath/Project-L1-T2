package database;

public class Player {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private int weeklySalary;

    public Player(String name, String country, int age, double height, String club, String position, int number, int weeklySalary) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.club = club;
        this.position = position;
        this.number = number;
        this.weeklySalary = weeklySalary;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getClub() {
        return this.club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeeklySalary() {
        return this.weeklySalary;
    }

    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        if(getNumber() == -1){
            return getName() +
            "," + getCountry()+
            "," + getAge() + 
            "," + getHeight() +
            "," + getClub() +
            "," + getPosition() +
            ",," + getWeeklySalary() ;
        }
        return getName() +
            "," + getCountry()+
            "," + getAge() + 
            "," + getHeight() +
            "," + getClub() +
            "," + getPosition() +
            "," + getNumber() +
            "," + getWeeklySalary() ;
    }


}


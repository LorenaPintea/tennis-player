package springdata.tennisplayer;

import java.sql.Date;
import java.sql.Time;

public class Player {
    private int id;
    private String name;
    private String nationality;
    private Date birthday;
    private int titles;

    public Player() {
    }

    public Player(int id, String name, String nationality, Date birthday, int titles) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthday = birthday;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getTitles() {
        return titles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthday=" + birthday +
                ", titles=" + titles +
                '}';
    }
}

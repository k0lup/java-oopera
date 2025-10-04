package staff;

import java.util.Objects;

public class Director extends Person {
   private int numberOfShows;

    public Director(String name, String surName, Gender gender, int numberOfShows) {
        super(name, surName, gender);
        if (numberOfShows < 0) {
            System.out.println("Количество поставленных спектаклей не может быть отрицательным числом");
            this.numberOfShows = 0;
        } else {
            this.numberOfShows = numberOfShows;
        }
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    public void setNumberOfShows(int numberOfShows) {
        this.numberOfShows = numberOfShows;
    }

    public void addOneShows() {
        this.numberOfShows += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return numberOfShows == director.numberOfShows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfShows);
    }

    @Override
    public String toString() {
        return "staff.Director{" +
                "numberOfShows=" + numberOfShows +
                ", " + super.toString() + '\'' +
                '}';
    }
}

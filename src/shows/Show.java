package shows;

import staff.Actor;
import staff.Director;

import java.util.ArrayList;
import java.util.Objects;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        if (title.isEmpty()) {
            System.out.println("Название не может быть пустым!");
            this.title = "Спектакль";
        } else {
            this.title = title;
        }
        if (duration <= 0) {
            System.out.println("Продолжительность спектакля должна быть больше 0 минут!"
                    + "Будет подставлено значение по умолчанию!");
            this.duration = 90;
        } else {
            this.duration = duration;
        }
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public boolean addNewActor(Actor actor) {
        if (checkActor(actor)){
            System.out.println("Такой актер уже есть в списке актеров этого спектакля!");
            return false;
        }
        listOfActors.add(actor);
        System.out.println("Добавили актера: " + actor);
        return true;
    }

    public boolean checkActor(Actor actor) {
        return listOfActors.contains(actor);
    }

    public boolean replaceActor(Actor oldActor, Actor newActor) {
        if (!checkActor(oldActor)){
            System.out.println("Актера: " + oldActor + " нет в списке актеров этого спектакля!");
            return false;
        }
        listOfActors.remove(oldActor);
        listOfActors.add(newActor);
        System.out.println("Заменили актера: " + oldActor + " на актера: " + newActor);
        return true;
    }

    @Override
    public String toString() {
        return "shows.Show{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", director=" + director +
                ", listOfActors=" + listOfActors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return duration == show.duration && Objects.equals(title, show.title) && Objects.equals(director, show.director)
                && Objects.equals(listOfActors, show.listOfActors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration, director, listOfActors);
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void setListOfActors(ArrayList<Actor> listOfActors) {
        this.listOfActors = listOfActors;
    }
}

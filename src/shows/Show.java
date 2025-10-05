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
        if (listOfActors.contains(actor)){
            System.out.println("Такой актер уже есть в списке актеров этого спектакля!");
            return false;
        }
        listOfActors.add(actor);
        System.out.println("Добавили актера: " + actor);
        return true;
    }



    public boolean replaceActor(Actor newActor, String surNameOldActor) {
        if (surNameOldActor == null || surNameOldActor.isEmpty()){
            System.out.println("Фамилия актера, которого необходимо заменить не должна быть пустой!");
            return false;
        }
        Actor oldActor = null;
        for (Actor actor : listOfActors){
            if (actor.getSurName().equals(surNameOldActor)){
                oldActor = actor;
                break;
            }
        }
        if (oldActor == null){
            System.out.println("Такого актера нет в списке");
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

    public String printDirectorInfo() {
        return "Имя режиссера: " + director.getName() + "\nФамилия режиссера: " + director.getSurName();
    }

    public String printActors(){
        if (listOfActors.isEmpty()){
            return "Пока на данный спектакль не назначили ни одного актера";
        }
        String result = "Список актеров:\n";
        for (Actor actor : listOfActors){
            result += "Имя актера: " + actor.getName() + "\nФамилия актера: " + actor.getSurName() + "\nРост актера: "
                    + actor.getHeight() + "\n\n";
        }
        return result;
    }
}

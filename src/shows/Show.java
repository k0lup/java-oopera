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
        if (listOfActors.contains(actor)) {
            System.out.println("Такой актер уже есть в списке актеров этого спектакля!");
            return false;
        }
        listOfActors.add(actor);
        System.out.println("Добавили актера: " + actor);
        return true;
    }



    public boolean replaceActor(Actor newActor, String surNameOldActor) {
        if (surNameOldActor == null || surNameOldActor.isEmpty()) {
            System.out.println("Фамилия актера, которого необходимо заменить не должна быть пустой!");
            return false;
        }
        if (newActor == null){
            System.out.println("Новый актер для добавления в список должен существовать!");
            return false;
        }

        int countReplace = 0;

        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (surNameOldActor.equals(actor.getSurName())) {
                System.out.println("Заменили актера: " + actor + " на актера: " + newActor);
                listOfActors.set(i, newActor);
                countReplace++;
            }
        }
        if (countReplace == 0) {
            System.out.println("Такого актера нет в списке");
            return false;
        }
        System.out.println("Всего заменили " + countReplace + " актера(ов)!");
        return true;
    }

    public void printDirectorInfo() {
        System.out.println("Имя режиссера: " + director.getName() + "\nФамилия режиссера: " + director.getSurName());
    }

    public void printActors() {
        if (listOfActors.isEmpty()) {
            System.out.println("Пока на данный спектакль не назначили ни одного актера");
            return;
        }
        StringBuilder result = new StringBuilder("Список актеров:\n");
        for (Actor actor : listOfActors) {
            result.append("Имя актера: ").append(actor.getName()).append("\nФамилия актера: ")
                    .append(actor.getSurName()).append("\nРост актера: ").append(actor.getHeight()).append("\n\n");
        }
        System.out.println(result);
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

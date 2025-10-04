import shows.Ballet;
import shows.Opera;
import shows.Show;
import staff.Actor;
import staff.Director;
import staff.Gender;
import staff.Person;

import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        Actor actor1 = new Actor("Василий", "Васильев", 180, Gender.MALE);
        Actor actor2 = new Actor("Аркадий", "Аркадьев", 191.2, Gender.MALE);
        Actor actor3 = new Actor("Василиса", "Васильева", 161.1, Gender.FEMALE);

        ArrayList<Actor> actorsForShow = new ArrayList<>();
        actorsForShow.add(actor1);
        actorsForShow.add(actor3);

        ArrayList<Actor> actorsForOpera = new ArrayList<>();
        actorsForOpera.add(actor2);
        actorsForOpera.add(actor3);

        ArrayList<Actor> actorsForBallet = new ArrayList<>();
        actorsForBallet.add(actor1);
        actorsForBallet.add(actor2);

        Show show = new Show("Обычный спектакль", 90, new Director("Семен", "Семенов",
                Gender.MALE, 1), actorsForShow);

        Opera opera = new Opera(5, new Person("Игорь", "Кузнецов", Gender.MALE),
                "либретто оперы", "Обычный спектакль", 90,
                new Director("Семен", "Семенов",
                Gender.MALE, 1), actorsForOpera);

        Ballet ballet = new Ballet(new Person("Павел", "Кузнецов", Gender.MALE),
                new Person("Игорь", "Кузнецов", Gender.MALE),
                "либретто балета", "Обычный спектакль", 90,
                new Director("Семен", "Семенов",
                        Gender.MALE, 1), actorsForBallet);

        System.out.println(show.getListOfActors());
        System.out.println(opera.getListOfActors());
        System.out.println(ballet.getListOfActors());

        show.replaceActor(actor1, actor2);
        System.out.println(show.getListOfActors());

        show.replaceActor(actor1, actor2);

        System.out.println(opera.getLibrettoText());
        System.out.println(ballet.getLibrettoText());
    }
}

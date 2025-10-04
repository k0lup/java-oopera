package shows;

import staff.Actor;
import staff.Director;
import staff.Person;

import java.util.ArrayList;
import java.util.Objects;

public class Opera extends MusicalShow {
    private final int choirSize;

    public Opera(int choirSize, Person musicAuthor, String librettoText, String title, int duration,
                 Director director, ArrayList<Actor> listOfActors) {
        super(musicAuthor, librettoText, title, duration, director,
                listOfActors);
        this.choirSize = choirSize;
    }

    @Override
    public String toString() {
        return "shows.Opera{" +
                "choirSize=" + choirSize +
                ", " + super.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Opera opera = (Opera) o;
        return choirSize == opera.choirSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), choirSize);
    }

    public int getChoirSize() {
        return choirSize;
    }
}

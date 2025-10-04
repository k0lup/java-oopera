package shows;

import staff.Actor;
import staff.Director;
import staff.Person;

import java.util.ArrayList;
import java.util.Objects;

public class Ballet extends MusicalShow {
    private final Person choreographer;
    public Ballet(Person choreographer, Person musicAuthor, String librettoText, String title, int duration,
                  Director director, ArrayList<Actor> listOfActors) {
        super(musicAuthor, librettoText, title, duration, director,
                listOfActors);
        this.choreographer= choreographer;
    }

    public Person getChoreographer() {
        return choreographer;
    }

    @Override
    public String toString() {
        return "shows.Ballet{" +
                "choreographer=" + choreographer +
                ", " + super.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ballet ballet = (Ballet) o;
        return Objects.equals(choreographer, ballet.choreographer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), choreographer);
    }
}

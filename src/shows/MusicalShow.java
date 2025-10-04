package shows;

import staff.Actor;
import staff.Director;
import staff.Person;

import java.util.ArrayList;
import java.util.Objects;

public class MusicalShow extends Show {
    private final Person musicAuthor;
    private final String librettoText;

    public MusicalShow(Person musicAuthor, String librettoText, String title, int duration, Director director,
                       ArrayList<Actor> listOfActors) {
        super(title, duration, director, listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    @Override
    public String toString() {
        return "shows.MusicalShow{" +
                "musicAuthor=" + musicAuthor +
                ", librettoText='" + librettoText + '\'' +
                ", " + super.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MusicalShow that = (MusicalShow) o;
        return Objects.equals(musicAuthor, that.musicAuthor) && Objects.equals(librettoText, that.librettoText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), musicAuthor, librettoText);
    }

    public Person getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }
}

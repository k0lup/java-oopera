package staff;

import java.util.Objects;

public class Actor extends Person {
    private final double height;
    public Actor(String name, String surName, double height, Gender gender) {
        super(name, surName, gender);
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Actor actor = (Actor) o;
        return Double.compare(height, actor.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }

    @Override
    public String toString() {
        return "staff.Actor{" +
                "height=" + height +
                ", " + super.toString() + '\'' +
                '}';
    }
}

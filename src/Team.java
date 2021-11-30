import java.io.Serializable;

public class Team implements Serializable {
    String name;
    String city;
    int place;
    int victories;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", place=" + place +
                ", victories=" + victories +
                '}';
    }
}

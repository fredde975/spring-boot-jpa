package ft.domain;

import javax.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private int classification;
    private boolean open;

    public Hotel() {
        //empty constructor required by jpa
    }

    public Hotel(String name, int classification, boolean open) {
        this.name = name;
        this.classification = classification;
        this.open = open;
    }

    public String getName() {
        return name;
    }

    public int getClassification() {
        return classification;
    }

    public boolean isOpen() {
        return open;
    }

    public long getId() {
        return id;
    }
}

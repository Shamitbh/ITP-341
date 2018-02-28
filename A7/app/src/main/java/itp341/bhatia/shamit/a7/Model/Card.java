package itp341.bhatia.shamit.a7.Model;

import java.io.Serializable;

public class Card implements Serializable {
    private String number;
    private String name;

    public Card(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


package functional;

import java.io.Serializable;
import java.util.ArrayList;

public class Participant implements Serializable {
    private String name;
    private String surname;
    private String placeOfWork;
    private String report;
    private String email;

    public Participant(String name, String surnaname, String placeOfWork,String report, String email) {
        this.name = name;
        this.surname = surnaname;
        this.placeOfWork = placeOfWork;
        this.report=report;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurnaname(String surnaname) {
        this.surname = surnaname;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "name: " + name +
                ", surname: " + surname +
                ", placeOfWork: " + placeOfWork +
                ", report: "+report+
                ", email: " + email;
    }
}

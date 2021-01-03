package ehu.isad.model;

import javafx.beans.property.BooleanProperty;

public class Pertsona {
    private String firstName;
    private String lastName;
    private String sport;
    private int years;
    private Boolean vegetarian;
    private String irudiPath;

    public Pertsona(String firstName, String lastName, String sport, int years, Boolean vegetarian, String irudiPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.years = years;
        this.vegetarian = vegetarian;
        this.irudiPath = irudiPath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }


    public String getIrudiPath() {
        return irudiPath;
    }

    public void setIrudiPath(String irudiPath) {
        this.irudiPath = irudiPath;
    }
}

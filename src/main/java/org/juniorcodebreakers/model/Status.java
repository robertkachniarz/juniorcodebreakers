package org.juniorcodebreakers.model;

public enum Status { //Enum okresla status w jakim znajduje sie rower

    RENTED,//rower wypozyczony
    AVAILABLE,//rower dostepny
    IN_REPAIR,//rower w naprawie
    STOLEN,//Radek ukradl rower
    READY_TO_DISTRIBUTION ;//swiezo kupiony gotowy do dystrybucji
}

 /*   RENTED(1),//rower wypozyczony
    AVAILABLE(2),//rower dostepny
    IN_REPAIR(3),//rower w naprawie
    STOLEN(4),//Radek ukradl rower
    READY_TO_DISTRIBUTION(5) ;//swiezo kupiony gotowy do dystrybucji

    private int i;
    Status(int i) {
        this.i=i;

    }

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
}*/

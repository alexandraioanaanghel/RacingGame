package org.alexandraanghel;

public class Car {

    //Agreagare Masini nostre ii adaugam un motor. O masina are un motor. Relatia has a
    //Aggregation "has-a"

    String name;
    double fuelLevel;
    double mileage; //consum
    double totalTraveledDistance;
    double maxSpeed;
    int doorCount;
    boolean damaged;
    String color;
    //Aggregation "has-a" relationship
    Engine engine;


    //Agregare intregul are sens si fara componenta si componenta are sens si in afara intregului. Iau motorul si il pun la o barca
    //Agregarea nu este o relatie chiar atat de stransa
    //Compositie o relatie mai stransa tot "has-a"

    //Primitive Data Types:
    // byte (cand lucram cu fis binare), short, int, long(pt intreg, pt milisecunde, pt id din baza de date), float, double, boolean, char

    //Wrapper(impachetare) class
    // Double testDouble;
    // Integer testInt;
    // Character testChar;
}

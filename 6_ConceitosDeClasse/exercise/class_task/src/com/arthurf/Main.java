package com.arthurf;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Nova instância da classe bike
        Bycicle bike = new Bycicle();

        // Utilização de métodos da classe
        bike.changeCadence(10);
        bike.speedUp(20);
        bike.changeGear(3);
        bike.printStates();
    }
}
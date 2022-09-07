package fr.ensicaen.ecole.genielogiciel.model;

public class DiceModel implements IDiceModel {
    @Override
    public int roll() {
        return (int) ((Math.random()*6)+1);
    }
}

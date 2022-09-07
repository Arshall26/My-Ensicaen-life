package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.effect.Effect;
import fr.ensicaen.ecole.genielogiciel.model.effect.EffectFactory;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

import java.util.Random;

public class SquareModel implements ISquareModel {
    private final int _id;
    private final Speciality _speciality;
    private Effect _effect;

    public SquareModel(int squareID){
        _id = squareID;
        _speciality = Speciality.Normal;
    }

    public static ISquareModel randomSquare(int squareID) {
        Speciality speciality;
        int examLevel = 0;
        //Les 15 premieres cases ne sont pas sujettes aux examens
        if(squareID<15){
            ISquareModel.Speciality[] specialities = ISquareModel.Speciality.values();
            //On ne tire pas d'examens ni de redoublement
            int x = new Random().nextInt(specialities.length-3);
            speciality = specialities[x];
        }
        else{
            ISquareModel.Speciality[] specialities = ISquareModel.Speciality.values();
            //On tire de tout sauf la case Diplome, réservé à la dernière case
            int x = new Random().nextInt(specialities.length-1);
            speciality = specialities[x];
            //Gestion du niveau de l'examen
            if (speciality==Speciality.Examen){
                //Les examens deviennent de plus en plus exigeant au fil de la partie
                examLevel= new Random().nextInt(squareID);
            }
        }
        Effect effect = EffectFactory.createEffect(speciality, examLevel);
        return new SquareModel(squareID, speciality, effect);
    }

    public SquareModel(int squareID, Speciality speciality, Effect effect) {
        _id = squareID;
        _speciality = speciality;
        _effect = effect;
    }

    @Override
    public int getSquareID() {
        return _id;
    }

    @Override
    public Speciality getSpeciality() {
        return _speciality;
    }
    public int effect(PlayerModel player) {
        return _effect.execute(player);
    }
}


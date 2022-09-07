package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;

public class EffectFactory {
    public static Effect createEffect(ISquareModel.Speciality speciality, int examLevel) {
        Effect effect = null;

        if (
            speciality == ISquareModel.Speciality.Enseignement_Economie ||
            speciality == ISquareModel.Speciality.Enseignement_Maths ||
            speciality == ISquareModel.Speciality.Enseignement_Info ||
            speciality == ISquareModel.Speciality.Enseignement_Anglais
        ) {
            effect = new EffectLearn();
        } else if (speciality == ISquareModel.Speciality.Examen) {
            effect = new EffectExam(examLevel);
        } else if (speciality == ISquareModel.Speciality.Redoublement) {
            effect = new EffectReset();
        } else if (speciality == ISquareModel.Speciality.Antiseche) {
            effect = new EffectBonusMalus(6);
        } else if (speciality == ISquareModel.Speciality.Jeudi) {
            effect = new EffectSkip();
        } else if (speciality == ISquareModel.Speciality.Soiree) {
            effect = new EffectParty();
        } else if (
            speciality == ISquareModel.Speciality.Diplome ||
            speciality == ISquareModel.Speciality.Normal
        ) {
            effect = new EffectNone();
        }

        return effect;
    }
}

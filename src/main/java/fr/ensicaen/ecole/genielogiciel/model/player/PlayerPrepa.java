package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.SquareModel;

public class PlayerPrepa extends PlayerHardSkillDecorator {
    public PlayerPrepa(PlayerModel player) {
        super(player);
    }

    @Override
    public int getHardSkillBonus(SquareModel square) {
        ISquareModel.Speciality speciality = square.getSpeciality();
        if (speciality == ISquareModel.Speciality.Enseignement_Info) {
            return -1;
        }
        if (speciality == ISquareModel.Speciality.Enseignement_Maths) {
            return 1;
        }
        return 0;
    }
}

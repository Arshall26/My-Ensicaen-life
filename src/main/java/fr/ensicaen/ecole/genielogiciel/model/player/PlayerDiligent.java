package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.SquareModel;

public class PlayerDiligent extends PlayerModel {
    public PlayerDiligent(int id, String username, ISquareModel square, SoftSkill softSkill, HardSkill hardSkill) {
        super(id, username, square, softSkill, hardSkill);
    }

    @Override
    public int getSoftSkillBonus() {
        return 0;
    }

    @Override
    public int getHardSkillBonus(SquareModel square) {
        return 0;
    }
}
package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.SquareModel;

public class PlayerLicence extends PlayerHardSkillDecorator {
    public PlayerLicence(PlayerModel player) {
        super(player);
    }

    @Override
    public int getHardSkillBonus(SquareModel square) {
        return 0;
    }
}

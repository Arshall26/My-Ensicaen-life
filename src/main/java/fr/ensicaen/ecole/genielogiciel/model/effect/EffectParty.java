package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectParty extends Effect {
    @Override
    public int execute(PlayerModel player) {
        player.setSkipTurn(true);
        player.incrementSkillLevel(-2);
        return 0;
    }
}

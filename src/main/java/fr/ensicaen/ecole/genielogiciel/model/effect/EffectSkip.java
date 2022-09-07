package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectSkip extends Effect {
    @Override
    public int execute(PlayerModel player) {
        player.setSkipTurn(true);
        return 0;
    }
}

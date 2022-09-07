package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectReset extends Effect {
    @Override
    public int execute(PlayerModel player) {
        // TODO: Find better way
        return -1000;
    }
}

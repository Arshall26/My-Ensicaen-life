package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectNone extends Effect {
    public int execute(PlayerModel player) {
        return 0;
    }
}

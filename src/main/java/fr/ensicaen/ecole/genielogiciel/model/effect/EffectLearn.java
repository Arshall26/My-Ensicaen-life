package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectLearn extends Effect {
    public int execute(PlayerModel player) {
        player.incrementSkillLevel(1);
        return 0;
    }
}

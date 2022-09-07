package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectBonusMalus extends Effect {
    private final int _bonusMalus;

    public EffectBonusMalus(int bonusMalus) {
        super();
        _bonusMalus = bonusMalus;
    }

    @Override
    public int execute(PlayerModel player) {
        return _bonusMalus;
    }
}

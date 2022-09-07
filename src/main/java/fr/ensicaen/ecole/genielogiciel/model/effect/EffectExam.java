package fr.ensicaen.ecole.genielogiciel.model.effect;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public class EffectExam extends Effect {
    private final int _examLevel;

    public EffectExam(int examLevel) {
        _examLevel = examLevel;
    }

    public int execute(PlayerModel player) {
        if (player.getSkillLevel() < _examLevel) {
            return -6;
        }
        return 0;
    }
}

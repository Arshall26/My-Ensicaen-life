package fr.ensicaen.ecole.genielogiciel.model.player;

public abstract class PlayerHardSkillDecorator extends PlayerModel {
    protected final PlayerModel _player;

    public PlayerHardSkillDecorator(PlayerModel player) {
        super(player.getPlayerID(), player.getPlayerUsername(), player.getSquare(), player.getSoftSkill(), player.getHardSkill());
        _player=player;
    }

    @Override
    public int getSoftSkillBonus() {
        return _player.getSoftSkillBonus();
    }
}

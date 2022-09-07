package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.SquareModel;

public abstract class PlayerModel {
    public enum SoftSkill {
        Dilettante,
        Diligent,
        Brilliant,
    }
    public enum HardSkill {
        Prepa,
        DUT,
        Licence
    }

    private final int _id;
    private ISquareModel _square;
    private final SoftSkill _softSkill;
    private final HardSkill _hardSkill;
    private final String _name;
    private final String _username;
    private int _skillLevel;
    private boolean _skipTurn;

    public PlayerModel(int id, String username, ISquareModel square, SoftSkill softSkill, HardSkill hardSkill) {
        _id = id;
        _square = square;
        _name = "P" + (id+1);
        _username = username;
        _skipTurn = false;
        _skillLevel = 0;

        _softSkill = softSkill;
        _hardSkill = hardSkill;
    }

    public ISquareModel getSquare() {
        return _square;
    }

    public void setSquare(ISquareModel square) {
        _square = square;
    }

    public boolean getSkipTurn() {
        return _skipTurn;
    }

    public void setSkipTurn(boolean bool) {
        _skipTurn=bool;
    }

    public int getPlayerID() {
        return _id;
    }

    public String getPlayerName() {
        return _name;
    }

    public String getPlayerUsername() {
        return _username;
    }

    public SoftSkill getSoftSkill() {
        return _softSkill;
    }

    public String getSoftSkillString() {
        return _softSkill.name();
    }

    public HardSkill getHardSkill() {
        return _hardSkill;
    }

    public String getHardSkillString() {
        return _hardSkill.name();
    }

    public int getSkillLevel() {
        return _skillLevel;
    }

    public void incrementSkillLevel(int nb){
        _skillLevel+=nb;
    }

    public abstract int getSoftSkillBonus();
    public abstract int getHardSkillBonus(SquareModel square);
}

package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.IServerModel;
import fr.ensicaen.ecole.genielogiciel.model.ProxyServerModel;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

import java.io.IOException;

public class SalaryPresenter implements ISalaryPresenter{
    private float _baseSalary;
    private final IServerModel _serverModel;

    public SalaryPresenter() {
        _serverModel = new ProxyServerModel();
        _baseSalary = 0;
    }

    public void retrieveBaseSalary() {
        try {
            _baseSalary = _serverModel.parseSalary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float computePlayerSalary(PlayerModel[] players, PlayerModel player) {
        int max_skill = player_max_skill(players);
        float skillPercent = 0.0F;
        if (player.getSkillLevel() > 0) {
            skillPercent = (max_skill - (max_skill - player.getSkillLevel())) / (float) max_skill;
        }
        return _baseSalary + skillPercent*_baseSalary;
    }

    private int player_max_skill(PlayerModel[] players){
        int max_skill = players[0].getSkillLevel();
        for (PlayerModel player : players) {
            int skill_i = player.getSkillLevel();
            if (skill_i > max_skill) {
                max_skill = skill_i;
            }
        }
        return max_skill;
    }

}

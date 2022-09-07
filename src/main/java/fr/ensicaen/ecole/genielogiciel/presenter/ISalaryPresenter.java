package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public interface ISalaryPresenter {
    float computePlayerSalary(PlayerModel[] players, PlayerModel player);
    void retrieveBaseSalary();
}

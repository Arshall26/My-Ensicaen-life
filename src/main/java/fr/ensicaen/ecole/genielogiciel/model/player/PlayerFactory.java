package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;

import java.util.Random;

public class PlayerFactory {
    public static PlayerModel createPlayer(int id, String username, String hardSkill, ISquareModel square) {
        PlayerModel player;

        PlayerModel.HardSkill hSkill = PlayerModel.HardSkill.valueOf(hardSkill);

        // Pick a random SoftSkill
        PlayerModel.SoftSkill[] softSkills = PlayerModel.SoftSkill.values();
        int x = new Random().nextInt(softSkills.length);
        PlayerModel.SoftSkill softSkill = softSkills[x];

        if (softSkill == PlayerModel.SoftSkill.Diligent) {
            player = new PlayerDiligent(
                    id,
                    username,
                    square,
                    softSkill,
                    hSkill
            );
        } else if (softSkill == PlayerModel.SoftSkill.Brilliant) {
            player = new PlayerBrilliant(
                    id,
                    username,
                    square,
                    softSkill,
                    hSkill
            );
        } else { // DILETTANTE
            player = new PlayerDilettante(
                    id,
                    username,
                    square,
                    softSkill,
                    hSkill
            );
        }

        if (hSkill == PlayerModel.HardSkill.DUT) {
            player = new PlayerDUT(player);
        } else if (hSkill == PlayerModel.HardSkill.Licence) {
            player = new PlayerLicence(player);
        } else if (hSkill == PlayerModel.HardSkill.Prepa) {
            player = new PlayerPrepa(player);
        }

        return player;
    }
}

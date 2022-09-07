package fr.ensicaen.ecole.genielogiciel.presenter;

public interface IGamePresenter {
    void runGameTurn();
    IBoardPresenter getBoardPresenter();
    IPlayerPresenter getPlayerPresenter();
    ISalaryPresenter getSalaryPresenter();
}
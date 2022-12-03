package controller;

import util.Position;

public interface Model {
    Position randomPosition();
    void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber, int mountainsNumber, int roadNumber, int rockNumber);
    void activation();
}

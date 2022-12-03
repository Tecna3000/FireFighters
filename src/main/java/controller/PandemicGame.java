package controller;



public class PandemicGame extends Movement implements Model{


    public PandemicGame(PandemicGrid grid) {
        super(0,1);

        //  super(grid.rowCount, grid.colCount);

    }


    @Override
    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber, int mountainsNumber, int roadNumber, int rockNumber) {

    }

    @Override
    public void activation() {

    }
}

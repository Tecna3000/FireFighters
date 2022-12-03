package controller;


import pandemic.Doctors;
import pandemic.People;
import pandemic.Virus;

public class PandemicGame extends Movement implements Model{

     final Doctors doctors ;
     public final Virus virus ;
     final People people;

    public PandemicGame(PandemicGrid grid) {
        super(grid.rowCount, grid.colCount);
        doctors = new Doctors(grid,this);
        virus = new Virus(grid,this);
        people = new People(grid,this);


    }


    @Override
    public void initialisation() {
        doctors.initialisation(3);
        virus.initialisation(3);

    }

    @Override
    public void activation() {
        virus.activation();
        doctors.activation();

    }
}

package pandemic;


import model.Model;
import model.Movement;

public class PandemicGame extends Movement implements Model {

     final Doctors doctors ;
     public final Virus virus ;
     public final People people;
    public final Virologists virologists;

     public final VaccinatedPeople vaccinatedPeople;
    public PandemicGame(PandemicGrid grid) {
        super(grid.rowCount, grid.colCount);
        doctors = new Doctors(grid,this);
        virus = new Virus(grid,this);
        people = new People(grid,this);
        vaccinatedPeople = new VaccinatedPeople(grid,this);
        virologists = new Virologists(grid,this);
    }


    @Override
    public void initialisation() {
        doctors.initialisation(5);
        virus.initialisation(5);
        people.initialisation(10);
        vaccinatedPeople.initialisation(8);
        virologists.initialisation(5);
    }

    @Override
    public void activation() {
        virus.activation();
        doctors.activation();
        people.activation();
        vaccinatedPeople.activation();
        virologists.activation();
    }
}

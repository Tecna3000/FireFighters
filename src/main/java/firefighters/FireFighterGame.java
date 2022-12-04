package firefighters;

import model.Model;
import model.Movement;
import util.Position;
import java.util.List;

public class FireFighterGame extends Movement implements Model {
    private final FireFighters fireFighters ;
    private final FireTrucks fireTrucks ;
    private final Clouds clouds;
    public final Rocks rock;
    public Fires fires;
    public Mountains mountains;
    public Road road;

    public FireFighterGame(FireFighterGrid grid) {
        super(grid.rowCount, grid.colCount);
        fireFighters = new FireFighters(grid, this);
        fires = new Fires(grid, this);
        clouds = new Clouds(grid, this);
        fireTrucks = new FireTrucks(grid, this);
        mountains = new Mountains(grid, this);
        road = new Road(grid, this);
        rock = new Rocks(grid, this);

    }

    @Override
    public void initialisation() {
        road.initialisation(13);
        rock.initialisation(5);
        fireFighters.initialisation(5);
        clouds.initialisation(5);
        fireTrucks.initialisation(5);
        mountains.initialisation(7);
        fires.initialisation(15);
    }
    @Override
    public void activation() {
        clouds.activation();
        road.activation();
        rock.activation();
        fireFighters.activation();
        fireTrucks.activation();
        mountains.activation();
        fires.activation();
    }
    public List<Position> skipMountain(Position position) {
        List<Position> list = next(position);
        for(Position mountain : mountains.getPositions())
            list.remove(mountain);
        return list;
    }

    public List<Position> skipMountainAndRoad(Position position) {
        List<Position> list = skipMountain(position);
        for(Position road : road.getPositions())
            list.remove(road);
        return list;
    }
}

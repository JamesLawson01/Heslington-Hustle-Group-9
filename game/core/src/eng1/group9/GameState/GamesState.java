package eng1.group9.gamestate;

import eng1.group9.gamestate.Activities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;






public class GamesState {

    /**
     * This class is the main game logic class. The 'game state', i.e. the record of the energy
     * and time, etc of the player is kept and modified in this class.
     * @param energy int, the remaining energy of the player
     * @param maxEnergy int the energy the player starts with in a day
     * @param time int the remaining time of the player
     * @param timeInDay int the total time in a day
     * @param day int the counter of the days
     * @param activityList int the list of activities taken place
     */

    private int energy;
    private int maxEnergy;
    private int time;
    private int timeInDay;
    private int day;
    private ArrayList<Activity> activityList = new ArrayList<>();

    private MapGraph map = new MapGraph();

    private TilePosition playerPosition;



    //constructor
    public GamesState(int eng, int tim){

        this.energy = eng;
        this.maxEnergy = eng;
        this.time = tim;
        this.timeInDay = tim;
    }


    //getters
    public int getEnergy(){

        return this.energy;
    }
    public int getTime(){

        return this.time;
    }

    public int getDay(){

        return this.day;
    }

    public ArrayList<Activity> getActivityList(){

        return this.activityList;
    }


    //the function to update the player position
    public boolean move(String direction){

        if((direction.equals("up")) && (this.canMoveUp())){

            getPlayerPosition();

            playerPosition.setI(playerPosition.getI() + 1);

            return true;
        }

        if((direction.equals("down")) && (this.canMoveDown())){

            getPlayerPosition();

            playerPosition.setI(playerPosition.getI() - 1);

            return true;
        }

        if((direction.equals("left")) && (this.canMoveLeft())){

            getPlayerPosition();

            playerPosition.setJ(playerPosition.getJ() - 1);

            return true;
        }

        if((direction.equals("right")) && (this.canMoveRight())){

            getPlayerPosition();

            playerPosition.setJ(playerPosition.getJ() - 1);

            return true;
        }

        return false;
    }


    //the functions to check whether the player is capable of moving in
    //that direction
    private boolean canMoveUp(){

        getPlayerPosition();

        HashMap<MapGraph.Tile, List<MapGraph.Tile>> tempMap = new HashMap<>();
        //tempMap = map.getFullMap();



        return false;
    }

    private boolean canMoveDown(){


        return false;
    }

    private boolean canMoveLeft(){


        return false;
    }

    private boolean canMoveRight(){


        return false;
    }


    //the function to perform an activity the user wants
    public boolean performActivity(Activity act){


        //if the activity is Sleep, the time and energy is reset
        //and the counter of the day increments
        if(act instanceof Sleep){

            this.day = this.day + 1;
            this.energy = this.maxEnergy;
            this.time = this.timeInDay;

            return true;
        }


        //if the activity is Eat, study or recreation, then the time and energy is decremented
        //by the desired amount and the activity is recorded in the ArrayList
        if((act.getEnergyConsumption() < this.energy) && (act.getTimeConsumption() < this.time)) {

            int tempTime = act.getTimeConsumption();
            int tempEnergy = act.getEnergyConsumption();

            activityList.add(act);
            this.time = this.time - tempTime;
            this.energy = this.energy - tempEnergy;

            return true;

        }else {

            return false;
        }
    }


    public ArrayList<Activity> getActivities(){


        return Node.getActivities();
    }

    private boolean getPlayerPosition(){

        playerPosition = player.getPlayerPosition();

        return true;
    }

    public ArrayList<?> scoreCalculation(){

        Integer sleepCounter = 0;
        Integer eatCounter = 0;
        Integer studyCounter = 0;
        Integer recreationalCounter = 0;
        ArrayList<Integer> counterList = new ArrayList<>();

        for(int i = 0; i < activityList.size(); i++){

            Activity acti = activityList.get(i);

            switch (acti.getClass().getSimpleName()) {

                case "Sleep":
                    sleepCounter = sleepCounter + 1;
                    break;
                case "Eat":
                    eatCounter = eatCounter + 1;
                    break;
                case "Study":
                    studyCounter = studyCounter + 1;
                    break;
                case "Recreational":
                    recreationalCounter = recreationalCounter + 1;
            }
        }

        counterList.add(sleepCounter);
        counterList.add(eatCounter);
        counterList.add(studyCounter);
        counterList.add(recreationalCounter);

        return counterList;
    }
}
package eng1.group9.Activities;


/**
 * This class is the abstract class for the eat, sleep, study, and recreation classes
 *
 * @param timeConsumption int, record of how much time is consumed for this activity
 * @param energyConsumption int, record of how much energy is consumed
 */
abstract class Activity {

    private int timeConsumption;
    private int energyConsumption;


    //Constructor
    public Activity(time, energy){

        this.timeConsumption = time;
        this.energyConsumption = energy;
    }


    //getters
    public int getTimeConsumption(){

        return  timeConsumption;
    }
    public int getEnergyConsumption(){

        return energyConsumption;
    }

}
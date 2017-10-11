/**
 * Created by Ariete on 4/20/2017.
 */
public class AlarmClock {
    int userHour;
    int userMinutes;
    int userSeconds;

    int alarmHour;
    int alarmMin;

    boolean radio = true;
    public  AlarmClock(int timeHour, int timeMin,int timeSec, String timePeriod,
                       int alarmHour, int alarmMin, String alarmPer){

        System.out.print("Initial Time: " + timeHour + ":" + timeMin + "0 " + timePeriod + "\n");
        System.out.print("The radio was turned on and is playing 1060 AM.\n");

        userHour = timeHour;
        this.alarmHour = alarmHour;
        this.alarmMin = alarmMin;
        userSeconds = timeSec;

    }

    public void snooze(int svar){
        //Snooze function add 9 minutes to the Alarm Minutes.
        System.out.println("Snooze was pressed");
        this.alarmMin += svar;
    }

    public String showTime(){
        //return string to show Time.
        String show;

        if(userMinutes < 10) //Give the timer a 0 before 1 through 9
            show = (userHour + ":0" + userMinutes); //Prints x:01, x:02...
        else
            show = (userHour + ":" + userMinutes); //prints x:10, x:11...

        return show;

    }


    public void tick(){
        //I don't think second ticks will work without use an actual random timer
        //if time greater than 60 reset minute and increase hour
        userSeconds++;

        if(userSeconds == 60)
        {
            userMinutes++;
            userSeconds = 0;
        }

        if(userMinutes == 60){
            userHour++;
            userMinutes = 0;
        }
        //if hour greater than 12 reset to 1, and switch AM, PM.
        if(userHour > 12){
            userHour = 1;
        }
    }



    public boolean checkAlarm(){
        //Check the alarm current time and return true if time is achieved.
        //System.out.println("User Minute: " + userMinutes);
        //System.out.println("Alarm Minutes: " + alarmMin);
        //System.out.println("User hour: " + userHour);

        if(userHour == alarmHour && userMinutes == alarmMin) {

            return true;
        }
        return false;
    }

    public void AlarmOff(){
        System.out.println("The alarm was shut off.");

    }
    public void status() {
        //Exit program if radio is off
        if (!radio)
        {
            System.out.println("The radio is off");
            System.exit(0);
        }
    }
    public boolean RadioOff()
    {
        return (radio = false);
    }
}

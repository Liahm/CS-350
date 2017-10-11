/**
 * Created by Eric Lee on 4/20/2017.
 */
public class main {
    public static void main(String[] args) {

        int i;

        int seconds;
        int svar = 9; //this is the snooze value
        String currentStation = "1060 AM";
        AlarmClock myClock = new AlarmClock(8, 0, 0, "AM", 8, 5, "AM");

        for (i = 0; i < 5; i++)
        {
            for (seconds = 0; seconds < 60; seconds++)
            {

                myClock.tick();

            }
            System.out.println("Time: " + myClock.showTime());
            if(myClock.checkAlarm() == true)
            {
                System.out.println("The radio is playing CurrentStation: " + currentStation);
            }
        }

        myClock.snooze(svar);


        for (i = 0; i < 9; i++)
        {
            System.out.println("Time: " + myClock.showTime());
            for (seconds = 0; seconds < 60; seconds++)
            {
                myClock.checkAlarm();
                myClock.tick();
            }
            if(myClock.checkAlarm() == true)
            {
                System.out.println("The radio is playing CurrentStation: " + currentStation);
            }
        }
        myClock.AlarmOff();
        myClock.RadioOff();
        myClock.status();
    }

}

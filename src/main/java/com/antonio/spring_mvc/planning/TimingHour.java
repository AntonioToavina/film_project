package com.antonio.spring_mvc.planning;

import com.antonio.spring_mvc.model.Act;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

public class TimingHour {
    Time firstHour;
    Time lastHour;

    public final static Time minHour = Time.valueOf("06:00:00");
    public final static Time maxHour = Time.valueOf("23:00:00");

    public TimingHour() {
    }
    public TimingHour(Time firstHour, int minuteDuration) {
        setFirstHour(firstHour);
        setLastHour(getLastHourByDuration(minuteDuration));
    }



    public Time getFirstHour() {
        return firstHour;
    }

    public void setFirstHour(Time firstHour) {
        this.firstHour = firstHour;
    }

    public Time getLastHour() {
        return lastHour;
    }

    public void setLastHour(Time lastHour) {
        this.lastHour = lastHour;
    }

    public Time getLastHourByDuration(int minute){
        long minuteMilliSec = minute * 60 * 1000;
        return new Time(getFirstHour().getTime()+(minuteMilliSec));
    }

    public int getDuration(){

        long differenceEnMillisecondes = getLastHour().getTime() - getFirstHour().getTime();
        return (int) (differenceEnMillisecondes / (60 * 1000));

    }

    public boolean timeIsInside(Time timeToCheck){
        if(timeToCheck.compareTo(getFirstHour())>=0 && timeToCheck.compareTo(getLastHour())<=0)
            return true;
        return false;
    }

    public TimingHour(Time firstHour, Time lastHour) {
        setFirstHour(firstHour);
        setLastHour(lastHour);
    }


    public static TimingHour generate(Time timeMin, Time timeMax, int minuteDuration, TimingHour timed){
        if(timeMin==null)
            timeMin=minHour;
        if(timeMax==null)
            timeMax=maxHour;
        TimingHour initial = new TimingHour(timeMin,timeMax);



        TimingHour result=new TimingHour(initial.getFirstHour(),minuteDuration);

        if(timed==null)
            return result;

        if(timed.timeIsInside(initial.getFirstHour())){

                Calendar calendrier = Calendar.getInstance();
                calendrier.setTime(timed.getLastHour());
                calendrier.add(Calendar.MINUTE, 1);


                result.setFirstHour(new Time(calendrier.getTimeInMillis()));
                result.setLastHour(result.getLastHourByDuration(minuteDuration));

                if(!initial.timeIsInside(result.getFirstHour()))
                    return null;
            }
                return result;
    }
    public static TimingHour generateTiming(Act act, List<TimingHour> timed){

        Time minTime = act.getFirsthour();
        TimingHour result=generate(minTime, act.getLasthour(),act.getDuration(),null);

        for (TimingHour timing :
                timed) {
            result= generate(minTime,act.getLasthour(),act.getDuration(),timing);
            if(result==null)
                return null;

            minTime=result.getFirstHour();
        }

        minTime= result.getLastHour();
        for (TimingHour timing :
                timed) {
            result= generate(minTime,act.getLasthour(),act.getDuration(),timing);
            if(result==null)
                return null;

            minTime=result.getFirstHour();
        }

        return result;
    }

    @Override
    public String toString() {
        return "TimingHour{" +
                "firstHour=" + firstHour +
                ", lastHour=" + lastHour +
                '}';
    }
}

package exame_2022;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event implements IEvent {
    private LocalDate date; 
    private List<Activity> activities = new ArrayList<>();
    
    public Event(LocalDate date, List<Activity> activities){
        this.date = date;
        this.activities = activities;
    }

    public List<Activity> getActivities(){
        return this.activities;
    }

    @Override
    public Event addActivity(Activity activity){
        // if (activity.getName().equals("Catering")){
        //     for (Activity a : activities){
        //         if (a.getName().equals("Catering")){
        //             return null;
        //         }
        //     }
        //     activities.add(activity);

        // }
        // else{
        //     for (Activity a : activities){
        //         if (a.getType().equals(activity.getType())){
        //             System.out.println("Activity already exists");
        //             return null;
        //         }
        //     }
        //     activities.add(activity);
        // }
        // return null;
        if (activity instanceof Catering){
            for (Activity a : activities){
                if (a instanceof Catering){
                    return null;
                }
            }
            activities.add(activity);

        }
        else{
            for (Activity a : activities){
                if (a instanceof Sport){
                    Sport s = (Sport) a;
                    Sport s2 = (Sport) activity;
                    if (s.getOption() == s2.getOption()){
                        System.out.println("Activity already exists");
                        return null;
                    }
                } else if (a instanceof Culture){
                    Culture c = (Culture) a;
                    Culture c2 = (Culture) activity;
                    if (c.getOption() == c2.getOption()){
                        System.out.println("Activity already exists");
                        return null;
                    }
                }
            }
            activities.add(activity);
        }
        return null;
    }

    @Override
    public double totalPrice(){
        double total = 0;
        for (Activity a : activities){
            total += a.getPriceByParticipant() * a.getParticipants();
        }
        return total;
    }

    @Override
    public LocalDate getDate(){
        return this.date;
    }

    @Override
    public String toString(){
        String s = "*** Evento em " + this.date + ", total=" + totalPrice() + "\n";
        for (Activity a : activities){
            s += a.toString() + "\n";
        }
        
        return s;
    }

    
    

    
}

package exame_2022;

public class Culture extends Activity {
    private Culture.Option option;

    public Culture(Culture.Option option, int participants){
        this.option = option;
        this.setParticipants(participants);
        this.setType(String.valueOf(option));
        this.setName("Culture");
        this.setPriceByParticipant(22);
    }

    public Culture.Option getOption(){
        return this.option;
    }

    public void setOption(Culture.Option option){
        this.option = option;
    }

    public enum Option{
        ARCHITECTURAL_TOUR, RIVER_TOUR, ART_MUSEUM, WINE_TASTING;
    }

    @Override 
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Culture){
            Culture culture = (Culture) obj;
            return this.option == culture.getOption() && this.getParticipants() == culture.getParticipants();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.option.hashCode() + this.getParticipants();
    }
    
}

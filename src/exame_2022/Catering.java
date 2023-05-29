package exame_2022;

public class Catering extends Activity {
    private Catering.Option option;

    public Catering(Catering.Option option, int participants){
        this.option = option;
        this.setParticipants(participants);
        this.setType(String.valueOf(option));
        this.setName("Catering");
        this.setPriceByParticipant(25);
    }

    public Catering.Option getOption(){
        return this.option;
    }

    public void setOption(Catering.Option option){
        this.option = option;
    }

    public enum Option{
        FULL_MENU, LIGHT_BITES, DRINKS_AND_SNACKS;
    }

    @Override 
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Catering){
            Catering catering = (Catering) obj;
            return this.option == catering.getOption() && this.getParticipants() == catering.getParticipants();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.option.hashCode() + this.getParticipants();
    }
}

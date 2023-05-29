package exame_2022;

    public class Sport extends Activity {
        private Sport.Modality modality;
    
        public Sport(Sport.Modality modality, int participants){
            this.modality = modality;
            this.setParticipants(participants);
            this.setType(String.valueOf(modality));
            this.setName("Sport");
            this.setPriceByParticipant(30);
        }
    
        public Sport.Modality getOption(){
            return this.modality;
        }
    
        public void setOption(Sport.Modality modality){
            this.modality = modality;
        }
    
        public enum Modality{
            KAYAK, BIKE;
        }
        @Override 
    public String toString(){
        return super.toString();
    }
    
        @Override
        public boolean equals(Object obj){
            if(obj instanceof Sport){
                Sport sport = (Sport) obj;
                return this.modality == sport.getOption() && this.getParticipants() == sport.getParticipants();
            }
            return false;
        }
    
        @Override
        public int hashCode(){
            return this.modality.hashCode() + this.getParticipants();
        }
    
}

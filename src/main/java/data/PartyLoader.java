package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartyLoader {

   private List<String> partyParticipants;
   private Integer[][] party;

   public List<String> getPartyParticipants() {
      return partyParticipants;
   }

   public void setPartyParticipants(List<String> partyParticipants) {
      this.partyParticipants = partyParticipants;
   }

   public Integer[][] getParty() {
      return party;
   }

   public void setParty(Integer[][] party) {
      this.party = party;
   }

   public void loadParticipants(){
      if(partyParticipants == null){
         partyParticipants = new ArrayList<>();
      }
      partyParticipants.add("1");
      partyParticipants.add("2");
      partyParticipants.add("3");
      partyParticipants.add("4");
   }

   public void loadParty(final Integer partyAttendants){

      party = new Integer[partyAttendants][partyAttendants];
      for(int i = 0; i < partyAttendants; i++){
         for(int j = 0; j < partyAttendants; j++)
            party[i][j] = 0;
      }

      fillParty(party, getPartyData());
   }

   private void fillParty(Integer[][] party, String partyData){
      List<String> dataList = Arrays.asList(partyData.split(";"));
      for(String data : dataList){
         String[] partyMember = data.split(",");
         party[Integer.parseInt(partyMember[0])- 1][Integer.parseInt(partyMember[1]) - 1] = 1;
      }
   }

   private String getPartyData(){
      StringBuilder party = new StringBuilder();
      party.append("1,2;");
      party.append("1,4;");
      party.append("1,3;");
      party.append("2,1;");
      party.append("2,4;");
      party.append("2,3;");
      party.append("4,1;");
      party.append("4,2;");
      party.append("4,3");

      return party.toString();
   }


}

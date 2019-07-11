package party;

import data.PartyLoader;

import java.util.List;
import java.util.Stack;

public class FindCelebrity {

   public static void main(String args[]){
      PartyLoader loader = new PartyLoader();
      loader.loadParty(4);
      loader.loadParticipants();

      Integer celebrity = findTheCelebrity(loader.getParty(), loader.getPartyParticipants());
      if(celebrity > 0){
         System.out.println("Celebrity found: " + celebrity);
      } else {
         System.out.println("Celebrity not found");
      }
   }

   private static Integer findTheCelebrity(final Integer[][] party, final List<String> participantsList){

      Stack<Integer> participants = new Stack<>();
      for(String participant : participantsList){
         participants.push(Integer.parseInt(participant));
      }

      while(participants.size() > 1){
         Integer pt1 = participants.pop();
         Integer pt2 = participants.pop();
         if(knowsParticipant(pt1, pt2, party)){
            participants.push(pt2);
         } else {
            participants.push(pt1);
         }
      }

      Integer celebrity = participants.pop();

      for(String participant : participantsList){
         if(knowsParticipant(celebrity, Integer.parseInt(participant), party))
            return -1;
      }


      return celebrity;
   }

   private static Boolean knowsParticipant(Integer pt1, Integer pt2, final Integer[][] party){
      if(party[pt1 - 1][pt2 - 1] == 1)
         return Boolean.TRUE;
      else
         return Boolean.FALSE;
   }
}

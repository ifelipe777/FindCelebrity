package party;

import data.PartyLoader;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FindCelebrity {

   private static String MSG_CELEBRITY_NOT_FOUND = "Celebrity not found";
   private static String MSG_CELEBRITY_FOUND = "Celebrity found: ";

   public static void main(String args[]){
      System.out.println(findTheCelebrityExecutor());
   }

   public static String findTheCelebrityExecutor(){
      PartyLoader.getInstance().loadParty();

      Integer celebrity = findTheCelebrity(PartyLoader.getInstance().getParty(), PartyLoader.getInstance().getPartyParticipants());
      if(celebrity > 0){
         return MSG_CELEBRITY_FOUND + PartyLoader.getInstance().getPartyParticipants().get(celebrity);
      } else {
         return MSG_CELEBRITY_NOT_FOUND;
      }
   }

   private static Integer findTheCelebrity(final Integer[][] party, final Map<Integer, String> participantsList){

      Stack<Integer> participants = new Stack<>();
      for(Map.Entry<Integer, String> participant : participantsList.entrySet()){
         participants.push(participant.getKey());
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

      for(Map.Entry<Integer, String> participant : participantsList.entrySet()){
         if(knowsParticipant(celebrity, participant.getKey(), party))
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

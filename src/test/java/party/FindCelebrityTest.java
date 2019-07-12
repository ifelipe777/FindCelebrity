package party;

import org.junit.Assert;
import org.junit.Test;

public class FindCelebrityTest {

   private static String MSG_CELEBRITY_NOT_FOUND = "Celebrity not found";

   @Test
   public void findCelebrityTest(){
      String result = FindCelebrity.findTheCelebrityExecutor();
      Assert.assertTrue(!result.equals(MSG_CELEBRITY_NOT_FOUND));
   }
}

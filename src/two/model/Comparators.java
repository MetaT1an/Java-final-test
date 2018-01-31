package two.model;

import java.util.Comparator;

public class Comparators {
   public static class nameComparator implements Comparator<StuInfo> {
      @Override
      public int compare(StuInfo s1, StuInfo s2){
         return s1.getName().compareTo(s2.getName());
      }
   };

   public static class idComparator implements Comparator<StuInfo> {
      @Override
      public int compare(StuInfo s1, StuInfo s2) {
          return s1.getId().compareTo(s2.getId());
      }
   };

   public static class scoreComparator implements Comparator<StuInfo> {
      @Override
      public int compare(StuInfo s1, StuInfo s2) {
         if(s1.getScore() == s2.getScore())
            return 0;
         else
             return (s1.getScore() < s2.getScore()) ? 1 : -1;
      }
   };
}

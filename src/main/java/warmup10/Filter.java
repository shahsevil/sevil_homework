package warmup10;

public class Filter {
   final String vow = "aeoiu";
   public String origin;

   public String Filterit(String origin){
      String a= origin.toLowerCase();
      String e = new String("");
      for(int i=0;i<a.length();i++){
          if (!vow.contains(String.valueOf(a.charAt(i)))){
              e+=a.charAt(i);
           }
      }
      return e;
   }



}

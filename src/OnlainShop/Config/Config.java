package OnlainShop.Config;

public class Config {
     public static boolean checkEmail(String email){
         String patternForEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
         return email.matches(patternForEmail);

     }

     public static boolean checkPassword(String password){

      String patternForPassword="^(?=.*[A-Z])(?=.*[1-9])(?=.*[@#$%^&+=!])[A-Za-z\\d@#$%^&+=!]{4,}$";
        return password.matches(patternForPassword);
}

}

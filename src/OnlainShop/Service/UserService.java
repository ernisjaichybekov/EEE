package OnlainShop.Service;

import OnlainShop.Models.User;

public interface UserService {

    String signUp(User user);

    User [] getAll();
    void logIn(String email,String password);
    void registration();
}

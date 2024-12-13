package OnlainShop.Service.lmpl;

import OnlainShop.Config.Config;
import OnlainShop.DAO.ProductsDAO;
import OnlainShop.DAO.UserDAO;
import OnlainShop.DataBase.DataBase;
import OnlainShop.Exception.lnvalidData;
import OnlainShop.Models.User;
import OnlainShop.Service.ProductsService;
import OnlainShop.Service.UserService;
import OnlainShop.enums.Role;

import java.util.Scanner;

public class Userlmpl implements UserService {


    private final UserDAO userDAO;
    Scanner scannerForStr = new Scanner(System.in);
    public void UserImpl(UserDAO userDAO) {

    }

    public Userlmpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String signUp(User user) {
        if (!Config.checkEmail(user.getEmail())) {
            throw new lnvalidData("Invalid email!");
        } else {
            User[] users = userDAO.getAll();
            for (User user1 : users) {
                if (user1.getEmail().equals(user.getEmail())) {
                    throw new IllegalArgumentException("Email already exists! ");
                }
            }
        }
        if (!Config.checkPassword(user.getPassword())) {
            throw new lnvalidData("Invalid password!");
        }
        userDAO.saveUser(user);
        return "Successfully";
    }
    @Override
    public User[] getAll() {
        return DataBase.users;
    }
    @Override
    public void logIn(String emailAdmin, String passwordAdmin) {
        ProductsDAO productsDAO = new OnlainShop.DAO.lmpl.Productslmpl();
        ProductsService products = new Productslmpl(productsDAO);
        Scanner scanner = new Scanner(System.in);
        Scanner scannerForInt = new Scanner(System.in);
        System.out.print("Write the email: ");
        String email = scanner.nextLine();
        System.out.print("Write the password: ");
        String password = scanner.nextLine();
        if (email.equals(emailAdmin) && password.equals(passwordAdmin)) {
            while (true) {
                System.out.println("""
                        1. Продукта кошуу.
                        2. Продукта очуруу.
                        3. Продукта озгортуу.
                        4. Бардык продукталарды коруу.
                        5. Чыгуу
                        """);
                System.out.print("Your choice: ");
                int number = scannerForInt.nextInt();
                switch (number) {
                    case 1 -> {
                        products.saveProducts();
                    }
                    case 2 -> {
                        products.deleteProductById();
                    }
                    case 3 -> {
                        products.updateById();
                    }
                    case 4 -> {
                        products.getAll();
                    }
                    case 5 -> {
                        System.out.println("Bye-bye!");
                        return;
                    }
                    default -> {
                        System.out.println("invalid number!");
                    }
                }
            }
        } else {
            if (true) {
                for (int i = 0; i < DataBase.users.length; i++) {
                    if (email.equals(DataBase.users[i].getEmail()) && password.equals(DataBase.users[i].getPassword())) {
                        while (true) {
                            System.out.println("""
                                    1. Бардык продукталарды коруу.
                                    2. Продукталарды категориясы менен размерлерине карап коруу.
                                    3. Избранныйга кошуу.
                                    4  Избранныйды очуруу.
                                    5. Бир клиенттин бардык избранныйдагы продукталарын коруу.
                                    6. Id-си аркылуу бир продуктаны коруу.
                                    7. Чыгуу
                                    """);
                            try {
                                System.out.print("Your choice: ");
                                int number = scannerForInt.nextInt();
                                switch (number) {
                                    case 1 -> {
                                        products.getAll();
                                    }
                                    case 2 -> {
                                        products.getSizesWithCategory();
                                    }
                                    case 3 -> {
                                        products.izbraanyi();
                                    }
                                    case 4 -> {
                                        products.deleteById();
                                    }
                                    case 5 -> {
                                        products.getAllIz();
                                    }
                                    case 6 -> {
                                        products.getById();
                                    }
                                    case 7 -> {
                                        System.out.println("Bye-bye!");
                                        return;
                                    }
                                    default -> {
                                        System.out.println("Invalid number!");
                                    }
                                }
                            } catch (RuntimeException r) {
                                System.out.println("Invalid command!");
                            }
                        }
                    } else System.out.println("Incorrect login or password!");
                }
            } else {
                System.out.println("Incorrect login or password!");
            }
        }
    }
    @Override
    public void registration() {
        System.out.println("Registration!");
        System.out.print("Write the email(@gmail.com): ");
        String email = "";
        boolean a = false;
        do {
            email = new Scanner(System.in).nextLine();
            a = false;
            if (!email.contains("@gmail.com")) {
                System.out.print("Invalid email!\nWrite the email(@gmail.com):");
                a = true;
            }
        } while (a);
        System.out.print("Write the password(password length>4): ");
        String password = "";
        do {
            password = new Scanner(System.in).nextLine();
            a = false;
            if (!Config.checkPassword(password)) {
                System.out.println("invalid password!\nWrite the password(password length>4): ");
                a = true;
            }
        } while (a);
        System.out.print("Enter the name: ");
        String result = userDAO.saveUser(new User(scannerForStr.nextLine(), email, password, Role.USER));
        System.out.println(result);
    }

}

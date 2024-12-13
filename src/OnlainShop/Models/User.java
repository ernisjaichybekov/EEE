package OnlainShop.Models;

import OnlainShop.enums.Role;

public class User {

    private long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String favoriteProducts;

    private static long generateId = 0;


    public User(){
        this.id = ++generateId;

    }

    public User(long id, String name, String email, String password, Role role, String favoriteProducts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.favoriteProducts = favoriteProducts;
    }

    public User(String s, String email, String password, Role role) {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFavoriteProducts() {
        return favoriteProducts;
    }
    public void setFavoriteProducts(String favoriteProducts) {
        this.favoriteProducts = favoriteProducts;

    }


    @Override
    public String toString() {
        return "User!" +
                "\nid= " + id +
                "\nname= " + name +
                "\nemail= " + email +
                "\npassword= " + password +
                "\nrole= " + role +
                "\nfavoriteProducts= " + favoriteProducts
                ;


    }

}

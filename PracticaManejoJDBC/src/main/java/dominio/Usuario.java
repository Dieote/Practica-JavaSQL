package dominio;

public class Usuario {
    private int id_User;
    private String userName;
    private String userPassword;

    public Usuario() {
    }

    public Usuario(int id_User) {
        this.id_User = id_User;
    }
    
    public Usuario(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Usuario(int id_User, String userName, String userPassword) {
        this.id_User = id_User;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    
    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "id_User=" + id_User + ", userName=" + userName + ", userPassword=" + userPassword + '}';
    }
    
    
}

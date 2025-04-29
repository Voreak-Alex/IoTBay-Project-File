package  model;
import java.io.Serializable;
import java.util.Objects;

//cd to the folder that the source is in
//mvn compile

public class User implements Serializable{
    private int UID;
    private int userLevel;
    private String email;
    private String password;
    private String name;

    

    public User() {
    }

    public User(String email, String password, String name, int userLevel) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userLevel = userLevel;
    }

    public int getUID(){
        return this.UID;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int getUserLevel() {
        return  this.userLevel;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, name, userLevel);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    
    
}

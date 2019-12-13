package database.yygq.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User_login{
    private String username;
    private String password;
    @JsonIgnore
    private String ignored_thing;


    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIgnored_thing(){
        this.ignored_thing = ignored_thing;
    }
    public String getIgnored_thing(){
        return ignored_thing;
    }


}

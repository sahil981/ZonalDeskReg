package iacademia.zonaldesk;

import java.util.Stack;

/**
 * Created by sahil on 1/7/17.
 */

public class Registerationdb {
    String username;
    String password;
    String email;
    String address;
    String pincode;
    String state;

    public Registerationdb(String username, String password, String email, String address, String pincode, String state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.pincode = pincode;
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public String getState() {
        return state;
    }
    public Registerationdb(){

    }
}

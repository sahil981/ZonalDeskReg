package iacademia.zonaldesk;

/**
 * Created by Sidharth on 7/1/2017.
 */

public class queryadddb {
    String name;
    String no;
    String address;
    String pincode;
    String query;
    String user_name;

    public String getUser_name() {
        return user_name;
    }

    public queryadddb(String user_name, String name, String no, String address, String pincode, String query) {
        this.name = name;
        this.no = no;
        this.address = address;
        this.pincode = pincode;
        this.query = query;
        this.user_name=user_name;

    }

    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public String getQuery() {
        return query;
    }

    public queryadddb() {
    }
}

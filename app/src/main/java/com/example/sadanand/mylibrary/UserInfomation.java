package com.example.sadanand.mylibrary;

/**
 * Created by lenovo on 2/9/2018.
 */

public class UserInfomation {
    int bookcount;
    String issuedate;
    String userbook1;


    public UserInfomation(){

    }
    public UserInfomation(int bookcount, String issuedate, String userbook1) {
        this.bookcount = bookcount;
        this.issuedate = issuedate;
        this.userbook1 = userbook1;

    }

    public String toString(){
return  userbook1 + " "  + issuedate;
    }
}

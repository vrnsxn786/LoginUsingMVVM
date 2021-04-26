package com.varun.loginusingmvvm.model;

import android.text.TextUtils;
import android.util.Patterns;

public class UserModel {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidEmail(){
        if (this.email!=null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }
        return false;
    }

    public boolean isValidPassword(){
        if (this.password!=null && this.password.length() >=6){
            return true;
        }
        return false;
    }

    public boolean isValidCredentials(){

        if (this.email.equalsIgnoreCase("ex@gmail.com") && this.password.equalsIgnoreCase("123456")){
            return  true;
        }
        return  false;

    }

    public String getWelcomeMessage(){
        return "Welcome\n"+this.getEmail();
    }
}

package com.varun.loginusingmvvm.viewModel;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.varun.loginusingmvvm.model.UserModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> email= new MutableLiveData<>();
    public MutableLiveData<String> password= new MutableLiveData<>();


    private UserModel userModel;
    private Context context;

    public LoginViewModel(UserModel userModel, Context context) {
        this.userModel = userModel;
        this.context = context;
    }

    public void onLogin(){
        userModel.setEmail(email.getValue());
        userModel.setPassword(password.getValue());

        if (!userModel.isValidEmail()){
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show();
        }else if (!userModel.isValidPassword()){
            Toast.makeText(context, "Invalid Password", Toast.LENGTH_SHORT).show();
        }else if (userModel.isValidCredentials()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show();
                }
            },500);
        }else{
            Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }

    }
}

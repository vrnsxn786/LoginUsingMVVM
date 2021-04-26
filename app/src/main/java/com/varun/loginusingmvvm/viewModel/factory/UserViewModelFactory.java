package com.varun.loginusingmvvm.viewModel.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.varun.loginusingmvvm.model.UserModel;
import com.varun.loginusingmvvm.viewModel.LoginViewModel;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private UserModel userModel;
    private Context context;


    public UserViewModelFactory(UserModel userModel,Context context){
        this.userModel= userModel;
        this.context= context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(userModel,context);
    }
}

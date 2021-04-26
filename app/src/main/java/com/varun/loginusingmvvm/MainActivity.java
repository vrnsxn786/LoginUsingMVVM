package com.varun.loginusingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.varun.loginusingmvvm.databinding.ActivityMainBinding;
import com.varun.loginusingmvvm.model.UserModel;
import com.varun.loginusingmvvm.viewModel.LoginViewModel;
import com.varun.loginusingmvvm.viewModel.factory.UserViewModelFactory;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        LoginViewModel loginViewModel= ViewModelProviders.of(this,
                new UserViewModelFactory( new UserModel(), this)).get(LoginViewModel.class);
        binding.setUserModel(loginViewModel);
    }
}
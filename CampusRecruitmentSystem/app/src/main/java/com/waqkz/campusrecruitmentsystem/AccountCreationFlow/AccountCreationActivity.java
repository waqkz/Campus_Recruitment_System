package com.waqkz.campusrecruitmentsystem.AccountCreationFlow;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import com.waqkz.campusrecruitmentsystem.R;

public class AccountCreationActivity extends AppCompatActivity implements TitleFragment.SendMembershipTypeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new TitleFragment())
                .commit();
    }


    @Override
    public void sendMembershipType(String sendMemberType) {

        SignInFragment.membershipType = sendMemberType;

        SignUpFragment.membershipType = sendMemberType;

    }
}

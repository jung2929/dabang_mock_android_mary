package com.softsquared.template.src.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.softsquared.template.R;
import com.softsquared.template.src.Adapter.ViewPagerAdapter;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.fragment.fragment_heart;
import com.softsquared.template.src.fragment.fragment_home;
import com.softsquared.template.src.fragment.fragment_map;
import com.softsquared.template.src.fragment.fragment_more;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class MainActivity extends BaseActivity implements MainActivityView {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private fragment_home home;
    private fragment_heart heart;
    private fragment_map map;
    private fragment_more more;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_heart:
                        setFrag(1);
                        break;
                    case R.id.action_map:
                        setFrag(2);
                        break;
                    case R.id.action_more:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        home = new fragment_home();
        heart = new fragment_heart();
        map = new fragment_map();
        more = new fragment_more();
        setFrag(0); //첫화면 지정
    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n){
            case 0:
                ft.replace(R.id.main_frame,home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,heart);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,map);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,more);
                ft.commit();
                break;
        }
    }

    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        showCustomToast(text);
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

//    public void customOnClick(View view) {
//        switch (view.getId()) {
//            case R.id.main_activity_btn_api_test:
//                tryGetTest();
//                break;
//            case R.id.main_activity_btn_simple_message_dialog:
//                SimpleMessageDialog simpleMessageDialog = new SimpleMessageDialog.Builder(this)
//                        .setMessage("message")
//                        .setButtonText("ok")
//                        .setOnClickListener(dialog -> {
//                            showCustomToast("click");
//                            dialog.dismiss();
//                        })
//                        .build();
//                simpleMessageDialog.show();
//                break;
//
//            case R.id.main_activity_btn_two_choice_dialog:
//                TwoChoiceDialog twoChoiceDialog = new TwoChoiceDialog.Builder(this)
//                        .setMessage("message")
//                        .setOnClickListener((dialog, which) -> {
//                            dialog.dismiss();
//                            switch (which) {
//                                case TwoChoiceDialog.BUTTON_LEFT:
//                                    showCustomToast("left");
//                                    break;
//                                case TwoChoiceDialog.BUTTON_RIGHT:
//                                    showCustomToast("right");
//                                    break;
//                            }
//                        }).build();
//                twoChoiceDialog.setCancelable(false);
//                twoChoiceDialog.show();
//                break;
//            default:
//                break;
//        }
//    }
}

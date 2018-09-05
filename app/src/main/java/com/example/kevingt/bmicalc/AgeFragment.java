package com.example.kevingt.bmicalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.github.paolorotolo.appintro.ISlidePolicy;

public class AgeFragment extends Fragment implements ISlidePolicy {
    public static final String PREF_USER_AGE_SEX = "PREF_USER_AGE_SEX";
    public static final String USER_AGE_EDITOR = "USER_AGE_EDITOR";
    public static final String USER_SEX_EDITOR = "USER_SEX_EDITOR";
    public static final String USER_NAME_EDITOR = "USER_NAME_EDITOR";

    private String userAge;
    private String userSex;
    private String userName;

    private EditText ageLabel;
    private EditText nameLabel;
    private RadioButton radioMale;
    private RadioButton radioFemale;

    private SharedPreferences pref;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.age_frag , container , false);
        nameLabel = (EditText) view.findViewById(R.id.name_label);
        ageLabel = (EditText) view.findViewById(R.id.age_label);
        radioMale = (RadioButton) view.findViewById(R.id.redio_male);
        radioFemale = (RadioButton) view.findViewById(R.id.redio_female);



        return view;
    }


    @Override
    public boolean isPolicyRespected() {
        userName = nameLabel.getText().toString();
        userAge = ageLabel.getText().toString();
        if(radioMale.isChecked())
            userSex="Male";
        else if(radioFemale.isChecked())
            userSex="Female";
        //  setSex.add(userSex);
        pref = getActivity().getSharedPreferences(PREF_USER_AGE_SEX, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(USER_NAME_EDITOR,userName);
        editor.putString(USER_AGE_EDITOR,userAge);
        editor.putString(USER_SEX_EDITOR,userSex);
        editor.commit();

        return userAge.length()>0 && (radioMale.isChecked()|| radioFemale.isChecked()) ;
    }

    @Override
    public void onUserIllegallyRequestedNextPage() {
        if (userAge.length() == 0) {
            Toast.makeText(getActivity(), "please enter your age", Toast.LENGTH_SHORT).show();
        }else if (userSex == ""){
            Toast.makeText(getActivity(), "please choose your sex", Toast.LENGTH_SHORT).show();
        }
    }


}

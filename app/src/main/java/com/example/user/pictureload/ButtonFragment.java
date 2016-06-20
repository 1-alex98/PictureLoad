package com.example.user.pictureload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ButtonFragment extends Fragment {

public int clicksf=1;


    public String name=this.toString();
public Button btn;


    public void OnAttach(Activity context)
    {
        super.onAttach(context);



    }



    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        btn= (Button) getActivity().findViewById(R.id.btnload);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   setGo();
                if (clicksf==7) {
                    Toast.makeText(getActivity(), "max. amount of Images loaded",
                        Toast.LENGTH_LONG).show();}

                clicksf++;
            }
        });
    }
    public void setGo()
    {
        if(clicksf<7) {
            MainActivity A= (MainActivity) getActivity();
            A.setImageViews(clicksf);


        }else {

        }
    }





    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_utton, container, false);
    }




}

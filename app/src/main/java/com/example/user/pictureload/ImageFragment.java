package com.example.user.pictureload;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class ImageFragment extends Fragment {


    public static int fclicks=1;
    public ImageView IM;
    public int id;
    public Bitmap bm= null;
    public String fragname="blank1";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
    public void setImage(Bitmap B)
    {
        IM.setImageBitmap(B);
    }
    public void setImageView(String path)
    {

         IM= (ImageView)getView().findViewById(R.id.IM);
        
        IM.setMaxWidth(100);
        IM.setMaxHeight(100);
        IM.setImageBitmap(BitmapFactory
               .decodeFile(path));


        IM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(getContext());
                a_builder.setMessage("Do you want to delete the picture?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                MainActivity A= (MainActivity) getActivity();
                                A.NewIntent();




                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }) ;
                AlertDialog alert = a_builder.create();
                alert.setTitle("Alert !!!");
                alert.show();
            }
        });

    }
}








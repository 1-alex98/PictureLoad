package com.example.user.pictureload;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends FragmentActivity
{
    public String ppicturepath;
    public int clicksp=1;
    int RESULT_LOAD_IMAGE = 0;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public  String Filename="ImageData";
    public String VAL_KEY="ImageString";
    public void setImageViews(int clicks)
    {

        clicksp= clicks;
        startG();
        FragmentManager fragManager = this.getSupportFragmentManager();
        ButtonFragment A=(ButtonFragment) fragManager.findFragmentById(R.id.utton);
        Toast.makeText(this,Integer.toString(A.clicksf),Toast.LENGTH_LONG);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public void NewIntent()
    {

    }



    public  void startG()
    {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);

            try{
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                //IM.setImageBitmap(BitmapFactory
                //       .decodeFile(picturePath));
                //Saving Path to Shared Preferences
                SharedPreferences settings = getSharedPreferences(Filename,0);
                SharedPreferences.Editor editor = settings.edit();
                VAL_KEY= VAL_KEY+ clicksp;
                editor.putString(VAL_KEY, picturePath);
                ppicturepath=picturePath;
                editor.commit();
            }
            catch(NullPointerException e){
                Toast.makeText(this,"No Image selected",Toast.LENGTH_LONG).show();

            }

            if (clicksp==1)
            {
                FragmentManager fragManager = this.getSupportFragmentManager();
                ImageFragment A=(ImageFragment) fragManager.findFragmentById(R.id.blank1);
                A.setImageView(ppicturepath);

            }else if (clicksp==2)
            {
                FragmentManager fragManager = this.getSupportFragmentManager();
                ImageFragment A=(ImageFragment) fragManager.findFragmentById(R.id.blank2);
                A.setImageView(ppicturepath);

            }else if (clicksp==3)
            {
                FragmentManager fragManager = this.getSupportFragmentManager();
                ImageFragment A=(ImageFragment) fragManager.findFragmentById(R.id.blank3);
                A.setImageView(ppicturepath);

            }else  if (clicksp==4)
            {
                FragmentManager fragManager = this.getSupportFragmentManager();
                ImageFragment A=(ImageFragment) fragManager.findFragmentById(R.id.blank4);
                A.setImageView(ppicturepath);

            }else if (clicksp==5)
            {
                FragmentManager fragManager = this.getSupportFragmentManager();
                ImageFragment A=(ImageFragment) fragManager.findFragmentById(R.id.blank5);
                A.setImageView(ppicturepath);

            }
            else if (clicksp==6)
            {
                FragmentManager fragManager = this.getSupportFragmentManager();
                ImageFragment A=(ImageFragment) fragManager.findFragmentById(R.id.blank6);
                A.setImageView(ppicturepath);
            }else{Toast.makeText(this,"Error 17765",Toast.LENGTH_LONG).show();}







        }

    }

    public static String[] Load(File file)
    {
        //Method for loading Arrays from Text files
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }

    public static void Save(File file, String[] data)
    {
        //Method for saving Arrays to text files
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.user.pictureload/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }


    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.user.pictureload/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
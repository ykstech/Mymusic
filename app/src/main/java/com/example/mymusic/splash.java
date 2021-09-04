package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.example.mymusic.MainActivity.getdata;


public class splash extends AppCompatActivity {


    ImageView splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        splash = findViewById(R.id.splash);

//        splash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  //  Toast.makeText(getApplicationContext(),"click ",Toast.LENGTH_LONG).show();
//
//            }
//        });

    //    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
     //           Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

     runtimePermission();


    //    Toast.makeText(getApplicationContext(),"path "+ MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,Toast.LENGTH_LONG).show();

      //  Toast.makeText(getApplicationContext(),"path2 "+
       //         Environment.getExternalStorageDirectory().getAbsolutePath(),Toast.LENGTH_LONG).show();
     //  getdata();
//        final Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {

//                finish();
//                startActivity(new Intent(splash.this, MainActivity.class));
//                return;

//
//            }
//        }, 1000);
//

    }



    public void runtimePermission(){
        Dexter.withContext(this).withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {


                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                splash.performClick();
                             myfn();
                           //     finish();
                          //   startActivity(new Intent(splash.this, MainActivity.class));




                            }
                        }, 500);

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                 permissionToken.continuePermissionRequest();
                    }
                }).check();


    }

    void myfn(){
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               // splash.performClick();

                finish();
                startActivity(new Intent(splash.this, MainActivity.class));




            }
        }, 2000);

    }

}
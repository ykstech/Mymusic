package com.example.mymusic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static com.example.mymusic.MainActivity.back;
import static com.example.mymusic.MainActivity.getAppContext;
import static com.example.mymusic.MainActivity.next;
import static com.example.mymusic.MainActivity.play;
import static com.example.mymusic.MainActivity.stateactivity;

public class NotificationReceiver extends BroadcastReceiver {
    public static  final  String anext = "NEXT";
    public static  final  String aprev = "PREVIOUS";
    public static  final  String aplay = "PLAY";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction()!=null){
            switch (intent.getAction()){
                case aplay :
                if(stateactivity==2){
                    play.performClick();
                     favorite.isplay();
                }else if(stateactivity==3){
                    play.performClick();
                  //  Toast.makeText(getAppContext(),"noimage", Toast.LENGTH_SHORT).show();
                    favmain.isplay();
                }else{

                    play.performClick();
                }
                    break;
                case  anext:
                    if(stateactivity==2){

                        MainActivity.next.performClick();
                        favorite.nexprev();
                    }else if(stateactivity==3){
                       // Toast.makeText(getAppContext(),"noimage",Toast.LENGTH_SHORT).show();
                        favmain.favnext();
                    }else {

                        MainActivity.next.performClick();
                    }

                    break;
                case  aprev:
                    if(stateactivity==2){
                        MainActivity.back.performClick();
                        favorite.nexprev();
                    }else if(stateactivity==3){
                        // Toast.makeText(getAppContext(),"noimage",Toast.LENGTH_SHORT).show();
                        favmain.favprev();
                    }else {

                        back.performClick();
                    }  break;
            }
        }


    }
}

package com.example.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphImageButton;
import soup.neumorphism.NeumorphImageView;
import soup.neumorphism.ShapeType;

import static android.view.View.GONE;
import static com.example.mymusic.ApplicationClass.anext;
import static com.example.mymusic.ApplicationClass.aplay;
import static com.example.mymusic.ApplicationClass.aprev;
import static com.example.mymusic.ApplicationClass.chid2;


public class MainActivity extends AppCompatActivity {

    public static RecyclerView parentRecyclerView;
 //   public static RecyclerView.Adapter ParentAdapter;
    public static ParentRecyclerViewAdapter ParentAdapter;
   public static ArrayList<ParentModel> parentModelArrayList = new ArrayList<>();
    public static RecyclerView.LayoutManager parentLayoutManager;
  public static   ChildRecyclerViewAdapter childRecyclerViewAdapter;
 public  static MediaMetadataRetriever   metaRetriver3;
    public static final int PERMISSION_READ = 0;

    //  public static final String ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION;
    static MyDatabase myDatabase;
 //   public static Bitmap songImage3 = null;

    static ArrayList<Todo> todoArrayList = new ArrayList<>();
    static ArrayList<Todo2> todoArrayList2 = new ArrayList<>();
    public static Uri uri;

    public static final int NEW_TODO_REQUEST_CODE = 200;
    public static final int UPDATE_TODO_REQUEST_CODE = 300;

    public static  Todo2 updatetodo2;
    TextView internetStatus;
    // public static Bitmap songImage3;
    public static ArrayList<HashMap<String, String>> generelist = new ArrayList<HashMap<String, String>>();

    public static ArrayList<songimageart> songimagelist = new ArrayList<>();
    public static ArrayList<Bitmap> songimagelist2 = new ArrayList<>();
    public static ArrayList<Bitmap> songimagelist3 = new ArrayList<>();

    public static ArrayList<HashMap<String, String>> timelist = new ArrayList<HashMap<String, String>>();

    public static ArrayList<HashMap<String, String>> artistmainlist = new ArrayList<HashMap<String, String>>();

    public static String newpath;

    public  BottomSheetBehavior bottomsheetBehavior;
static NeumorphCardView cardView,favoritem,cardView2;
public  static TextView name,artist,namemain,noofmain,subname;
    static NeumorphImageButton next;
    static NeumorphImageButton mnext;
    static NeumorphImageButton back;
    static NeumorphImageButton mback;
    static NeumorphImageButton mplay;
    static NeumorphImageButton play;
    NeumorphImageButton left,allsongsicon,topicon;
     AllAngleExpandableButton menu;
     static NeumorphImageView album_art2;
  //  NeumorphCardView flatcard;
    static CoordinatorLayout mactivity;
  public  static   RoundedImageView  album_art;
 public  static Bitmap songImage;
  static Thread updateseekbar;
public static long one=0;
  static AppCompatSeekBar seekBar,seekbar2;
public  static Uri uri2;
RelativeLayout top,bottom1;
 static NestedScrollView lmain;
static View bottom;
float slideoff;
int i=1;
int state=0;
float slideoffse;
    int state2=1;
public  static int positionm=0;
    private static Context context;
    private static  Activity activity;
    public  static  TextView timer,timerfull,no,topno;

  public static   MediaMetadataRetriever metaRetriver;
   public static byte[] art;
   static int xx=1;
// public  static    String[] itemsm;
public   static MediaPlayer mediaPlayerm;
static    ProgressBar progressBar;

   // public static ArrayList<File> mysongsm;

    NeumorphCardView button;
    AppCompatButton button2;

    static TextView table,table2;
    public static String songnamem;
    public static  String artistm;
    public  static String genere="";
    public  static String generecount="";
    public static String artistcount="";
    public  static String timecount= "";
    int status;
    //ss
   // final String MEDIA_PATH = Environment.getExternalStorageState();
    public static ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    public static ArrayList<CourseModal> courseModalArrayList =new ArrayList<>();

    public static ArrayList<CourseModal> courseModalArrayList2 =new ArrayList<>();

    public static ArrayList<CourseModal> courseModalArrayList3 =new ArrayList<>();
  //  private static Object MainActivity2;

    public static int stateactivity;

    static MediaSessionCompat mediaSession;
    //end
    static NotificationManager notificationManager;
    DownloadManager manager;
    Intent intent;
    String action,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent, action and MIME type
         intent = getIntent();
         action = intent.getAction();
         type = intent.getType();




        MainActivity.context = getApplicationContext();
       MainActivity.activity = MainActivity.getactivity();

        setContentView(R.layout.activity_main);


        ///movie//

        parentRecyclerView = findViewById(R.id.Parent_recyclerView);
        parentModelArrayList.clear();
        parentModelArrayList.add(new ParentModel("AI Recommended Songs"));
        parentModelArrayList.add(new ParentModel("Top Artist Songs"));
        parentModelArrayList.add(new ParentModel("Most Played Songs"));

        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager = new LinearLayoutManager(context);
        ParentAdapter = new ParentRecyclerViewAdapter(parentModelArrayList, context);
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentRecyclerView.setAdapter(ParentAdapter);
        // initialise();

     //   internetStatus = (TextView) findViewById(R.id.internet_status);

        // At activity startup we manually check the internet status and change
        // the text status

        //moview end//


      //  getSupportActionBar().hide();

        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, MyDatabase.DB_NAME).fallbackToDestructiveMigration().build();
        checkIfAppLaunchedFirstTime();
       //  loadAllTodos();

        stateactivity=1;
        mediaSession = new MediaSessionCompat(this,"PlayerAudio");


        mactivity = findViewById(R.id.mactivity);
        lmain = findViewById(R.id.lmain);
        button = findViewById(R.id.button);
      //  button2 = findViewById(R.id.button2);

        no = findViewById(R.id.no);

        allsongsicon = findViewById(R.id.basin_image_view);
        topicon = findViewById(R.id.basin_image_view2);

        topno = findViewById(R.id.top50);
    //   progressBar = findViewById(R.id.progress);

      //  getdata();

         bottom = findViewById(R.id.bottom);
       // RelativeLayout bottomsheet = bottom.findViewById(R.id.design_bottom_sheet);

        top = bottom.findViewById(R.id.top);
        bottom1 = bottom.findViewById(R.id.bottom1);


      //  table = findViewById(R.id.table);

     //   table2 = findViewById(R.id.table2);
      //  album_art2 = findViewById(R.id.imagecardm);
        cardView = findViewById(R.id.flat_card);

        cardView2 = findViewById(R.id.flat_card3);

        favoritem = findViewById(R.id.flat_cardf);
       back = bottom.findViewById(R.id.back);
        play = bottom.findViewById(R.id.play);
       next = bottom.findViewById(R.id.next);
       album_art = bottom.findViewById(R.id.album_art);
        seekBar = bottom.findViewById(R.id.seekbar);
        seekbar2 = bottom.findViewById(R.id.seekbarcardview2);
       timer = bottom.findViewById(R.id.timer);
        timerfull = bottom.findViewById(R.id.timerfull);

        mplay = bottom.findViewById(R.id.mplay);

        mback = bottom.findViewById(R.id.mback);
        mnext = bottom.findViewById(R.id.mnext);

        name = bottom.findViewById(R.id.name);
        artist = bottom.findViewById(R.id.artist);
        namemain = bottom.findViewById(R.id.namemain);
        subname = bottom.findViewById(R.id.subname);

        noofmain = findViewById(R.id.noofmain);




        left = bottom.findViewById(R.id.left);

        menu = (AllAngleExpandableButton) bottom.findViewById(R.id.button_expandable);


        bottomsheetBehavior = BottomSheetBehavior.from(bottom);
      //  bottomsheetBehavior.setPeekHeight(200);

        bottomsheetBehavior.setHideable(false);

        deactivated(play);
        deactivated(mplay);
        deactivated(next);
        deactivated(mnext);
        deactivated(back);
        deactivated(mback);
        deactivatedc(cardView);
        deactivatedc(favoritem);

        parentRecyclerView.setVisibility(GONE);

        if(one>9999999){
            one=0;
        }
if(one==0) {

//    if (checkPermission()) {
//      //  setAudio();
//        getAudioFiles();
//    }
    getAudioFiles();

}

        loadAllTodos2();

        loadAllTodos();



//        MyAsyncTask.execute(Environment.getExternalStorageDirectory().getAbsolutePath());

     //   getdata();

//        loadsongs();

        //runtimePermission();
       // getPlayList();



//        bottomsheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//       // bottomsheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
      //  bottomsheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);




        //       new MyAsyncTask().execute(context.getExternalFilesDir(null).getAbsolutePath());

      //  AllAngleExpandableButton button = (AllAngleExpandableButton)findViewById(R.id.button_expandable);


//        manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//        Uri urid = Uri.parse("https://pagalsong.in/lakeeran-haseen-dilruba-mp3-song.html");
//        DownloadManager.Request request = new DownloadManager.Request(urid);
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
//        long reference = manager.enqueue(request);


//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mplayer(Uri.parse("https://www.shazam.com/track/562803740/baarish-ki-jaaye"));
//                mediaPlayerm.start();
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                   // changeTextStatus(true);
                    mediaPlayerm.pause();
                    finish();
                    startActivity(new Intent(getApplicationContext(), download.class));

                } else {
                   // changeTextStatus(false);
                    toast("No Internet Connection");
                }

            }
        });


        loadData(1);
       loadData(2);

    if(courseModalArrayList2.size()==0){
         deactivatedc(favoritem);
    }
//        if(courseModalArrayList3.size()==0){
//            deactivatedc(cardView2);
//        }


    init();

        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {R.drawable.ic_baseline_menu_24,R.drawable.ic_baseline_star_rate_24, R.drawable.ic_baseline_favorite_24, R.drawable.ic_baseline_share_24};
      //  final List<ButtonData> buttonDatas = new ArrayList<>();
    //    int[] drawable = {R.drawable.plus, R.drawable.mark, R.drawable.settings, R.drawable.heart};292626
        int[] color = {R.color.menu,R.color.color_accent, R.color.color_accent, R.color.color_accent};
        for (int i = 0; i < 4; i++) {
            ButtonData buttonData;
            if (i == 0) {
                buttonData = ButtonData.buildIconButton(this, drawable[i], 3);
            } else {
                buttonData = ButtonData.buildIconButton(this, drawable[i], 5);
            }
            buttonData.setBackgroundColorId(this, color[i]);
            buttonDatas.add(buttonData);
        }
        menu.setButtonDatas(buttonDatas);
     //   setListener(button);


/*
        for (int i = 0; i < drawable.length; i++) {
            ButtonData buttonData = ButtonData.buildIconButton(context, drawable[i], 0);
            buttonDatas.add(buttonData);
        }
        menu.setButtonDatas(buttonDatas);


 */

        menu.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {
                //do whatever you want,the param index is counted from startAngle to endAngle,
                //the value is from 1 to buttonCount - 1(buttonCount if aebIsSelectionMode=true)

              //    Toast.makeText(getApplicationContext(),"click"+index,Toast.LENGTH_SHORT).show();
                  if(index==1){
                      adddata(1);
                  }
                  else if(index==2){
                  adddata(2);

                  }else {
                   //   String sharePath = Environment.getExternalStorageDirectory().getPath()
                    //          + "/Soundboard/Ringtones/custom_ringtone.ogg";
                      String sharePath= songsList.get(positionm).get("path");
                      Uri uri = Uri.parse(sharePath);
                      Intent share = new Intent(Intent.ACTION_SEND);
                      share.setType("audio/*");
                      share.putExtra(Intent.EXTRA_STREAM, uri);
                      startActivity(Intent.createChooser(share, "Share Sound File"));
                  }
            }

            @Override
            public void onExpand() {

            }

            @Override
            public void onCollapse() {

            }
        });

        allsongsicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             cardView.performClick();
            }
        });
        topicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              cardView2.performClick();
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomsheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomsheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mediaPlayerm.isPlaying()){
                    mediaPlayerm.pause();


                }else {
                           mediaPlayerm.start();

                }
                icon();
            }
        });
        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayerm.isPlaying()){
                    mediaPlayerm.pause();
                }else {
                    mediaPlayerm.start();

                }
               icon();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // deactivated(back);
                if(positionm==0) {
                    uri = Uri.parse(songsList.get(songsList.size()-1).get("path"));
                    positionm = songsList.size()-1;
                }else {

                    uri = Uri.parse(songsList.get(positionm-1).get("path"));
                    positionm = positionm-1;
                }
                mplayer(uri);
                mediaPlayerm.start();
                icon();
             //   stop(back);
            }
        });
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  deactivated(mback);
                if(positionm==0) {
                    uri = Uri.parse(songsList.get(songsList.size()-1).get("path"));
                    positionm = songsList.size()-1;
                }else {

                    uri = Uri.parse(songsList.get(positionm-1).get("path"));
                    positionm = positionm-1;
                }
                mplayer(uri);
                mediaPlayerm.start();
                icon();
           //      stop(mback);
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                next.setEnabled(false);
//                next.setActivated(false);
//                next.setClickable(false);

                //     Toast.makeText(getApplicationContext(),"deactivated",Toast.LENGTH_SHORT).show();
                if(positionm==songsList.size()-1) {
                    uri = Uri.parse(songsList.get(0).get("path"));
                    positionm = 0;
                }else {

                    uri = Uri.parse(songsList.get(positionm+1).get("path"));
                    positionm = positionm+1;
                }
                mplayer(uri);
                mediaPlayerm.start();

               icon();
              // stop(next);

              //  Toast.makeText(getApplicationContext(),"activated",Toast.LENGTH_SHORT).show();
            }
        });

        mnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(positionm==songsList.size()-1) {
                    uri = Uri.parse(songsList.get(0).get("path"));
                    positionm = 0;
                }else {

                    uri = Uri.parse(songsList.get(positionm+1).get("path"));
                    positionm = positionm+1;
                }
                mplayer(uri);
                mediaPlayerm.start();
               // deactivated(mnext);

                icon();
              // stop(mnext);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomsheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                //init();
            }
        });

        bottomsheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState==BottomSheetBehavior.STATE_COLLAPSED) {

                    bottomsheetBehavior.setHideable(false);
//                    bottomsheetBehavior.setPeekHeight(200);
                    state=0;
                    i=1;
                    top.setVisibility(View.VISIBLE);
                    bottom1.setVisibility(GONE);
                    lmain.setVisibility(View.VISIBLE);
                    init();
                }
                if(newState==BottomSheetBehavior.STATE_EXPANDED){
                    state=1;
                    i=1;
                    top.setVisibility(GONE);
                    bottom1.setVisibility(View.VISIBLE);
                    lmain.setVisibility(GONE);
           //      Toast.makeText(getApplicationContext(),"expanded",Toast.LENGTH_SHORT).show();
                }

                if(newState==BottomSheetBehavior.STATE_DRAGGING){

                    top.setVisibility(View.VISIBLE);
                    bottom1.setVisibility(View.VISIBLE);
                   // lmain.setVisibility(View.VISIBLE);
                //  Toast.makeText(getApplicationContext(),"dragging",Toast.LENGTH_SHORT).show();
                }

//                if(newState==BottomSheetBehavior.STATE_SETTLING){
//                     state2=1;
//                 // Toast.makeText(getApplicationContext(),"settling",Toast.LENGTH_SHORT).show();
//                }
           }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if(state==0 && i==1){
                    slideoffse=1;

                    slideoff=0;

                    i++;
                }else if(state==1 && i==1) {
                    slideoffse=0;
                    slideoff=1;
                    i++;
                }

                if(slideOffset<1&&slideOffset>0){

                    top.setVisibility(View.VISIBLE);
                    bottom1.setVisibility(View.VISIBLE);
                    lmain.setVisibility(View.VISIBLE);
                }

                ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(top, View.ALPHA, slideoffse, 1-slideOffset);
                slideoffse = 1-slideOffset;
             //   Toast.makeText(getApplicationContext(),"alphas "+state2+"alphae "+(1-slideOffset),Toast.LENGTH_SHORT).show();
               ObjectAnimator fadeAltAnim2 = ObjectAnimator.ofFloat(bottom1, View.ALPHA, slideoff, slideOffset);
                slideoff = slideOffset;
              //  fadeAltAnim.setDuration(dur);
              //  fadeAltAnim.setStartDelay(delay);

              //  fadeAltAnim3.setStartDelay(delay);
               // fadeAltAnim3.setDuration(dur+100);

                AnimatorSet set2 = new AnimatorSet();

                set2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {


                    }
                    @Override
                    public void onAnimationStart(Animator animation){

                    }
                });


                set2.playTogether(fadeAltAnim,fadeAltAnim2 );
                set2.start();


            }
        });



         cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                 //starting the profile activity
                 finish();
                 startActivity(new Intent(getApplicationContext(), favorite.class));

             }
         });
        favoritem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                courseModalArrayList=courseModalArrayList2;
              int  id = 2;
                Intent intent = new Intent(getApplicationContext(), favmain.class);
                intent.putExtra("Id", id);
                finish();
                startActivity(intent);
//                //starting the profile activity
              //  finish();
             //  startActivity(new Intent(getApplicationContext(), favmain.class));
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseModalArrayList=courseModalArrayList3;
                int  id = 1;
                Intent intent = new Intent(getApplicationContext(), favmain.class);
                intent.putExtra("Id", id);
                finish();
                startActivity(intent);
            }
        });


     //   getdata();

name.setSelected(true);
artist.setSelected(true);
subname.setSelected(true);
namemain.setSelected(true);

try {
    xx=0;
    uri = Uri.parse(songsList.get(positionm).get("path"));
    mplayer(uri);
    icon();

} catch (Exception e) {
    e.printStackTrace();
    xx=1;
}

//runtimePermission();
//getdata();

    //    ParentAdapter.notifyDataSetChanged();
       // childRecyclerViewAdapter.notifyDataSetChanged();

        if(one!=0) {
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if (type.startsWith("audio/")) {
                    handleSendVideo(intent); // Handle single image being sent
                }
            }
        }

    }

        void handleSendVideo(Intent intent) {
            Uri videouri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
            if (videouri != null) {
                // Update UI to reflect image being shared

             //   String str2= String.valueOf(videouri);
                String str = videouri.getPath();

                // Trim the given string
              //  str = str.trim();
//               int ff=0,count=0;
//                for (int i = 0; i < str2.length(); i++) {
//
//                    // Print current character
//                    if(str2.charAt(i)=='/'){
//
//                        if(count==3){
//                            ff=i;
//                            break;
//                        }
//
//                        count++;
//
//                }
//                }
//                // Replace All space (unicode is \\s) to %20
//                str2 = str2.substring(ff, str2.length() );
//
//                str2 = str2.replaceAll("%20", " ");
//
//              //  toast("uri2 "+str2);
                str = str.substring(13, str.length() );

                Uri n = Uri.parse(str);

              //  Toast.makeText(getApplicationContext(),"uri2 "+n,Toast.LENGTH_LONG).show();

                mplayer(n);
              //  bottomsheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                mediaPlayerm.start();

                icon();


            }
        }



    public static Context getAppContext() {
        return MainActivity.context;
    }

    public static Activity getactivity() {
        return MainActivity.activity;
    }

    public static void activated(NeumorphImageButton button){
        button.setActivated(true);
        button.setEnabled(true);

    }
    public static void activatedc(NeumorphCardView button){
        button.setActivated(true);
        button.setEnabled(true);

    }

    public static void deactivated(NeumorphImageButton button){
        button.setActivated(false);
        button.setEnabled(false);


    }

    public static void deactivatedc(NeumorphCardView button){
        button.setActivated(false);
        button.setEnabled(false);


    }

    public static void icon(){
        try {



            activated(play);
            activated(mplay);
            activated(next);
            activated(mnext);
            activated(back);
            activated(mback);
            activatedc(cardView);
            activatedc(favoritem);

            parentRecyclerView.setVisibility(View.VISIBLE);

            if(mediaPlayerm.isPlaying()){

             //   name.setText(songsList.get(position).get("name"));

                play.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.ic_baseline_pause_24));
            //    play.setShapeType(ShapeType.PRESSED);
             //   mplay.setShapeType(ShapeType.PRESSED);
                mplay.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.pause));


                shownotification(R.drawable.ic_baseline_pause_24);
            }else {

              //  name.setText(songsList.get(position).get("name"));




             //   name.setText(songsList.get(0).get("songPath"));
                play.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.ic_baseline_play_arrow_24));
                play.setShapeType(ShapeType.FLAT);
                mplay.setShapeType(ShapeType.FLAT);

                mplay.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.play));


                shownotification(R.drawable.ic_baseline_play_arrow_24);

            }
        } catch (Exception e) {
            e.printStackTrace();
         //   Toast.makeText(MainActivity.getAppContext(),"No Songs Found",Toast.LENGTH_SHORT).show();


        }

    }
    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    public static void mplayer(Uri uri){

        if(xx==1) {
            if (mediaPlayerm != null) {
                if (mediaPlayerm.isPlaying()) {
                    mediaPlayerm.stop();
                }
                mediaPlayerm.release();

                mediaPlayerm = null;
            }

          //  Intent intent = new Intent(context, musicservice.class);
         //   intent.putExtra("uri5", uri);

          //  getAppContext().startService(intent);


           // getAppContext().startService(new Intent(context,musicservice.class));
           mediaPlayerm = MediaPlayer.create(MainActivity.getAppContext(), uri);
        }

        metaRetriver = new MediaMetadataRetriever();
        metaRetriver.setDataSource(uri.getPath());

//seekbar//
        mediaPlayerm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                next.performClick();
            }
        });
///counte//




        //counterend//

        String dural = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

        String dura = createtime(Long.parseLong(dural));


        long durationStr = Long.parseLong(dural);


      //  int progress = (int)(getProgressPercentage(currentDuration, totalDuration));
        //Log.d("Progress", ""+progress);
       // songProgressBar.setProgress(progress);


          seekBar.setMax((int)durationStr);

          //  Toast.makeText(MainActivity.getAppContext(),"duration "+durationStr,Toast.LENGTH_SHORT).show();
        seekbar2.setMax((int) durationStr);


        updateseekbar = new Thread(){
            @Override
            public void run() {
                long total =  durationStr;
                long currentPosition=0;

            //    int progress = (int)(getProgressPercentage(currentPosition, total));

              while (currentPosition<total){

                    try {

                        sleep(1000);
                        // current = mediaPlayerm.getCurrentPosition();

                    if(mediaPlayerm != null && mediaPlayerm.isPlaying()) {
                        currentPosition = mediaPlayerm.getCurrentPosition();

                       // int progress = (int)(getProgressPercentage(currentPosition, total));
                        seekBar.setProgress((int) currentPosition);

                        //    Toast.makeText(MainActivity.getAppContext(),"pp"+currentPosition,Toast.LENGTH_SHORT).show();
                        seekbar2.setProgress((int) currentPosition);
                    }

                    }
               catch (  Exception e) {
                    e.printStackTrace();
                }




              }
            }
        };






        final long[] pp = new long[1];

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
               // updateseekbar.stop();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               mediaPlayerm.seekTo(seekBar.getProgress());
               pp[0] = seekBar.getProgress();


                seekbar2.setProgress((int) pp[0]);

             //   int totalDuration = Math.toIntExact(durationStr);
             //   int currentPosition = progressToTimer(seekBar.getProgress(), totalDuration);

                // forward or backward to certain seconds
             //   mediaPlayerm.seekTo(currentPosition);


            }
        });

        seekbar2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        //seekbar//

        updateseekbar.start();


        timerfull.setText(dura);

        try {


            final Handler handler = new Handler(Looper.getMainLooper());
            final int delay = 1000;

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                        String currenttime = createtime(mediaPlayerm.getCurrentPosition());

                        timer.setText(currenttime);
                        handler.postDelayed(this, delay);

                }
            }, delay);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

                art = metaRetriver.getEmbeddedPicture();
                 songImage = BitmapFactory.decodeByteArray(art, 0, art.length);
                album_art.setImageBitmap(songImage);
        //    album_art2.setImageBitmap(songImage);


        } catch (Exception e) {
                album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));

       //     album_art2.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
               songImage = null;



            //    Toast.makeText(MainActivity.getAppContext(),"No Image",Toast.LENGTH_SHORT).show();
            }
            artist.setText(metaRetriver .extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
            subname.setText(metaRetriver .extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));

        artistm = metaRetriver .extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
       // artist.setText(artistm);
       // subname.setText(artistm);
            if(artist.length()==0){

                artist.setText("unknown artist");

                subname.setText("unknown artist");

                artistm = "unknown artist";
            }

        namemain.setText(metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
            name.setText(metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        songnamem = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);


          if(name.length()==0){
              name.setText(songsList.get(positionm).get("name"));

              namemain.setText(songsList.get(positionm).get("name"));
              songnamem = songsList.get(positionm).get("name");
          }

          genere=metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
          if(genere==null){
              genere = "unknown";
          }


          if(xx==1) {


              int flag3 = 0;
              for (int i = 0; i < todoArrayList.size(); i++) {
                  if (todoArrayList.get(i).description.equals(String.valueOf(uri))) {
                      double countcat = todoArrayList.get(i).time + 1;
                      updateRow(countcat, String.valueOf(uri));
                      //   toast("found");
                      flag3 = 1;
                      break;
                  } else {
                      flag3 = 2;
                  }
              }

              if (flag3 == 2) {
                  if (songImage==null) {

                  }else {
                      Todo todo2 = new Todo();
                      todo2.description = String.valueOf(uri);
                      todo2.time = 1;
                      insertRow(todo2);
                  }

              }



              int flag = 0;
              for (int i = 0; i < todoArrayList2.size(); i++) {
                  if (todoArrayList2.get(i).category.equals(genere)) {
                      double countcat = todoArrayList2.get(i).countcat + 1;
                      updateRow2(countcat, genere);
                      //   toast("found");
                      flag = 1;
                      break;
                  } else {
                      flag = 2;
                  }
              }

              if (flag == 2) {
                  if (genere.equals("unknown") || songImage==null) {

                  } else {
                      Todo2 todo2 = new Todo2();
                      todo2.category = genere;
                      todo2.countcat = 1;
                      todo2.artist = "";
                      todo2.countartist = 0;

                      insertRow2(todo2);

                  }
              }

              int flag2 = 0;
              for (int i = 0; i < todoArrayList2.size(); i++) {
                  if (todoArrayList2.get(i).artist.equals(artistm)) {
                      double countartist = todoArrayList2.get(i).countartist + 1;
                      updateRow3(countartist, artistm);
                      //   toast("found");
                      flag2 = 1;
                      break;
                  } else {
                      flag2 = 2;
                  }
              }

              if (flag2 == 2) {
                  if (artistm.equals("unknown") || artistm.equals("unknown artist") || songImage==null ) {

                  } else {

                      Todo2 todo3 = new Todo2();
                      todo3.category = "";
                      todo3.countcat = 0;
                      todo3.artist = artistm;
                      todo3.countartist = 1;

                      insertRow3(todo3);

                  }
              }

          }
     //   myfn2();



        noofmain.setText(Integer.toString(songsList.size())+" Songs");


        xx=1;
    }

//
//    public boolean checkPermission() {
//        int READ_EXTERNAL_PERMISSION = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
//        if((READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED)) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_READ);
//            return false;
//        }
//        return true;
//    }
//
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case  PERMISSION_READ: {
//                if (grantResults.length > 0 && permissions[0].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
//                        Toast.makeText(getApplicationContext(), "Please allow storage permission", Toast.LENGTH_LONG).show();
//                    } else {
//                      //  setAudio();
//                        getAudioFiles();
//                    }
//                }
//            }
//        }
//    }

    public  void getAudioFiles() {
      //  MainActivity test = new MainActivity();
        class update extends AsyncTask<ArrayList<HashMap<String, String>>, ProgressBar, String> {


            @Override
            protected String doInBackground(ArrayList<HashMap<String, String>>... arrayLists) {

                String ss;

        try {
            String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

            //  songimagelist.clear();tools:ignore="ScopedStorage"
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                uri2 = MediaStore.Audio.Media
                        .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
            } else {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
                          //  uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            String[] projection = {MediaStore.Audio.AudioColumns.TITLE,MediaStore.Audio.AudioColumns.DATA};

            //= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
           // uri = Uri.fromFile(Environment.getExternalStorageDirectory());
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                uri2 = MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL);
//            } else {
//                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                //toast("uri "+uri);
//
//            }
         //   toast(String.valueOf(uri));
            Cursor cursor = contentResolver.query(uri2, projection, selection, null, null);
            //looping through all rows and adding to list
            if (cursor != null && cursor.moveToFirst()) {
                do {

                   // String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                 //     String duration = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                   // String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                       String title = cursor.getString(0);

                    String url = cursor.getString(1);


                 MediaMetadataRetriever   metaRetriver2 = new MediaMetadataRetriever();

                   Uri urim = Uri.parse(url);
                    metaRetriver2.setDataSource(urim.getPath());
                   String artist=metaRetriver2 .extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
                   String genere=metaRetriver2.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);

//                   Bitmap nbit2;
//                    try {
//
//
//                        byte[] art3 = metaRetriver2.getEmbeddedPicture();
//                         nbit2 = BitmapFactory.decodeByteArray(art3, 0, art3.length);
//
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        nbit2 = null;
//                    }
//                    songimagelist.add(new songimageart(nbit2, url));


//                    String year=metaRetriver2.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
                    if(genere==null){
                        genere = "unknown";
                    }  if(artist==null){
                        artist = "unknown";
                    }

                  //  songimagelist.add(nbit);

//                    if(year==null){
//                        year = "unknown";
//                    }


                    //   if(Integer.parseInt(duration)>5000) {

                        HashMap<String, String> song = new HashMap<String, String>();
                        song.put("name", title);
                        song.put("path", url);
                        song.put("genere",genere);
                        song.put("artist",artist);
                   //     song.put("image", );

                        songsList.add(song);
               //     }

                } while (cursor.moveToNext());
            }
           Collections.sort(songsList, new Comparator<HashMap<String, String>>() {
               @Override
               public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
                   return o1.get("name").compareTo(o2.get("name"));
               }
           });

        mymetaphoto(songsList);



         //   Toast.makeText(MainActivity.getAppContext(), "Songs ready to Play", Toast.LENGTH_SHORT).show();
           //   toast("s "+songimagelist.size()+" ss "+songsList.size());
               ss="Songs ready to Play";
        } catch (Exception e) {
            e.printStackTrace();

            //deactivatedc(favoritem);
        //    Toast.makeText(MainActivity.getAppContext(), "No Song Found", Toast.LENGTH_SHORT).show();
            ss="No Song Found";

        }


                return ss;



            }

            @Override
            protected void onPostExecute(String todo2) {
                super.onPostExecute(todo2);

                try {
                    if (todo2.equals("Songs ready to Play")) {

                      //  toast("size "+Integer.toString(songsList.size()));
                       // toast("uri"+ uri);

                        uri = Uri.parse(songsList.get(positionm).get("path"));
                        mplayer(uri);
                        icon();
                        parentRecyclerView.setVisibility(View.VISIBLE);
                      //   toast("uri "+uri.getPath());

                        if (Intent.ACTION_SEND.equals(action) && type != null) {
                            if (type.startsWith("audio/")) {

                                // parentRecyclerView.setVisibility(GONE);
                                 handleSendVideo(intent); // Handle single image being sent
                            }
                        }

                    }else if (Intent.ACTION_SEND.equals(action) && type != null) {
                            if (type.startsWith("audio/")) {

                                deactivated(play);
                                deactivated(mplay);
                                deactivated(next);
                                deactivated(mnext);
                                deactivated(back);
                                deactivated(mback);
                                deactivatedc(cardView);
                                parentRecyclerView.setVisibility(GONE);
                                handleSendVideo(intent); // Handle single audio being sent
                            }
                        }




                    else {
                        deactivated(play);
                        deactivated(mplay);
                        deactivated(next);
                        deactivated(mnext);
                        deactivated(back);
                        deactivated(mback);
                        deactivatedc(cardView);
                        parentRecyclerView.setVisibility(GONE);
                    }
                    toast(todo2);
                }catch (Exception e){
                    toast("ERROR");
                }
            }

        }
        new update().execute();




        //   AudioAdapter adapter = new AudioAdapter(this, audioArrayList);
      //  recyclerView.setAdapter(adapter);
    }

    public  void count(TextView txtvar, int txtvarval,int show){


        txtvar.setText("");



        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //stat
                ValueAnimator valueAnim = ValueAnimator.ofInt(0, txtvarval );
                valueAnim.setDuration(1000);
                 valueAnim.setStartDelay(1000);
                valueAnim.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        txtvar.setText(valueAnim.getAnimatedValue().toString());


                    }
                });

                valueAnim.start();

                //end
            }
        });
if(show==1) {
    txtvar.append("Songs");
}
    }


    public  static   void getdata(){



         class MyAsyncTask extends AsyncTask<String, ProgressBar, ArrayList<File>> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
               // getscr();
           //    lmain.setVisibility(GONE);
             //  bottom.setVisibility(GONE);
              //  ProgressBar  progressBar =  findViewById(R.id.progress);
               // progressBar.setVisibility(View.VISIBLE);

            }


            @Override
    protected ArrayList<File> doInBackground(String... strings) {




                    File file = new File(strings[0]);
                  //     Toast.makeText(MainActivity.getAppContext(),"Songs",Toast.LENGTH_SHORT).show();



                    File[] files = file.listFiles();

                  ArrayList<File> arrayList = new ArrayList<>();
             //   Log.e("details", Arrays.toString(file.listFiles()));
                if (files != null) {

                  //  Log.e("details", "not null");
                    for (File singlefile : files) {
                        if (singlefile.isDirectory() && !singlefile.isHidden()) {
                            arrayList.addAll(findsong(singlefile));
                        } else {
                            if (singlefile.getName().endsWith(".mp3")) {
                                arrayList.add(singlefile);
                            }
                        }
                    }
                }

                return arrayList;


            }

    @Override
    protected void onPostExecute(ArrayList<File> mysongsm) {
        super.onPostExecute(mysongsm);

        try {
            for (int i = 0; i < mysongsm.size(); i++) {
                //  itemsm[i] = mysongsm.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");

                HashMap<String, String> song = new HashMap<String, String>();
                song.put("name", mysongsm.get(i).getName().substring(0, (mysongsm.get(i).getName().length() - 4)));
                song.put("path", mysongsm.get(i).getAbsolutePath());


                songsList.add(song);

              //  Toast.makeText(MainActivity.getAppContext(),"song "+songsList.get(i).get("name"),Toast.LENGTH_SHORT).show();
            }


        //    Toast.makeText(MainActivity.getAppContext(),"songs"+songsList.size(),Toast.LENGTH_SHORT).show();
            uri = Uri.parse(songsList.get(positionm).get("path"));
           mplayer(uri);
           //icon();

            Toast.makeText(MainActivity.getAppContext(),"songs ready to play",Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
/*
            deactivated(play);
            deactivated(mplay);
            deactivated(next);
            deactivated(mnext);
            deactivated(back);
            deactivated(mback);

            deactivatedc(cardView);


             Toast.makeText(MainActivity.getAppContext(),"No Songs Found",Toast.LENGTH_SHORT).show();


 */
        }

    }

    private Collection<? extends File> findsong(File singlefile) {

    //  AsyncTask<String, ProgressBar, ArrayList<File>> arrayList  =  new MyAsyncTask().execute(String.valueOf(singlefile));
        return doInBackground(singlefile.getAbsolutePath());
    }
}

//        MyAsyncTask  ul = new MyAsyncTask();
//        ul.execute(Environment.getExternalStorageDirectory().getAbsolutePath());

      // new MyAsyncTask().execute(Environment.getExternalStorageDirectory().getAbsolutePath());

           new MyAsyncTask().execute(String.valueOf(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI));

      //  Log.e(TAG, "getdata:",MainActivity.getAppContext().getExternalFilesDir(null).getAbsolutePath() );
    }


//    private  void  loadsongs() {
//   //     mysongsm = findsong(Environment.getExternalStorageDirectory());
//      //  itemsm = new String[mysongsm.size()];
//    }

/*
        static class FileExtensionFilter implements FilenameFilter {
            public boolean accept(File dir, String name) {
                return (name.endsWith(".mp3") || name.endsWith(".MP3" ) || name.endsWith(".wav" ));
            }
        }

        public ArrayList<HashMap<String, String>> getPlayList(){
            File home = new File(Environment.getExternalStorageDirectory()+"/");

            if (Objects.requireNonNull(home.listFiles(new FileExtensionFilter())).length > 0) {
                for (File file : Objects.requireNonNull(home.listFiles(new FileExtensionFilter()))) {
                    HashMap<String, String> song = new HashMap<String, String>();
                    song.put("songTitle", file.getName().substring(0, (file.getName().length() - 4)));
                    song.put("songPath", file.getPath());

                    // Adding each song to SongList
                    songsList.add(song);
                }
            }
            // return songs list array
            return songsList;
        }


 */
        /**
         * Class to filter files which are having .mp3 extension
         * */


       // adapter = new favorite.ProductsAdapter(this,mysongs);

        //recyclerView.setAdapter(adapter);






    @Override
    public void onBackPressed(){
        if(bottomsheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
          bottomsheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
         // init();
        }else {

            finish();

        }
    }
/*
    public static String createtime(int duration){
        String time="";
        int min=duration/1000/60;
        int sec = duration/1000%60;
        time+=min+":";

        if(sec<10){
            time+="0";
        }
        time+=sec;
     return  time;
    }

 */

    public static String createtime(long milliseconds){
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        // Add hours if there
        if(hours > 0){
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if(seconds < 10){
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;}

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }
    public static int getProgressPercentage(long currentDuration, long totalDuration){
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage =(((double)currentSeconds)/totalSeconds)*100;

        // return percentage
        return percentage.intValue();
    }

    public static int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = (int) (totalDuration / 1000);
        currentDuration = (int) ((((double)progress) / 100) * totalDuration);

        // return current duration in milliseconds
        return currentDuration * 1000;
    }

    public static void adddata(int s) {
        // below line is use to add data to array list.
        // loadData();
        int flagx=0;
        if(s==1){
            courseModalArrayList=courseModalArrayList3;
        }else {
            courseModalArrayList=courseModalArrayList2;
        }

        for(int i=0;i<courseModalArrayList.size();i++){
            if(courseModalArrayList.get(i).getCourseDescription().equals(songsList.get(positionm).get("path"))){

                flagx=1;
                break;
            }
        }

        if(flagx==0) {
            courseModalArrayList.add(new CourseModal(songsList.get(positionm).get("name"), songsList.get(positionm).get("path"),songsList.get(positionm).get("genere"),songsList.get(positionm).get("artist")));
            // notifying adapter when new data added.
          //  adapter.notifyItemInserted(courseModalArrayList.size());

            saveData(s);

            String nn;
            if(s==1){
                nn="top50";
            }else {
                nn="favorites";
            }
            // after saving data we are displaying a toast message.
            Toast.makeText(context, "song added to "+nn, Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(context, "song already exists", Toast.LENGTH_SHORT).show();
        }
    }


    public static void saveData(int s) {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
//
//        if(s==1){
//            courseModalArrayList=courseModalArrayList3;
//        }else {
//            courseModalArrayList=courseModalArrayList2;
//        }
         String sp ="shared preferences"+s;
        SharedPreferences sharedPreferences = context.getSharedPreferences(sp, MODE_PRIVATE);

        //getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.

        String json = gson.toJson(courseModalArrayList);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("courses", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

    }

    public static  void  deletedata(int s){
        String sp ="shared preferences"+s;
        SharedPreferences sharedPreferences = context.getSharedPreferences(sp, MODE_PRIVATE);

        //getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //SharedPreferences.Editor editor = settings.edit();
        editor.remove("courses");
        editor.apply();

        saveData(s);




    }

    public static void loadData(int s) {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.

        String sp ="shared preferences"+s;
        SharedPreferences sharedPreferences = context.getSharedPreferences(sp, MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("courses", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<CourseModal>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list

        courseModalArrayList = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (courseModalArrayList == null) {
            // if the array list is empty
            // creating a new array list.
            courseModalArrayList = new ArrayList<>();
        }

        if(s==1){
        courseModalArrayList3=courseModalArrayList;
        }else {
          courseModalArrayList2=courseModalArrayList;
        }

    }


    void init() {
        no.setText(String.valueOf(courseModalArrayList2.size()));
        topno.setText(String.valueOf(courseModalArrayList3.size()) + " Songs");

     //   count(no,courseModalArrayList2.size(),1);

       // count(topno,courseModalArrayList3.size(),1);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static void shownotification(int playpause) {
      //  Intent intent = new Intent(context, MainActivity.class);
      //  PendingIntent contentintent = PendingIntent.getActivity(context, 0, intent, 0);

        Intent previntent = new Intent(context, NotificationReceiver.class).setAction(aprev);
        PendingIntent prevpendingintent = PendingIntent.getBroadcast(context, 0, previntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent playintent = new Intent(context, NotificationReceiver.class).setAction(aplay);
        PendingIntent playpendingintent = PendingIntent.getBroadcast(context, 0, playintent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent nextintent = new Intent(context, NotificationReceiver.class).setAction(anext);
        PendingIntent nextpendingintent = PendingIntent.getBroadcast(context, 0, nextintent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap smallicon,sm;
        if (songImage == null) {

            smallicon = BitmapFactory.decodeResource(context.getResources(),R.drawable.cloth);

        }else {
               smallicon = songImage;
        }
        sm= BitmapFactory.decodeResource(context.getResources(),R.drawable.cloth);

        Notification notification = new NotificationCompat.Builder(context, chid2)
                .setLargeIcon(smallicon)
                .setSmallIcon(R.drawable.cloth)
                .setContentTitle(songnamem)
                .setContentText(artistm)
                .addAction(R.drawable.ic_baseline_fast_rewind_24, "Previous", prevpendingintent)
                .addAction(playpause, "Play", playpendingintent)
                .addAction(R.drawable.ic_baseline_fast_forward_24, "Next", nextpendingintent)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setMediaSession(mediaSession.getSessionToken()))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                 .setColorized(true)
                .setColor(Color.RED)

              //  .setAutoCancel(true)
             //   .setContentIntent(contentintent)
                .setOnlyAlertOnce(true)
                .build();

        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

      //  notificationManager.cancel(0);

    }


//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mediaPlayerm.stop();
//        mediaPlayerm.release();
//        notificationManager.cancel(0);
//    }



    @SuppressLint("StaticFieldLeak")
    private static void loadAllTodos() {
        new AsyncTask<String, Void, List<Todo>>() {
            @Override
            protected List<Todo> doInBackground(String... params) {
                return myDatabase.daoAccess().fetchAllTodos();
            }

            @Override
            protected void onPostExecute(List<Todo> todoList) {
                todoArrayList.clear();
                todoArrayList.addAll(todoList);

                fetchbytimemax();

                if(checkIfAppLaunchedFirstTime()==1)
                {
                  //  mplayer(uri);
                }

            }
        }.execute();
    }
    @SuppressLint("StaticFieldLeak")
    private static void loadAllTodos2() {
        new AsyncTask<String, Void, List<Todo2>>() {
            @Override
            protected List<Todo2> doInBackground(String... params) {
                return myDatabase.daoAccess().fetchAllTodos2();
            }

            @Override
            protected void onPostExecute(List<Todo2> todoList2) {
                todoArrayList2.clear();
                todoArrayList2.addAll(todoList2);
                fetchbyartmax();

                if(checkIfAppLaunchedFirstTime()==1)
                {
                 //   mplayer(uri);
                }

            }
        }.execute();
    }

    private static void buildDummyTodos() {
        Todo todo = new Todo();
      //  todo.name = "Android Retrofit Tutorial";
        todo.description = "jadu";
        todo.time = 0;

     //   todo.artist = "jubin";

      //  todo.category = "Android";
      //  todoArrayList.add(todo);

        todoArrayList.add(todo);
        insertList(todoArrayList);
    }
    private static void buildDummyTodos2() {
        Todo2 todo = new Todo2();

        todo.artist = "yks";

        todo.category = "Android";
        todoArrayList2.add(todo);
        insertList2(todoArrayList2);
//
//        todo = new Todo2();
//        todo.category = "iOS";
//        todo.artist = "bhai";
//
//
//        todoArrayList2.add(todo);
//
//        todo = new Todo2();
//        todo.category = "Kotlin";
//
//        todo.artist = "jihaaaa";
//
//        todoArrayList2.add(todo);
//
//        todo = new Todo2();
//        todo.category = "Swift";
//
//        todo.artist = "doon";
//
//        todoArrayList2.add(todo);

    }


    @SuppressLint("StaticFieldLeak")
    private static void insertList(List<Todo> todoList) {
        new AsyncTask<List<Todo>, Void, Void>() {
            @Override
            protected Void doInBackground(List<Todo>... params) {
                myDatabase.daoAccess().insertTodoList(params[0]);

                return null;

            }

            @Override
            protected void onPostExecute(Void voids) {
                super.onPostExecute(voids);
               // loadAllTodos2();
            }
        }.execute(todoList);

    }
    @SuppressLint("StaticFieldLeak")
    private static void insertList2(List<Todo2> todoList2) {
        new AsyncTask<List<Todo2>, Void, Void>() {
            @Override
            protected Void doInBackground(List<Todo2>... params) {
                myDatabase.daoAccess().insertTodoList2(params[0]);

                return null;

            }

            @Override
            protected void onPostExecute(Void voids) {
                super.onPostExecute(voids);
            //    loadAllTodos2();
            }
        }.execute(todoList2);

    }


    private static int checkIfAppLaunchedFirstTime() {
        final String PREFS_NAME = "SharedPrefs";

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("firstTime", true)) {
            settings.edit().putBoolean("firstTime", false).apply();
            buildDummyTodos();
            buildDummyTodos2();
            return 1;

        }else {
            return 0;
        }
    }

//
//    @SuppressLint("StaticFieldLeak")
//    private static void updateRow2(Todo2 todo2) {
//        new AsyncTask<Todo2, Void, Integer>() {
//            @Override
//            protected Integer doInBackground(Todo2... params) {
//                return myDatabase.daoAccess().updateTodo2(params[0]);
//            }
//
//            @Override
//            protected void onPostExecute(Integer number) {
//                super.onPostExecute(number);
//
//            }
//        }.execute(todo2);
//
//
//    }

    @SuppressLint("StaticFieldLeak")
    private static void updateRow2(double countcat, String category) {
        class update extends AsyncTask<String, ProgressBar, Integer> {


            @Override
            protected Integer doInBackground(String... strings) {
                return myDatabase.daoAccess().updateTodo2(Double.parseDouble(strings[0]),strings[1]);

            }

            @Override
            protected void onPostExecute(Integer s) {
                super.onPostExecute(s);
              //  toast("updated");
                loadAllTodos2();


            }

        }
        new update().execute(String.valueOf(countcat),category);
    }
    @SuppressLint("StaticFieldLeak")
    private static void updateRow3(double countartist, String artist) {
        class update extends AsyncTask<String, ProgressBar, Integer> {


            @Override
            protected Integer doInBackground(String... strings) {
                return myDatabase.daoAccess().updateTodo3(Double.parseDouble(strings[0]),strings[1]);

            }

            @Override
            protected void onPostExecute(Integer s) {
                super.onPostExecute(s);
              //  toast("updated2");
               // loadAllTodos();
                loadAllTodos2();



            }

        }
        new update().execute(String.valueOf(countartist),artist);
    }
    @SuppressLint("StaticFieldLeak")
    private static void updateRow(double countartist, String artist) {
        class update extends AsyncTask<String, ProgressBar, Integer> {


            @Override
            protected Integer doInBackground(String... strings) {
                return myDatabase.daoAccess().updateTodo(Double.parseDouble(strings[0]),strings[1]);

            }

            @Override
            protected void onPostExecute(Integer s) {
                super.onPostExecute(s);
              //  toast("updated3");
               loadAllTodos();


            }

        }
        new update().execute(String.valueOf(countartist), String.valueOf(artist));
    }

    @SuppressLint("StaticFieldLeak")
    private static void fetchbycatmax() {
        class update extends AsyncTask<String, ProgressBar, ArrayList<String>> {


            @Override
            protected ArrayList<String> doInBackground(String... strings) {
                return (ArrayList<String>) myDatabase.daoAccess().fetchTodoListByCategory();

            }

            @Override
            protected void onPostExecute(ArrayList<String> todo2) {
                super.onPostExecute(todo2);

                generelist.clear();


                int old=0;
                for(int i=0;i<todo2.size();i++){
                   for(int j=0;j<songsList.size();j++){
                       if(songsList.get(j).get("genere").equals(todo2.get(i))){
                           final   HashMap<String, String> songf = new HashMap<String, String>();
                           songf.put("name", songsList.get(j).get("name"));

                           songf.put("path", songsList.get(j).get("path"));

                           songf.put("genere", songsList.get(j).get("genere"));
                           songf.put("artist", songsList.get(j).get("artist"));
                        //   songf.put("image", songsList.get(j).get("image"));


                           generelist.add(songf);


                       }
                   }

                    for(int k=0;k<artistmainlist.size();k++){
                        for(int l=old;l<generelist.size();l++) {
                            if (generelist.get(l).get("artist").equals(artistmainlist.get(k).get("artist"))) {
                                final   HashMap<String, String> songf = new HashMap<String, String>();
                                songf.put("name", generelist.get(l).get("name"));

                                songf.put("path", generelist.get(l).get("path"));

                                songf.put("genere", generelist.get(l).get("genere"));
                                songf.put("artist", generelist.get(l).get("artist"));

                             //   songf.put("image", generelist.get(l).get("image"));

                                generelist.add(old,songf);
                                generelist.remove(l+1);

                            }
                        }
                    }
                    old=generelist.size();
                }

//                for(int i=0;i<timelist.size();i++){
//
//                    for(int j=0;j<generelist.size();j++){
//                    if(generelist.get(j).get("path").equals(timelist.get(i).get("path"))){
//                        generelist.remove(j);
//                    }
//                    }
//                }
//
//                generelist.addAll(0,timelist);

//
                try {
                    if (one == 0) {
                        ParentAdapter.notifyDataSetChanged();
                        childRecyclerViewAdapter.notifyDataSetChanged();
                        one++;
                        //    toast("loaded");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


//                ParentAdapter.notifyDataSetChanged();
//                childRecyclerViewAdapter.notifyDataSetChanged();

             //   myfn();
             //   myfn2();

//                ParentAdapter.setHasStableIds(true);
//                childRecyclerViewAdapter.setHasStableIds(true);
               // lmain.scrollTo(0,0);





            }

        }
        new update().execute();
    }

    private static void myfn() {

        table.setText("");
        for(int i=0;i<generelist.size();i++){

            table.append(i+" N: "+generelist.get(i).get("name")+" G: "+generelist.get(i).get("genere")+" A: "+generelist.get(i).get("artist"));
            table.append("\n");
        }
    }


    private static void myfn2() {

        table2.setText("");
        int ins2=0;
        for(int i=1;i<todoArrayList2.size();i++){

            if(todoArrayList2.get(i).category.equals("")){

            }else {
                table2.append(ins2 + " G: " + todoArrayList2.get(i).category + " C: " + todoArrayList2.get(i).countcat);
                table2.append("\n");
                ins2++;
            }
        }

        table2.append("\n\n\n");
        int ins=0;
        for(int i=1;i<todoArrayList2.size();i++){

            if(todoArrayList2.get(i).artist.equals("")){

            }else {
            table2.append(ins+" A: "+todoArrayList2.get(i).artist+" C: "+todoArrayList2.get(i).countartist);
            table2.append("\n");
            ins++;
        }
        }

        table2.append("\n\n\n");
        int ins3=0;
        for(int i=1;i<todoArrayList.size();i++){

            if(todoArrayList.get(i).description.equals("")){

            }else {
                   String str = String.valueOf(todoArrayList.get(i).description);
                table2.append(ins3 + " D: " + str.substring(0, 10) + " C: " + todoArrayList.get(i).time);
                table2.append("\n");
                ins3++;
            }
        }


    }

    @SuppressLint("StaticFieldLeak")
    private static void fetchbyartmax() {
        class update extends AsyncTask<String, ProgressBar, ArrayList<String>> {


            @Override
            protected ArrayList<String> doInBackground(String... strings) {
                return (ArrayList<String>) myDatabase.daoAccess().fetchTodoListByartist();

            }

            @Override
            protected void onPostExecute(ArrayList<String> todo2) {
                super.onPostExecute(todo2);

             //   artistlist.clear();
                artistmainlist.clear();
              //  artistlist=todo2;


                for(int i=0;i<todo2.size();i++){
                    for(int j=0;j<songsList.size();j++) {
                        if(songsList.get(j).get("artist").equals(todo2.get(i))){
                            final HashMap<String, String> songf = new HashMap<String, String>();
                            songf.put("name", songsList.get(j).get("name"));

                            songf.put("path", songsList.get(j).get("path"));

                            songf.put("genere", songsList.get(j).get("genere"));
                            songf.put("artist", songsList.get(j).get("artist"));

                         //   songf.put("image", songsList.get(j).get("image"));
                            artistmainlist.add(songf);

                        }
                    }

                }



                fetchbycatmax();
             //   fetchbytimemax();

            }

        }
        new update().execute();
    }

    @SuppressLint("StaticFieldLeak")
    private static void fetchbytimemax() {
        class update extends AsyncTask<String, ProgressBar, ArrayList<String>> {


            @Override
            protected ArrayList<String> doInBackground(String... strings) {
                return (ArrayList<String>) myDatabase.daoAccess().fetchTodoListBytime();

            }

            @Override
            protected void onPostExecute(ArrayList<String> todo2) {
                super.onPostExecute(todo2);

                timelist.clear();

                for(int i=0;i<todo2.size();i++){
                    for(int j=0;j<songsList.size();j++) {
                        if(songsList.get(j).get("path").equals(todo2.get(i))){
                        final HashMap<String, String> songf = new HashMap<String, String>();
                        songf.put("name", songsList.get(j).get("name"));

                        songf.put("path", songsList.get(j).get("path"));

                        songf.put("genere", songsList.get(j).get("genere"));
                        songf.put("artist", songsList.get(j).get("artist"));

                       //     songf.put("image", songsList.get(j).get("image"));
                     //   toast(songsList.get(j).get("name"));
                        timelist.add(songf);

                    }
                    }

                }
             //   fetchbycatmax();


            }

        }
        new update().execute();
    }

    @SuppressLint("StaticFieldLeak")
    private static void insertRow2(Todo2 todo2) {
        new AsyncTask<Todo2, Void, Long>() {
            @Override
            protected Long doInBackground(Todo2... params) {

                if(generecount.equals(genere)){
               return 0L;
                }else{

                    generecount=genere;
                    return myDatabase.daoAccess().insertTodo2(params[0]);
                }
            }

            @Override
            protected void onPostExecute(Long id) {
                super.onPostExecute(id);
               // toast("inserted");
                loadAllTodos2();
            }
        }.execute(todo2);

    }
    @SuppressLint("StaticFieldLeak")
    private static void insertRow3(Todo2 todo2) {
        new AsyncTask<Todo2, Void, Long>() {
            @Override
            protected Long doInBackground(Todo2... params) {

                if(artistcount.equals(artistm)){
                    return 0L;
                }else{

                    artistcount=artistm;
                    return myDatabase.daoAccess().insertTodo3(params[0]);
                }
            }

            @Override
            protected void onPostExecute(Long id) {
                super.onPostExecute(id);
             //   toast("inserted2");
                loadAllTodos2();
            }
        }.execute(todo2);

    }

    @SuppressLint("StaticFieldLeak")
    private static void insertRow(Todo todo) {
        new AsyncTask<Todo, Void, Long>() {
            @Override
            protected Long doInBackground(Todo... params) {

                if(timecount.equals(String.valueOf(uri))){
                    return 0L;
                }else{

                    timecount= String.valueOf(uri);
                    return myDatabase.daoAccess().insertTodo(params[0]);
                }
            }

            @Override
            protected void onPostExecute(Long id) {
                super.onPostExecute(id);
              //  toast("inserted3");
                loadAllTodos();
            }
        }.execute(todo);

    }


    public static void toast (String s){
          Toast.makeText(context,s,Toast.LENGTH_SHORT).show();

    }


    public static class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder> {
        public ArrayList<HashMap<String, String>> childModelArrayList;
        Context cxt;

        public  class MyViewHolder extends RecyclerView.ViewHolder{
            public NeumorphImageView heroImage;
            public TextView movieName;

            public MyViewHolder(View itemView) {
                super(itemView);
                heroImage = itemView.findViewById(R.id.hero_image);
                movieName = itemView.findViewById(R.id.movie_name);

//                View.OnClickListener clickListener = new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                };
//
            }
        }

        public ChildRecyclerViewAdapter(ArrayList<HashMap<String, String>> arrayList, Context mContext) {
            this.cxt = mContext;
            this.childModelArrayList = arrayList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_recyclerview_items, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            HashMap<String, String> currentItem = childModelArrayList.get(position);

            holder.heroImage.setShadowColorDark(Color.rgb(17,17,17));
            holder.heroImage.setShadowColorLight(Color.rgb(44,44,44));
           // holder.heroImage.setShapeAppearanceModel();
        //    app:neumorph_shadowColorDark="@color/design_dark_default_color_shadow_dark"
       //     app:neumorph_shadowColorLight="@color/design_dark_default_color_shadow_light"
        //    app:neumorph_shapeAppearance="@style/CustomShapeAppearance2"



            Uri uri3= Uri.parse(currentItem.get("path"));
//async task//
           //            byte[] arr=  currentItem.get("image").getBytes();
            //  Bitmap nbit = BitmapFactory.decodeByteArray(arr, 0, arr.length);



            Bitmap nbit=null;
          //  int u = 0;

            for(int i=0;i<songimagelist.size();i++){
                if(songimagelist.get(i).getpath().equals(currentItem.get("path"))){
                  //  u=i;

                    nbit=songimagelist.get(i).getbp();
                }
            }



            if (nbit == null) {
                    holder.heroImage.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                 //    toast("null");
                } else {
                    holder.heroImage.setImageBitmap(nbit);

                }


            //end//
          // songImage3 =  mymetaphoto(uri3);
         //    mymetaphoto(uri3);


            holder.movieName.setText(currentItem.get("name"));

          //  int finalU = u;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // newpath= currentItem.get("path");
                    mplayer(uri3);
                    mediaPlayerm.start();
                    icon();

                    for(int i=0;i<songsList.size();i++){
                        if(songsList.get(i).get("path").equals(currentItem.get("path"))){
                            positionm=i;
                         //   toast("pos "+positionm+"index "+ finalU);
                            break;
                        }
                    }


                }
            });

        }

        @Override
        public int getItemCount() {
            return childModelArrayList.size();
        }
    }

    public static void mymetaphoto(ArrayList<HashMap<String, String>> list) {

      //  Bitmap songImage3=null;



        class update extends AsyncTask<ArrayList<HashMap<String, String>>, ProgressBar, Integer> {


            @Override
            protected Integer doInBackground(ArrayList<HashMap<String, String>>... arrayLists) {

                 //   ArrayList<Bitmap> nbitlist = new ArrayList<>();
                 //   nbitlist.clear();
                    //  Thread.sleep(600);
                songimagelist.clear();
                 for(int i=0;i<arrayLists[0].size();i++) {
                     Bitmap nbit;
                     String path=arrayLists[0].get(i).get("path");
                     try {
                         MediaMetadataRetriever   metaRetriver3 = new MediaMetadataRetriever();
                         metaRetriver3.setDataSource(path);
                         byte[] art3 = metaRetriver3.getEmbeddedPicture();

                          nbit = BitmapFactory.decodeByteArray(art3, 0, art3.length);
                         // songimagelist.add(nbit);

                     } catch (Exception e) {
                         e.printStackTrace();
                         nbit=null;
                     }
                     songimagelist.add(new songimageart(nbit,path));
                 }
                 return 0;



            }

            @Override
            protected void onPostExecute(Integer todo2) {
                super.onPostExecute(todo2);
              //  songimagelist.clear();
               // songimagelist=todo2;
//
//                  ParentAdapter.notifyDataSetChanged();
//                 childRecyclerViewAdapter.notifyDataSetChanged();

            //    toast("loaded");
            }

        }
        new update().execute(list);



    }

    ////child end//
public static class ParentRecyclerViewAdapter extends RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder> {
    private ArrayList<ParentModel> parentModelArrayList;
    public Context cxt;
    private RecyclerView.RecycledViewPool
            viewPool
            = new RecyclerView
            .RecycledViewPool();

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category;
        public RecyclerView childRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.Movie_category);
            childRecyclerView = itemView.findViewById(R.id.Child_RV);
        }
    }

    public ParentRecyclerViewAdapter(ArrayList<ParentModel> exampleList, Context context) {
        this.parentModelArrayList = exampleList;
        this.cxt = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recyclerview_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return parentModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ParentModel currentItem = parentModelArrayList.get(position);
        LinearLayoutManager layoutManager = new LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);

        holder.category.setText(currentItem.movieCategory());
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        // added the first child row
        if (parentModelArrayList.get(position).movieCategory().equals("AI Recommended Songs")) {
         //   arrayList.addAll(generelist);
         //   mymetaphoto(generelist);

            arrayList = generelist;

        }

        // added in second child row
        if (parentModelArrayList.get(position).movieCategory().equals("Top Artist Songs")) {
            //arrayList.addAll(artistmainlist);
           // mymetaphoto(artistmainlist);


            arrayList = artistmainlist;
        }

        // added in third child row
        if (parentModelArrayList.get(position).movieCategory().equals("Most Played Songs")) {
          ///  arrayList.addAll(timelist);
          //  mymetaphoto(timelist);

            arrayList = timelist;
        }

        /*
        // added in fourth child row
        if (parentModelArrayList.get(position).movieCategory().equals("Category4")) {
            arrayList.add(new ChildModel(R.drawable.bestofoscar6,"Movie Name"));
            arrayList.add(new ChildModel(R.drawable.bestofoscar5,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar4,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar3,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar2,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar1,"Movie Name"));
        }

        // added in fifth child row
        if (parentModelArrayList.get(position).movieCategory().equals("Category5")) {
            arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi4,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.hollywood2,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar4,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.mov2,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.hollywood1,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar1,"Movie Name"));
        }

        // added in sixth child row
        if (parentModelArrayList.get(position).movieCategory().equals("Category6")) {
            arrayList.add(new ChildModel(R.drawable.hollywood5,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.blackp,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.bestofoscar4,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.moviedubbedinhindi6,"Movie Name"));
            arrayList.add(new ChildModel( R.drawable.hollywood1,"Movie Name"));
            arrayList.add(new ChildModel(R.drawable.bestofoscar6,"Movie Name"));
        }

         */

        layoutManager.setInitialPrefetchItemCount(1);


        childRecyclerViewAdapter = new ChildRecyclerViewAdapter(arrayList,holder.childRecyclerView.getContext());
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
        holder.childRecyclerView.setRecycledViewPool(viewPool);
      //  ParentAdapter.notifyDataSetChanged();
      //  childRecyclerViewAdapter.notifyDataSetChanged();


    }

    }


    public void changeTextStatus(boolean isConnected) {

        // Change status according to boolean value
        if (isConnected) {
            internetStatus.setText("Internet Connected.");
            internetStatus.setTextColor(Color.parseColor("#00ff00"));
        } else {
            internetStatus.setText("Internet Disconnected.");
            internetStatus.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    @Override
    protected void onPause() {

        super.onPause();
        MyApplication.activityPaused();// On Pause notify the Application
    }

    @Override
    protected void onResume() {

        super.onResume();
        MyApplication.activityResumed();// On Resume notify the Application
    }
}

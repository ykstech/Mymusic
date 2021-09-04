package com.example.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qtalk.recyclerviewfastscroller.RecyclerViewFastScroller;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import eu.gsottbauer.equalizerview.EqualizerView;
import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphImageButton;
import soup.neumorphism.ShapeType;

import static android.view.View.GONE;
import static com.example.mymusic.MainActivity.adddata;
import static com.example.mymusic.MainActivity.artistm;
import static com.example.mymusic.MainActivity.back;
import static com.example.mymusic.MainActivity.createtime;
import static com.example.mymusic.MainActivity.mediaPlayerm;
import static com.example.mymusic.MainActivity.metaRetriver;
import static com.example.mymusic.MainActivity.mplayer;
import static com.example.mymusic.MainActivity.next;
import static com.example.mymusic.MainActivity.positionm;
import static com.example.mymusic.MainActivity.shownotification;
import static com.example.mymusic.MainActivity.songImage;
import static com.example.mymusic.MainActivity.songnamem;
import static com.example.mymusic.MainActivity.songsList;
import static com.example.mymusic.MainActivity.updateseekbar;

public class favorite extends AppCompatActivity {

    public  BottomSheetBehavior bottomsheetBehavior;
    View bottom;
    int index=0;
    int flag=1;
    int lastpos=positionm;
   public static Context con;

RecyclerView recyclerView;
AllAngleExpandableButton menu;
CoordinatorLayout coordinatorLayout;
String[] items;
TextView noofsongs;
    static TextView name;
    static TextView namemain;
    static TextView artist;
    TextView favorites;
    static TextView subname2;
    static TextView timerfull;
    static TextView timer;
EditText search;
    static ProductsAdapter adapter;
   public static ArrayList<File> mysongs;
    int last;
   static AppCompatSeekBar seekbarf;
    static AppCompatSeekBar seekbarf2;
   // public  static int positionm;
    NeumorphCardView cardView;

    RecyclerViewFastScroller fastScroller;
   static NeumorphImageButton backf,nextf,play,left,mplay,mnextf,mbackf;
    RelativeLayout top,bottom1;
    LinearLayout lmain;
    static RoundedImageView album_art;
    ImageView nosong;
    //BarVisualizer bar2;
    float slideoff;
    int i=1;
    int state=0;
    float slideoffse;
    int state2=1;

    public static int count=1,pos=positionm;
    String sname;
    public static  String EXTRA_NAME = "song_name";
 // public   static MediaPlayer mediaPlayer;
    public  static   NeumorphCardView lc=null;
    String path="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        con = this;
        MainActivity.stateactivity=2;
        //LayoutInflater inflater = LayoutInflater.from(getApplicationContext());

// Put another XML name here with R.layout
        //View view = inflater.inflate(R.layout.activity_main, null);

// Your Layout object
      //  cardView = view.findViewById(R.id.flat_card);
      //  cardView.addView(view);


        bottom = findViewById(R.id.bottom);

        coordinatorLayout = findViewById(R.id.coordinate);
        bottomsheetBehavior = BottomSheetBehavior.from(bottom);

        top = bottom.findViewById(R.id.top);
        bottom1 = bottom.findViewById(R.id.bottom1);

        lmain = findViewById(R.id.lmain);
        menu = (AllAngleExpandableButton) bottom.findViewById(R.id.button_expandable);


        search = findViewById(R.id.search);

        nosong = findViewById(R.id.nosong);

        fastScroller = findViewById(R.id.fastscroller);

      //  cardView = findViewById(R.id.flat_card);
        backf = bottom.findViewById(R.id.back);
        play = bottom.findViewById(R.id.play);
        nextf = bottom.findViewById(R.id.next);

       mbackf = bottom.findViewById(R.id.mback);
        mnextf = bottom.findViewById(R.id.mnext);

        mplay = bottom.findViewById(R.id.mplay);

        name = bottom.findViewById(R.id.name);

        artist = bottom.findViewById(R.id.artist);

        seekbarf = bottom.findViewById(R.id.seekbarcardview2);
        seekbarf2 = bottom.findViewById(R.id.seekbar);

        timerfull = bottom.findViewById(R.id.timerfull);

        timer = bottom.findViewById(R.id.timer);
        subname2 = bottom.findViewById(R.id.subname);
        namemain = bottom.findViewById(R.id.namemain);
           album_art = bottom.findViewById(R.id.album_art);

        left = bottom.findViewById(R.id.left);

        noofsongs = findViewById(R.id.noofsongs);

        recyclerView = findViewById(R.id.listViewHeroes);
        recyclerView.setHasFixedSize(true);
        //  bar2 = findViewById(R.id.bar);




        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapter = new ProductsAdapter(this,songsList);


        recyclerView.setAdapter(adapter);

        enableSwipeToDeleteAndUndo();


        noofsongs.setText(Integer.toString(songsList.size())+" songs");

    // search.setSelected(false);
   //  search.setEnabled(false);
    // search.setActivated(false);
     //search.setFocusedByDefault(false);
    // search.setDefaultFocusHighlightEnabled(false);


        namemain.setSelected(true);
        name.setSelected(true);
        artist.setSelected(true);
        subname2.setSelected(true);

//     if(mediaPlayer!=null){
//         mediaPlayer.stop();
//         mediaPlayer.release();
//     }

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

        menu.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {
                //do whatever you want,the param index is counted from startAngle to endAngle,
                //the value is from 1 to buttonCount - 1(buttonCount if aebIsSelectionMode=true)

                //    Toast.makeText(getApplicationContext(),"click"+index,Toast.LENGTH_SHORT).show();


                if (index == 1) {
                    adddata(1);
                } else if (index == 2) {
                    adddata(2);

                } else {
                    //   String sharePath = Environment.getExternalStorageDirectory().getPath()
                    //          + "/Soundboard/Ringtones/custom_ringtone.ogg";
                    String sharePath = songsList.get(positionm).get("path");
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


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setCursorVisible(true);
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

              //     Toast.makeText(getApplicationContext(),"text "+s,Toast.LENGTH_SHORT).show();


            //    search.setCursorVisible(true);
               // bottomsheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                adapter.getFilter().filter(s);





            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
/*
        Collections.sort(songsList, new Comparator<HashMap<String, String>>() {
            @Override
            public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
                return o1.get("name").compareTo(o2.get("name"));
            }
        });


 */


        play.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             MainActivity.play.performClick();
             isplay();

             adapter.notifyDataSetChanged();

         }
     });


        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.play.performClick();
                isplay();

                adapter.notifyDataSetChanged();
            }
        });


        backf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.performClick();

                pos=positionm;
                name.setText(songnamem);
                namemain.setText(songnamem);

                subname2.setText(artistm);
                artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                   // Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }
            isplay();
            seek();
                adapter.notifyDataSetChanged();

            }
        });

        mbackf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   back.performClick();

                pos=positionm;
                name.setText(songnamem);
                namemain.setText(songnamem);

                subname2.setText(artistm);
                artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                 //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }

                isplay();
                seek();

                adapter.notifyDataSetChanged();

            }
        });




        mnextf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next.performClick();

                pos=positionm;
                name.setText(songnamem);
                namemain.setText(songnamem);

                subname2.setText(artistm);
                artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                 //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }
                isplay();
            seek();

                adapter.notifyDataSetChanged();
            }
        });


        nextf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next.performClick();

                pos=positionm;
                name.setText(songnamem);
                namemain.setText(songnamem);

                subname2.setText(artistm);
                artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                  //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }
isplay();
                seek();
                adapter.notifyDataSetChanged();
            }
        });







        bottomsheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState==BottomSheetBehavior.STATE_COLLAPSED) {

                    bottomsheetBehavior.setHideable(false);
                //    bottomsheetBehavior.setPeekHeight(200);
                    state=0;
                    i=1;
                    top.setVisibility(View.VISIBLE);
                    bottom1.setVisibility(GONE);
                    lmain.setVisibility(View.VISIBLE);

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


      left.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              bottomsheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
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

        name.setText(songnamem);
        namemain.setText(songnamem);
        subname2.setText(artistm);
        artist.setText(artistm);
        if(songImage==null){

            album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
            //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
        }else {
            album_art.setImageBitmap(songImage);
        }
     isplay();
        seek();

        mediaPlayerm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                next.performClick();
                seek();

                pos=positionm;

                name.setText(songnamem);
                namemain.setText(songnamem);

                subname2.setText(artistm);
                artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                    //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }

                adapter.notifyDataSetChanged();
            }
        });

    }

    @SuppressLint("ClickableViewAccessibility")
    public static void seek() {



        mediaPlayerm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                next.performClick();
                seek();


                pos=positionm;

                name.setText(songnamem);
                namemain.setText(songnamem);

                subname2.setText(artistm);
                artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                    //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }

                adapter.notifyDataSetChanged();
            }
        });





        String dural = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

        String dura = createtime(Long.parseLong(dural));


        long durationStr = Long.parseLong(dural);


        seekbarf.setMax((int)durationStr);
        seekbarf2.setMax((int)durationStr);
        updateseekbar = new Thread() {
            @Override
            public void run() {
                long total = durationStr;
            //    int current = 0;
                long currentPosition = 0;

                ///     Toast.makeText(MainActivity.getAppContext(),"pp"+currentPosition,Toast.LENGTH_SHORT).show();
                while (currentPosition < total) {
//                    try{
//                        sleep(500);
//                        current = mediaPlayerm.getCurrentPosition();
//                        seekBar.setProgress(current);}

                    try {

                        sleep(1000);
                        // current = mediaPlayerm.getCurrentPosition();

                        if (mediaPlayerm != null && mediaPlayerm.isPlaying()) {
                            currentPosition = mediaPlayerm.getCurrentPosition();
                            seekbarf.setProgress((int) currentPosition);
                            seekbarf2.setProgress((int) currentPosition);

                            //    Toast.makeText(MainActivity.getAppContext(),"pp"+currentPosition,Toast.LENGTH_SHORT).show();
                          //  seekbar2.setProgress(currentPosition);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }
        };
        updateseekbar.start();

        final long[] pp = new long[1];

        seekbarf2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayerm.seekTo(seekBar.getProgress());
                pp[0] = seekBar.getProgress();

                //  seekBar.setProgress(pp[0]);

                seekbarf.setProgress((int) pp[0]);
            }
        });

        seekbarf.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

    //    String endtime = createtime(mediaPlayerm.getDuration());
        timerfull.setText(dura);

        try {
            final Handler handler = new Handler();
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
    }

    public static void isplay() {
        if (mediaPlayerm.isPlaying()) {


            play.setImageDrawable(ContextCompat.getDrawable(favorite.con, R.drawable.ic_baseline_pause_24));
            mplay.setImageDrawable(ContextCompat.getDrawable(favorite.con, R.drawable.pause));


        } else {


            play.setImageDrawable(ContextCompat.getDrawable(favorite.con, R.drawable.ic_baseline_play_arrow_24));
            mplay.setImageDrawable(ContextCompat.getDrawable(favorite.con, R.drawable.play));
        }
    }


    @Override
    public void onBackPressed(){
        if(bottomsheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
            bottomsheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }else {

            String ch = search.getText().toString();
            if( ch.equals("")) {
                finish();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }else{
                search.setText("");
            }
        }
    }


//
//    public void runtimePermission(){
//        Dexter.withContext(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                .withListener(new PermissionListener() {
//                    @Override
//                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                   displaysongs();
//                    }
//
//                    @Override
//                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//                            permissionToken.continuePermissionRequest();
//                    }
//                }).check();
//
//    }
//
//    public ArrayList<File> findsong (File file){
//        ArrayList<File> arrayList = new ArrayList<>();
//        File[] files = file.listFiles();
//        for(File singlefile: files){
//            if(singlefile.isDirectory() && !singlefile.isHidden()){
//                arrayList.addAll(findsong(singlefile));
//            }
//            else {
//                if(singlefile.getName().endsWith(".mp3")||singlefile.getName().endsWith(".wav")){
//                    arrayList.add(singlefile);
//                }
//            }
//        }
//        return arrayList;
//    }
//
//    void  displaysongs(){
//        mysongs = findsong(Environment.getExternalStorageDirectory());
//    items = new String[mysongs.size()];
//    for(int i = 0; i<mysongs.size();i++){
//        items[i] = mysongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");
//
//    }
//
//
//
//        adapter = new ProductsAdapter(this,songsList);
//
//        recyclerView.setAdapter(adapter);
//
//
//
//
//    }
/*
    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listitem,null);
            TextView textView = view.findViewById(R.id.txtsongname);
            textView.setSelected(true);
            textView.setText(items[position]);

            return  view;
        }
    }

 */


    public  class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> implements Filterable, RecyclerViewFastScroller.OnPopupTextUpdate {


        private Context mCtx;
        private ArrayList<HashMap<String, String>> heroList;
      private   ArrayList<HashMap<String, String>> filteredlist = new ArrayList<>();
          String querytex="";
        private int absoluteAdapterPosition;
        //   private   ArrayList<HashMap<String, String>> filteredlistlast = new ArrayList<>();



        public ProductsAdapter(Context mCtx, ArrayList<HashMap<String, String>> heroList) {
            this.mCtx = mCtx;
            this.heroList = heroList;
            this.filteredlist = heroList;
         //   this.absoluteAdapterPosition=getAbsoluteAdapterPosition();
        //    this.filteredlistlast=filteredlist;
         //   heroListfull = new ArrayList<>(heroList);

        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.listitem,parent, false);
            return new ProductViewHolder(view);



        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {



           // holder.ra

            String datatext = filteredlist.get(position).get("name");
            if(querytex!=null && !querytex.isEmpty()){
                int start = datatext.toLowerCase().indexOf(querytex.toLowerCase());
                int end = start+querytex.length();
                if(start!=-1){
                    Spannable spannable = new SpannableString(datatext);
                    ColorStateList colorStateList = new ColorStateList(new int [][]{new int []{}},new int []{Color.RED});
                    TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.BOLD,-1,colorStateList,null);
                    spannable.setSpan(textAppearanceSpan,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    holder.txtsongname.setText(spannable);
                }else {

                    holder.txtsongname.setText(datatext);
                }
            }else {

                holder.txtsongname.setText(datatext);
            }

            holder.number.setText(String.valueOf(position+1));




       //     holder.txtsongname.setText(filteredlist.get(position).get("name"));

            /*
            holder.neumorphCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //sss

                    positionm=position;
                    //holder.itemView.performClick();

                    //end



                 //   Toast.makeText(getApplicationContext(),"pos"+position,Toast.LENGTH_SHORT).show();
                }
            });

             */

//            if(position!=positionm){
//                if (holder.bar != null)
//                    holder.bar.release();
//
//            }
       //     holder.radio.setChecked(position==positionm);

            if(position==positionm && songsList.size()==filteredlist.size() ){





//        if(positionm==adapter.getadapterposition()){
           //    itemTouchhelper.onChildViewDetachedFromWindow(recyclerView);
//        }else


                holder.neumorphCardView.setShapeType(ShapeType.PRESSED);

                holder.neumorphCardView.setShadowColorDark(Color.rgb(17,17,17));
                holder.neumorphCardView.setShadowColorLight(Color.rgb(44,44,44));

                holder.txtsongname.setTextColor(Color.rgb(245,70,120));


               // if(mediaPlayerm.isPlaying()) {

                        // int id = mediaPlayerm.getAudioSessionId();
                        // if (id != -1) {
                        //  holder.bar.setAudioSessionId(id);
                        holder.equalizer.setVisibility(View.VISIBLE);
                        holder.equalizer.animateBars();
                        //   holder.equalizer.setAnimationDuration(2000);
                        //}

             //   }else{
                  //  holder.equalizer.stopBars();
              //  }


                // holder.bar.setRawAudioBytes(bytes);
             //   int audioSessionId = mediaPlayerm.getAudioSessionId();
              //  if (audioSessionId != -1){

              //  }
               //    holder.bar.setAudioSessionId(audioSessionId);

            }

            else {




                holder.neumorphCardView.setShapeType(ShapeType.FLAT);

                holder.neumorphCardView.setShadowColorDark(Color.rgb(48,48,48));
                holder.neumorphCardView.setShadowColorLight(Color.rgb(48,48,48));

                holder.txtsongname.setTextColor(Color.WHITE);

                try {
                    holder.equalizer.setVisibility(GONE);
                    holder.equalizer.stopBars();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //   holder.bar.release();
            }

            //end




        }


        @Override
        public int getItemCount() {


         return filteredlist.size();

        }

        @Override
        public Filter getFilter() {
            return filter;
        }

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence ch) {


                if(ch!=null && !ch.equals("")){
                    List<HashMap<String, String>> newlist = new ArrayList<>();

                    querytex=ch.toString();

                    for(int i=0;i<songsList.size();i++){
                        if(songsList.get(i).get("name").toLowerCase().contains(ch.toString().toLowerCase()))
                        {


                            HashMap<String, String> song = new HashMap<String, String>();
                            song.put("name", songsList.get(i).get("name"));

                            song.put("path",songsList.get(i).get("path") );



                            newlist.add(song);
                        }
                    }

                  //  song.put("path", mysongsm.get(i).getAbsolutePath());

                 //   Set<String> keys = song.keySet();
                 //   List<String> listkeys = new ArrayList<String>(keys);



                    FilterResults filterResults = new FilterResults();
                    filterResults.count = newlist.size();
                    filterResults.values = newlist;

               //     Toast.makeText(getApplicationContext(),"index"+listkeys.indexOf(songsList.get(2).get("path")),Toast.LENGTH_SHORT).show();


                    return filterResults;
                }

                return null;
            }

            @Override
            protected void publishResults(CharSequence ch, FilterResults results) {

                 if(results!=null ){
                     if(results.count>0){


                     //    Toast.makeText(getApplicationContext(),"name "+songsList.get(positionm).get("name"),Toast.LENGTH_SHORT).show();

                         fastScroller.setVisibility(View.VISIBLE);
                         nosong.setVisibility(GONE);
                   filteredlist = (ArrayList<HashMap<String, String>>) results.values;
                   /*

                   int mila=positionm;
                         for(int j=0;j<filteredlist.size();j++){
                             if(filteredlist.get(j).get("path").equals(path)){
                                 mila=j;
                                 flag=1;

                                 Toast.makeText(getApplicationContext(),"name2 "+filteredlist.get(j).get("name"),Toast.LENGTH_SHORT).show();
                             }
                         }

                         if(flag==1){

                             positionm=mila;
                         }else {
                             flag=0;
                         }


                    //     Toast.makeText(getApplicationContext(),"index"+index,Toast.LENGTH_SHORT).show();


                          */

                     }
                     else {

                         filteredlist.clear();
                         fastScroller.setVisibility(GONE);
                         nosong.setVisibility(View.VISIBLE);
                         querytex="";
                        //   Toast.makeText(getApplicationContext(),"No Song Found",Toast.LENGTH_SHORT).show();

                     }

                 }else {

                     fastScroller.setVisibility(View.VISIBLE);
                     nosong.setVisibility(GONE);
                         filteredlist = heroList;
                         querytex="";
                         search.setCursorVisible(false);

                 }

                noofsongs.setText(String.valueOf(filteredlist.size())+" songs");


              //  Toast.makeText(getApplicationContext(),"size"+filteredlist.size(),Toast.LENGTH_LONG).show();
                notifyDataSetChanged();

             //   filteredlistlast=filteredlist;

            }
        };

        @NotNull
        @Override
        public CharSequence onChange(int i) {


            return filteredlist.get(i).get("name").substring(0, 1).toUpperCase();
        }

//        public int getadapterposition() {
//            return getadapterposition();
//        }
//
//        public int getAbsoluteAdapterPosition() {
//            return absoluteAdapterPosition;
//        }
//
//        public void setAbsoluteAdapterPosition(int absoluteAdapterPosition) {
//            this.absoluteAdapterPosition = getAbsoluteAdapterPosition();
//        }

        class ProductViewHolder extends RecyclerView.ViewHolder {

            CheckBox radio;
            TextView   txtsongname,number;
            NeumorphCardView neumorphCardView;
            AppCompatImageButton expand,textViewUpdate,textViewDelete,textViewdetail,textViewDelete2;
            CardView cardView;
            RelativeLayout relative;
            LinearLayout hidden2,hidden1;
          //  BarVisualizer bar;

            EqualizerView equalizer = findViewById(R.id.equalizer);
            public ProductViewHolder(View listViewItem) {
                super(listViewItem);

                txtsongname = listViewItem.findViewById(R.id.txtsongname);

                number = listViewItem.findViewById(R.id.number);
              //  bar = listViewItem.findViewById(R.id.bar);
                equalizer = listViewItem.findViewById(R.id.equalizer);
            //    radio = listViewItem.findViewById(R.id.radio);
               neumorphCardView =  listViewItem.findViewById(R.id.main);



               View.OnClickListener clickListener = new View.OnClickListener(){

                   @Override
                   public void onClick(View v) {
                       if (getAdapterPosition() == pos && count == 2 && songsList.size()==filteredlist.size()) {
                          // Toast.makeText(getApplicationContext(),"pos "+pos+" count "+count,Toast.LENGTH_LONG).show();
                           bottomsheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                       } else {
                           positionm = getAdapterPosition();
                           pos = positionm;
                           count = 1;
                           count++;
                           
                 //       Toast.makeText(getApplicationContext(),"pos " +positionm,Toast.LENGTH_SHORT).show();


                           for(int i=0;i<songsList.size();i++){
                               if(songsList.get(i).get("path").equals(filteredlist.get(positionm).get("path"))){
                                   index=i;
                                   break;
                               }
                           }





                           positionm=index;
                        //   Toast.makeText(getApplicationContext(),"index " +positionm,Toast.LENGTH_SHORT).show();


                           Uri uri = Uri.parse(songsList.get(index).get("path"));
                       mplayer(uri);
                       name.setText(songnamem);
                       //    Toast.makeText(getApplicationContext(),"name "+songnamem,Toast.LENGTH_SHORT).show();
                       namemain.setText(songnamem);

                       subname2.setText(artistm);
                       artist.setText(artistm);
                       if (songImage == null) {

                           album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                           //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                       } else {
                           album_art.setImageBitmap(songImage);
                       }

                       seek();
                       mediaPlayerm.start();



                       /*
                           neumorphCardView.setShapeType(ShapeType.PRESSED);

                           neumorphCardView.setShadowColorDark(Color.rgb(17,17,17));
                           neumorphCardView.setShadowColorLight(Color.rgb(44,44,44));

                           txtsongname.setTextColor(Color.rgb(245,70,120));


                        */

                       notifyDataSetChanged();
                       isplay();
                       MainActivity.icon();

                   }

                   }
               };
/*
                mediaPlayerm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        next.performClick();
                        seek();

                        name.setText(songnamem);
                        namemain.setText(songnamem);

                        subname2.setText(artistm);
                        artist.setText(artistm);
                        if(songImage==null){

                            album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                            //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                        }else {
                            album_art.setImageBitmap(songImage);
                        }

                        adapter.notifyDataSetChanged();
                    }
                });

 */

 //  isplay();


                itemView.setOnClickListener(clickListener);
           //    radio.setOnClickListener(clickListener);
         //     neumorphCardView.setOnClickListener(clickListener);





            }


        }



//        public int getpp(){
//            return getAbsoluteAdapterPosition();
//        }

        public void removeItem(int position) {

            filteredlist.remove(position);
                // positionm=position;
                if(position<positionm){
                    positionm--;
                    pos=positionm;
                }
             //  Toast.makeText(getApplicationContext(),"pos "+positionm+"index "+position,Toast.LENGTH_SHORT).show();
              notifyDataSetChanged();
            noofsongs.setText(filteredlist.size() + " songs");

        }

        public void restoreItem(HashMap<String, String> songk, int position) {
            filteredlist.add(position, songk);
            if(position<=positionm){
                positionm++;
                pos=positionm;
            }
           //    Toast.makeText(getApplicationContext(),"pos "+positionm+"index "+position,Toast.LENGTH_SHORT).show();

            notifyDataSetChanged();

            noofsongs.setText(filteredlist.size()+" songs");
        }

        public ArrayList<HashMap<String, String>> getData() {

            return filteredlist;
        }

    }


//    @Override
//    protected void onDestroy() {
//        if(bar2!= null){
//            bar2.release();
//        }
//
//            super.onDestroy();
//    }


    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAbsoluteAdapterPosition();
//
//                if(position==positionm) {
//
//                }else {

                    //  final String item = adapter.getData().get(position);
              final   HashMap<String, String> songk = new HashMap<String, String>();
                songk.put("name", adapter.getData().get(position).get("name"));

                songk.put("path",adapter.getData().get(position).get("path") );

                songk.put("genere",adapter.getData().get(position).get("genere") );
                songk.put("artist",adapter.getData().get(position).get("artist") );


                // final

                adapter.removeItem(position);


                int ps=position+1;
                //start









                //end

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout,  "", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        adapter.restoreItem(songk, position);

                      //  recyclerView.scrollToPosition(position);

                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(com.google.android.material.R.id.snackbar_text);
             //   textView.setTextColor(Color.YELLOW);



                final int[] o = {6};
               Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        --o[0];
                        String text = o[0] +"    song no. "+ps+" was removed from    the list.";
                        SpannableString spannableString = new SpannableString(text);
                        ForegroundColorSpan green = new ForegroundColorSpan(Color.RED);

                        spannableString.setSpan(green,
                                0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        textView.setText(spannableString);

                        if(o[0]>0){
                            handler.postDelayed(this, 600);
                        }

                    }
                }, 0);

                snackbar.show();

          //  }
            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);

    }

//
//    public String count(){
//
//
//        final String[] fn = {""};
//
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //stat
//                ValueAnimator valueAnim = ValueAnimator.ofInt(0, 5 );
//                valueAnim.setDuration(1000);
//                // valueAnim.setStartDelay(500);
//                valueAnim.setInterpolator(new AccelerateDecelerateInterpolator());
//                valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        // int val = (int) animation.getAnimatedValue();
//                        //  txtvar.setText("₹"+valueAnim.getAnimatedValue().toString());
//
//                        fn[0] = valueAnim.getAnimatedValue().toString()   ;
//
//                    }
//                });
//
//                valueAnim.start();
//                //end
//            }
//        });
//
//
//        return fn[0];
//
//    }
//
 public static void nexprev(){
        favorite.pos=positionm;
        favorite.name.setText(songnamem);
        favorite.namemain.setText(songnamem);

        favorite.subname2.setText(artistm);
        favorite.artist.setText(artistm);
        if(songImage==null){

            favorite.album_art.setImageDrawable(ContextCompat.getDrawable(con, R.drawable.cloth));
            //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
        }else {
            favorite.album_art.setImageBitmap(songImage);
        }

        favorite.isplay();
        favorite.seek();

        favorite.adapter.notifyDataSetChanged();

    }


}
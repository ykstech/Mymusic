package com.example.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.qtalk.recyclerviewfastscroller.RecyclerViewFastScroller;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

import eu.gsottbauer.equalizerview.EqualizerView;
import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.NeumorphImageButton;
import soup.neumorphism.NeumorphImageView;
import soup.neumorphism.ShapeType;

import static android.view.View.GONE;
import static com.example.mymusic.MainActivity.courseModalArrayList;
import static com.example.mymusic.MainActivity.deletedata;

import static com.example.mymusic.MainActivity.mediaPlayerm;
import static com.example.mymusic.MainActivity.mplayer;
import static com.example.mymusic.MainActivity.positionm;
import static com.example.mymusic.MainActivity.saveData;
import static com.example.mymusic.MainActivity.songImage;
import static com.example.mymusic.MainActivity.songsList;
import static com.example.mymusic.MainActivity.stateactivity;

public class favmain extends AppCompatActivity {

    public static Context context2;
    public int remain;
    public static int index2;
    static NeumorphImageButton playimage;
    static NeumorphImageView album_art;
    RecyclerView recyclerView;
  public   static ProductsAdapter adapter;
  MotionLayout motion;
  TextView favn,favm;
  int Id;
  //public static SharedPreferences sharedPreferences;


  //  ArrayList<CourseModal> courseModalArrayList =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favmain);
       context2 = this;
       stateactivity=3;
       String theme="";
         Id = getIntent().getIntExtra("Id",1);
        if(Id==1){
            theme = "Top 50";
        }else if(Id==2){
          theme = "Favorites";
        }
        playimage = findViewById(R.id.playimage);

        favn = findViewById(R.id.favn);
        favm = findViewById(R.id.favm);
        motion = findViewById(R.id.motion);


        favn.setText(String.valueOf(courseModalArrayList.size())+" songs");
        favm.setText(theme);

        album_art = findViewById(R.id.imagecard);

        recyclerView = findViewById(R.id.listViewHeroes2);
        recyclerView.setHasFixedSize(true);
        //  bar2 = findViewById(R.id.bar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


      //  loadData();

        adapter = new favmain.ProductsAdapter(courseModalArrayList, favmain.this);
        //  adapter = new CourseAdapter(courseModalArrayList, MainActivity.this);


        recyclerView.setAdapter(adapter);

        enableSwipeToDeleteAndUndo();

        remain=positionm;

    //    Toast.makeText(context, "remain "+remain, Toast.LENGTH_SHORT).show();

        int flag=0,ind=0;
        for(int i=0;i<courseModalArrayList.size();i++){
            if(courseModalArrayList.get(i).getCourseDescription().equals(songsList.get(positionm).get("path"))){
                ind=i;
                flag=1;
                break;
            }
        }



        if(flag==1) {
            positionm = ind;

            if (songImage == null) {
                album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
            } else {
                album_art.setImageBitmap(songImage);
            }

            index2=remain;
         //   Toast.makeText(context, "index "+index2, Toast.LENGTH_SHORT).show();
        }else {

            positionm = -1;

            album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
         //   Toast.makeText(context, "pos "+positionm, Toast.LENGTH_SHORT).show();
        }

        playimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.play.performClick();
                isplay();

            }
        });

        isplay();

        mediaPlayerm.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
              //  next.performClick();
              //  seek();
                Uri uri2;

                if(positionm==-1){

                    uri2 = Uri.parse(courseModalArrayList.get(0).getCourseDescription());
                    positionm=0;

                }else {
                    if (positionm == courseModalArrayList.size() - 1) {
                        uri2 = Uri.parse(courseModalArrayList.get(0).getCourseDescription());
                        positionm = 0;
                    } else {

                        uri2 = Uri.parse(courseModalArrayList.get(positionm + 1).getCourseDescription());
                        positionm = positionm + 1;
                    }
                }
                mplayer(uri2);
                mediaPlayerm.start();

                for(int i=0;i<songsList.size();i++){
                    if(songsList.get(i).get("path").equals(courseModalArrayList.get(positionm).getCourseDescription())){
                        index2=i;
                        break;
                    }
                }


                //  name.setText(songnamem);
              //  namemain.setText(songnamem);

              //  subname2.setText(artistm);
              //  artist.setText(artistm);
                if(songImage==null){

                    album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                    //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                }else {
                    album_art.setImageBitmap(songImage);
                }

                adapter.notifyDataSetChanged();
                isplay();
            }
        });

    //    adddata();

    }

    public static void isplay() {
        if (mediaPlayerm.isPlaying()) {


            playimage.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.pause));
           // mplay.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.pause));


        } else {


            playimage.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.play));
         //   mplay.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.play));
        }
    }


/*
    public static void adddata() {
        // below line is use to add data to array list.
       // loadData();
        int flagx=0;
        for(int i=0;i<courseModalArrayList.size();i++){
            if(courseModalArrayList.get(i).getCourseDescription().equals(songsList.get(positionm).get("path"))){

                flagx=1;
                break;
            }
        }

        if(flagx==0) {
            courseModalArrayList.add(new CourseModal(songsList.get(positionm).get("name"), songsList.get(positionm).get("path")));
            // notifying adapter when new data added.
           adapter.notifyItemInserted(courseModalArrayList.size());

            saveData();
        }else {

            Toast.makeText(context2, "song already exists", Toast.LENGTH_SHORT).show();
        }
    }




    public static void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = context2.getSharedPreferences("shared preferences", MODE_PRIVATE);

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
    }

    public static void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.


    SharedPreferences sharedPreferences = context2.getSharedPreferences("shared preferences", MODE_PRIVATE);

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

        // after saving data we are displaying a toast message.
        Toast.makeText(context2, "song added to Favorites", Toast.LENGTH_SHORT).show();
    }




 */


    public  class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> implements  RecyclerViewFastScroller.OnPopupTextUpdate {


        private Context mCtx;
    //    private ArrayList<HashMap<String, String>> heroList;
       // private   ArrayList<HashMap<String, String>> filteredlist = new ArrayList<>();

        private final ArrayList<CourseModal> courseModalArrayList;


        public ProductsAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
            this.mCtx = context;
            this.courseModalArrayList = courseModalArrayList;

            //    this.filteredlist = heroList;

        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.listitem,parent, false);
            return new favmain.ProductsAdapter.ProductViewHolder(view);



        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {

            CourseModal modal = courseModalArrayList.get(position);
            holder.txtsongname.setText(modal.getCourseName());
          //  holder.courseDescTV.setText(modal.getCourseDescription());


            // holder.ra

      //      holder.txtsongname.setText(filteredlist.get(position).get("name"));
            holder.number.setText(String.valueOf(position+1));



      if(position==positionm ){





                holder.neumorphCardView.setShapeType(ShapeType.PRESSED);

                holder.neumorphCardView.setShadowColorDark(Color.rgb(17,17,17));
                holder.neumorphCardView.setShadowColorLight(Color.rgb(44,44,44));

                holder.txtsongname.setTextColor(Color.rgb(245,70,120));


                holder.equalizer.setVisibility(View.VISIBLE);
                holder.equalizer.animateBars();

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
            }

            //end




        }


        @Override
        public int getItemCount() {


            return courseModalArrayList.size();

        }
        public void removeItem(int position) {

            courseModalArrayList.remove(position);
            deletedata(Id);
            // positionm=position;
            if(position<positionm){
                positionm--;
              //  pos=positionm;
            }
            //  Toast.makeText(getApplicationContext(),"pos "+positionm+"index "+position,Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
            favn.setText(courseModalArrayList.size() + " songs");

        }

        public void restoreItem(HashMap<String, String> songk, int position) {

            courseModalArrayList.add(position, new CourseModal(songk.get("name"),songk.get("path"),songk.get("genere"),songk.get("artist")));
            saveData(Id);
            if(position<=positionm){
                positionm++;
              //  pos=positionm;
            }
            //    Toast.makeText(getApplicationContext(),"pos "+positionm+"index "+position,Toast.LENGTH_SHORT).show();

            notifyDataSetChanged();

            favn.setText(courseModalArrayList.size()+" songs");
        }

        public ArrayList<CourseModal> getData() {
            return courseModalArrayList;
        }



        @NotNull
        @Override
        public CharSequence onChange(int i) {


            return courseModalArrayList.get(i).getCourseName().substring(0, 1).toUpperCase();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {

            CheckBox radio;
            TextView txtsongname,number;
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
                   /*
                        if (getAdapterPosition() == pos && count == 2 ) {
                            // Toast.makeText(getApplicationContext(),"pos "+pos+" count "+count,Toast.LENGTH_LONG).show();
                            bottomsheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        } else {


                            positionm = getAdapterPosition();
                            pos = positionm;
                            count = 1;
                            count++;

                            //     Toast.makeText(getApplicationContext(),"pos2+" +positionm,Toast.LENGTH_SHORT).show();



                    */


                        positionm=getAdapterPosition();
                            for(int i=0;i<songsList.size();i++){
                                if(songsList.get(i).get("path").equals(courseModalArrayList.get(positionm).getCourseDescription())){
                                    index2=i;
                                    break;
                                }
                            }




                            Uri uri = Uri.parse(songsList.get(index2).get("path"));
                            mplayer(uri);



                            /*
                            name.setText(songnamem);
                            namemain.setText(songnamem);

                            subname2.setText(artistm);
                            artist.setText(artistm);
                            */

                            if (songImage == null) {
                                album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
                                //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
                            } else {
                                album_art.setImageBitmap(songImage);
                            }
                          //  seek();


                            mediaPlayerm.start();



                            notifyDataSetChanged();
                           isplay();

                        MainActivity.icon();

                         //   positionm=index;
                        }


                };
                itemView.setOnClickListener(clickListener);




            }


        }



    }
    @Override
    public void onBackPressed(){


        if(positionm==-1){
            positionm=remain;

        }else {

            positionm=index2;

        }
      //  Toast.makeText(context, "pos "+positionm, Toast.LENGTH_SHORT).show();
        finish();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

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
                songk.put("name", adapter.getData().get(position).getCourseName());

                songk.put("path",adapter.getData().get(position).getCourseDescription() );

                songk.put("genere",adapter.getData().get(position).getgenere() );
                songk.put("artist",adapter.getData().get(position).getartist() );


                // final

                adapter.removeItem(position);


                int ps=position+1;
                //start









                //end

                Snackbar snackbar = Snackbar
                        .make(motion,  "", Snackbar.LENGTH_LONG);
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

     ItemTouchHelper   itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);

    }

    public  static void favnext(){
        Uri uri2;

        if(positionm==-1){

            uri2 = Uri.parse(courseModalArrayList.get(0).getCourseDescription());
            positionm=0;

        }else {
            if (positionm == courseModalArrayList.size() - 1) {
                uri2 = Uri.parse(courseModalArrayList.get(0).getCourseDescription());
                positionm = 0;
            } else {

                uri2 = Uri.parse(courseModalArrayList.get(positionm + 1).getCourseDescription());
                positionm = positionm + 1;
            }
        }
        mplayer(uri2);
        mediaPlayerm.start();

        for(int i=0;i<songsList.size();i++){
            if(songsList.get(i).get("path").equals(courseModalArrayList.get(positionm).getCourseDescription())){
                index2=i;
                break;
            }
        }


        //  name.setText(songnamem);
        //  namemain.setText(songnamem);

        //  subname2.setText(artistm);
        //  artist.setText(artistm);
        if(songImage==null){

            album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
            //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
        }else {
            album_art.setImageBitmap(songImage);
        }

        adapter.notifyDataSetChanged();
        isplay();
        MainActivity.icon();

    }

    public  static void favprev(){

        Uri uri2;

        if(positionm==-1){

            uri2 = Uri.parse(courseModalArrayList.get(0).getCourseDescription());
            positionm=0;

        }else {
            if (positionm == 0) {
                uri2 = Uri.parse(courseModalArrayList.get(courseModalArrayList.size()-1).getCourseDescription());
                positionm = courseModalArrayList.size()-1;
            } else {

                uri2 = Uri.parse(courseModalArrayList.get(positionm - 1).getCourseDescription());
                positionm = positionm - 1;
            }
        }
        mplayer(uri2);
        mediaPlayerm.start();

        for(int i=0;i<songsList.size();i++){
            if(songsList.get(i).get("path").equals(courseModalArrayList.get(positionm).getCourseDescription())){
                index2=i;
                break;
            }
        }


        //  name.setText(songnamem);
        //  namemain.setText(songnamem);

        //  subname2.setText(artistm);
        //  artist.setText(artistm);
        if(songImage==null){

            album_art.setImageDrawable(ContextCompat.getDrawable(MainActivity.getAppContext(), R.drawable.cloth));
            //   Toast.makeText(getApplicationContext(),"noimage",Toast.LENGTH_SHORT).show();
        }else {
            album_art.setImageBitmap(songImage);
        }

        adapter.notifyDataSetChanged();
        isplay();
        MainActivity.icon();


    }




}
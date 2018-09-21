package com.example.synthesizer;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.HashMap;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener {

    public static final float DEFAULT_VOLUME=1.0f;
    public static final int DEFAULT_PRIORITY=1;
    public static final int DEFAULT_LOOP=0;
    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonHighA;
    private Button buttonHighBb;
    private Button buttonHighB;
    private Button buttonHighC;
    private Button buttonHighCs;
    private Button buttonHighD;
    private Button buttonHighDs;
    private Button buttonHighE;
    private Button buttonHighF;
    private Button buttonHighFs;
    private Button buttonHighG;
    private Button buttonHighGs;

    private Button buttonScale;
    private Button buttonTwinkle;
    private CheckBox checkboxFullTwinkle;
    private Boolean completeTwinkle = false;
    private Button buttonOde;
    private Button buttonBlank;


    private Map<Integer, Integer> noteMap;

    private SoundPool soundPool;
    private int noteA2;
    private int noteBb2;
    private int noteB2;
    private int noteC2;
    private int noteCs2;
    private int noteD2;
    private int noteDs2;
    private int noteE2;
    private int noteF2;
    private int noteFs2;
    private int noteG2;
    private int noteGs2;
    private int noteA3;
    private int noteBb3;
    private int noteB3;
    private int noteC3;
    private int noteCs3;
    private int noteD3;
    private int noteDs3;
    private int noteE3;
    private int noteF3;
    private int noteFs3;
    private int noteG3;
    private int noteGs3;
    private int noteA4;
    private int noteBb4;
    private int noteB4;
    private int noteC4;
    private int noteCs4;
    private int noteD4;
    private int noteDs4;
    private int noteE4;
    private int noteF4;
    private int noteFs4;
    private int noteG4;
    private int noteGs4;

    Song scale = new Song();
    Song twinklePart = new Song();
    Song twinkleFull = new Song();
    Song Ode = new Song();
    Song BlankT1 = new Song();
    Song BlankT2 = new Song();

    //ColorDrawable viewColor;
    //int alphaMod;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_synthesizer);

        handler = new Handler();
        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
        createSongs();
    }

    private void createSongs() {
        createScale();
        createTwinkle();
        createOde();
        createBlank();
    }

    private void createScale(){
        scale.add(new Note(noteA3));
        scale.add(new Note(noteBb3));
        scale.add(new Note(noteB3));
        scale.add(new Note(noteC3));
        scale.add(new Note(noteCs3));
        scale.add(new Note(noteD3));
        scale.add(new Note(noteDs3));
        scale.add(new Note(noteE3));
        scale.add(new Note(noteF3));
        scale.add(new Note(noteFs3));
        scale.add(new Note(noteG3));
        scale.add(new Note(noteGs3));
        scale.add(new Note(noteA4));
        scale.add(new Note(noteBb4));
        scale.add(new Note(noteB4));
        scale.add(new Note(noteC4));
        scale.add(new Note(noteCs4));
        scale.add(new Note(noteD4));
        scale.add(new Note(noteDs4));
        scale.add(new Note(noteE4));
        scale.add(new Note(noteF4));
        scale.add(new Note(noteFs4));
        scale.add(new Note(noteG4));
        scale.add(new Note(noteGs4));
    }
    private void createTwinkle(){
        twinklePart.add(new Note(noteA3,2.0f));
        twinklePart.add(new Note(noteA3,2.0f));
        twinklePart.add(new Note(noteE4,2.0f));
        twinklePart.add(new Note(noteE4,2.0f));
        twinklePart.add(new Note(noteFs4,2.0f));
        twinklePart.add(new Note(noteFs4,2.0f));
        twinklePart.add(new Note(noteE4,2.0f));
        twinklePart.add(new Note(noteD3,2.0f));
        twinklePart.add(new Note(noteD3,2.0f));
        twinklePart.add(new Note(noteCs3,2.0f));
        twinklePart.add(new Note(noteCs3,2.0f));
        twinklePart.add(new Note(noteB3,2.0f));
        twinklePart.add(new Note(noteB3,2.0f));
        twinklePart.add(new Note(noteA3,2.0f));
        twinkleFull.add(new Note(noteA3,2.0f));
        twinkleFull.add(new Note(noteA3,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteFs4,2.0f));
        twinkleFull.add(new Note(noteFs4,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteB3,2.0f));
        twinkleFull.add(new Note(noteB3,2.0f));
        twinkleFull.add(new Note(noteA3,2.0f));

        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteB3,2.0f));

        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteB3,2.0f));

        twinkleFull.add(new Note(noteA3,2.0f));
        twinkleFull.add(new Note(noteA3,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteFs4,2.0f));
        twinkleFull.add(new Note(noteFs4,2.0f));
        twinkleFull.add(new Note(noteE4,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteD3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteCs3,2.0f));
        twinkleFull.add(new Note(noteB3,2.0f));
        twinkleFull.add(new Note(noteB3,2.0f));
        twinkleFull.add(new Note(noteA3,2.0f));
    }
    private void createOde(){
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteF3,2.0f));
        Ode.add(new Note(noteG3,2.0f));
        Ode.add(new Note(noteG3,2.0f));
        Ode.add(new Note(noteF3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteE3,2.0f*2/3));
        Ode.add(new Note(noteD3,4.0f));
        Ode.add(new Note(noteD3,1.0f));

        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteF3,2.0f));
        Ode.add(new Note(noteG3,2.0f));
        Ode.add(new Note(noteG3,2.0f));
        Ode.add(new Note(noteF3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteD3,2.0f*2/3));
        Ode.add(new Note(noteC3,4.0f));
        Ode.add(new Note(noteC3,1.0f));

        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteE3,4.0f));
        Ode.add(new Note(noteF3,4.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteE3,4.0f));
        Ode.add(new Note(noteF3,4.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteA3,1.0f));

        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteF3,2.0f));
        Ode.add(new Note(noteG3,2.0f));
        Ode.add(new Note(noteG3,2.0f));
        Ode.add(new Note(noteF3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteC3,2.0f));
        Ode.add(new Note(noteD3,2.0f));
        Ode.add(new Note(noteE3,2.0f));
        Ode.add(new Note(noteD3,2.0f*2/3));
        Ode.add(new Note(noteC3,4.0f));
        Ode.add(new Note(noteC3,1.0f));
    }
    private void createBlank(){
        createBlankPt1();
        createBlankPt2();
        createBlankPt3();
    }
    private void createBlankPt1(){
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteA4,4.0f));
        BlankT1.add(new Note(noteA4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteFs4,4.0f));
        BlankT1.add(new Note(noteFs4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteFs4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteA4,4.0f));
        BlankT1.add(new Note(noteA4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT1.add(new Note(noteB4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteFs4,4.0f));
        BlankT1.add(new Note(noteFs4,4.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT1.add(new Note(noteCs4,4.0f));
        BlankT2.add(new Note(0,0.5f));
    }
    private void createBlankPt2(){
        BlankT1.add(new Note(noteG3,2.0f*2/3));
        BlankT1.add(new Note(noteF3,2.0f*2/3));
        BlankT1.add(new Note(noteA4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteB4,2.0f*2/3));
        BlankT1.add(new Note(noteA4,2.0f*2/3));
        BlankT1.add(new Note(noteB4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteD4,2.0f*2/3));
        BlankT1.add(new Note(noteCs4,2.0f*2/3));
        BlankT1.add(new Note(noteFs4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteCs4,2.0f*2/3));
        BlankT1.add(new Note(noteD4,2.0f*2/3));
        BlankT1.add(new Note(noteCs4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteG3,2.0f*2/3));
        BlankT1.add(new Note(noteF3,2.0f*2/3));
        BlankT1.add(new Note(noteA4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteB4,2.0f*2/3));
        BlankT1.add(new Note(noteA4,2.0f*2/3));
        BlankT1.add(new Note(noteB4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteD4,2.0f*2/3));
        BlankT1.add(new Note(noteCs4,2.0f*2/3));
        BlankT1.add(new Note(noteFs4,2.0f));
        BlankT2.add(new Note(0,0.5f));

        BlankT1.add(new Note(noteCs4,2.0f*2/3));
        BlankT1.add(new Note(noteD4,2.0f*2/3));
        BlankT1.add(new Note(noteCs4,2.0f));
        BlankT2.add(new Note(0,0.5f));
    }
    private void createBlankPt3(){
        BlankT1.add(new Note(noteG3, 4.0f));
        BlankT1.add(new Note(noteG3, 4.0f));
        BlankT1.add(new Note(noteG3, 4.0f));
        BlankT1.add(new Note(noteF3, 4.0f));
        BlankT1.add(new Note(noteF3, 4.0f));
        BlankT1.add(new Note(noteF3, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT2.add(new Note(noteG2, 4.0f));
        BlankT2.add(new Note(noteG2, 4.0f));
        BlankT2.add(new Note(noteG2, 4.0f));
        BlankT2.add(new Note(noteF2, 4.0f));
        BlankT2.add(new Note(noteF2, 4.0f));
        BlankT2.add(new Note(noteF2, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));

        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));

        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteFs4, 4.0f));
        BlankT1.add(new Note(noteFs4, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteF3, 4.0f));
        BlankT2.add(new Note(noteF3, 4.0f));

        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));

        BlankT1.add(new Note(noteG3, 4.0f));
        BlankT1.add(new Note(noteG3, 4.0f));
        BlankT1.add(new Note(noteG3, 4.0f));
        BlankT1.add(new Note(noteF3, 4.0f));
        BlankT1.add(new Note(noteF3, 4.0f));
        BlankT1.add(new Note(noteF3, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT2.add(new Note(noteG2, 4.0f));
        BlankT2.add(new Note(noteG2, 4.0f));
        BlankT2.add(new Note(noteG2, 4.0f));
        BlankT2.add(new Note(noteF2, 4.0f));
        BlankT2.add(new Note(noteF2, 4.0f));
        BlankT2.add(new Note(noteF2, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));

        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteA4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT1.add(new Note(noteB4, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteA3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));
        BlankT2.add(new Note(noteB3, 4.0f));

        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteFs4, 4.0f));
        BlankT1.add(new Note(noteFs4, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteF3, 4.0f));
        BlankT2.add(new Note(noteF3, 4.0f));

        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteCs4, 4.0f));
        BlankT1.add(new Note(noteD4, 4.0f));
        BlankT1.add(new Note(0,1.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteC3, 4.0f));
        BlankT2.add(new Note(noteD3, 4.0f));
        BlankT2.add(new Note(0,1.0f));
    }
    private void createBlankPt4(){
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteG3,4.0f));
        BlankT1.add(new Note(noteF3,4.0f));
        BlankT1.add(new Note(0,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT1.add(new Note(noteA4,4.0f));
        BlankT1.add(new Note(noteD4,4.0f));
        BlankT2.add(new Note(noteE3,4.0f));
        BlankT2.add(new Note(noteE3,4.0f));
        BlankT2.add(new Note(noteE3,4.0f));
        BlankT2.add(new Note(0,4.0f));
        BlankT2.add(new Note(0,4.0f));
        BlankT2.add(new Note(noteD3,4.0f));
        BlankT2.add(new Note(noteA3,4.0f));
        BlankT2.add(new Note(noteD3,4.0f));
    }

    private void initializeNoteMap() {
        noteMap=new HashMap<>();
        // in a map, you store a key:value pair
        noteMap.put(R.id.button_synth_a, noteA3);
        noteMap.put(R.id.button_synth_bb, noteBb3);
        noteMap.put(R.id.button_synth_b, noteB3);
        noteMap.put(R.id.button_synth_c, noteC3);
        noteMap.put(R.id.button_synth_cs, noteCs3);
        noteMap.put(R.id.button_synth_d, noteD3);
        noteMap.put(R.id.button_synth_ds, noteDs3);
        noteMap.put(R.id.button_synth_e, noteE3);
        noteMap.put(R.id.button_synth_f, noteF3);
        noteMap.put(R.id.button_synth_fs, noteFs3);
        noteMap.put(R.id.button_synth_g, noteG3);
        noteMap.put(R.id.button_synth_gs, noteGs3);
        noteMap.put(R.id.button_synth_ha,noteA4);
        noteMap.put(R.id.button_synth_hbb,noteBb4);
        noteMap.put(R.id.button_synth_hb,noteB4);
        noteMap.put(R.id.button_synth_hc, noteC4);
        noteMap.put(R.id.button_synth_hcs, noteCs4);
        noteMap.put(R.id.button_synth_hd, noteD4);
        noteMap.put(R.id.button_synth_hds, noteDs4);
        noteMap.put(R.id.button_synth_he, noteE4);
        noteMap.put(R.id.button_synth_hf, noteF4);
        noteMap.put(R.id.button_synth_hfs, noteFs4);
        noteMap.put(R.id.button_synth_hg, noteG4);
        noteMap.put(R.id.button_synth_hgs, noteGs4);
    }

    private void initializeSoundPool() {
        soundPool= new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        noteA2 = soundPool.load(this, R.raw.scalea2,1);
        noteBb2 = soundPool.load(this, R.raw.scalebflat2,1);
        noteB2 = soundPool.load(this, R.raw.scaleb2,1);
        noteC2 = soundPool.load(this, R.raw.scalec2,1);
        noteCs2 = soundPool.load(this, R.raw.scalecsharp2,1);
        noteD2 = soundPool.load(this, R.raw.scaled2,1);
        noteDs2 = soundPool.load(this, R.raw.scaledsharp2,1);
        noteE2 = soundPool.load(this, R.raw.scalee2,1);
        noteF2 = soundPool.load(this, R.raw.scalef2,1);
        noteFs2 = soundPool.load(this, R.raw.scalefsharp2,1);
        noteG2 = soundPool.load(this, R.raw.scaleg2,1);
        noteGs2 = soundPool.load(this, R.raw.scalegsharp2,1);
        noteA3 = soundPool.load(this,R.raw.scalea3,1);
        noteBb3 = soundPool.load(this,R.raw.scalebflat3,1);
        noteB3 = soundPool.load(this,R.raw.scaleb3,1);
        noteC3 = soundPool.load(this,R.raw.scalec,1);
        noteCs3 = soundPool.load(this,R.raw.scalecs,1);
        noteD3 = soundPool.load(this,R.raw.scaled,1);
        noteDs3 = soundPool.load(this,R.raw.scaleds,1);
        noteE3 = soundPool.load(this,R.raw.scalee,1);
        noteF3 = soundPool.load(this,R.raw.scalef,1);
        noteFs3 = soundPool.load(this,R.raw.scalefs,1);
        noteG3 = soundPool.load(this,R.raw.scaleg,1);
        noteGs3 = soundPool.load(this,R.raw.scalegs,1);
        noteA4= soundPool.load(this,R.raw.scalehigha,1);
        noteBb4 = soundPool.load(this,R.raw.scalehighbb,1);
        noteB4 = soundPool.load(this,R.raw.scalehighb,1);
        noteC4 = soundPool.load(this,R.raw.scalehighc,1);
        noteCs4 = soundPool.load(this,R.raw.scalehighcs,1);
        noteD4 = soundPool.load(this,R.raw.scalehighd,1);
        noteDs4 = soundPool.load(this,R.raw.scalehighds,1);
        noteE4 = soundPool.load(this,R.raw.scalehighe,1);
        noteF4 = soundPool.load(this,R.raw.scalehighf,1);
        noteFs4 = soundPool.load(this,R.raw.scalehighfs,1);
        noteG4 = soundPool.load(this,R.raw.scalehighg,1);
        noteGs4 = soundPool.load(this,R.raw.scalehighgs,1);
    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonHighA.setOnClickListener(noteListener);
        buttonHighBb.setOnClickListener(noteListener);
        buttonHighB.setOnClickListener(noteListener);
        buttonHighC.setOnClickListener(noteListener);
        buttonHighCs.setOnClickListener(noteListener);
        buttonHighD.setOnClickListener(noteListener);
        buttonHighDs.setOnClickListener(noteListener);
        buttonHighE.setOnClickListener(noteListener);
        buttonHighF.setOnClickListener(noteListener);
        buttonHighFs.setOnClickListener(noteListener);
        buttonHighG.setOnClickListener(noteListener);
        buttonHighGs.setOnClickListener(noteListener);
        buttonScale.setOnClickListener(this);
        buttonTwinkle.setOnClickListener(this);
        buttonOde.setOnClickListener(this);
        buttonBlank.setOnClickListener(this);
        checkboxFullTwinkle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                completeTwinkle=isChecked;
            }
        });
    }

    private void wireWidgets() {
        buttonA=findViewById(R.id.button_synth_a);
        buttonBb=findViewById(R.id.button_synth_bb);
        buttonB=findViewById(R.id.button_synth_b);
        buttonC=findViewById(R.id.button_synth_c);
        buttonCs=findViewById(R.id.button_synth_cs);
        buttonD=findViewById(R.id.button_synth_d);
        buttonDs=findViewById(R.id.button_synth_ds);
        buttonE=findViewById(R.id.button_synth_e);
        buttonF=findViewById(R.id.button_synth_f);
        buttonFs=findViewById(R.id.button_synth_fs);
        buttonG=findViewById(R.id.button_synth_g);
        buttonGs=findViewById(R.id.button_synth_gs);
        buttonHighA=findViewById(R.id.button_synth_ha);
        buttonHighBb=findViewById(R.id.button_synth_hbb);
        buttonHighB=findViewById(R.id.button_synth_hb);
        buttonHighC=findViewById(R.id.button_synth_hc);
        buttonHighCs=findViewById(R.id.button_synth_hcs);
        buttonHighD=findViewById(R.id.button_synth_hd);
        buttonHighDs=findViewById(R.id.button_synth_hds);
        buttonHighE=findViewById(R.id.button_synth_he);
        buttonHighF=findViewById(R.id.button_synth_hf);
        buttonHighFs=findViewById(R.id.button_synth_hfs);
        buttonHighG=findViewById(R.id.button_synth_hg);
        buttonHighGs=findViewById(R.id.button_synth_hgs);
        buttonScale=findViewById(R.id.button_synth_scale);
        buttonTwinkle=findViewById(R.id.button_synth_twinkle);
        checkboxFullTwinkle=findViewById(R.id.checkBox_synth_twinklecomplete);
        buttonOde=findViewById(R.id.button_synth_ode);
        buttonBlank=findViewById(R.id.button_synth_blank);
    }

    private void delay(int length) {
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, float rate){
        if(note!=0){
            soundPool.play(note,DEFAULT_VOLUME,DEFAULT_VOLUME,DEFAULT_PRIORITY,DEFAULT_LOOP,rate);
        }
    }

    private void playNote(Note note){
        playNote(note.getNoteId(),1.0f);
    }

    @Override
    public void onClick(final View view) {
        //one method to handle all button clicks
        //but don't forget to tell the buttons who's doing the listening
        switch(view.getId()){
//            case R.id.button_synth_a:
//                playNote(noteA3);
//                break;
//            case R.id.button_synth_bb:
//                playNote(noteBb3);
//                break;
//            case R.id.button_synth_b:
//                playNote(noteB3);
//                break;
//            case R.id.button_synth_c:
//                playNote(noteC3);
//                break;
//            case R.id.button_synth_cs:
//                playNote(noteCs3);
//                break;
//            case R.id.button_synth_d:
//                playNote(noteD3);
//                break;
//            case R.id.button_synth_ds:
//                playNote(noteDs3);
//                break;
//            case R.id.button_synth_e:
//                playNote(noteE3);
//                break;
//            case R.id.button_synth_f:
//                playNote(noteF3);
//                break;
//            case R.id.button_synth_fs:
//                playNote(noteFs3);
//                break;
//            case R.id.button_synth_g:
//                playNote(noteG3);
//                break;
//            case R.id.button_synth_gs:
//                playNote(noteGs3);
//                break;
//            case R.id.button_synth_ha:
//                playNote(noteHighA);
//                break;
//            case R.id.button_synth_hbb:
//                playNote(noteHighBb);
//                break;
//            case R.id.button_synth_hb:
//                playNote(noteB4);
//                break;
//            case R.id.button_synth_hc:
//                playNote(noteC4);
//                break;
//            case R.id.button_synth_hcs:
//                playNote(noteCs4);
//                break;
//            case R.id.button_synth_hd:
//                playNote(noteD4);
//                break;
//            case R.id.button_synth_hds:
//                playNote(noteDs4);
//                break;
//            case R.id.button_synth_he:
//                playNote(noteE4);
//                break;
//            case R.id.button_synth_hf:
//                playNote(noteF4);
//                break;
//            case R.id.button_synth_hfs:
//                playNote(noteFs4);
//                break;
//            case R.id.button_synth_hg:
//                playNote(noteG4);
//                break;
//            case R.id.button_synth_hgs:
//                playNote(noteGs4);
//                break;
            case R.id.button_synth_scale:
                playSongs(250, scale);
                break;
            case R.id.button_synth_twinkle:
                if(completeTwinkle){
                    playSongs(250, twinkleFull);
                } else {
                    playSongs(250, twinklePart);
                }
                break;
            case R.id.button_synth_ode:
                playSongs(250, Ode);
                break;
            case R.id.button_synth_blank:
                playSongs(500, BlankT1, BlankT2);
                break;
        }
    }


    private void playSongs(long startDelay, Song... songs) {
        long base = SystemClock.uptimeMillis() + startDelay;
        for (Song song : songs) {
            long delay = 0;
            for (final Note note : song.getNotes()) {
                handler.postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        if(note.getNoteId()!=0){
                            soundPool.play(note.getNoteId(), DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, DEFAULT_LOOP, note.getRate());
                        }
                    }
                }, base + delay);
                delay+=1000/note.getRate();
            }
        }
    }


    // make inner class to handle button clicks for individual notes
    class KeyboardNoteListener implements View.OnClickListener, View.OnLongClickListener
    {
        @Override
        public void onClick(final View view) {
            // get id of clicked button
            int id = view.getId();
            // use map to find note
            int note = noteMap.get(id);
            // play note
//            view.getBackground().setColorFilter(Color.argb(255,0,255,255), PorterDuff.Mode.MULTIPLY);
//            new CountDownTimer(2000,100){
//                @Override
//                public void onTick(long millisUntilFinished) {
//                viewColor= (ColorDrawable) view.getBackground();
//                alphaMod=Color.alpha(viewColor.getColor());
//                view.setBackgroundColor(Color.argb(alphaMod-25,0,255,255));
//                }
//                @Override
//                public void onFinish() {
//                    view.getBackground().clearColorFilter();
//                }
//            }.start();
            playNote(note,1.0f);
        }

        @Override
        public boolean onLongClick(View view) {
            // get id of clicked button
            int id = view.getId();
            // use map to find note
            int note = noteMap.get(id);
            // play note
//            view.getBackground().setColorFilter(Color.argb(255,0,255,255), PorterDuff.Mode.MULTIPLY);
//            new CountDownTimer(2000,100){
//                @Override
//                public void onTick(long millisUntilFinished) {
//                viewColor= (ColorDrawable) view.getBackground();
//                alphaMod=Color.alpha(viewColor.getColor());
//                view.setBackgroundColor(Color.argb(alphaMod-25,0,255,255));
//                }
//                @Override
//                public void onFinish() {
//                    view.getBackground().clearColorFilter();
//                }
//            }.start();
            playNote(note,1.0f);
            return false;
        }
    }

}

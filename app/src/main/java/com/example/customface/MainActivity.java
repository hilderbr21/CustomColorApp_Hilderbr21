/* @Marc Hilderbrand
* September 30, 2019
 */

package com.example.customface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        //initiate the SurfaceView that will be modified to form the face
        Face theFace = findViewById(R.id.theFaceView);

        //initiate the face controller and randomize
        FaceController faceCtrl = new FaceController(theFace);
        theFace.randomize();

        //create SeekBars for each color
        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        //set a listener for any change in each SeekBar. The single method in FaceController change respective variables.
        seekBarRed.setOnSeekBarChangeListener(faceCtrl);
        seekBarGreen.setOnSeekBarChangeListener(faceCtrl);
        seekBarBlue.setOnSeekBarChangeListener(faceCtrl);

        //set a listener for the randomize button
        View randomButton = findViewById(R.id.randomize);
        randomButton.setOnClickListener(faceCtrl);

        //set a listener for the radioGroup
        RadioGroup group = findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(faceCtrl);


    }
}

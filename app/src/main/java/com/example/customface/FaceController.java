/* @Marc Hilderbrand
 * September 30, 2019
 */

package com.example.customface;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
public class FaceController implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    protected Face theFace;

    public FaceController(Face f)
    {
        theFace = f;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        switch (seekBar.getId())
        {
            case (R.id.seekBarRed) :
                theFace.setTheColor('r', progress);
                break;

            case (R.id.seekBarGreen) :
                theFace.setTheColor('g', progress);
                break;

            case (R.id.seekBarBlue) :
                theFace.setTheColor('b', progress);
                break;
        }

        theFace.invalidate();
    }

    public void onStartTrackingTouch(SeekBar seekBar){}
    public void onStopTrackingTouch(SeekBar seekBar){}

    @Override
    public void onClick(View button)
    {
        theFace.randomize();
    }

    //change a variable in Face that holds a value that changes depending on what is checked
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedID)
    {
        if(checkedID == R.id.hairColor)
        {
            theFace.whatIsChecked = 1;

        }
        else if(checkedID == R.id.eyeColor)
        {
            theFace.whatIsChecked = 2;
        }
        else if(checkedID == R.id.skinColor)
        {
            theFace.whatIsChecked = 3;
        }
        theFace.invalidate();
    }


}

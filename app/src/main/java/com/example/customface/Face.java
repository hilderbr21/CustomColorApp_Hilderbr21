/* @Marc Hilderbrand
 * September 30, 2019
 */

package com.example.customface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;


public class Face extends SurfaceView {

    //initialize paint variables to be used when drawing
    private Paint skinColor = new Paint();
    private Paint eyeColor = new Paint();
    private Paint hairColor = new Paint();
    private int hairStyle;

    //hard coded face translation
    private int faceX = 800;
    private int faceY = 400;

    //other face attributes
    private Paint facialFeaturesColor = new Paint();
    private Paint eyeWhiteColor = new Paint();

    public FaceInfo faceAttributes = new FaceInfo();

    //used to store which radioButton is checked
    public int whatIsChecked = 0;

    public Face(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        setWillNotDraw(false);

    }


    //method called in FaceController that sets the RGB color of what is checked
    public void setTheColor(char color, int progress)
    {
        switch(color)
        {
            //set the color of what is checked with the newly changed color
            case 'r' :
                switch(whatIsChecked) {
                    case 3:
                        faceAttributes.redSkinColor = progress;
                        break;

                    case 2:
                        faceAttributes.redEyeColor = progress;
                        break;

                    case 1:
                        faceAttributes.redHairColor = progress;
                        break;
                }
                break;

            case 'g' :
                switch(whatIsChecked) {
                    case 3:
                        faceAttributes.greenSkinColor = progress;
                        break;

                    case 2:
                        faceAttributes.greenEyeColor = progress;
                        break;

                    case 1:
                        faceAttributes.greenHairColor = progress;
                        break;
                }
                break;


            case 'b' :
                switch(whatIsChecked) {
                    case 3:
                        faceAttributes.blueSkinColor = progress;
                        break;

                    case 2:
                        faceAttributes.blueEyeColor = progress;
                        break;

                    case 1:
                        faceAttributes.blueHairColor = progress;
                        break;
                }
                break;
        }
        invalidate();
    }


    //Randomize to be called when the randomized button is pushed
    public void randomize()
    {
        //set red ints
        faceAttributes.redSkinColor = (int) (Math.random()*255);
        faceAttributes.redEyeColor = (int) (Math.random()*255);
        faceAttributes.redHairColor = (int) (Math.random()*255);

        //set green ints
        faceAttributes.greenSkinColor = (int) (Math.random()*255);
        faceAttributes.greenEyeColor = (int) (Math.random()*255);
        faceAttributes.greenHairColor = (int) (Math.random()*255);

        //set blue ints
        faceAttributes.blueSkinColor = (int) (Math.random()*255);
        faceAttributes.blueEyeColor = (int) (Math.random()*255);
        faceAttributes.blueHairColor = (int) (Math.random()*255);


        hairStyle = (int) (Math.random()*3);


        invalidate();
    }

    //set hairstyle
    public void setHair()
    {

    }

    @Override
    public void onDraw(Canvas canvas)
    {
        facialFeaturesColor.setColor(Color.BLACK);
        eyeWhiteColor.setColor(Color.WHITE);
        setBackgroundColor(Color.WHITE);

        skinColor.setARGB(255, faceAttributes.redSkinColor, faceAttributes.greenSkinColor, faceAttributes.blueSkinColor);
        eyeColor.setARGB(255, faceAttributes.redEyeColor, faceAttributes.greenEyeColor, faceAttributes.blueEyeColor);
        hairColor.setARGB(255, faceAttributes.redHairColor, faceAttributes.greenHairColor, faceAttributes.blueHairColor);


        canvas.drawCircle(faceX,faceY,250, skinColor);



        //draw eyes
        canvas.drawCircle(faceX-100,faceY-100,50,eyeWhiteColor);
        canvas.drawCircle(faceX+100,faceY-100,50,eyeWhiteColor);

        //draw iris
        canvas.drawCircle(faceX-100, faceY-100, 25, eyeColor);
        canvas.drawCircle(faceX+100, faceY-100, 25, eyeColor);

        //draw pupil
        canvas.drawCircle(faceX-100, faceY-100, 10, facialFeaturesColor);
        canvas.drawCircle(faceX+100, faceY-100, 10, facialFeaturesColor);


        //draw nose
        canvas.drawRect(faceX + 25, faceY - 25, faceX - 25, faceY + 25, facialFeaturesColor);
        //draw an arc for the mouth
        canvas.drawArc((float) faceX-75,(float) faceY-100, (float) faceX+75,(float) faceY-150,(float)180,
                (float) -180,true,facialFeaturesColor);


        //draw hairstyle
        if(hairStyle == 1) {
            canvas.drawRect(faceX + 150, faceY - 300, faceX - 150, faceY - 225, hairColor);
        }
        else if(hairStyle == 2)
        {
            canvas.drawRect(faceX + 150, faceY - 300, faceX - 150, faceY - 225, hairColor);
        }
    }

}

package com.example.user4.sietzeberends_problemset1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView[] images = new ImageView[10];
    CheckBox[] checkBoxes = new CheckBox[10];
    LinearLayout layout;

    ImageView arms;
    ImageView body;
    ImageView ears;
    ImageView eyebrows;
    ImageView eyes;
    ImageView glasses;
    ImageView hat;
    ImageView mouth;
    ImageView mustache;
    ImageView nose;
    ImageView shoes;

    CheckBox chArms;
    CheckBox chBody;
    CheckBox chEars;
    CheckBox chEyebrows;
    CheckBox chEyes;
    CheckBox chGlasses;
    CheckBox chHat;
    CheckBox chMouth;
    CheckBox chMustache;
    CheckBox chNose;
    CheckBox chShoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.linearLayout);
        arms = (ImageView) findViewById(R.id.armsImage);
        ears = (ImageView) findViewById(R.id.earsImage);
        eyebrows = (ImageView) findViewById(R.id.eyebrowsImage);
        eyes = (ImageView) findViewById(R.id.eyesImage);
        glasses = (ImageView) findViewById(R.id.glassesImage);
        hat = (ImageView) findViewById(R.id.hatImage);
        mouth = (ImageView) findViewById(R.id.mouthImage);
        mustache = (ImageView) findViewById(R.id.mustacheImage);
        nose = (ImageView) findViewById(R.id.noseImage);
        shoes = (ImageView) findViewById(R.id.shoesImage);
        chArms = (CheckBox) findViewById(R.id.armsCb);
        chEars = (CheckBox) findViewById(R.id.earsCb);
        chEyebrows = (CheckBox) findViewById(R.id.eyebrowsCb);
        chEyes = (CheckBox) findViewById(R.id.eyesCb);
        chGlasses = (CheckBox) findViewById(R.id.glassesCb);
        chHat = (CheckBox) findViewById(R.id.hatCb);
        chMouth = (CheckBox) findViewById(R.id.mouthCb);
        chMustache = (CheckBox) findViewById(R.id.mustacheCb);
        chNose = (CheckBox) findViewById(R.id.noseCb);
        chShoes = (CheckBox) findViewById(R.id.shoesCb);

        images[0] = arms;
        images[1] = ears;
        images[2] = eyebrows;
        images[3] = eyes;
        images[4] = glasses;
        images[5] = hat;
        images[6] = mouth;
        images[7] = mustache;
        images[8] = nose;
        images[9] = shoes;

        checkBoxes[0] = chArms;
        checkBoxes[1] = chEars;
        checkBoxes[2] = chEyebrows;
        checkBoxes[3] = chEyes;
        checkBoxes[4] = chGlasses;
        checkBoxes[5] = chHat;
        checkBoxes[6] = chMouth;
        checkBoxes[7] = chMustache;
        checkBoxes[8] = chNose;
        checkBoxes[9] = chShoes;

        chArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    arms.setVisibility(View.INVISIBLE);
                }
            }
        });

        for (int i = 0; i < checkBoxes.length; i++) {
            final ImageView image = images[i];
            checkBoxes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        image.setVisibility(View.VISIBLE);
                    }
                    else {
                        image.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
        chArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    arms.setVisibility(View.VISIBLE);
                } else {
                    arms.setVisibility(View.INVISIBLE);
                }
            }
        });
    };

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int visibility[] = new int[10];
        for(int i = 0; i < images.length; i++) {
            visibility[i] = images[i].getVisibility();
        }
        outState.putIntArray("visibility", visibility);

        int currentOrientation = this.getResources().getConfiguration().orientation;
        outState.putInt("orientation", currentOrientation);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        int visibility[] = inState.getIntArray("visibility");

        for (int i = 0; i < images.length; i++) {
            images[i].setVisibility(visibility[i]);
        }

        int orientation = inState.getInt("orientation");

        /*if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            layout.setOrientation(LinearLayout.VERTICAL);
        }
        else {
            layout.setOrientation(LinearLayout.VERTICAL);
        }*/
    }
}
package com.example.user4.sietzeberends_problemset1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // arrays to keep track of all images and checkboxes
    ImageView[] images = new ImageView[10];
    CheckBox[] checkBoxes = new CheckBox[10];

    // all the bodyparts
    ImageView image;
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

    // all the checkboxes
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

        // instantiate all the bodyparts
        arms = findViewById(R.id.armsImage);
        ears = findViewById(R.id.earsImage);
        eyebrows = findViewById(R.id.eyebrowsImage);
        eyes = findViewById(R.id.eyesImage);
        glasses = findViewById(R.id.glassesImage);
        hat = findViewById(R.id.hatImage);
        mouth = findViewById(R.id.mouthImage);
        mustache = findViewById(R.id.mustacheImage);
        nose = findViewById(R.id.noseImage);
        shoes = findViewById(R.id.shoesImage);

        // instantiate all the checkboxes
        chArms = findViewById(R.id.armsCb);
        chEars = findViewById(R.id.earsCb);
        chEyebrows = findViewById(R.id.eyebrowsCb);
        chEyes = findViewById(R.id.eyesCb);
        chGlasses = findViewById(R.id.glassesCb);
        chHat = findViewById(R.id.hatCb);
        chMouth = findViewById(R.id.mouthCb);
        chMustache = findViewById(R.id.mustacheCb);
        chNose = findViewById(R.id.noseCb);
        chShoes = findViewById(R.id.shoesCb);

        // keep track of all the bodyparts
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

        // keep track of all the checkboxes
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

        // set OnClickListeners on the checkboxes, change visibility of the bodypart when clicked
        for (int i = 0; i < checkBoxes.length; i++) {
            image = images[i];
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
    }

    // save al the current visibility settings of all the bodyparts
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int visibility[] = new int[10];
        for(int i = 0; i < images.length; i++) {
            visibility[i] = images[i].getVisibility();
        }
        outState.putIntArray("visibility", visibility);
    }

    // restore all the visibility settings of all the bodyparts
    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        int visibility[] = inState.getIntArray("visibility");

        for (int i = 0; i < images.length; i++) {
            if (visibility != null) {
                images[i].setVisibility(visibility[i]);
            }
        }
    }
}
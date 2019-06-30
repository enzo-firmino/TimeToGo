package com.example.timetogo;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

public class MainActivity extends AppCompatActivity {

    Boolean beach;
    Boolean city;
    Boolean mountain;

    ImageView beachIV;
    ImageView mountainIV;
    ImageView cityIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beach = false;
        city = false;
        mountain = false;

        setImagesToBlackAndWhite();
        changeValueCrystalRangeSeeker();


    }

    private void setImagesToBlackAndWhite() {
        beachIV = findViewById(R.id.beach);
        mountainIV = findViewById(R.id.mountain);
        cityIV = findViewById(R.id.city);

        //Set filter to black and white
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);

        beachIV.setColorFilter(filter);
        mountainIV.setColorFilter(filter);
        cityIV.setColorFilter(filter);

        beachIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beach = !beach;
                changeImageSaturationBeach();
            }
        });
        cityIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = !city;

                changeImageSaturationCity();
            }
        });
        mountainIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mountain = !mountain;

                changeImageSaturationMountain();
            }
        });
    }

    private void changeImageSaturationBeach() {
        ColorMatrix matrix = new ColorMatrix();

        if (beach) {
            matrix.setSaturation(1);
        } else {
            matrix.setSaturation(0);
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        beachIV.setColorFilter(filter);
    }

    private void changeImageSaturationCity() {
        ColorMatrix matrix = new ColorMatrix();

        if (city) {
            matrix.setSaturation(1);
        } else {
            matrix.setSaturation(0);
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        cityIV.setColorFilter(filter);
    }

    private void changeImageSaturationMountain() {
        ColorMatrix matrix = new ColorMatrix();

        if (mountain) {
            matrix.setSaturation(1);
        } else {
            matrix.setSaturation(0);
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        mountainIV.setColorFilter(filter);
    }

    private void changeValueCrystalRangeSeeker() {

        final TextView budgetValuesTV = findViewById(R.id.budgetValues);
        final CrystalRangeSeekbar budgetValuesCRS = findViewById(R.id.budgetValuesCRS);

        budgetValuesCRS.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                budgetValuesTV.setText(budgetValuesCRS.getSelectedMinValue() + "$ - " + budgetValuesCRS.getSelectedMaxValue() + "$");
            }
        });
    }


}

package com.example.timetogo;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;

public class MainActivity extends AppCompatActivity {

    Boolean beach;
    Boolean city;
    Boolean mountain;

    Boolean days;
    Boolean week;
    Boolean choose;

    ImageView beachIV;
    ImageView mountainIV;
    ImageView cityIV;

    ImageView daysIV;
    ImageView weekIV;
    ImageView youChooseIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beach = false;
        city = false;
        mountain = false;
        days = false;
        week = false;
        choose = false;

        setImagesToBlackAndWhite();
        changeValueCrystalRangeSeeker();
        openActivityOnButtonClick();


    }

    private void openActivityOnButtonClick() {
        CardView button = findViewById(R.id.takeAwayTV);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LandingPage.class);
                startActivity(intent);
            }
        });
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

        daysIV = findViewById(R.id.aFewDays);
        weekIV = findViewById(R.id.aboutAWeek);
        youChooseIV = findViewById(R.id.youChoose);

        //Set filter to black and white
        ColorMatrix matrixDuration = new ColorMatrix();
        matrixDuration.setSaturation(0);
        ColorMatrixColorFilter filterDuration = new ColorMatrixColorFilter(matrixDuration);

        daysIV.setColorFilter(filterDuration);
        weekIV.setColorFilter(filterDuration);
        youChooseIV.setColorFilter(filterDuration);

        daysIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days = !days;
                changeImageSaturationDays();
            }
        });
        weekIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                week = !week;
                changeImageSaturationWeek();
            }
        });
        youChooseIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = !choose;
                changeImageSaturationYouChoose();
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

    private void changeImageSaturationDays() {
        ColorMatrix matrixDuration = new ColorMatrix();

        if (days) {
            matrixDuration.setSaturation(1);
        } else {
            matrixDuration.setSaturation(0);
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixDuration);
        daysIV.setColorFilter(filter);
    }

    private void changeImageSaturationWeek() {
        ColorMatrix matrixDuration = new ColorMatrix();

        if (week) {
            matrixDuration.setSaturation(1);
        } else {
            matrixDuration.setSaturation(0);
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixDuration);
        weekIV.setColorFilter(filter);
    }

    private void changeImageSaturationYouChoose() {
        ColorMatrix matrixDuration = new ColorMatrix();

        if (choose) {
            matrixDuration.setSaturation(1);
        } else {
            matrixDuration.setSaturation(0);
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixDuration);
        youChooseIV.setColorFilter(filter);
    }

    private void changeValueCrystalRangeSeeker() {

        final TextView budgetValuesTV = findViewById(R.id.budgetValues);
        final CrystalRangeSeekbar budgetValuesCRS = findViewById(R.id.budgetValuesCRS);

        budgetValuesCRS.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                if (maxValue.intValue() == 3000) {
                    budgetValuesTV.setText(minValue + "$ - " + maxValue + "$+");

                } else {
                    budgetValuesTV.setText(minValue + "$ - " + maxValue + "$");
                }
            }
        });

        final TextView peopleValuesTV = findViewById(R.id.numberOfPeopleValues);
        final CrystalSeekbar peopleCRS = findViewById(R.id.peopleCRS);

        peopleCRS.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number value) {
                if (value.intValue() == 1) {
                    peopleValuesTV.setText("Just me!");

                } else {
                    peopleValuesTV.setText(value + "");
                }
            }
        });
    }


}

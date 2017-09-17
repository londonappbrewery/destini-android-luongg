package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String STORY_CHAPTER = "STORY-STATE";
    private TextView storyTv;
    private Button choiceOneBtn, choiceTwoBtn;
    private int storyChapter, storyDestination = 0, choiceOneDest = 0, choiceTwoDest = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyTv = (TextView) findViewById(R.id.storyTextView);
        choiceOneBtn = (Button)findViewById(R.id.buttonTop);
        choiceTwoBtn = (Button) findViewById(R.id.buttonBottom);
        storyChapter = 1;

        if (savedInstanceState != null) {
            storyChapter = savedInstanceState.getInt(STORY_CHAPTER);
            reloadView(storyChapter);
        }

        choiceOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNextStory(1);
            }
        });
        
        choiceTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNextStory(2);
            }
        });
    }

    private void getNextStory(int clickedButton) {
        if (clickedButton == 1) {
            switch (storyChapter) {
                case 1:
                    storyDestination = R.string.T3_Story;
                    choiceOneDest = R.string.T3_Ans1;
                    choiceTwoDest = R.string.T3_Ans2;
                    storyChapter = 3;
                    break;
                case 2:
                    storyDestination = R.string.T3_Story;
                    choiceOneDest = R.string.T3_Ans1;
                    choiceTwoDest = R.string.T3_Ans2;
                    storyChapter = 3;
                    break;
                case 3:
                    storyDestination = R.string.T6_End;
                    choiceOneDest = 0;
                    choiceTwoDest = 0;
                    storyChapter = 6;
                    break;
            }
        } else {
            switch (storyChapter) {
                case 1:
                    storyDestination = R.string.T2_Story;
                    choiceOneDest = R.string.T2_Ans1;
                    choiceTwoDest = R.string.T2_Ans2;
                    storyChapter = 2;
                    break;
                case 2:
                    storyDestination = R.string.T4_End;
                    choiceOneDest = 0;
                    choiceTwoDest = 0;
                    storyChapter = 4;
                    break;
                case 3:
                    storyDestination = R.string.T5_End;
                    choiceOneDest = 0;
                    choiceTwoDest = 0;
                    storyChapter = 5;
                    break;
            }
        }
        storyTv.setText(storyDestination);
        if (choiceOneDest != 0 && choiceTwoDest != 0) {
            choiceOneBtn.setText(choiceOneDest);
            choiceTwoBtn.setText(choiceTwoDest);
            choiceOneBtn.setVisibility(View.VISIBLE);
            choiceTwoBtn.setVisibility(View.VISIBLE);
        } else {
            choiceOneBtn.setVisibility(View.GONE);
            choiceTwoBtn.setVisibility(View.GONE);
        }

    }

    private void reloadView(int chapter) {
        switch(chapter) {
            case 2:
                storyDestination = R.string.T2_Story;
                choiceOneDest = R.string.T2_Ans1;
                choiceTwoDest = R.string.T2_Ans2;
                break;
            case 3:
                storyDestination = R.string.T3_Story;
                choiceOneDest = R.string.T3_Ans1;
                choiceTwoDest = R.string.T3_Ans2;
                break;
            case 4:
                storyDestination = R.string.T4_End;
                choiceOneDest = 0;
                choiceTwoDest = 0;
                break;
            case 5:
                storyDestination = R.string.T5_End;
                choiceOneDest = 0;
                choiceTwoDest = 0;
                break;
            case 6:
                storyDestination = R.string.T6_End;
                choiceOneDest = 0;
                choiceTwoDest = 0;
                break;
            default:
                break;
        }

        if (storyDestination != 0) {
            storyTv.setText(storyDestination);
            if (choiceOneDest != 0 && choiceTwoDest != 0) {
                choiceOneBtn.setText(choiceOneDest);
                choiceTwoBtn.setText(choiceTwoDest);
                choiceOneBtn.setVisibility(View.VISIBLE);
                choiceTwoBtn.setVisibility(View.VISIBLE);
            } else {
                choiceOneBtn.setVisibility(View.GONE);
                choiceTwoBtn.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(STORY_CHAPTER, storyChapter);
    }
}

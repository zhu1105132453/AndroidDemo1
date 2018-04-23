package com.example.zjj20180414.androiddemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_result)
    TextView text_result;
    @BindView(R.id.text_winner)
    TextView text_winner;
    
    int smile, dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
    
    @OnClick(R.id.button)
    public void buttonClicked(View view) {
        if (smile == 0 || dog ==0){
            Toast.makeText(this, "请亮出你的拳头！", Toast.LENGTH_SHORT).show();
            text_result.setText("");
            text_winner.setText("");
            
        } else {
            switch (smile){
                case 1:
                    if (dog == 1){
                        text_result.setText("Smile:石头     Dog:石头");
                        text_winner.setText("平局");
                    }else if (dog == 2){
                        text_result.setText("Smile:石头     Dog:剪刀");
                        text_winner.setText("Smile");
                    } else {
                        text_result.setText("Smile:石头     Dog:布");
                        text_winner.setText("Dog");
                    }
                    break;
                case 2:
                    if (dog == 1){
                        text_result.setText("Smile:剪刀     Dog:石头");
                        text_winner.setText("Dog");
                    }else if (dog == 2){
                        text_result.setText("Smile:剪刀     Dog:剪刀");
                        text_winner.setText("平局");
                    } else {
                        text_result.setText("Smile:剪刀     Dog:布");
                        text_winner.setText("Smile");
                    }
                    break;
                case 3:
                    if (dog == 1){
                        text_result.setText("Smile:布     Dog:石头");
                        text_winner.setText("Smile");
                    }else if (dog == 2){
                        text_result.setText("Smile:布     Dog:剪刀");
                        text_winner.setText("Dog");
                    } else {
                        text_result.setText("Smile:布     Dog:布");
                        text_winner.setText("平局");
                    }
                    break;
            }
        }
        
    }
    
    @OnCheckedChanged({R.id.radioButton, R.id.radioButton2, R.id.radioButton3})
    public void onRadioCheckSmile(CompoundButton view, boolean isChanged){
        switch (view.getId()){
            case R.id.radioButton:
                if (isChanged)
                smile = 1;
                break;
            case R.id.radioButton2:
                if (isChanged)
                smile = 2;
                break;
            case R.id.radioButton3:
                if (isChanged)
                smile = 3;
                break;
            default:
                smile = 0;
                break;
        }
    }

    @OnCheckedChanged({R.id.radioButton4, R.id.radioButton5, R.id.radioButton6})
    public void onRadioCheckDog(CompoundButton view, boolean isChanged){
        switch (view.getId()){
            case R.id.radioButton4:
                if (isChanged)
                dog = 1;
                break;
            case R.id.radioButton5:
                if (isChanged)
                dog = 2;
                break;
            case R.id.radioButton6:
                if (isChanged)
                dog = 3;
                break;
            default:
                dog = 0;
                break;
        }
    }
    
}

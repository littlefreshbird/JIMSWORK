package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FreeTreatActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.patientname)
    TextView patientname;
    @BindView(R.id.patientage)
    TextView patientage;
    @BindView(R.id.patientsex)
    TextView patientsex;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.button_1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_treat);
        ButterKnife.bind(this);
        initview();

    }

    private void initview() {
        image.setImageResource(R.drawable.doctor1);
        patientname.setText("姓名：李国胜");
        patientage.setText("年龄：28");
        patientsex.setText("性别：男");

    }

    @OnClick(R.id.button_1)
    public void onClick() {
        finish();
    }
}

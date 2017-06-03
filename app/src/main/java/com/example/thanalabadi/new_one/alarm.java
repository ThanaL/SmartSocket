package com.example.thanalabadi.new_one;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class alarm extends AppCompatActivity implements TimePickerFragment.TimeDialogListener,View.OnClickListener{
    final TimePickerFragment dialog = new TimePickerFragment();
    private static final String DIALOG_TIME = "MainActivity.TimeDialog";

    FloatingActionButton f1,f2,f3,f4,f5,f6,f7;
    public List<days> day = new ArrayList<days>();
    public TextView time;
    public ImageButton save,out;
    public EditText name;
    public RadioGroup radioGroup;
    public static boolean test;
    public RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        time = (TextView) findViewById(R.id.time_text);
        save=(ImageButton) findViewById(R.id.save);
        out=(ImageButton) findViewById(R.id.out);
        name=(EditText)findViewById(R.id.name);
        dialog.show(getSupportFragmentManager(), DIALOG_TIME);
        radioGroup = (RadioGroup) findViewById(R.id.radio);

        time.setOnClickListener(alarm.this);
        save.setOnClickListener(alarm.this);
        out.setOnClickListener(alarm.this);


        f1=(FloatingActionButton) findViewById(R.id.satarday);
        f2=(FloatingActionButton) findViewById(R.id.sunday);
        f3=(FloatingActionButton) findViewById(R.id.monday);
        f4=(FloatingActionButton) findViewById(R.id.tusday);
        f5=(FloatingActionButton) findViewById(R.id.wednesday);
        f6=(FloatingActionButton) findViewById(R.id.theresday);
        f7=(FloatingActionButton) findViewById(R.id.friday);

        f1.setOnClickListener(alarm.this);
        f2.setOnClickListener(alarm.this);
        f3.setOnClickListener(alarm.this);
        f4.setOnClickListener(alarm.this);
        f5.setOnClickListener(alarm.this);
        f6.setOnClickListener(alarm.this);
        f7.setOnClickListener(alarm.this);

    }

    public void changecolor(int id,String name) {
        FloatingActionButton  f = (FloatingActionButton) findViewById(id);

        if (f.getBackgroundTintList().equals(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)))) {
            f.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
            day.add(new days(id,name));


        } else {
            f.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
            day.remove(new days(id,name));
        }
    }

    public void onFinishDialog(String Time) {

        time.setText(Time);



    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.time:
                dialog.show(getSupportFragmentManager(), DIALOG_TIME);
                break;




            case R.id.satarday:
                changecolor(R.id.satarday,"sat");

                break;
            case R.id.sunday:
                changecolor(R.id.sunday,"sun");

                break;
            case R.id.monday:
                changecolor(R.id.monday,"Mon");

                break;
            case R.id.tusday:
                changecolor(R.id.tusday,"tue");

                break;
            case R.id.wednesday:
                changecolor(R.id.wednesday,"wed");

                break;
            case R.id.theresday:
                changecolor(R.id.theresday,"thu");

                break;
            case R.id.friday:
                changecolor(R.id.friday,"Frt");

                break;

            case R.id.save:
                save();
                break;

            case R.id.out:
                finish();
                break;











        }







    }
    private void save() {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        DateFormat sdf = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = sdf.parse(time.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }



        //getting GMT timezone, you can get any timezone e.g. UTC
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        String newFormat = sdf.format(date);

config.names.add(new piece(mac,new Time(name.getText().toString(),newFormat,radioButton.getText().toString())));







        Toast.makeText(this, "Save Success", Toast.LENGTH_SHORT).show();





    }
}

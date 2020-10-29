package com.example.pedla.ui.home;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/*import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pedla.HS;
*/
import com.example.pedla.Choice;
import com.example.pedla.Login;
import com.example.pedla.R;
/*import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
*/import com.example.pedla.Stores;
import com.google.android.gms.common.api.Status;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment  {

    private HomeViewModel homeViewModel;
    TextView tvdate;
    EditText etdate;
    EditText etdate2;
    EditText ettime;
    EditText ettime2;
    TextView tvtime;
    TimePickerDialog timePickerDialog;
    DatePickerDialog.OnDateSetListener setListener;
    String amPm;
    EditText editText;
    TextView textView1;
    private Button btntostore;
   /* Button btnpicker;
    TextView location;
    TextView name,longitude;
    int PLACE_PICKER_REQUEST=1;*/


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        tvdate=root.findViewById(R.id.tv_date);
        etdate=root.findViewById(R.id.et_date);
        etdate2=root.findViewById(R.id.et_date2);

        ettime=root.findViewById(R.id.et_time);
        tvtime=root.findViewById(R.id.tv_time);
        ettime2=root.findViewById(R.id.et_time2);

        editText=root.findViewById(R.id.edit_text);
        textView1=root.findViewById(R.id.text_view1);

        btntostore=root.findViewById(R.id.btnstores);
       /* btnpicker=root.findViewById(R.id.picker);
        location=root.findViewById(R.id.address);
        name=root.findViewById(R.id.name);
        longitude=root.findViewById(R.id.longitude);*/

        final Calendar calender=Calendar.getInstance();
        final int year= calender.get(Calendar.YEAR);
        final int month= calender.get(Calendar.MONTH);
        final int day= calender.get(Calendar.DAY_OF_MONTH);

        final int year1= calender.get(Calendar.YEAR);
        final int month1= calender.get(Calendar.MONTH);
        final int day1= calender.get(Calendar.DAY_OF_MONTH);


        Places.initialize(HomeFragment.this.getContext(),"AIzaSyAIrloRRV7osj8QUUa3KfuwzRwzPvVP35A");

        editText.setFocusable(false);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List <Place.Field> fieldList= Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.NAME);
                Intent intent=new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN,
                        fieldList).build(HomeFragment.this.getContext());

                startActivityForResult(intent,100);
            }
        });

        btntostore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToStores();
            }
        });

        etdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        HomeFragment.this.getActivity(), R.style.TimePickerTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date= day+"/"+month+"/"+year;
                        etdate.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });


        etdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        HomeFragment.this.getActivity(), R.style.TimePickerTheme,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year1, int month1, int day1) {
                        month1=month1+1;
                        String date= day1+"/"+month1+"/"+year1;
                        etdate2.setText(date);

                    }
                },year1,month1,day1);
                datePickerDialog.show();

            }
        });

        ettime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentHour=calender.get(Calendar.HOUR_OF_DAY);
                int currentminute=calender.get(Calendar.MINUTE);

                timePickerDialog=new TimePickerDialog(HomeFragment.this.getActivity(),R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        if(hourOfDay>=12){
                            amPm=" PM";
                            hourOfDay=hourOfDay-12;

                        }else{
                            amPm=" AM";
                        }
                        ettime.setText(String.format("%02d:%02d",hourOfDay,minute)+amPm);
                    }
                },currentHour,currentminute,false);
                timePickerDialog.show();
            }
        });

        ettime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentHour1=calender.get(Calendar.HOUR_OF_DAY);
                int currentminute1=calender.get(Calendar.MINUTE);

                timePickerDialog=new TimePickerDialog(HomeFragment.this.getActivity(),R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        if(hourOfDay>=12){
                            amPm=" PM";
                            hourOfDay=hourOfDay-12;
                        }else{
                            amPm=" AM";
                        }
                        ettime2.setText(String.format("%02d:%02d",hourOfDay,minute)+amPm);
                    }
                },currentHour1,currentminute1,false);
                timePickerDialog.show();
            }
        });

       /* btnpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(HomeFragment.this.getActivity())
                    ,PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }


            }
        });*/

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            Place place=Autocomplete.getPlaceFromIntent(data);
            editText.setText(place.getAddress());

            textView1.setText(String.format("Locality Name: %s",place.getName()));



        }else if(requestCode== AutocompleteActivity.RESULT_ERROR){
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(HomeFragment.this.getActivity(),status.getStatusMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void moveToStores(){
        Intent intent=new Intent (this.getActivity(), Stores.class);
        startActivity(intent);

    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==PLACE_PICKER_REQUEST){
            if (resultCode==RESULT_OK){
                Place place= PlacePicker.getPlace(data,HomeFragment.this.getActivity());

                String Location = String.format(String.valueOf(place.getName()));
                String addr=String.format(String.valueOf( place.getAddress()));
                String latitude=String.valueOf(place.getLatLng().longitude);

                location.setText(Location);
                name.setText(addr);
                longitude.setText(latitude);
            }
        }
    }*/
}
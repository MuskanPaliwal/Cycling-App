package com.example.pedla.ui.home;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.example.pedla.AboutApp;
import com.example.pedla.CovidRules;
import com.example.pedla.R;
import com.example.pedla.Signup;
import com.example.pedla.Stores;

import java.util.Calendar;

/*import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pedla.HS;
*/
import com.example.pedla.AboutApp;
import com.example.pedla.BadiLake;
import com.example.pedla.Choice;
import com.example.pedla.CovidRules;

import com.example.pedla.DoodhTalayi;
import com.example.pedla.GovardhanSagar;
import com.example.pedla.Login;
import com.example.pedla.OldCity;
import com.example.pedla.R;
/*import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
*/import com.example.pedla.RaniRoad;
import com.example.pedla.SajjanGarh;
import com.example.pedla.Stores;
import com.google.android.gms.common.api.Status;

/*import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;*/
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
//import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment  {
    TextView profilename;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String Userid;

    private CardView cardView1;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;

    private CardView cardView2;
    private HomeViewModel homeViewModel;
    LinearLayout ml;
    private TextView t1;
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



        img1=root.findViewById(R.id.cimg1);
        img2=root.findViewById(R.id.cimg2);
        img3=root.findViewById(R.id.cimg3);
        img4=root.findViewById(R.id.cimg4);
        img5=root.findViewById(R.id.cimg5);
        img6=root.findViewById(R.id.cimg6);


        ml=root.findViewById(R.id.hsLayout);
        t1=root.findViewById(R.id.tv_1);


        cardView1=root.findViewById(R.id.card11);
        cardView2=root.findViewById(R.id.card22);

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

        profilename=root.findViewById(R.id.tv_2);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        Userid=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference=fStore.collection("Users").document(Userid);

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String name=documentSnapshot.getString("Name");
                    profilename.setText("Hello "+ name);
                }
            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), BadiLake.class);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), RaniRoad.class);
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), DoodhTalayi.class);
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), SajjanGarh.class);
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), GovardhanSagar.class);
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), OldCity.class);
                startActivity(intent);
            }
        });



        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), CovidRules.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this.getActivity(), AboutApp.class);
                startActivity(intent);
            }
        });

        //Places.initialize(HomeFragment.this.getActivity(),"AIzaSyAIrloRRV7osj8QUUa3KfuwzRwzPvVP35A");

        editText.setFocusable(false);

        /*editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Place.Field> fieldList= Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.NAME);
                Intent intent=new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN,
                        fieldList).build(HomeFragment.this.getActivity());

                startActivityForResult(intent,100);
            }
        });*/

*/
        btntostore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (moveToStores()){
                    Intent intent =new Intent(HomeFragment.this.getActivity(),Stores.class);
                    startActivity(intent);
                }
                else{
                    AlertDialog();
                }
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

        LoadSettings();

        return root;

    }
   /* @Override
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
    }*/

    private boolean moveToStores(){
        String dateone, datetwo,timeone,timetwo;
        dateone=etdate.getText().toString().trim();
        datetwo=etdate2.getText().toString().trim();
        timeone=ettime.getText().toString().trim();
        timetwo=ettime2.getText().toString().trim();

        if(dateone.length()==0|| datetwo.length()==0|| timeone.length()==0|| timetwo.length()==0){

            Toast.makeText(HomeFragment.this.getContext(), "Please fill the empty fields", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeFragment.this.getActivity(),R.style.AlertDialogue);
        alertDialogBuilder.setMessage("Please ensure All The Fields Are Correct").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

    private void LoadSettings(){
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(HomeFragment.this.getActivity());
        boolean chk_night=sp.getBoolean("NIGHT",false);
        if(chk_night){
            ml.setBackgroundColor(Color.parseColor("#000000"));
            t1.setTextColor(Color.parseColor("#ffffff"));
            tvtime.setTextColor(Color.parseColor("#ffffff"));
            tvdate.setTextColor(Color.parseColor("#ffffff"));
            textView1.setTextColor(Color.parseColor("#ffffff"));

        }
        else{
            ml.setBackgroundColor(Color.parseColor("#ffffff"));
            t1.setTextColor(Color.parseColor("#000000"));
            tvtime.setTextColor(Color.parseColor("#000000"));
            tvdate.setTextColor(Color.parseColor("#000000"));
            textView1.setTextColor(Color.parseColor("#000000"));
        }


        String orien=sp.getString("ORIENTATION","false");
        if("1".equals(orien)){

            HomeFragment.this.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);

        }
        else if("2".equals(orien)){
            HomeFragment.this.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
        else if("3".equals(orien)){
            HomeFragment.this.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }
    }

    @Override
    public void onResume() {
        LoadSettings();
        super.onResume();
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
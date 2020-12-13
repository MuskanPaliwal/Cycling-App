package com.example.pedla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class bookingadapter extends FirestoreRecyclerAdapter<bookingmodel,bookingadapter.viewholder> {


    public bookingadapter(@NonNull FirestoreRecyclerOptions<bookingmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder viewholder, int i, @NonNull bookingmodel bookingmodel) {
        viewholder.t1.setText("Date of booking: "+bookingmodel.getDate());
        viewholder.t2.setText("Start Time: "+bookingmodel.getTime());
        viewholder.t3.setText("Store: "+bookingmodel.getStore());
        viewholder.t4.setText("Cycle: "+bookingmodel.getCycle());
        viewholder.t5.setText("Accessories: "+bookingmodel.getAccessory());
        viewholder.t6.setText("Total Amount paid: "+bookingmodel.getTotal_Amount());
        viewholder.t7.setText("End Time: "+bookingmodel.getEnd_Time());
        Glide.with(viewholder.bookedcycle.getContext()).load(bookingmodel.getCycle_Image()).into(viewholder.bookedcycle);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.triplerow,parent,false);
        return new bookingadapter.viewholder(view);
    }



    public class viewholder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t5,t6,t7;
        ImageView bookedcycle;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.datebooking);
            t2=itemView.findViewById(R.id.timebooking);
            t3=itemView.findViewById(R.id.storebooking);
            t4=itemView.findViewById(R.id.cyclebooking);
            t5=itemView.findViewById(R.id.accessorybooking);
            t6=itemView.findViewById(R.id.paybooking);
            t7=itemView.findViewById(R.id.endtimebooking);
            bookedcycle=itemView.findViewById(R.id.bookedcycle);

        }
    }
}

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
import com.google.firebase.firestore.DocumentSnapshot;

public class myadapterone extends FirestoreRecyclerAdapter<modelone,myadapterone.viewholder> {


    private myadapterone.OnItemClicked listener;
    public myadapterone(@NonNull FirestoreRecyclerOptions<modelone> options, myadapterone.OnItemClicked listener) {
        super(options);
        this.listener=listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder viewholder, int i, @NonNull modelone modelone) {
        viewholder.namecycle.setText(modelone.getCycle_Name());
        viewholder.amountcycle.setText("Amount per hour: "+modelone.getAmount());
        Glide.with(viewholder.cycleimage.getContext()).load(modelone.getCycle_Image()).into(viewholder.cycleimage);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doublerow,parent,false);
        return new myadapterone.viewholder(view);
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView namecycle, amountcycle;
        ImageView cycleimage;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    listener.onItemGetClick(position,getSnapshots().getSnapshot(position));
                }
            });

            namecycle=(TextView)itemView.findViewById(R.id.namecycle);
            amountcycle=(TextView)itemView.findViewById(R.id.amountcycle);
            cycleimage=(ImageView)itemView.findViewById(R.id.cycleimage);

        }
    }

    public  interface  OnItemClicked {
        void onItemGetClick(int position, DocumentSnapshot documentSnapshot);
    }
}

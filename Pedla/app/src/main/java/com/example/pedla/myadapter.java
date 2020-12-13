package com.example.pedla;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter extends FirestoreRecyclerAdapter<model,myadapter.myviewholder>
{
private OnListItemClicked listener;

    public myadapter(@NonNull FirestoreRecyclerOptions<model> options,OnListItemClicked listener) {
        super(options);
        this.listener=listener;

    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, final int i, @NonNull final model model) {
       // final model temp= options.getSnapshots().get(i);
        holder.name.setText(model.getName());
        holder.course.setText("Available Cycles: "+model.getAvailable_Cycles());
        holder.email.setText(model.getLocation());
        Glide.with(holder.img.getContext()).load(model.getImage()).into(holder.img);

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder{

        TextView name, course, email;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    listener.onItemClick(position,getSnapshots().getSnapshot(position));
                }
            });

            name=(TextView)itemView.findViewById(R.id.nametext);
            course=(TextView)itemView.findViewById(R.id.coursetext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
            img=(ImageView)itemView.findViewById(R.id.storeimage);
        }
    }

    public  interface  OnListItemClicked {
        void onItemClick(int position, DocumentSnapshot documentSnapshot);
    }


}

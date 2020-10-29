package com.example.pedla;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyStoreAdapter extends RecyclerView.Adapter<MyStoreAdapter.ViewHolder> {
    MyStoreData[] myStoreData;
    Context context;

    public MyStoreAdapter(MyStoreData[] myStoreData,Stores activity) {
        this.myStoreData=myStoreData;
        this.context=activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.stores_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MyStoreData myStoreDataList=myStoreData[position];

        holder.storename.setText(myStoreDataList.getStorename());
        holder.availablecycle.setText(myStoreDataList.getAvailablecycle());
        holder.distance.setText(myStoreDataList.getDistance());
        holder.storeimage.setImageResource(myStoreDataList.getStoreimage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Cycles.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return myStoreData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView storeimage;
        TextView storename;
        TextView availablecycle;
        TextView distance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storeimage=itemView.findViewById(R.id.csimage1);
            storename=itemView.findViewById(R.id.csname1);
            availablecycle=itemView.findViewById(R.id.csdesciption1);
            distance=itemView.findViewById(R.id.csdes1);

        }
    }
}

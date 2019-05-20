package com.example.projecthomemaker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.SampleViewHolder> {
    ArrayList<Recipe> entryData;

    public ListAdapter(ArrayList<Recipe> entryData) {
        this.entryData = entryData;
    }

    @NonNull
    @Override
    //create an instance of our viewholder which is our connection to the layout
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new SampleViewHolder(itemView);
    }

    @Override
    //bind an element from our list of data to the provided viewholder
    public void onBindViewHolder(@NonNull SampleViewHolder sampleViewHolder, int i) {
        final Recipe data = entryData.get(i);
        sampleViewHolder.listTitleView.setText(data.getName());
        sampleViewHolder.listRatingView.setText(data.getStarRating());

        //reiterate all this through the object to place your items (image,names,id, etc.)
        sampleViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo start an intent
                Intent sampleIntent = new Intent(v.getContext(),AddRecipeActivity.class);
                sampleIntent.putExtra(RecipeListActivity.TAG, data);
                //..............
                v.getContext().startActivity(sampleIntent);// can also use startActivityForResult(intent,requestCode)
                //^ to start an intent from an onclick from outside of an activity.

            }
        });
    }

    @Override
    //used by the recyclerview to know when to stop
    public int getItemCount() {
        return this.entryData.size();
    }
    //our connection to the views in the layout
    class SampleViewHolder extends RecyclerView.ViewHolder{

        TextView listTitleView, listRatingView;
        View parentView;
        //bind the datamembers of our viewholder to the items in the layout
        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);
            listTitleView = itemView.findViewById(R.id.list_item_title);
            listRatingView = itemView.findViewById(R.id.list_item_rating);
            parentView = itemView.findViewById(R.id.parent_list_layout);
        }
    }
}

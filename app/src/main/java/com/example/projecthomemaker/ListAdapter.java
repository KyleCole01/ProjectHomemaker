package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.SampleViewHolder> {
    ArrayList<Recipe> entryData;
    int lastPosition = -1;

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
    public void onBindViewHolder(@NonNull SampleViewHolder sampleViewHolder, final int i) {
        final Recipe data = entryData.get(i);
        setEnterAnimation(sampleViewHolder.parentView,i);
        sampleViewHolder.listTitleView.setText(data.getName());
        sampleViewHolder.listRatingView.setText(data.getCategory());
        sampleViewHolder.listItemImage.setImageBitmap(loadImageBitmap(sampleViewHolder.parentView.getContext(),(data.getName().replace(" ","_")),".jpg"));
        sampleViewHolder.starRatingView.setText("Stars: " + data.getStarRating());
        sampleViewHolder.costRatingView.setText("Cost: "+ data.getCostRating());
        sampleViewHolder.parentView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                RecipeDbDao.deleteRecipe(data.getName());
                entryData.remove(i);
                notifyDataSetChanged();
                return true;
            }
        });

               //reiterate all this through the object to place your items (image,names,id, etc.)
        sampleViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sampleIntent = new Intent(v.getContext(),AddRecipeActivity.class);
                sampleIntent.putExtra(RecipeListActivity.TAG, data);
                v.getContext().startActivity(sampleIntent);// can also use startActivityForResult(intent,requestCode)
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

        TextView listTitleView, listRatingView, starRatingView,costRatingView;
        View parentView;
        ImageView listItemImage;

        //bind the data members of our viewHolder to the items in the layout
        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);
            listTitleView = itemView.findViewById(R.id.list_item_title);
            listRatingView = itemView.findViewById(R.id.list_item_category);
            listItemImage = itemView.findViewById(R.id.list_item_image);
            parentView = itemView.findViewById(R.id.parent_list_layout);
            starRatingView = itemView.findViewById(R.id.list_item_star);
            costRatingView = itemView.findViewById(R.id.list_item_cost);
        }
    }
    private void setEnterAnimation(View viewToAnimate, int position){
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(),android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
    public Bitmap loadImageBitmap(Context context, String name, String extension){
        name = name + "." + extension;
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try{
            fileInputStream = context.openFileInput(name);
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}

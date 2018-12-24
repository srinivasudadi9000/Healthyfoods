package com.maple.healthyfoods;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>{

    private ArrayList<SingleItemModel> itemModels;
    private Context mContext;
    private int position;

    public SectionListDataAdapter(ArrayList<SingleItemModel> itemModels, Context mContext, int position) {
        this.itemModels = itemModels;
        this.mContext = mContext;
        this.position= position;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v ;
        if (position == 2){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_double_card, null);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card, null);
        }
        SingleItemRowHolder singleItemRowHolder = new SingleItemRowHolder(v);
        return singleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int position) {
        SingleItemModel itemModel = itemModels.get(position);
        holder.tvTitle.setText(itemModel.getName());
       // holder.tv_description.setText(itemModel.getDescription());
      //  holder.rating_tv.setText(itemModel.getRating());
    }

    @Override
    public int getItemCount() {
        return (null != itemModels ? itemModels.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle,tv_description,rating_tv;
        protected ImageView itemImage;

        public SingleItemRowHolder(final View itemView) {
            super(itemView);
           // this.rating_tv= itemView.findViewById(R.id.rating_tv);
          //  this.tv_description = itemView.findViewById(R.id.tv_description);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.itemImage = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}

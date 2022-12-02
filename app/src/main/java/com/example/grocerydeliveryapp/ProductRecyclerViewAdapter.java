package com.example.grocerydeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.RecyclerViewHolder> {


    private Context mContext;
    private ArrayList<Item> itemList;

    public ProductRecyclerViewAdapter(Context context, ArrayList<Item> itemList) {
        mContext = context;
        this.itemList = itemList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(String.valueOf(item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemName;
        private TextView itemPrice;
        private TextView itemWeight;
        private TextView itemWeightDecrement;
        private TextView itemWeightIncrement;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemprice);
            itemWeight = itemView.findViewById(R.id.itemWeight);
            itemWeightDecrement = itemView.findViewById(R.id.itemWeightDecrement);
            itemWeightIncrement = itemView.findViewById(R.id.itemWeightIncrement);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Intent itemDetailsIntent = new Intent(mContext, ItemDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("Item", (Serializable) itemList.get(getAdapterPosition()));
//                itemDetailsIntent.putExtra("Item", bundle);
//                mContext.startActivity(itemDetailsIntent);
                }
            });

            itemWeightIncrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int incrementedWeight = Integer.parseInt(itemWeight.getText().toString()) + 1;
                    itemWeight.setText(Integer.toString(incrementedWeight));
                }
            });

            itemWeightDecrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Integer.parseInt(itemWeight.getText().toString()) > 0) {
                        int decrementedWeight = Integer.parseInt(itemWeight.getText().toString()) - 1;
                        itemWeight.setText(Integer.toString(decrementedWeight));
                    }
                }
            });


        }
    }
}

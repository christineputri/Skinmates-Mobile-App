package com.example.skinmates;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView brand, productName, productRating;
        // jumlah reviews otw

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_pic);
            brand = itemView.findViewById(R.id.product_brand);
            productName = itemView.findViewById(R.id.product_name);
            productRating = itemView.findViewById(R.id.product_rating);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(context).inflate(R.layout.card_product, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(products.get(position).getImageLink()).error(R.drawable.logo_skinmates).into(holder.image);
        holder.brand.setText(products.get(position).getBrand());
        holder.productName.setText(products.get(position).getName());
        holder.productRating.setText(String.valueOf(products.get(position).getRating()));
        // total review
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setFilter(ArrayList<Product> filterModel) {
        products = new ArrayList<>();
        products.addAll(filterModel);
        notifyDataSetChanged();
    }
}

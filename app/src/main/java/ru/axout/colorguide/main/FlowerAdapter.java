package ru.axout.colorguide.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import ru.axout.colorguide.R;
import ru.axout.colorguide.model.Flower;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerHolder> {

    private final Context context;
    private List<Flower> flowers;

    public FlowerAdapter(Context context, List<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
        // Сообщим всем зарегистрированным наблюдателям, что данные изменились.
        // Это необходимо для обновления отображения RecyclerView.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FlowerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_item, parent, false);
        return new FlowerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerHolder holder, int position) {
        Flower item = flowers.get(position);
        holder.flower = item;

        holder.flowerRus.setText(item.getFlower_rus());
        holder.flowerLat.setText(item.getFlower_lat());
        holder.flowerDesc.setText(item.getFlower_desc());

        Picasso.get()
                .load(item.getFlower_img())
                .error(R.drawable.ic_florist)
                .placeholder(R.drawable.ic_florist)
                .fit()
                .into(holder.flowerImg);
    }

    @Override
    public int getItemCount() {
        if (flowers == null) return 0;
        else return flowers.size();
    }

    static class FlowerHolder extends RecyclerView.ViewHolder {

        Flower flower;
        ImageView flowerImg;
        TextView flowerRus, flowerLat, flowerDesc;

        FlowerHolder(@NonNull View itemView) {
            super(itemView);

            flowerImg = itemView.findViewById(R.id.flower_img);
            flowerRus = itemView.findViewById(R.id.flower_rus);
            flowerLat = itemView.findViewById(R.id.flower_lat);
            flowerDesc = itemView.findViewById(R.id.flower_desc);
        }
    }
}

package douglasmoran.com.libraries.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import douglasmoran.com.libraries.Models.Photos;
import douglasmoran.com.libraries.R;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder>{


    Context context;
    ArrayList<Photos> photosArrayList;



    public PhotosAdapter(Context context, ArrayList<Photos> photosArrayList) {
        this.context = context;
        this.photosArrayList = photosArrayList;
    }

    @NonNull
    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_postales,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.ViewHolder viewHolder, int i) {

        final Photos photo = photosArrayList.get(i);

        Glide.with(context)
                .load(photo.getImg1())
                .into(viewHolder.img1);

        Glide.with(context)
                .load(photo.getImg2())
                .into(viewHolder.img2);

        Glide.with(context)
                .load(photo.getImg3())
                .into(viewHolder.img3);

        Glide.with(context)
                .load(photo.getImg4())
                .into(viewHolder.img4);

        Glide.with(context)
                .load(photo.getImg5())
                .into(viewHolder.img5);

        Glide.with(context)
                .load(photo.getImg6())
                .into(viewHolder.img6);

    }

    @Override
    public int getItemCount() {
        return photosArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        CardView cardViewPostaleimg1,cardViewPostaleimg2,cardViewPostaleimg3,cardViewPostaleimg4,cardViewPostaleimg5,cardViewPostaleimg6;
        ImageView img1,img2,img3,img4,img5,img6;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewPostaleimg1 = itemView.findViewById(R.id.cardViewRecyclerPostales);
            cardViewPostaleimg2 = itemView.findViewById(R.id.cardViewRecyclerPostalesimg2);
            cardViewPostaleimg3 = itemView.findViewById(R.id.cardViewRecyclerPostalesimg3);
            cardViewPostaleimg4 = itemView.findViewById(R.id.cardViewRecyclerPostalesimg4);
            cardViewPostaleimg5 = itemView.findViewById(R.id.cardViewRecyclerPostalesimg5);
            cardViewPostaleimg6 = itemView.findViewById(R.id.cardViewRecyclerPostalesimg6);
            img1 = itemView.findViewById(R.id.postalesimg1);
            img2 = itemView.findViewById(R.id.postalesimg2);
            img3 = itemView.findViewById(R.id.postalesimg3);
            img4 = itemView.findViewById(R.id.postalesimg4);
            img5 = itemView.findViewById(R.id.postalesimg5);
            img6 = itemView.findViewById(R.id.postalesimg6);



        }
    }

    public void addData(ArrayList<Photos> phots) {
        photosArrayList = (phots);
        notifyDataSetChanged();
    }
}

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
                .into(viewHolder.postal);



    }

    @Override
    public int getItemCount() {
        return photosArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        CardView cardViewPostale;
        ImageView postal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewPostale = itemView.findViewById(R.id.cardViewRecyclerPostales);
            postal = itemView.findViewById(R.id.postales);



        }
    }

    public void addData(ArrayList<Photos> phots) {
        photosArrayList.addAll(phots);
        notifyDataSetChanged();
    }
}

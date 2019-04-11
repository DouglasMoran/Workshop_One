package douglasmoran.com.libraries.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import douglasmoran.com.libraries.Main2Activity;
import douglasmoran.com.libraries.MapsActivity;
import douglasmoran.com.libraries.Models.Libraries;
import douglasmoran.com.libraries.R;

public class LibrariesAdapter extends RecyclerView.Adapter<LibrariesAdapter.ViewHolder> {

    Context context;
    ArrayList<Libraries> libraries;

    public LibrariesAdapter(Context context, ArrayList<Libraries> libraries) {
        this.context = context;
        this.libraries = libraries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_libraries,viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final  Libraries libraries1 = libraries.get(i);

        viewHolder.countryItem.setText(libraries1.getCountry());
        viewHolder.numberpicItem.setText(libraries1.getNumberpic());

        Glide.with(context)
                .load(libraries1.getImgItem())
                .into(viewHolder.iconItem);

        viewHolder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("detail", libraries1);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return libraries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //RelativeLayout relativeLayoutItem;
        CardView cardViewItem;
        ImageView iconItem;
        TextView countryItem, numberpicItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //relativeLayoutItem = itemView.findViewById(R.id.relativeItems);
            cardViewItem = itemView.findViewById(R.id.cardViewItems);
            cardViewItem.setCardBackgroundColor(Color.WHITE);

            iconItem = itemView.findViewById(R.id.iconItems);
            countryItem = itemView.findViewById(R.id.countryItems);
            numberpicItem = itemView.findViewById(R.id.numberpicItems);
        }
    }
}

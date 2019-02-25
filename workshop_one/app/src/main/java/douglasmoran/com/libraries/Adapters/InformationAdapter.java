package douglasmoran.com.libraries.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import douglasmoran.com.libraries.Models.Information;
import douglasmoran.com.libraries.R;


public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder>  {

    Context context;
    ArrayList<Information> informationArrayList;

    public InformationAdapter(Context context, ArrayList<Information> informationArrayList) {
        this.context = context;
        this.informationArrayList = informationArrayList;
    }

    @NonNull
    @Override
    public InformationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_information,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationAdapter.ViewHolder viewHolder, int i) {

        final  Information info = informationArrayList.get(i);

        viewHolder.textoHistory.setText(info.getTxtHistory());
        viewHolder.historiDescInfo.setText(info.getHistory());
        viewHolder.constInfo.setText(info.getConstruction());
        viewHolder.jwInfo.setText(info.getJewel());
        viewHolder.curiosInfo.setText(info.getCuriosity());
        viewHolder.dsingInfo.setText(info.getDesing());
        viewHolder.addrssInfo.setText(info.getAddress());

    }

    @Override
    public int getItemCount() {
        return informationArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardViewInformation;
        TextView textoHistory, historiDescInfo, constInfo, jwInfo, curiosInfo, dsingInfo, addrssInfo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewInformation = itemView.findViewById(R.id.cardViewInfo);
            textoHistory = itemView.findViewById(R.id.txtHistoryInfo);
            historiDescInfo = itemView.findViewById(R.id.historyDescriptionInfo);
            constInfo = itemView.findViewById(R.id.constructionInfo);
            jwInfo = itemView.findViewById(R.id.jewelInfo);
            curiosInfo =  itemView.findViewById(R.id.curiosityInfo);
            dsingInfo = itemView.findViewById(R.id.desingInfo);
            addrssInfo = itemView.findViewById(R.id.addressInfo);


        }
    }

    public void addData(ArrayList<Information> information) {
        informationArrayList.addAll(information);
        notifyDataSetChanged();
    }

}

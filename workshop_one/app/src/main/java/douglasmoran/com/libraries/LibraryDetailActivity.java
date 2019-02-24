package douglasmoran.com.libraries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import douglasmoran.com.libraries.Models.Libraries;


public class LibraryDetailActivity extends AppCompatActivity {

    CardView cardViewDetail;
    TextView countryDetail, titleDetail, descriptionDetail;
    ImageView iconDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_detail);

        getRss();
        loadContent();

    }

    private void getRss() {

        cardViewDetail = findViewById(R.id.cardViewDetails);
        iconDetail = findViewById(R.id.iconDetails);
        countryDetail = findViewById(R.id.countryDetails);
        titleDetail = findViewById(R.id.titleDetails);
        descriptionDetail = findViewById(R.id.descriptionMainDetails);

    }

    private void loadContent() {
        Intent intent = getIntent();
        Libraries getLibraries = intent.getParcelableExtra("detail");

        Glide.with(this)
                .load(getLibraries.getImgDetail())
                .into(iconDetail);


        countryDetail.setText(getLibraries.getCountry());
        countryDetail.setTextColor(this.getResources().getColor(R.color.colorPrimary));
        titleDetail.setText(getLibraries.getTitle());
        descriptionDetail.setText(getLibraries.getMainDescription());

    }
}

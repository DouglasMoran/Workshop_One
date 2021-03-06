package douglasmoran.com.libraries;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import douglasmoran.com.libraries.Fragments.InformationFragment;
import douglasmoran.com.libraries.Fragments.MapFragment;
import douglasmoran.com.libraries.Fragments.PhotosFragment;
import douglasmoran.com.libraries.Models.Libraries;

public class Main2Activity extends AppCompatActivity implements InformationFragment.OnFragmentInteractionListener, PhotosFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener{

    CardView cardViewDetail;
    TextView countryDetail, titleDetail, descriptionDetail, txtsTimes;
    ImageView iconDetail, times, backBtn;

    static Libraries libraryParam;
    //ImageView swipetabs;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        getRss();
        loadContent();

    }

    private void getRss() {

        cardViewDetail = findViewById(R.id.cardViewDetails);
        iconDetail = findViewById(R.id.iconDetails);
        countryDetail = findViewById(R.id.countryDetails);
        titleDetail = findViewById(R.id.titleDetails);
        descriptionDetail = findViewById(R.id.descriptionMainDetails);
        times = findViewById(R.id.timeCards);
        txtsTimes = findViewById(R.id.textoTime);

    }

    private void loadContent() {
        Intent intent = getIntent();
        libraryParam = intent.getParcelableExtra("detail");


        backBtn = findViewById(R.id.backButtom);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });



        //para mapas
        ImageView mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMaps = new Intent(Main2Activity.this, MapsActivity.class);
                intentMaps.putExtra("detail", libraryParam);
                startActivity(intentMaps);

            }
        });



        Glide.with(this)
                .load(libraryParam.getImgDetail())
                .into(iconDetail);

        Glide.with(this)
                .load(libraryParam.getTime())
                .into(times);


        countryDetail.setText(libraryParam.getCountry());
        //countryDetail.setTextColor(this.getResources().getColor(R.color.colorPrimary));
        titleDetail.setText(libraryParam.getTitle());
        descriptionDetail.setText(libraryParam.getMainDescription());
        txtsTimes.setText(libraryParam.getTxttime());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Fragment newInstance(int sectionNumber) {
            Fragment fragment = null;
            switch (sectionNumber){
                case 1: fragment = new InformationFragment();
                    ((InformationFragment) fragment).elTutoId =  libraryParam.getId();
                    break;
                case 2: fragment = new PhotosFragment();
                    ((PhotosFragment) fragment).elTutoId =  libraryParam.getId();
                    break;
                /*case 3: fragment = new MapFragment();
                    break;*/
            }
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));



            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            //quiete un viewpage ahora solo retorna 2 antes 3
            return 2;
        }
    }
}

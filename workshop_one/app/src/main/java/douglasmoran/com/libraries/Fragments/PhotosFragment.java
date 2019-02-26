package douglasmoran.com.libraries.Fragments;


import android.content.Context;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import douglasmoran.com.libraries.Adapters.PhotosAdapter;
import douglasmoran.com.libraries.Models.Libraries;
import douglasmoran.com.libraries.Models.Photos;
import douglasmoran.com.libraries.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PhotosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PhotosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotosFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public int elTutoId = 0;

    private OnFragmentInteractionListener mListener;


    private String jsonUrl = "https://raw.githubusercontent.com/DouglasMoran/Workshop_One/master/photos.json";
    ArrayList<Photos> photosArrayListBiblioteca;
    RecyclerView recyclerViewPhotos;
    PhotosAdapter photosAdapter;

    //RequestQueue request;



    public PhotosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhotosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotosFragment newInstance(String param1, String param2) {
        PhotosFragment fragment = new PhotosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        loadPhotos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        photosArrayListBiblioteca = new ArrayList<>();

        recyclerViewPhotos = view.findViewById(R.id.recyclerFragmentPhotos);

        recyclerViewPhotos.setHasFixedSize(true);

        recyclerViewPhotos.setLayoutManager(new LinearLayoutManager(getContext()));

        photosArrayListBiblioteca = new ArrayList<>();
        //request = Volley.newRequestQueue(getContext());

        //loadPhotos();

        photosAdapter = new PhotosAdapter(getActivity(),photosArrayListBiblioteca);
        recyclerViewPhotos.setAdapter(photosAdapter);
        photosAdapter.notifyDataSetChanged();

        return view;
    }

    private void loadPhotos() {
        RequestQueue resRequestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest aarRequest = new JsonArrayRequest(jsonUrl, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        //Limpiar la lista
                        photosArrayListBiblioteca.clear();
                        if (jsonArray.length()>0){
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject tmp = null;
                                try {
                                    tmp = jsonArray.getJSONObject(i);
                                    photosAdapter.notifyDataSetChanged();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Gson gson = new Gson();
                                Photos pic = gson.fromJson(tmp.toString(),Photos.class);
                                if(pic.getId()==elTutoId)
                                    photosArrayListBiblioteca.add(pic);

                            }

                            //photosAdapter.addData(photosArrayListBiblioteca);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

        };
        Volley.newRequestQueue(getActivity()).add(aarRequest);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

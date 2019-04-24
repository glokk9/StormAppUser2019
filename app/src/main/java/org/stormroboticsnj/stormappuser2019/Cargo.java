package org.stormroboticsnj.stormappuser2019;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Cargo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Cargo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cargo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Cargo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cargo.
     */
    // TODO: Rename and change types and number of parameters
    public static Cargo newInstance(String param1, String param2) {
        Cargo fragment = new Cargo();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cargo, container, false);
        final Button cargoRocket3Down = view.findViewById(R.id.btnCargoR3D);
        cargoRocket3Down.setTag(11);
        final Button cargoRocket3Up = view.findViewById(R.id.btnCargoR3U);
        cargoRocket3Up.setTag(11);
        final Button cargoRocket2Down = view.findViewById(R.id.btnCargoR2D);
        cargoRocket2Down.setTag(12);
        final Button cargoRocket2Up = view.findViewById(R.id.btnCargoR2U);
        cargoRocket2Up.setTag(12);
        final Button cargoRocket1Down = view.findViewById(R.id.btnCargoR1D);
        cargoRocket1Down.setTag(13);
        final Button cargoRocket1Up = view.findViewById(R.id.btnCargoR1U);
        cargoRocket1Up.setTag(13);
        final Button cargoPlebDown = view.findViewById(R.id.btnCargoPD);
        cargoPlebDown.setTag(14);
        final Button cargoPlebUp = view.findViewById(R.id.btnCargoPU);
        cargoPlebUp.setTag(14);
//        final Button cargoPlayerStationUp = view.findViewById(R.id.btnCargoPSU);
//        cargoPlayerStationUp.setTag(15);
//        final Button cargoPlayerStationDown = view.findViewById(R.id.btnCargoPSD);
//        cargoPlayerStationDown.setTag(15);
//        final Button cargoGroundDown = view.findViewById(R.id.btnCargoGD);
//        cargoGroundDown.setTag(16);
//        final Button cargoGroundUp = view.findViewById(R.id.btnCargoGU);
//        cargoGroundUp.setTag(16);
        // Inflate the layout for this fragment
        return view;

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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

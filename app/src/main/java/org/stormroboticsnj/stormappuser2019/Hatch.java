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
 * {@link Hatch.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Hatch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Hatch extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Hatch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Hatch.
     */
    // TODO: Rename and change types and number of parameters
    public static Hatch newInstance(String param1, String param2) {
        Hatch fragment = new Hatch();
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
        View view = inflater.inflate(R.layout.fragment_hatch, container, false);
        // Inflate the layout for this fragment
        final Button hatchRocket3Down = view.findViewById(R.id.btnHatchR3D);
        hatchRocket3Down.setTag(21);
        final Button hatchRocket3Up = view.findViewById(R.id.btnHatchR3U);
        hatchRocket3Up.setTag(21);
        final Button hatchRocket2Down = view.findViewById(R.id.btnHatchR2D);
        hatchRocket2Down.setTag(22);
        final Button hatchRocket2Up = view.findViewById(R.id.btnHatchR2U);
        hatchRocket2Up.setTag(22);
        final Button hatchRocket1Down = view.findViewById(R.id.btnHatchR1D);
        hatchRocket1Down.setTag(23);
        final Button hatchRocket1Up = view.findViewById(R.id.btnHatchR1U);
        hatchRocket1Up.setTag(23);
        final Button hatchPlebDown = view.findViewById(R.id.btnHatchPD);
        hatchPlebDown.setTag(24);
        final Button hatchPlebUp = view.findViewById(R.id.btnHatchPU);
        hatchPlebUp.setTag(24);
        final Button hatchPlayerStationUp = view.findViewById(R.id.btnHatchPSU);
        hatchPlayerStationUp.setTag(25);
        final Button hatchPlayerStationDown = view.findViewById(R.id.btnHatchPSD);
        hatchPlayerStationDown.setTag(25);
        final Button hatchGroundDown = view.findViewById(R.id.btnHatchGD);
        hatchGroundDown.setTag(26);
        final Button hatchGroundUp = view.findViewById(R.id.btnHatchGU);
        hatchGroundUp.setTag(26);
        return view ;
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

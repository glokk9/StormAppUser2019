package org.stormroboticsnj.stormappuser2019;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RadioGroup;
import org.stormroboticsnj.stormappuser2019.match;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Endgame.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Endgame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Endgame extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static int selfLevel, assistLevel, assistTwoLevel;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Endgame() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Endgame.
     */
    // TODO: Rename and change types and number of parameters
    public static Endgame newInstance(String param1, String param2) {
        Endgame fragment = new Endgame();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_endgame, container, false);
        final RadioGroup selfGroup = view.findViewById(R.id.rdogSelf);
        final RadioGroup assistGroup = view.findViewById(R.id.rdogAssist);
        final RadioGroup assistTwoGroup = view.findViewById(R.id.rdogAssist2);


        selfGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rdoSelf3:
                        selfLevel = 3;
                        break;
                    case R.id.rdoSelf2:
                        selfLevel = 2;
                        break;
                    case R.id.rdoSelf1:
                        selfLevel= 1;
                        break;
                    default:
                        selfLevel= 0;
                }
            }
        });
        assistGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rdoAssist3:
                        assistLevel = 3;
                        break;
                    case R.id.rdoAssist2:
                        assistLevel = 2;
                        break;
                    case R.id.rdoAssist1:
                        assistLevel= 1;
                        break;
                    default:
                        assistLevel= 0;
                }
            }
        });
        assistTwoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rdoAssist23:
                        assistTwoLevel = 3;
                        break;
                    case R.id.rdoAssist22:
                        assistTwoLevel = 2;
                        break;
                    case R.id.rdoAssist21:
                        assistTwoLevel= 1;
                        break;
                    default:
                        assistTwoLevel= 0;
                }
            }
        });

        return view;

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
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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

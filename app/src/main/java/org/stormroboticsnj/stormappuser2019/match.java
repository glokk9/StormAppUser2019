package org.stormroboticsnj.stormappuser2019;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
import android.net.Uri;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import org.w3c.dom.Text;


public class match extends AppCompatActivity implements autonomous.OnFragmentInteractionListener, Hatch.OnFragmentInteractionListener,
        Cargo.OnFragmentInteractionListener, Endgame.OnFragmentInteractionListener{

    public static int cargoR3, cargoR2, cargoR1, cargoShip, cargoP, cargoG, autoCargo;
    public static int hatchR3, hatchR2, hatchR1, hatchShip, hatchP, hatchG, autoHatches;
    private TextView t;
    DeepSpace  deepSpace;
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
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
        setContentView(R.layout.activity_match);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
        deepSpace = new DeepSpace();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }
//    //Called by counter increment buttons
    public void incrementCounter(View view){
        if (view == null) {
            System.out.println("view is NULL");
        }
        if (view.getTag() == null) {
            System.out.println("GetTag is NULL");
        }
        int tag = Integer.parseInt(view.getTag().toString());
        this.incrementCounter(tag);
    }
//
//
//    // Called by counter increment function with tag, increment correct counter if less than max.
    public void incrementCounter(int fieldID) {
        // First digit: 1 = cargo, 2 = hatch, 3 = auto
        // Second digit: row number, top=1 to bottom of respective fragment
        switch (fieldID) {
            case 11:
                if (cargoR3 < 4) {
                    ++cargoR3;
                    t = (TextView) findViewById(R.id.txtCargoR3);
                    t.setText(Integer.toString(cargoR3));
                }
                break;
            case 12:
                if (cargoR2 < 4) {
                    ++cargoR2;
                    t = (TextView) findViewById(R.id.txtCargoR2);
                    t.setText(Integer.toString(cargoR2));
                }
                break;
            case 13:
                if (cargoR1 < 4) {
                    ++cargoR1;
                    t = (TextView) findViewById(R.id.txtCargoR1);
                    t.setText(Integer.toString(cargoR1));
                }
                break;
            case 14:
                if (cargoShip < 8) {
                    ++cargoShip;
                    t = (TextView) findViewById(R.id.txtCargoP);
                    t.setText(Integer.toString(cargoShip));
                }
                break;
            case 15:
                if (cargoP < 32) {
                    ++cargoP;
                    //t = (TextView) findViewById(R.id.txtCargoPS);
                    t.setText(Integer.toString(cargoP));
                }
                break;
            case 16:
                if (cargoG < 32){
                    ++cargoG;
                    //t = (TextView) findViewById(R.id.txtCargoG);
                    t.setText(Integer.toString(cargoG));
                }
                break;
            case 21:
                if (hatchR3 < 4) {
                    ++hatchR3;
                    t = (TextView) findViewById(R.id.txtHatchR3);
                    t.setText(Integer.toString(hatchR3));
                }
                break;
            case 22:
                if (hatchR2 < 4) {
                    ++hatchR2;
                    t = (TextView) findViewById(R.id.txtHatchR2);
                    t.setText(Integer.toString(hatchR2));
                }
                break;
            case 23:
                if (hatchR1 < 4) {
                    ++hatchR1;
                    t = (TextView) findViewById(R.id.txtHatchR1);
                    t.setText(Integer.toString(hatchR1));
                }
                break;
            case 24:
                if (hatchShip < 8) {
                    ++hatchShip;
                    t = (TextView) findViewById(R.id.txtHatchP);
                    t.setText(Integer.toString(hatchShip));
                }
                break;
            case 25:
                if (hatchP < 32) {
                    ++hatchP;
                    //t = (TextView) findViewById(R.id.txtHatchPS);
                    t.setText(Integer.toString(hatchP));
                }
                break;
            case 26:
                if (hatchG < 32) {
                    ++hatchG;
                    //t = (TextView) findViewById(R.id.txtHatchG);
                    t.setText(Integer.toString(hatchG));
                }
                break;
            case 31:
                if (autoHatches < 32) {
                    ++autoHatches;
                    t = (TextView) findViewById(R.id.txtHatchNum);
                    t.setText(Integer.toString(autoHatches));
                }
                break;
            case 32:
                if (autoCargo < 32) {
                    ++autoCargo;
                    t = (TextView) findViewById(R.id.txtCargoNum);
                    t.setText(Integer.toString(autoCargo));
                }
        }
    }
//
//    //Called by counter decrement buttons
    public void decrementCounter(View v){
        int tag = Integer.parseInt(v.getTag().toString());
        this.decrementCounter(tag);
    }
//
//    //Called by counter decrement function with tag, decrement correct counter if greater than 0.
    public void decrementCounter(int fieldID) {
        switch (fieldID) {
            case 11:
                if (cargoR3 > 0) {
                    --cargoR3;
                    t = (TextView) findViewById(R.id.txtCargoR3);
                    t.setText(Integer.toString(cargoR3));
                }
                break;
            case 12:
                if (cargoR2 > 0) {
                    --cargoR2;
                    t = (TextView) findViewById(R.id.txtCargoR2);
                    t.setText(Integer.toString(cargoR2));
                }
                break;
            case 13:
                if (cargoR1 > 0) {
                    --cargoR1;
                    t = (TextView) findViewById(R.id.txtCargoR1);
                    t.setText(Integer.toString(cargoR1));
                }
                break;
            case 14:
                if (cargoShip > 0) {
                    --cargoShip;
                    t = (TextView) findViewById(R.id.txtCargoP);
                    t.setText(Integer.toString(cargoShip));
                }
                break;
            case 15:
                if (cargoP > 0) {
                    --cargoP;
                    //t = (TextView) findViewById(R.id.txtCargoPS);
                    t.setText(Integer.toString(cargoP));
                }
                break;
            case 16:
                if (cargoG > 0) {
                    --cargoG;
                    //t = (TextView) findViewById(R.id.txtCargoG);
                    t.setText(Integer.toString(cargoG));
                }
                break;
            case 21:
                if (hatchR3 > 0) {
                    --hatchR3;
                    t = (TextView) findViewById(R.id.txtHatchR3);
                    t.setText(Integer.toString(hatchR3));
                }
                break;
            case 22:
                if (hatchR2 > 0) {
                    --hatchR2;
                    t = (TextView) findViewById(R.id.txtHatchR2);
                    t.setText(Integer.toString(hatchR2));
                }
                break;
            case 23:
                if (hatchR1 > 0) {
                    --hatchR1;
                    t = (TextView) findViewById(R.id.txtHatchR1);
                    t.setText(Integer.toString(hatchR1));
                }
                break;
            case 24:
                if (hatchShip > 0) {
                    --hatchShip;
                    t = (TextView) findViewById(R.id.txtHatchP);
                    t.setText(Integer.toString(hatchShip));
                }
                break;
            case 25:
                if (hatchP > 0) {
                    --hatchP;
                    //t = (TextView) findViewById(R.id.txtHatchPS);
                    t.setText(Integer.toString(hatchP));
                }
                break;
            case 26:
                if (hatchG > 0) {
                    --hatchG;
                    //t = (TextView) findViewById(R.id.txtHatchG);
                    t.setText(Integer.toString(hatchG));
                }
                break;
            case 31:
                if (autoHatches > 0) {
                    --autoHatches;
                    t = (TextView) findViewById(R.id.txtHatchNum);
                    t.setText(Integer.toString(autoHatches));
                }
                break;
            case 32:
                if (autoCargo > 0) {
                    --autoCargo;
                    t = (TextView) findViewById(R.id.txtCargoNum);
                    t.setText(Integer.toString(autoCargo));
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_match, menu);
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
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_match, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
    public void resetVariables(){
        cargoR3 = 0;
        cargoR2 = 0;
        cargoR1 = 0;
        cargoP = 0;
        cargoG = 0;
        cargoShip = 0;
        autoCargo = 0;
        hatchR3 = 0;
        hatchR2 = 0;
        hatchR1 = 0;
        hatchP = 0;
        hatchG = 0;
        hatchShip = 0;
        autoHatches = 0;

        Endgame.selfLevel = 0;
        Endgame.assistLevel = 0;
        Endgame.assistTwoLevel = 0;
        //Endgame.specialCases = 0;

    }
    public DeepSpace dataify(View v){
        DeepSpace deepSpace = new DeepSpace();
        //deepSpace.setTeamNum(MainActivity.teamNum);
        //deepSpace.setMatchNum(MainActivity.matchNum);
        //deepSpace.setAlliance(MainActivity.allianceColor == "red" ? 0 : 1); // 0 = red; 1 = blue
        int checkedID;

        RadioGroup selfGroup = findViewById(R.id.rdogSelf);
        RadioGroup assistGroup = findViewById(R.id.rdogAssist);
        RadioGroup assistTwoGroup = findViewById(R.id.rdogAssist2);
        RadioGroup startPosGroup = autonomous.startPosGroup;
        CheckBox passLineBox = autonomous.passAutoLineBox;

        checkedID = selfGroup.getCheckedRadioButtonId();
        switch(checkedID) {
            case R.id.rdoSelf1:
                deepSpace.setSelfLevel(1);
                break;
            case R.id.rdoSelf2:
                deepSpace.setSelfLevel(2);
                break;
            case R.id.rdoSelf3:
                deepSpace.setSelfLevel(3);
                break;
            default:
                deepSpace.setSelfLevel(0);
        }
        checkedID = assistGroup.getCheckedRadioButtonId();
        switch(checkedID) {
            case R.id.rdoAssist1:
                deepSpace.setAssistLevel(1);
                break;
            case R.id.rdoAssist2:
                deepSpace.setAssistLevel(2);
                break;
            case R.id.rdoAssist3:
                deepSpace.setAssistLevel(3);
                break;
            default:
                deepSpace.setAssistLevel(0);

        }
        checkedID = assistTwoGroup.getCheckedRadioButtonId();
        switch(checkedID) {
            case R.id.rdoAssist21:
                deepSpace.setAssistTwoLevel(1);
                break;
            case R.id.rdoAssist22:
                deepSpace.setAssistTwoLevel(2);
                break;
            case R.id.rdoAssist23:
                deepSpace.setAssistTwoLevel(3);
                break;
            default:
                deepSpace.setAssistTwoLevel(0);
        }
        checkedID = startPosGroup.getCheckedRadioButtonId();
        switch(checkedID) {
            case R.id.rdoLVL1:
                deepSpace.setStartingPosition(1);
                break;
            case R.id.rdoLVL2:
                deepSpace.setStartingPosition(2);
                break;
        }
        deepSpace.setAutoHatches(autoHatches);
        deepSpace.setAutoCargo(autoCargo);
        deepSpace.setCargoRT(cargoR3);
        deepSpace.setCargoRD(cargoR2);
        deepSpace.setCargoRU(cargoR1);
        deepSpace.setCargoShip(cargoShip);
        deepSpace.setCargoPlayer(cargoP);
        deepSpace.setCargoGround(cargoG);
        deepSpace.setHatchRT(hatchR3);
        deepSpace.setHatchRD(hatchR2);
        deepSpace.setHatchRU(hatchR1);
        deepSpace.setHatchShip(hatchShip);
        deepSpace.setHatchPlayer(hatchP);
        deepSpace.setHatchGround(hatchG);
        deepSpace.setPassAutoLine(passLineBox.isChecked() ? 1 : 0);
        return deepSpace;
    }
    public void submit(View v){
        final View vTwo = v;
        String errString = ""; //Build a string of the possible problems in the data to warn the user.
        /*if (anything is unmodified){
            errString = " You may have forgotten to enter data into the following fields:";
            String errSubString = "";
            //build errsubstring by adding all of the unmodified thingies
            errString += errSubString;
         }
//        */
        new AlertDialog.Builder(this)
                .setTitle("Save Data and Return to Main Screen")
                .setMessage("Are you sure that you wish to submit data? Check to make sure you filled out all fields") //Warn the user before submitting.
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deepSpace = dataify(vTwo);
                        System.out.println("Deep Space: " + deepSpace);
                        org.stormroboticsnj.stormappuser2019.Handler.getInstance(getApplicationContext()).addAllData(deepSpace);

                        //Prepare to return to the main menu
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

//                        MainActivity.QRready = true; //Notify the main activity that a QR code can be generated.

                        resetVariables(); //Reset all variables to default, clear all temporary data
                        //MainActivity.clearTempData();

                        startActivity(intent); //Return to main menu
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Do nothing
                    }
                })
                .show();

    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private String[] tabTitles = new String[]{"Sandstorm", "Cargo", "Hatch", getString(R.string.tminus30)};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return autonomous.newInstance("sdf","sdf");
                case 1:
                    return Cargo.newInstance("sdf","sdf");
                case 2:
                    return Hatch.newInstance("sdf","sdf");
                case 3:
                    return Endgame.newInstance("df", "lolzies");
                default:
                    return null; // shouldn't happen
            }
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

    }
}
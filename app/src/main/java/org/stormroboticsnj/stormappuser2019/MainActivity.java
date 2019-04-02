package org.stormroboticsnj.stormappuser2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//import com.bumptech.glide.Glide; - supports image loading like QRs
//import com.opencsv.CSVWriter; THESE IMPORT STATEMENTS DON'T WORK
//import org.greenrobot.eventbus.EventBus;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static boolean QRready = false;
    public static int teamNum;
    public static int matchNum;
    public static String allianceColor; //default radio is red


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup redBlueGroup = findViewById(R.id.redBlueGroup);
        final Button start = findViewById(R.id.btnStart);
        final TextView teamView = findViewById(R.id.txtTeamNum);
        final TextView matchView = findViewById(R.id.txtMatchNum);
        final Button deleteLast = findViewById(R.id.button8);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                allianceColor = redBlueGroup.getCheckedRadioButtonId() == R.id.red ? "red" : "blue";
                String insertErrString = "";
                if (teamView.getText().toString().matches("")) insertErrString += "team number";
                if (matchView.getText().toString().matches("") && !insertErrString.matches("")) insertErrString += ", match number";
                else if (matchView.getText().toString().matches("")) insertErrString += "match number";
                if (teamView.getText().toString().length() > 5) insertErrString +="\t Team Num too long";
                if (matchView.getText().toString().length() > 4) insertErrString += "\t Match Num too long";

                if (!insertErrString.matches("")) { //If something is missing, display error to user.
                    Toast.makeText(getApplicationContext(), "Missing data: " + insertErrString, Toast.LENGTH_SHORT).show();
                } else {
                    //TeamNumbers tn = new TeamNumbers(this);
                    //if (tn.isATeamNumber(Integer.parseInt(team.getText().toString()))) { //Check if team number exists
                        //Warn the user if there is already a database entry.
                        //if (QRGenReady) Toast.makeText(getApplicationContext(), "There is already an entry in the database. Adding too many entries can cause generated QR codes to become too large to scan!", Toast.LENGTH_SHORT).show();
                        //Prepare to enter the match
                        //PowerUp power = new PowerUp(Integer.parseInt(team.getText().toString()), Integer.parseInt(match.getText().toString()), red.isChecked() ? 1 : 0);
                        //System.out.println("Power: " + power);
                        //EventBus.getDefault().postSticky(power);
                    teamNum =  Integer.parseInt(teamView.getText().toString());
                    matchNum = Integer.parseInt(matchView.getText().toString());
                        switchTo(match.class); //Enter the match
                    //} else {
                    //    Toast.makeText(getApplicationContext(), "Please input a valid team number", Toast.LENGTH_SHORT).show();
                    //}
                }
            }
        });
    }
    public void switchTo(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
    public static void clearTempData(){ //Clears temp data for new entry
        teamNum = 0;
        matchNum = 0;
        allianceColor = "";
    }
    public void genQR(View v){
        if (QRready) { //Check if the a QR is ready to be generated
            List<DeepSpace> teams = Handler.getInstance(this).getAllTeams();
            String content = "@stormscouting"; //Append a string that the master app requires in all QR codes.
            for (DeepSpace steam : teams) {
                content += steam.toString(); //Add data to string
            }
            System.out.println("Content: " + content);
            EventBus.getDefault().postSticky(content);
            Intent qr = new Intent(this, QR.class);
            startActivity(qr); //Start QR generation activity
        } else {
            Toast.makeText(getApplicationContext(), "A QR code cannot be generated until data is input", Toast.LENGTH_SHORT).show();
        }
    }
    public void delete(View v){
        if(Handler.getInstance(this).getDBSize() > 0) {
            final List<DeepSpace> teams = Handler.getInstance(getApplicationContext()).getAllTeams();
            final ArrayList<CheckBox> teamsChk = new ArrayList<>();
            ScrollView scroll = new ScrollView(this);
            LinearLayout checkLayout = new LinearLayout(getApplicationContext());
            checkLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            scroll.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            checkLayout.setOrientation(LinearLayout.VERTICAL);
            for (int i = 0; i < teams.size(); ++i) {
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(String.valueOf(teams.get(i).getTeamNum()));
                checkBox.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
                //checkBox.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.mchk));
                teamsChk.add(checkBox);
            }
            for (int j = 0; j < teamsChk.size(); ++j) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.leftMargin = 25;
                params.topMargin = 25;
                checkLayout.addView(teamsChk.get(j), params);
            }
            scroll.addView(checkLayout);
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Delete specific Teams")
                    .setView(scroll)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            for (int k = 0; k < teamsChk.size(); ++k) {
                                if (teamsChk.get(k).isChecked())
                                    Handler.getInstance(getApplicationContext()).deleteFromDB(teams.get(k));
                            }
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            AppCompatDialog dialog = builder.create();
            dialog.show();
        }
    }
    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
//        // save the note's current draft, because the activity is stopping
//        // and we want to be sure the current note progress isn't lost.
//        ContentValues values = new ContentValues();
//        values.put(NotePad.Notes.COLUMN_NAME_NOTE, getCurrentNoteText());
//        values.put(NotePad.Notes.COLUMN_NAME_TITLE, getCurrentNoteTitle());
//
//        // do this update in background on an AsyncQueryHandler or equivalent
//        mAsyncQueryHandler.startUpdate (
//                mToken,  // int token to correlate calls
//                null,    // cookie, not used here
//                mUri,    // The URI for the note to update.
//                values,  // The map of column names and new values to apply to them.
//                null,    // No SELECT criteria are used.
//                null     // No WHERE columns are used.
//        );
        // TODO***** Save data when user app is closed*****
    }
    //final RadioGroup redBlueGroup(RadioGroup) findViewById(R.id.redBlueGroup);
    //redBlueGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()

}

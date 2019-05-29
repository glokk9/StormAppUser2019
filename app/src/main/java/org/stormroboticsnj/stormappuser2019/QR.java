package org.stormroboticsnj.stormappuser2019;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import net.glxn.qrgen.android.QRCode;
import java.io.ByteArrayOutputStream;
import org.greenrobot.eventbus.EventBus;
import org.stormroboticsnj.stormappuser2019.Handler;

/**
 * <p>Generates QR Code.  Copy and paste each year as there usually is no change</p>
 */
public class QR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        //Gets string
        String output = EventBus.getDefault().removeStickyEvent(String.class);
        //Assets for qr code
        Display disp = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        ByteArrayOutputStream code = QRCode.from(output).withSize(size.x-10,size.x-10).stream();
        byte[] byteArray = code.toByteArray();
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView myImage = (ImageView) findViewById(R.id.imgQR);

        myImage.setMinimumHeight(size.y-10);
        myImage.setMinimumWidth(size.x-10);
        myImage.setMaxHeight(size.y-10);
        myImage.setMaxWidth(size.x-10);
        myImage.setImageBitmap(bmp);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView t2 = (TextView) findViewById(R.id.privacy);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        final Button backbtn = findViewById(R.id.btnBack);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo(MainActivity.class);
            }
        });
    }
    private void switchTo(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent); //Start QR generation activity
    }

    /**
     * Action to return to main page and delete database
     * @param v - View to pass to method
     */
    public void deleteAndExit(View v){
        new AlertDialog.Builder(this) //confirm with user
                .setTitle("Return to Main screen")
                .setMessage("Are you sure? Doing this will delete the current database table, which cannot be undone")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Handler.getInstance(getApplicationContext()).clearTable(); //clear database table
                        Toast.makeText(getApplicationContext(), "Database cleared", Toast.LENGTH_SHORT).show();
                        //MainActivity.QRready = false; //Nofity main menu that a QR code is not ready to be generated
                        Intent back = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(back); //return to main menu
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                })
                .setIcon(R.mipmap.ic_launcher)
                .show();
    }
}

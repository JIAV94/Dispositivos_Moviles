package mx.tec.lab3;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = getApplicationContext();

        final Toast MyToast = new Toast(context);

        AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);
        DialogConf.setTitle("Nionic");
        DialogConf.setMessage("Escribe algo Meco!");

        final EditText txtmsg = new EditText(context);
        DialogConf.setView(txtmsg);

        DialogConf.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = txtmsg.getText().toString();
                        if (msg.isEmpty()) {
                            MyToast.makeText(context, "No escribiste nada.", MyToast.LENGTH_LONG).show();
                        }
                        else{
                            MyToast.makeText(context, "Escribiste " + msg, MyToast.LENGTH_LONG).show();
                        }
                    }
                });
        DialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyToast.makeText(context, "Esta es una tostadita.", MyToast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyDialog = DialogConf.create();
        MyDialog.show();


        // Notifications
        AlertDialog.Builder ThirdDialogConf = new AlertDialog.Builder(this);

        ThirdDialogConf.setTitle("Confirmation Dialog");
        ThirdDialogConf.setMessage("This is the Text of the Dialog");
        ThirdDialogConf.setIcon(R.mipmap.ic_launcher);

        final EditText TextInput = new EditText(context);
        TextInput.setTextColor(Color.BLUE);
        ThirdDialogConf.setView(TextInput);


        ThirdDialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String str = TextInput.getEditableText().toString();
                        Toast.makeText(context, "You wrote this in the dialog: " + str, Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyThirdDialog = ThirdDialogConf.create();
        MyThirdDialog.show();


        /*Step 5: Bar Notification ---------------------------------------------------------------*/

        int NOTIF_ID = 1234;
        Notification.Builder NotifBuilder = new Notification.Builder(this);
        NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotifBuilder.setContentTitle("Important Notification");
        NotifBuilder.setContentText("This is the detail of the notification");

        Intent notificationIntent = new Intent(context, ChildActivity.class);
        notificationIntent.putExtra("myData", "This string comes from the previous activity");
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        NotifBuilder.setContentIntent(contentIntent);

        NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        MyNotification.notify(NOTIF_ID, NotifBuilder.build());
    }
}
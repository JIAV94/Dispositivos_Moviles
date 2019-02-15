package mx.tec.lab3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    }
}
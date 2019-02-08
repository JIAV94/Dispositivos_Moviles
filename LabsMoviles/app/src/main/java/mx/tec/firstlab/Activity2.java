package mx.tec.firstlab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Bundle message = getIntent().getExtras();
        String msg = message.getString( "mensaje");

        TextView new_text = (TextView) findViewById(R.id.inputText);
        new_text.setText(msg);

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    public void openMainActivity() {
        finish();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }
}

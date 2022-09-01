package br.com.up.whatsappsemcontato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutName;
    private TextInputEditText inputEditTextName;
    private TextInputLayout inputLayoutNumber;
    private TextInputEditText inputEditTextNumber;
    private Button buttonSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutName = findViewById(R.id.input_layout_name);
        inputEditTextName = findViewById(R.id.input_text_name);
        inputLayoutNumber = findViewById(R.id.input_layout_number);
        inputEditTextNumber = findViewById(R.id.input_text_number);
        buttonSendMessage = findViewById(R.id.button_Add_message);

        buttonSendMessage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openWebPage();
                    }
                });

    }



    public void openWebPage() {

        String number = inputEditTextNumber.getText().toString();
        String message = inputEditTextName.getText().toString();

        Uri webpage = Uri.parse("https://wa.me/"+number+"?text="+message);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}

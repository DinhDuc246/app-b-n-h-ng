package com.example.hyhy.EmailLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.hyhy.HomeActivity;
import com.example.hyhy.MainActivity;
import com.example.hyhy.OpenrationRetrofitApi.ApiClient;
import com.example.hyhy.OpenrationRetrofitApi.Api_Interface;
import com.example.hyhy.OpenrationRetrofitApi.Users;
import com.example.hyhy.R;
import com.example.hyhy.Sessions.SessionManager;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailRegisterActivity extends AppCompatActivity {
    EditText register_name,register_email,register_password ;
    Button btn_continue;

    SessionManager sessionManager;
    String user_id;

    public static Api_Interface api_interface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        /////////////status bar hide start ///////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /////////////status bar hide end ///////////////

        api_interface = ApiClient.getApiClient().create(Api_Interface.class);

        sessionManager = new SessionManager(this);

        init();
    }

    private void init() {
        register_name = findViewById(R.id.register_name);
        register_email = findViewById(R.id.register_email);
        register_password = findViewById(R.id.register_password);
        btn_continue = findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registration();
            }
        });
    }

    private void Registration() {
        String user_name = register_name.getText().toString().trim();
        String user_email = register_email.getText().toString().trim();
        String user_password = register_password.getText().toString().trim();

        if(TextUtils.isEmpty(user_name)){
            register_name.setError("Username is required!");
            return;
        }else if (TextUtils.isEmpty(user_email)){
            register_email.setError("UserEmail is required!");
            return;
        }else if (TextUtils.isEmpty(user_password)){
            register_password.setError("password is required!");
            return;
        }
        Log.d("TEST", "Test");
//            ProgressDialog dialog = new ProgressDialog(this);
//            dialog.setTitle("Registering...");
//            dialog.setMessage("Please wait while we are checking your credentials");
//            dialog.show();
//            dialog.setCanceledOnTouchOutside(false);
        Api_Interface client = ApiClient.getApiClient().create(Api_Interface.class);
        Call<ResponseBody> call = client.performEmailRegistration(user_name,user_email,user_password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Log.e("TEST", "Test");
//                    user_id = response.body().getUserId();
//                    sessionManager.createSession(user_id);
                    Intent intent = new Intent(EmailRegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    Animatoo.animateSwipeLeft(EmailRegisterActivity.this);
//                    Toast.makeText(getApplicationContext(), "dmmmm",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "error",Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });

    }

    public void goToLogin(View view) {
        Intent intent = new Intent(EmailRegisterActivity.this,EmailLoginActivity.class);
        startActivity(intent);
        Animatoo.animateSlideLeft(this);
        finish();
    }

    public void backToMainPage(View view) {
        Intent intent = new Intent(EmailRegisterActivity.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(this);
        finish();
    }
}
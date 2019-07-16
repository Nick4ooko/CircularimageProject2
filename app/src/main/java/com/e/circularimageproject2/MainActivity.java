package com.e.circularimageproject2;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    private ImageView profile;
    private Button btchooseimage;
    private static final int PICK_IMAGE_REQUEST =1;
    private Uri nimageUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >22){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
        }



        profile =(ImageView) findViewById(R.id.iv_profile_id);
        btchooseimage =(Button) findViewById(R.id.bt_chooseimage_id);

        btchooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btchooseimage();

            }
        });
    }

    private void btchooseimage() {

        Intent intentImage = new Intent();
        intentImage.setType("image/*");

        intentImage.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intentImage,PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData()!= null){
            nimageUri = data.getData();
            profile.setImageURI(nimageUri);

        }
    }
}

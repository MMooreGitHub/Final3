package com.example.android.afinal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class GetReportActivity extends AppCompatActivity {

    private ImageView picture;
    private EditText code;
    String codePicture="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_report);
        setTitle("Get Report");
        picture = (ImageView) findViewById(R.id.report_image);
        code = (EditText) findViewById(R.id.report_code);

    }


    public void readFromFirebase(View view) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        codePicture = code.getText().toString();
        codePicture = codePicture+".png";
        StorageReference imageRef = storage.getReference().child(codePicture);
        imageRef.getBytes(5*1024*1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                picture.setImageBitmap(bitmap);
            }
        });
    }

}


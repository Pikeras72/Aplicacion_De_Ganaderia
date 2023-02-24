package com.example.info_ganaderia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class LibrosActivity extends AppCompatActivity {

    private ListView libros;
    private ArrayList<String> arrayLibros;

    private StorageReference mstorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        libros = findViewById(R.id.ListViewLibros);
        arrayLibros = new ArrayList<>();
        mstorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference pathReference = mstorageRef.child("Libros");
        pathReference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()){
                    arrayLibros.add(item.getName()+"");
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayLibros);
                libros.setAdapter(arrayAdapter);
            }
        }).addOnFailureListener((e)->{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(LibrosActivity.this);
            builder1.setMessage("Ha ocurrido un error, comprueba tu conexión a internet");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "OK",
                    (dialog,id)->{dialog.cancel();});
            AlertDialog alertDialog = builder1.create();
            alertDialog.show();
        });
    }


}
package com.example.or3a.Or3a;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.or3a.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomDialog extends AppCompatDialogFragment {

    EditText editNum ;

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout , null);

        final AlertDialog builder = new AlertDialog.Builder(getActivity())
                .setTitle("مطلوب كام اسم")
                .setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK" , null).show();


        editNum = view.findViewById(R.id.editNumName);


        Button positiveButton = builder.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numName = Integer.parseInt(editNum.getText().toString());


                if(NameOr3q.nameOr3a.size() <= numName){
                    Toast.makeText(getActivity(), "You Can't Add Numper More Than Names", Toast.LENGTH_LONG).show();
                }else{

                    List<String> list = NameOr3q.nameOr3a ;
                    List<String>  randNum = new ArrayList<>();


                    int countRandom = Integer.parseInt(String.valueOf(editNum.getText()));

                    Random rand = new Random();

                    for (int i = 0; i < countRandom; i++) {
                        int randomIndex = rand.nextInt(list.size());
                        String randomElement = list.get(randomIndex);
                        list.remove(randomIndex);
                        randNum.add(randomElement);
                    }

                    Intent goToShowName = new Intent(getActivity(), ShowName.class);
                    goToShowName.putStringArrayListExtra("list" , (ArrayList<String>) randNum);
                    startActivity(goToShowName);
                }

            }
        });

        return builder ;

    }
}

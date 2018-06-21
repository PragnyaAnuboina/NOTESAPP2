package com.cs17b004.notesapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Shownote extends DialogFragment {
      note y;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
        LayoutInflater z=getActivity().getLayoutInflater();
        View dialog=z.inflate(R.layout.activity_shownote,null);
        b.setView(dialog);
        final TextView title=(TextView)dialog.findViewById(R.id.textView);
        final TextView description=(TextView)dialog.findViewById(R.id.textView2);
        ImageView favorite=(ImageView)dialog.findViewById(R.id.imageView);
        ImageView todo=(ImageView)dialog.findViewById(R.id.imageView2);
        ImageView done=(ImageView)dialog.findViewById(R.id.imageView3);
        ImageView budget=(ImageView)dialog.findViewById(R.id.imageView4);
        //Button edit=(Button)dialog.findViewById(R.id.button2);
        Button ok=(Button)dialog.findViewById(R.id.button);
        title.setText(y.getTitle());
        description.setText(y.getDescription());
        if(!y.isFavorite())
            favorite.setVisibility(View.INVISIBLE);
        if(!y.isTodo())
            todo.setVisibility(View.INVISIBLE);
        if(!y.isDone())
            done.setVisibility(View.INVISIBLE);
        if(!y.isBudget())
            budget.setVisibility(View.INVISIBLE);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        /*edit.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                //AlertDialog.Builder b1=new AlertDialog.Builder(getActivity());
                LayoutInflater z=getActivity().getLayoutInflater();
                View dialog2=z.inflate(R.layout.activity_newnote,null);
                Newnote n=new Newnote();
                n.show(getFragmentManager(),"123");
                final EditText title2 = (EditText) dialog2.findViewById(R.id.editText);
                final EditText description2 = (EditText) dialog2.findViewById(R.id.editText2);
                final CheckBox favorite2 = (CheckBox) dialog2.findViewById(R.id.checkBox);
                final CheckBox done2 = (CheckBox) dialog2.findViewById(R.id.checkBox2);
                final CheckBox todo2 = (CheckBox) dialog2.findViewById(R.id.checkBox3);
                final CheckBox budget2 = (CheckBox) dialog2.findViewById(R.id.checkBox4);
                Button ok2 = (Button) dialog2.findViewById(R.id.button);
                Button cancel2 = (Button) dialog2.findViewById(R.id.button2);
                title2.setText(title.getText().toString());
                description2.setText(description.getText().toString());
                favorite2.setChecked(y.isFavorite());
                done2.setChecked(y.isDone());
                todo2.setChecked(y.isTodo());
                budget2.setChecked(y.isBudget());
                cancel2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                ok2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        y.setTitle(title2.getText().toString());
                        y.setDescription(description2.getText().toString());
                        y.setFavorite(favorite2.isChecked());
                        y.setDone(done2.isChecked());
                        y.setTodo(todo2.isChecked());
                        y.setBudget(budget2.isChecked());
                        MainActivity ac=(MainActivity)getActivity();
                        ac.editnote(y);
                        dismiss();
                    }
                });

            }
        });*/
        return b.create();

    }
    public void sendnote(note x){
        y=x;
    }
}

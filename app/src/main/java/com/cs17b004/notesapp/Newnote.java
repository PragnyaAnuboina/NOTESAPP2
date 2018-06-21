package com.cs17b004.notesapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Newnote extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        LayoutInflater x = getActivity().getLayoutInflater();
        View dialog = x.inflate(R.layout.activity_newnote, null);
        //b.setMessage("NEW NOTE");
        b.setView(dialog);
        final EditText title = (EditText) dialog.findViewById(R.id.editText);
        final EditText description = (EditText) dialog.findViewById(R.id.editText2);
        final CheckBox favorite = (CheckBox) dialog.findViewById(R.id.checkBox);
        final CheckBox done = (CheckBox) dialog.findViewById(R.id.checkBox2);
        final CheckBox todo = (CheckBox) dialog.findViewById(R.id.checkBox3);
        final CheckBox budget = (CheckBox) dialog.findViewById(R.id.checkBox4);
        Button ok = (Button) dialog.findViewById(R.id.button);
        Button cancel = (Button) dialog.findViewById(R.id.button2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note z = new note();
                z.setTitle(title.getText().toString());
                z.setDescription(description.getText().toString());
                z.setFavorite(favorite.isChecked());
                z.setTodo(todo.isChecked());
                z.setDone(done.isChecked());
                z.setBudget(budget.isChecked());
                MainActivity m = (MainActivity) getActivity();
                m.createnewnote(z);
                dismiss();
            }
        });
        return b.create();

    }
}

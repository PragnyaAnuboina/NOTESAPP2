package com.cs17b004.notesapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NoteAdapter na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        na = new NoteAdapter();
        setContentView(R.layout.activity_main);
        ListView files = (ListView) findViewById(R.id.listview);
        files.setAdapter(na);
        files.setLongClickable(true);
        files.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                na.deletenote(position);
                return true;
            }
        });
        files.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                note temp = na.getItem(position);
                Shownote z = new Shownote();
                z.sendnote(temp);
                z.show(getFragmentManager(), "123");
            }
        });
    }

    /*  public void editnote(note a){
          na.editnote(temp,a);
      }*/
    public void createnewnote(note w) {
        na.addnote(w);
    }

    public class NoteAdapter extends BaseAdapter {
        private JSONSerializer mSerializer;
        List<note> notelist = new ArrayList<note>();

        public NoteAdapter() {

            mSerializer = new JSONSerializer("NOTESAPP.json", MainActivity.this.getApplicationContext());

            try {
                notelist = mSerializer.load();
            } catch (Exception e) {
                notelist = new ArrayList<note>();
                Log.e("Error loading notes: ", "", e);
            }

        }

        public void saveNotes() {
            try {
                mSerializer.save(notelist);

            } catch (Exception e) {
                Log.e("Error Saving Notes", "", e);
            }
        }

        // ArrayList<note> notelist=new ArrayList<note>();

        @Override
        public int getCount() {
            return notelist.size();
        }

        @Override
        public note getItem(int position) {
            return notelist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View x, ViewGroup parent) {
            if (x == null) {
                LayoutInflater a = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                x = a.inflate(R.layout.activity_listitem, parent, false);
            }
            TextView title = (TextView) x.findViewById(R.id.textView);
            TextView description = (TextView) x.findViewById(R.id.textView2);
            ImageView favorite = (ImageView) x.findViewById(R.id.imageView);
            ImageView todo = (ImageView) x.findViewById(R.id.imageView2);
            ImageView done = (ImageView) x.findViewById(R.id.imageView3);
            ImageView budget = (ImageView) x.findViewById(R.id.imageView4);
            note temp = notelist.get(position);
            title.setText(temp.getTitle());
            description.setText(temp.getDescription());
            if (!temp.isFavorite()) {
                favorite.setVisibility(View.GONE);
            }
            if (!temp.isBudget()) {
                budget.setVisibility(View.GONE);
            }
            if (!temp.isTodo()) {
                    todo.setVisibility(View.GONE);
            }
            if (!temp.isDone()) {
                    done.setVisibility(View.GONE);
            }
            return x;
            }
            public void addnote (note w){
                notelist.add(w);
                notifyDataSetChanged();
            }
            public void deletenote ( int n){
                notelist.remove(n);
                notifyDataSetChanged();
            }
      /*  public  void editnote(note x,note y){
            notelist.remove(x);
            notelist.add(y);
            notifyDataSetChanged();
        }*/
        }

        @Override
        protected void onPause() {
            super.onPause();

            na.saveNotes();
        }

        public void newnote(View view) {
            Newnote n = new Newnote();
            n.show(getFragmentManager(), "123");
        }
    }



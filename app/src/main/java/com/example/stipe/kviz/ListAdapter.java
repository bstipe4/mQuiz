package com.example.stipe.kviz;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater layoutInflater;

    public ListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return DataStorageUser.allUsersList.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if (view == null) {
            view = layoutInflater.inflate(R.layout.one_user, viewGroup, false);
        }

        TextView username = (TextView) view.findViewById(R.id.username);
        TextView score = (TextView) view.findViewById(R.id.score);
        TextView num=(TextView)view.findViewById(R.id.num);

        Highscore currentUser = DataStorageUser.allUsersList.get(i);

        username.setText(String.valueOf(currentUser.getUsername()));
        score.setText(String.valueOf(currentUser.getScore()));
        num.setText(String.valueOf(i+1));

        return view;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}

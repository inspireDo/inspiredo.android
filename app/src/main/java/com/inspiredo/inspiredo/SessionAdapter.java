package com.inspiredo.inspiredo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapter for History of sessions
 *
 * Created by Erik Kessler
 * (c) 2015 inspireDo
 */
class SessionAdapter extends ArrayAdapter<MeditationSessionModel> {

    public SessionAdapter(Context context, int resource) {
        super(context, resource);
    }

    /**
     * Override this method so we can set the date or if needed "Next Session"
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the view if needed
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.session_row, null);
        }

        // Get the Task
        MeditationSessionModel session = getItem(position);
        TextView date = (TextView) convertView.findViewById(R.id.tvDate);

        if (session.getIndex() == -1) {
            date.setText("Next Session");
        } else {
            date.setText(session.getTitle());
        }


        return convertView;
    }

}

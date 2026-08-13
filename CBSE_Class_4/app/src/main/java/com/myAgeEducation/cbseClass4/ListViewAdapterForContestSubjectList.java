package com.myAgeEducation.cbseClass4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapterForContestSubjectList extends BaseAdapter
{
    Activity context;
    ArrayList<Integer> _image;
    ArrayList<String> _subjectName;
    private Context _context;

    public ListViewAdapterForContestSubjectList(Activity context, ArrayList<Integer> image, ArrayList<String> subjectName) {
        super();
        this.context = context;
        this._image = image;
        this._subjectName = subjectName;
        _context = context;
    }

    public int getCount() {
        return _subjectName.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView textViewSubjectName;
        ImageView imageViewSubject;
    }

    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        final ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.listitem_subjectlist, null);
            holder = new ViewHolder();
            holder.textViewSubjectName = convertView.findViewById(R.id.textViewSubjectName);
            holder.imageViewSubject = convertView.findViewById(R.id.imageViewSubjectImage);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewSubjectName.setText(_subjectName.get(position));
        holder.imageViewSubject.setImageResource(_image.get(position));

        return convertView;
    }
}

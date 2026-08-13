package com.myAgeEducation.cbseClass4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ListViewAdapterForSubjectList extends BaseAdapter
{
    Activity context;
    ArrayList<Integer> _image;
    ArrayList<String> _subjectName;
    ArrayList<String> _tagLine;
    private Context _context;

    public ListViewAdapterForSubjectList(Activity context, ArrayList<Integer> image, ArrayList<String> subjectName, ArrayList<String> tagLine) {
        super();
        this.context = context;
        this._image = image;
        this._subjectName = subjectName;
        _tagLine = tagLine;
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
        TextView textViewTagLine;
        ImageView imageViewSubject;
        ImageView imageViewTopRight;
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
            holder.textViewTagLine = convertView.findViewById(R.id.textViewTagLine);
            holder.imageViewSubject = convertView.findViewById(R.id.imageViewSubjectImage);
            holder.imageViewTopRight = convertView.findViewById(R.id.imageViewTopRight);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        String text = _subjectName.get(position);
        holder.textViewSubjectName.setText(text);
        if(TextUtils.equals(text, "Knowledge Contest"))
        {
            holder.textViewSubjectName.setTextSize(TypedValue.COMPLEX_UNIT_PX, _context.getResources().getDimension(R.dimen.knowledge_contest_list_item_font_size));
            holder.imageViewTopRight.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.textViewSubjectName.setTextSize(TypedValue.COMPLEX_UNIT_PX, _context.getResources().getDimension(R.dimen.subject_text_size));
            holder.imageViewTopRight.setVisibility(View.GONE);
        }

        holder.textViewTagLine.setText(_tagLine.get(position));
        holder.imageViewSubject.setImageResource(_image.get(position));

        return convertView;
    }
}

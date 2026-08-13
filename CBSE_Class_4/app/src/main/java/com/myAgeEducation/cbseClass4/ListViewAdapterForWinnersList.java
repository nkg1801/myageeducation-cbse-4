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

public class ListViewAdapterForWinnersList extends BaseAdapter
{
    Activity context;
    ArrayList<String> _winnerPhotoBase64;
    ArrayList<String> _contestName;
    ArrayList<String> _winnerName;
    ArrayList<String> _winnerCity;
    private Context _context;

    public ListViewAdapterForWinnersList(Activity context, ArrayList<String> winnerPhotoBase64, ArrayList<String> contestName, ArrayList<String> winnerName, ArrayList<String> winnerCity) {
        super();
        this.context = context;
        this._winnerPhotoBase64 = winnerPhotoBase64;
        this._contestName = contestName;
        this._winnerName = winnerName;
        this._winnerCity = winnerCity;
        _context = context;
    }

    public int getCount() {
        return _winnerName.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView textViewContestName;
        TextView textViewWinnerName;
        TextView textViewWinnerCity;
        ImageView imageViewWinnerPhoto;
    }

    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        final ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.listitem_winners, null);
            holder = new ViewHolder();
            holder.textViewContestName = convertView.findViewById(R.id.textViewContestName);
            holder.textViewWinnerName = convertView.findViewById(R.id.textViewWinnerName);
            holder.textViewWinnerCity = convertView.findViewById(R.id.textViewWinnerCity);
            holder.imageViewWinnerPhoto = convertView.findViewById(R.id.imageViewSubjectImage);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewContestName.setText("Contest: " + _contestName.get(position));
		holder.textViewWinnerName.setText("Name: " + _winnerName.get(position));
		holder.textViewWinnerCity.setText("City: " + _winnerCity.get(position));

        String imageData = _winnerPhotoBase64.get(position);

        if(imageData == null || imageData.length() < 100)
        {
            holder.imageViewWinnerPhoto.setImageResource(R.drawable.photo_outline);
        }
		else
		{
			holder.imageViewWinnerPhoto.setImageBitmap(Util.LoadBitmapFromBase64Encoding(imageData));
		}
        return convertView;
    }
}

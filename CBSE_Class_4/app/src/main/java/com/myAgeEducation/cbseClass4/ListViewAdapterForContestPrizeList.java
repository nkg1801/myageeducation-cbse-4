package com.myAgeEducation.cbseClass4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapterForContestPrizeList extends BaseAdapter
{
    Activity context;
    ArrayList<Integer> _prizeImage;
    ArrayList<String> _prizeImageBase64;
    ArrayList<String> _prizeDescription;
    private Context _context;
    private boolean _showButton;

    public ListViewAdapterForContestPrizeList(Activity context, ArrayList<String> prizeImage, ArrayList<String> prizeDescription, boolean showButton) {
        super();
        this.context = context;
        this._prizeImageBase64 = prizeImage;
        this._prizeDescription = prizeDescription;
        this._showButton = showButton;
        _context = context;
    }

    public int getCount() {
        return _prizeDescription.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView textViewPrizeDescription;
        ImageView imageViewPrizeImage;
    }

    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        final ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.listitem_prize_list, null);
            holder = new ViewHolder();
            holder.textViewPrizeDescription = convertView.findViewById(R.id.textViewPrizeDescription);
            holder.imageViewPrizeImage = convertView.findViewById(R.id.imageViewPrizeImage);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        //holder.textViewPrizeDescription.setText(_prizeDescription.get(position));
        holder.textViewPrizeDescription.setText(Html.fromHtml(_prizeDescription.get(position)));

        String imageData = _prizeImageBase64.get(position);

        if(imageData == null)
        {
            //ToDo: do something here
        }

        if(imageData.length() < 100) {
            int resourceIdentifier = _context.getResources().getIdentifier(imageData, "drawable", _context.getPackageName());
            if(resourceIdentifier != 0)
            {
                holder.imageViewPrizeImage.setImageResource(resourceIdentifier);
            }
        }
        else
        {
            holder.imageViewPrizeImage.setImageBitmap(Util.LoadBitmapFromBase64Encoding(imageData));
        }

        if(_showButton)
        {
            convertView.findViewById(R.id.buttonChoosePrize).setVisibility(View.VISIBLE);
        }
        else
        {
            convertView.findViewById(R.id.buttonChoosePrize).setVisibility(View.GONE);
        }
        return convertView;
    }
}

package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter<DailyCA> {
    private ArrayList<DailyCA> dailyCA;
    private Context context;
    private TextView tvweek;
    private TextView tvGrade;
    private ImageView iv;


    public DGAdapter(Context context, int resource, ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        dailyCA = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvweek = rowView.findViewById(R.id.textViewWeek);
        tvGrade = rowView.findViewById(R.id.textViewGrade);

        // Get the ImageView object
        iv = rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyCA currentGrade = dailyCA.get(position);
        // Set the TextView to show the food

        tvweek.setText("week" + String.valueOf(currentGrade.getWeek()));
        tvGrade.setText(currentGrade.getDgGrade());
        iv.setImageResource(R.drawable.dg);
        // Return the nicely done up View to the ListView
        return rowView;
    }


}

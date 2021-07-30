package sg.edu.rp.c346.id20046797.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCountryCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvPhoneNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        // Obtain the Android Version information based on the position
        Contact currentContact = contactList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentContact.getName());
        tvCountryCode.setText(currentContact.getCountryCode() + "");
        tvPhoneNum.setText(currentContact.getPhoneNum() + "");

        if (currentContact.getGender() == 'F') ivGender.setImageResource(R.drawable.female);
        else ivGender.setImageResource(R.drawable.male);

        return rowView;
    }


}

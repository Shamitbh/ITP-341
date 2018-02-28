package itp341.toolbars;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import itp341.toolbars.Model.Mail;
import itp341.toolbars.R;

import java.util.List;

public class MailAdapter extends ArrayAdapter<Mail>{
    private int mLayoutResource;
    //TODO Constants
    private final int MAX_LENGTH_TITLE = 20;
    private final int MAX_LENGTH_MESSAGE = 44;

    public MailAdapter(Context context, int resource, List<Mail> objects) {
        super(context, resource, objects);
        mLayoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(mLayoutResource, parent, false);
        }

        Mail mail = getItem(position);

        TextView textViewSender = (TextView) convertView.findViewById(R.id.list_mail_sender);
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.list_mail_title);
        TextView textViewMessage = (TextView) convertView.findViewById(R.id.list_mail_message);

        String titleString = mail.getTitle();
        String messageString = mail.getMessage();

        //TODO implement length check
        textViewTitle.setText(titleString);
        textViewMessage.setText(messageString);
        textViewSender.setText(mail.getSender());


        //TODO modify Read / unread


        return convertView;
    }
}

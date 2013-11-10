package com.example.kradar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;

public class PopUp extends DialogFragment{

	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.pops, null));
        
        builder.setMessage(R.string.Title)
               .setPositiveButton(R.string.entor, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   EditText entry=(EditText) ((Dialog) dialog).findViewById(R.id.text_entry);
                	   try{
                		   int newLife=Integer.parseInt(entry.getText().toString());
                		   mListener.onSetLifePositiveClick(PopUp.this, newLife);
                	   }catch(Exception e){
                		   mListener.onSetLifeNegativeClick(PopUp.this);
                	   }
                	   
                	   
                   }
               })
               .setNegativeButton(R.string.cansel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   mListener.onSetLifeNegativeClick(PopUp.this);
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    
    public interface NoticeDialogListener {
        public void onSetLifePositiveClick(DialogFragment dialog, int newlife);
        public void onSetLifeNegativeClick(DialogFragment dialog);
    }
    
    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;
    
    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
    
    
}

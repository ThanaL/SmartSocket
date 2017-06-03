package com.example.thanalabadi.new_one;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder> {
    private List<piece> mItemList;

    public RecyclerAdapter(List<piece> itemList) {


        mItemList = itemList;
    }

    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        RecyclerItemViewHolder holder =new RecyclerItemViewHolder(view,context);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, int position) {
        piece item = mItemList.get(position);
        holder.setItem(item,position);
        holder.setListeners();

    }





    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }




     class RecyclerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView name;
         private final ImageButton state;
         private final ImageButton alarm;
         private final ImageButton delete;
         private final ImageButton wifi;

         private final CardView cardView;
         private final ImageButton Share;
        public  Context context;
         private int position;
        public  piece item;
        public RecyclerItemViewHolder(final View parent,Context context) {
            super(parent);
            name = (TextView) parent.findViewById(R.id.name);
            state = (ImageButton) parent.findViewById(R.id.state);
            alarm = (ImageButton) parent.findViewById(R.id.alarm);
            wifi = (ImageButton) parent.findViewById(R.id.wifi);

            delete = (ImageButton) parent.findViewById(R.id.delete);
            cardView=(CardView) parent.findViewById(R.id.card);
            Share=(ImageButton)parent.findViewById(R.id.share);
this.context=context;

        }


         public void setItem( piece item, int position) {
             this.position=position;
this.item= item;
             name.setText(item.getName());

             if (item.getState().equals("on")) {
                 state.setEnabled(true);

                 state.setImageResource(R.drawable.light_on);
                 wifi.setImageResource(R.drawable.wifi_on);
             }
             else if (item.getState().equals("error")) {
                 state.setImageResource(R.drawable.light_off);
                 wifi.setImageResource(R.drawable.wifi_off);
                 state.setEnabled(false);
             }
             else {
                 state.setEnabled(true);

                 state.setImageResource(R.drawable.light_off);
                 wifi.setImageResource(R.drawable.wifi_on);
             }

         }




         public void setListeners() {

             name.setOnClickListener( RecyclerItemViewHolder.this);
             alarm.setOnClickListener( RecyclerItemViewHolder.this);
             state.setOnClickListener( RecyclerItemViewHolder.this);
             delete.setOnClickListener( RecyclerItemViewHolder.this);
             Share.setOnClickListener(RecyclerItemViewHolder.this);

             cardView.setOnClickListener(RecyclerItemViewHolder.this);

         }


         @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.delete:
                    removeitem(position);
                    break;

                case R.id.alarm:
                    RecyclerItemViewHolder.this.context.startActivity(new Intent(RecyclerItemViewHolder.this.context,alarm.class));

                    break;
                case R.id.state:
                    changeState();
                    break;
                case R.id.name:
changeName();
                    break;

                case R.id.share:
share();
                    break;




            }
        }


         private void removeitem(final int position) {

             AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
             builder1.setMessage("Are you sure want to Delete.");
             builder1.setCancelable(true);

             builder1.setPositiveButton(
                     "Yes",
                     new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int id) {

                             mItemList.remove(position);
                             notifyItemRemoved(position);
                             notifyItemRangeChanged(position,mItemList.size());
                         }
                     });

             builder1.setNegativeButton(
                     "No",
                     new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int id) {
                             dialog.cancel();
                         }
                     });

             AlertDialog alert11 = builder1.create();
             alert11.show();






         }

         private void changeState() {

             if(item.getState().equals("erorr")){
                 state.setEnabled(false);

                 state.setImageResource(R.drawable.light_off);
                 wifi.setImageResource(R.drawable.wifi_off);
             }
             else if(item.getState().equals("on")){
                 state.setEnabled(true);

                 state.setImageResource(R.drawable.light_off);
                 wifi.setImageResource(R.drawable.wifi_on);
             }

             else{
                 state.setEnabled(true);

                 state.setImageResource(R.drawable.light_off);
                 wifi.setImageResource(R.drawable.wifi_on);
             }




         }

         public void changeName()
         {

             final EditText edit=new EditText(context);

             edit.setText(name.getText());

             AlertDialog.Builder dialog = new AlertDialog.Builder(context);
             dialog.setCancelable(false);
             dialog.setTitle("Edit Nme");
             dialog.setView(edit);

             dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int id) {
                     name.setText(edit.getText().toString());
                 }
             })
                     .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.cancel();
                         }
                     });

             final AlertDialog alert = dialog.create();
             alert.show();

         }

         public void share(){

             final EditText edit=new EditText(context);


             AlertDialog.Builder dialog = new AlertDialog.Builder(context);
             dialog.setCancelable(false);
             dialog.setTitle("Permision");
             dialog.setView(edit);

             dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int id) {
                     item.users.add(edit.getText().toString());
                 }
             })
                     .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.cancel();
                         }
                     });

             final AlertDialog alert = dialog.create();
             alert.show();


         }

         public void addItem( piece currentObject) {
             mItemList.add(0, currentObject);
             notifyItemInserted(0);
             notifyItemRangeChanged(0, mItemList.size());
//		notifyDataSetChanged();
         }
     }

}

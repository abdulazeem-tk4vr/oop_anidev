package com.example.oop_project.Retailer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.oop_project.Customer.CustomerSubCategories;
import com.example.oop_project.Customer.model_category;
import com.example.oop_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;

public class TransactionAdapter extends FirebaseRecyclerAdapter<com.example.oop_project.Retailer.TransModel_sub, TransactionAdapter.myviewholder> {
    boolean t;
    public TransactionAdapter(@NonNull FirebaseRecyclerOptions<com.example.oop_project.Retailer.TransModel_sub> options,boolean t) {
        super(options);
        this.t=t;
    }

    @Override
    public void onDataChanged() {
        super.onDataChanged();
    }

    @Override
    public void onError(@NonNull DatabaseError error) {
        super.onError(error);
        error.toException().printStackTrace();
    }


    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final TransModel_sub model) {
        if(t){
            holder.shop.setText("Retailer Name: ");
        }else{
            holder.shop.setText("Customer Name: ");
        }
        holder.pname.setText(model.getPname());
        holder.custname.setText(model.getUsername());
        holder.cost.setText(model.getCost());
        holder.ddate.setText(model.getDdate());
        holder.dname.setText(model.getDname());
        holder.dnum.setText(model.getDnumber());
        holder.dqty.setText(model.getQuantity());
        holder.status.setText(model.getStatus());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_info, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView custname,cost,ddate,dname,dnum,dqty,status,pname,shop;
        public myviewholder(@NonNull View view) {
            super(view);
            shop = (TextView) view.findViewById(R.id.Custtitle);
            pname = (TextView) view.findViewById(R.id.Titletext);
            custname = (TextView) view.findViewById(R.id.CustName);
            cost = (TextView) view.findViewById(R.id.cost_trans);
            ddate = (TextView) view.findViewById(R.id.deliverydate);
            dname = (TextView) view.findViewById(R.id.deliveryexec);
            dnum = (TextView) view.findViewById(R.id.deliverynum);
            dqty = (TextView) view.findViewById(R.id.quantity_trans);
            status = (TextView) view.findViewById(R.id.stat_trans);
        }
    }

}

package com.example.android.contactsapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.contactsapp.R;
import com.example.android.contactsapp.local.ContactEntity;
import com.example.android.contactsapp.service.model.ContactsModel;

import java.util.HashMap;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    List<? extends ContactEntity> contacts;
    private HashMap<String,String> phone;

    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        public TextView id,name,gender,email,address,mobile,home,office;

        public ContactsViewHolder(View view){
            super(view);
            id =(TextView) view.findViewById(R.id.id);
            name =(TextView) view.findViewById(R.id.name);
            gender =(TextView) view.findViewById(R.id.gender);
            email =(TextView) view.findViewById(R.id.email);
            address =(TextView) view.findViewById(R.id.address);
            mobile =(TextView) view.findViewById(R.id.mobile);
            home =(TextView) view.findViewById(R.id.home);
            office =(TextView) view.findViewById(R.id.office);
        }
    }

    public ContactsAdapter(List<ContactEntity> list){
        this.contacts=list;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup viewGroup,int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_contactlist_content,viewGroup,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder viewHolder,int index){
       ContactEntity contactsModel =contacts.get(index);
        phone = contactsModel.getPhone();
        viewHolder.id.setText(contactsModel.getId());
        viewHolder.name.setText(contactsModel.getName());
        viewHolder.gender.setText(contactsModel.getGender());
        viewHolder.email.setText(contactsModel.getEmail());
        viewHolder.address.setText(contactsModel.getAddress());
        viewHolder.mobile.setText(phone.get("mobile"));
        viewHolder.home.setText(phone.get("home"));
        viewHolder.office.setText(phone.get("office"));
    }

    @Override
    public int getItemCount() {
        return contacts == null  ? 0:contacts.size();
    }
}

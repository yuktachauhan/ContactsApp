package com.example.android.contactsapp.view.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.contactsapp.R;
import com.example.android.contactsapp.service.model.ContactListModel;
import com.example.android.contactsapp.service.model.ContactsModel;
import com.example.android.contactsapp.view.adapter.ContactsAdapter;
import com.example.android.contactsapp.viewmodel.ContactsViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    private List<ContactsModel> contactsModelList;
    private RecyclerView recyclerView;
    private ContactsAdapter contactsAdapter;
    private ContactsViewModel contactsViewModel;
    private ContactListModel contactListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        contactsViewModel =new ContactsViewModel(getApplication());
        observeViewModel(contactsViewModel);


    }


    public void observeViewModel(final ContactsViewModel contactsViewModel){
        contactsViewModel.getAllContacts().observe(this, new Observer<ContactListModel>() {
            @Override
            public void onChanged(@Nullable ContactListModel contactListModel) {
                List<ContactsModel> contacts = contactListModel.getContactsModelList();
                contactsAdapter = new ContactsAdapter(contacts);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(contactsAdapter);
                contactsAdapter.notifyDataSetChanged();
            }
        });
    }

}

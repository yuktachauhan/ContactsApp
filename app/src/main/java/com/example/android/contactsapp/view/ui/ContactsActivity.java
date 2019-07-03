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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        contactsViewModel =new ContactsViewModel(getApplication());
        observerViewModel(contactsViewModel);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsAdapter);

    }

    public void observerViewModel(final ContactsViewModel contactsViewModel){
        contactsViewModel.getContactList().observe(this, new Observer<List<ContactsModel>>() {
            @Override
            public void onChanged(@Nullable List<ContactsModel> contactsModels) {
                if(contactsModels!=null){
                    contactsAdapter=new ContactsAdapter(contactsModels);
                }
            }
        });

    }

}

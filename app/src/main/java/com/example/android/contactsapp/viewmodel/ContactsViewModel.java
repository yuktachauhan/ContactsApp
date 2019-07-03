package com.example.android.contactsapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.android.contactsapp.service.ContactsService;
import com.example.android.contactsapp.service.RemoteRepository;
import com.example.android.contactsapp.service.model.ContactListModel;
import com.example.android.contactsapp.service.model.ContactsModel;

import java.util.List;

public class ContactsViewModel extends AndroidViewModel {

    private LiveData<List<ContactsModel>> contactList;


    public ContactsViewModel(Application application){
        super(application);
        contactList = RemoteRepository.getInstance().getContactsListModel();

    }

    public LiveData<List<ContactsModel>> getContactList(){
       return contactList;
    }
}

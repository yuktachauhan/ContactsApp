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

public class ContactsViewModel extends ViewModel {

    private RemoteRepository remoteRepository;

    public ContactsViewModel(ContactsService contactsService){
        remoteRepository = new RemoteRepository(contactsService);
    }

    public LiveData<ContactListModel> getContactList(){
        return remoteRepository.getContactsListModel();
    }
}

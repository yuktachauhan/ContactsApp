package com.example.android.contactsapp.service;

import android.arch.lifecycle.LiveData;

import com.example.android.contactsapp.service.model.ContactListModel;

public class RemoteRepository {
    private ContactsService contactsService;

    public RemoteRepository(ContactsService contactsService){
        this.contactsService=contactsService;
    }

    public LiveData<ContactListModel> getContactsListModel(){
        return (LiveData<ContactListModel>) contactsService.getContactList();
    }
}

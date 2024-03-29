package com.example.android.contactsapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.contactsapp.local.ContactEntity;
import com.example.android.contactsapp.service.ContactRepository;
import com.example.android.contactsapp.service.model.ContactListModel;

import java.util.List;

public class ContactsViewModel extends ViewModel {

    private ContactRepository contactRepository;
    private LiveData<ContactListModel> allContacts;
    private LiveData<List<ContactEntity>> contact;

    public ContactsViewModel(){


        contactRepository=ContactRepository.getInstance();
        //allContacts = contactRepository.getContactList();

    }

   // public LiveData<ContactListModel> getAllContacts(){return allContacts;};

   /* public void saveToDb(LiveData<List<ContactEntity>> contact){
          contactRepository.saveToDb(contact);
    }*/

    public LiveData<List<ContactEntity>> loadFromDb(){
        return contactRepository.getFromDb();
    }

}

package com.example.android.contactsapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.android.contactsapp.service.model.ContactListModel;

public class ContactsViewModel extends AndroidViewModel {

    private LiveData<ContactListModel> contactListModelLiveData;

    public ContactsViewModel(@NonNull Application application, LiveData<ContactListModel> contactListModelLiveData){
        super(application);
        this.contactListModelLiveData =contactListModelLiveData;
    }

    public LiveData<ContactListModel> getContactListModel(){
        return contactListModelLiveData;
    }
}

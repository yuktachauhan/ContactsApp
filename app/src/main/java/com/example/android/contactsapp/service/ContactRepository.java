package com.example.android.contactsapp.service;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import android.widget.Toast;

import com.example.android.contactsapp.local.ContactDao;
import com.example.android.contactsapp.local.ContactDatabase;
import com.example.android.contactsapp.local.ContactEntity;
import com.example.android.contactsapp.service.model.ContactListModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactRepository {
    private ContactsService contactsService;
    private static Retrofit retrofit=null;
    private ApiClient apiClient = new ApiClient();
    private static ContactRepository remoteRepository;
    Application application;
    private ContactDao contactDao;

    public ContactRepository(Application application){
        retrofit =apiClient.getClient();
        contactsService=retrofit.create(ContactsService.class);

        ContactDatabase database = ContactDatabase.getInstance(application);
        contactDao=database.getContactDao();
    }

    public static synchronized ContactRepository getInstance(){
        if(remoteRepository==null){
            remoteRepository=new ContactRepository(getInstance().application);
        }
        return remoteRepository;
    }


    public void getContactList(){
       //final MutableLiveData<ContactListModel> allContacts = new MutableLiveData<>();
        contactsService.getContacts().enqueue(new Callback<ContactListModel>() {
            @Override
            public void onResponse(Call<ContactListModel> call, Response<ContactListModel> response) {
               // allContacts.setValue(response.body());
                Log.i("Response",response.body().toString());
                contactDao.saveContacts(response.body().getContactsModelList());
            }
            @Override
            public void onFailure(Call<ContactListModel> call, Throwable t) {
                Toast.makeText(application,t.getMessage(),Toast.LENGTH_LONG).show();
               // allContacts.setValue(null);
            }
        });
       // return allContacts;
    }

    public LiveData<List<ContactEntity>> getFromDb(){
        getContactList();
        return contactDao.loadContactsFromDB();
    }

    /*public void saveToDb(LiveData<List<ContactEntity>> contacts){
        contactDao.saveContacts(contacts);
    }*/
}

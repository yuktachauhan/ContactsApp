package com.example.android.contactsapp.service;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.example.android.contactsapp.service.model.ContactListModel;
import com.example.android.contactsapp.service.model.ContactsModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RemoteRepository {
    private ContactsService contactsService;
    private static Retrofit retrofit=null;
    private ApiClient apiClient = new ApiClient();
    private static RemoteRepository remoteRepository;
    Application application;


    public RemoteRepository(){
        retrofit =apiClient.getClient();
        contactsService=retrofit.create(ContactsService.class);

    }

    public static synchronized RemoteRepository getInstance(){
        if(remoteRepository==null){
            remoteRepository=new RemoteRepository();
        }
        return remoteRepository;
    }


    public LiveData<ContactListModel> getContactList(){
        final MutableLiveData<ContactListModel> allContacts = new MutableLiveData<>();
        contactsService.getContacts().enqueue(new Callback<ContactListModel>() {
            @Override
            public void onResponse(Call<ContactListModel> call, Response<ContactListModel> response) {
                allContacts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ContactListModel> call, Throwable t) {
                Toast.makeText(application,t.getMessage(),Toast.LENGTH_LONG).show();
                allContacts.setValue(null);
            }
        });
        return allContacts;
    }
}

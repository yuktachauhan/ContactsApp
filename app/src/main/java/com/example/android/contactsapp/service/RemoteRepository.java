package com.example.android.contactsapp.service;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.example.android.contactsapp.service.model.ContactListModel;

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


    public RemoteRepository(Application application){
        this.application=application;
        retrofit =apiClient.getClient();
        contactsService=retrofit.create(ContactsService.class);

    }

    public static synchronized RemoteRepository getInstance(){
        if(remoteRepository==null){
            remoteRepository=new RemoteRepository(getInstance().application);
        }
        return remoteRepository;
    }
    public LiveData<ContactListModel> getContactsListModel(){

        final MutableLiveData<ContactListModel> contacts =new MutableLiveData<>();
        contactsService.getContactList().enqueue(new Callback<ContactListModel>() {
            @Override
            public void onResponse(Call<ContactListModel> call, Response<ContactListModel> response) {
                Toast.makeText(application,"Response is successful",Toast.LENGTH_LONG).show();
                  contacts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ContactListModel> call, Throwable t) {
                Toast.makeText(application,t.getMessage(),Toast.LENGTH_LONG).show();
                contacts.setValue(null);
            }
        });
     return contacts;
    }
}

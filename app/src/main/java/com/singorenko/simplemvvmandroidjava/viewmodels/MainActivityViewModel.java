package com.singorenko.simplemvvmandroidjava.viewmodels;

import android.os.AsyncTask;

import com.singorenko.simplemvvmandroidjava.models.NicePlace;
import com.singorenko.simplemvvmandroidjava.repositories.NicePlaceRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

 private MutableLiveData<List<NicePlace>> mNicePlaces;
 private NicePlaceRepository mRepository;
 private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

 //Here we are gonna to retrieve the data
 public void init(){
     if(mNicePlaces != null){
        //this means that we already retrieve the data
         return;
     }
     mRepository = NicePlaceRepository.getInstance();
     mNicePlaces = mRepository.getNicePlaces();
 }

 public void addNewValue(final NicePlace nicePlace){
    mIsUpdating.setValue(true);

     //Simulate asking data to server side
     // Do in this way only like a test mode for see the MVVM.
     new AsyncTask<Void, Void, Void>(){
         @Override
         protected void onPostExecute(Void aVoid){
             super.onPostExecute(aVoid);
             List<NicePlace> currentPlaces = mNicePlaces.getValue();
             currentPlaces.add(nicePlace);
             mNicePlaces.postValue(currentPlaces);
             mIsUpdating.postValue(false);
         }

         @Override
         protected Void doInBackground(Void... voids) {
             try{
                 Thread.sleep(2000);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
             return null;
         }
     }.execute();
 }

 public LiveData<List<NicePlace>> getNicePlaces(){
     return mNicePlaces;
 }
 public LiveData<Boolean> getIsUpdating(){return  mIsUpdating;}
}

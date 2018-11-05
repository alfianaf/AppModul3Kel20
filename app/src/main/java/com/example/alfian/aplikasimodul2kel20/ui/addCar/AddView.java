package com.example.alfian.aplikasimodul2kel20.ui.addCar;


public interface AddView {

    String getName();

    String getMerk();

    String getModel();

    String getYear();

    void successAddCar();

    void failedAddCar();
}
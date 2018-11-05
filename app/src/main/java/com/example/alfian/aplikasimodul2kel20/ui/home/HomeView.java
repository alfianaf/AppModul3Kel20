package com.example.alfian.aplikasimodul2kel20.ui.home;

import com.example.alfian.aplikasimodul2kel20.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);

}

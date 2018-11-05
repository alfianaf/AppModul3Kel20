package com.example.alfian.aplikasimodul2kel20.ui.detailCar;

import com.example.alfian.aplikasimodul2kel20.data.model.DataCar;

import java.util.List;

public interface DetailView {
    String getName();

    String getMerk();

    String getModel();

    String getYear();
    void showError(String message);
    void showSuccess(List<DataCar> car);

    void successUpdate();

    void failedUpdate();
}

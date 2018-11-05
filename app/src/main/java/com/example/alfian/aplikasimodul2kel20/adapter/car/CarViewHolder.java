package com.example.alfian.aplikasimodul2kel20.adapter.car;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.alfian.aplikasimodul2kel20.data.model.DataCar;
import com.example.alfian.aplikasimodul2kel20.R;

public class CarViewHolder extends RecyclerView.ViewHolder {

    LinearLayout linearLayout;
    TextView tvHomeName;
    TextView tvHomeMerk;

    public CarViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        linearLayout = itemView.findViewById(R.id.llItemC);
        tvHomeName = itemView.findViewById(R.id.tvItemCName);
        tvHomeMerk = itemView.findViewById(R.id.tvItemCMerk);
    }

    public void bind(final DataCar dataCar, final CarListener carListerner) {
        tvHomeName.setText(dataCar.getName());
        tvHomeMerk.setText(dataCar.getMerk());

        linearLayout.setOnClickListener(v -> carListerner.onCarClick(dataCar));
    }
}

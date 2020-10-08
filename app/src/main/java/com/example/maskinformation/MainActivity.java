package com.example.maskinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maskinformation.Model.MaskeModel;
import com.example.maskinformation.Remote.ApiUtils;
import com.example.maskinformation.Remote.MaskeService;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MaskeService maskeService;
    @BindView(R.id.BarkodTxt)
    TextView BarkodTxt;
    @BindView(R.id.LanguageTxt)
    TextView LanguageTxt;
    @BindView(R.id.AmbalajTxt)
    TextView AmbalajTxt;
    @BindView(R.id.BoyutTxt)
    TextView BoyutTxt;
    @BindView(R.id.KategoriTxt)
    TextView KategoriTxt;
    @BindView(R.id.RenkTxt)
    TextView RenkTxt;
    @BindView(R.id.KoliTxt)
    TextView KoliTxt;
    @BindView(R.id.KutuTxt)
    TextView KutuTxt;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    Button ScanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        maskeService = ApiUtils.getMaskeService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ScanBtn = findViewById(R.id.ScanBtn);
        ScanBtn.setOnClickListener(this);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {
                if (result.getContents() == null) {
                    Toast.makeText(this, "Sonuç bulunamadı", Toast.LENGTH_SHORT).show();
                } else {
                    BarkodTxt.setText(result.getContents());
                    try {
                        maskeService.findbarkod(result.getContents()).enqueue(new Callback<MaskeModel>() {
                            @Override
                            public void onResponse(Call<MaskeModel> call, Response<MaskeModel> response) {
                                if (response.isSuccessful()) {

                                    MaskeModel maske = response.body();
                                    if (maske != null) {
                                        Log.e("maske ", maske.getDil());
                                        LanguageTxt.setText(maske.getDil());
                                        AmbalajTxt.setText(maske.getAmbalaj());
                                        BoyutTxt.setText(maske.getBoyut());
                                        KategoriTxt.setText(maske.getKategori());
                                        RenkTxt.setText(maske.getRenk());
                                        KoliTxt.setText(maske.getKoli());
                                        KutuTxt.setText(maske.getKutu());
                                        if (maske.getRenk() != null) {
                                            Color(maske.getRenk());
                                        }
                                    }else{
                                        Toasty.error(getApplicationContext() , "SİSTEMDE KAYITLI DEĞİLDİR" , Toast.LENGTH_LONG).show();
                                    }
                                }
                                else {
                                    Log.e("else hata ", response.errorBody().toString());
                                    Toasty.error(getApplicationContext(), "HATA OLUŞTU , TEKRAR DENEYİNİZ", Toast.LENGTH_LONG).show();
                                }
                            }
                            @Override
                            public void onFailure(Call<MaskeModel> call, Throwable t) {
                                Log.e("hata ", t.getMessage());
                                Toasty.error(getApplicationContext(), "HATA OLUŞTU , TEKRAR DENEYİNİZ", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "HATA OLUŞTU , TEKRAR DENEYİNİZ", Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }catch (Exception e1){
            e1.printStackTrace();
            Toast.makeText(getApplicationContext() , "HATA OLUŞTU , TEKRAR DENEYİNİZ" , Toast.LENGTH_LONG).show();
        }
    }
    public void scanow() {
        try {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setCaptureActivity(Portrait.class);
            integrator.setOrientationLocked(false);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
            integrator.setPrompt("Barkod Okuma");
            integrator.initiateScan();

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            Toasty.error(getApplicationContext() , "HATALI BARKOD OKUMA , TEKRAR DENEYİNİZ" , Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View v) {
        scanow();
    }
    private void Color(String renk) {
        if (renk.equals("INDIGO")) {
            imageView3.setColorFilter(Color.parseColor("#006ca9"));
        } else if (renk.equals("BLACK")) {
            imageView3.setColorFilter(Color.BLACK);
        } else if (renk.equals("RED")) {
            imageView3.setColorFilter(Color.RED);
        } else if (renk.equals("WHITE")) {
            imageView3.setColorFilter(Color.WHITE);
        } else if (renk.equals("BEIGE")) {
            imageView3.setColorFilter(Color.parseColor("#F5F5DC"));
        } else if (renk.equals("KHAKI")) {
            imageView3.setColorFilter(Color.parseColor("#c3b091"));
        } else if (renk.equals("NAVY")) {
            imageView3.setColorFilter(Color.parseColor("#000080"));
        } else if (renk.equals("PURPLE")) {
            imageView3.setColorFilter(Color.parseColor("#800080"));
        } else if (renk.equals("GREY")) {
            imageView3.setColorFilter(Color.GRAY);
        }
    }
}

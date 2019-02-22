package com.shafi.sbf.interndcr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Data dataApi ;

    Spinner productGroupm , Literaturem , physicianSamplem , giftm;

    EditText AmountLiterature , AmountPhysic ,AmountGift ;

    EditText AccompaniedWithm , Remarksm ;

    List<ProductGroupList> productGroupLists = new ArrayList<>();
    List<LiteratureList> literatureLists = new ArrayList<>();
    List<PhysicianSampleList> physicianSampleLists = new ArrayList<>();
    List<GiftList> giftLists = new ArrayList<>();

    List<String> productGroupStringList = new ArrayList<String>();
    List<String> literatureStringList = new ArrayList<String>();
    List<String> physicianStringList = new ArrayList<String>();
    List<String> giftStringList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productGroupm = findViewById(R.id.spinner_product_group);
        Literaturem = findViewById(R.id.spinner_literature);
        physicianSamplem = findViewById(R.id.spinner_Physician);
        giftm = findViewById(R.id.spinner_Gift);


        AmountLiterature = findViewById(R.id.amount_literature);
        AmountPhysic = findViewById(R.id.amount_Physician);
        AmountGift = findViewById(R.id.amount_Gift);

        AccompaniedWithm = findViewById(R.id.edit_text_accompanied);
        Remarksm = findViewById(R.id.edit_text_remarks);



        //add choose
        addChooseProductList();
        addChooseLiterature();
        addChoosePhysican();
        addChooseGift();




        networkLibraryInitialazer();

        getData();


    }

    private void addChooseProductList() {
        ProductGroupList productGroupList = new ProductGroupList();
        productGroupList.setId(0);
        productGroupList.setProductGroup("Choose");
        productGroupLists.add(productGroupList);
    }

    private void addChooseLiterature() {
        LiteratureList literatureList = new LiteratureList();
        literatureList.setId(0);
        literatureList.setLiterature("Choose");
        literatureLists.add(literatureList);
    }


    private void addChoosePhysican() {
        PhysicianSampleList physicianSampleList = new PhysicianSampleList();
        physicianSampleList.setId(0);
        physicianSampleList.setSample("Choose");
        physicianSampleLists.add(physicianSampleList);

    }

    private void addChooseGift() {
        GiftList giftList = new GiftList();
        giftList.setId(0);
        giftList.setGift("Choose");
        giftLists.add(giftList);

    }



    private void networkLibraryInitialazer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataApi = retrofit.create(Data.class);
    }
    private void getData() {

        Call<AllList> allListCall = dataApi.getAllData();
        allListCall.enqueue(new Callback<AllList>() {
            @Override
            public void onResponse(Call<AllList> call, Response<AllList> response) {

                productGroupLists.addAll(response.body().getProductGroupList());
                physicianSampleLists.addAll(response.body().getPhysicianSampleList());
                literatureLists.addAll(response.body().getLiteratureList());
                giftLists.addAll(response.body().getGiftList());

                makeStringProductList(productGroupLists);
                makeStringLiteratureList(literatureLists);
                makeStringPhysicianList(physicianSampleLists);
                makeStringGiftList(giftLists);
            }

            @Override
            public void onFailure(Call<AllList> call, Throwable t) {

            }
        });

    }

    private void makeStringProductList(List<ProductGroupList> productGroupLists) {

        for(int i =0;i<productGroupLists.size();i++){
            productGroupStringList.add(productGroupLists.get(i).getProductGroup());
        }

        loadSpinnerPRoductGroup(productGroupStringList);

    }

    private void loadSpinnerPRoductGroup(List<String> productGroupStringList) {
        ArrayAdapter product = new ArrayAdapter(this,R.layout.spinner_item,productGroupStringList);
        product.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        productGroupm.setAdapter(product);
    }

    private void makeStringLiteratureList(List<LiteratureList>literatureLists){

        for (int i = 0; i < literatureLists.size() ; i++ ){
            literatureStringList.add(literatureLists.get(i).getLiterature());
        }

        loadSpinnerLiteratureList(literatureStringList);

    }

    private void loadSpinnerLiteratureList(List<String> literatureStringList) {
        ArrayAdapter literature = new ArrayAdapter(this,R.layout.spinner_item,literatureStringList);
        literature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Literaturem.setAdapter(literature);
    }

    private void makeStringPhysicianList(List<PhysicianSampleList> physicianSampleLists) {
        for (int i = 0; i < physicianSampleLists.size() ; i++ ){
            physicianStringList.add(physicianSampleLists.get(i).getSample());
        }
        loadSpinnerPhysicianSampleList(physicianStringList);
    }

    private void loadSpinnerPhysicianSampleList(List<String> physicianStringList) {
        ArrayAdapter physician = new ArrayAdapter(this,R.layout.spinner_item,physicianStringList);
        physician.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        physicianSamplem.setAdapter(physician);
    }

    private void makeStringGiftList(List<GiftList> giftLists) {
        for (int i = 0; i < giftLists.size() ; i++ ){
            giftStringList.add(giftLists.get(i).getGift());
        }
        loadSpinnerGiftList(giftStringList);
    }

    private void loadSpinnerGiftList(List<String> giftStringList) {
        ArrayAdapter gift = new ArrayAdapter(this,R.layout.spinner_item,giftStringList);
        gift.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        giftm.setAdapter(gift);
    }


    public void submit(View view) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast_done,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id_done));
        // The actual toast generated here.
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}

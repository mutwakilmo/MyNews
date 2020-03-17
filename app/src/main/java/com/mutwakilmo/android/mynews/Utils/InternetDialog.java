package com.mutwakilmo.android.mynews.Utils;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.mutwakilmo.android.mynews.R;

/**
 * Created by Mutwakil Mo🐮🐮🐮 on 13/03/2020
 */
public class InternetDialog {

    private Context context;


    public InternetDialog(Context context){
        this.context = context;
    }

    public void showNoInternetDialog(){
        final Dialog internetDialog = new Dialog(context, R.style.df_dialog);
        internetDialog.setContentView(R.layout.dialog_no_internet);
        internetDialog.setCancelable(true);
        internetDialog.setCanceledOnTouchOutside(true);
        internetDialog.findViewById(R.id.btnSpinAndWinRedeem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                internetDialog.dismiss();
            }
        });
        internetDialog.show();
    }
    //-------------------------
    //Check Internet
    //--------------------------
    public  boolean getInternetStatus() {

        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(!isConnected) {
            //show no internet dialog
            showNoInternetDialog();
        }
        return isConnected;
    }
}

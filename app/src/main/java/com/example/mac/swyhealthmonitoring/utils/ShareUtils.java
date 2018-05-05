package com.example.mac.swyhealthmonitoring.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;

public class ShareUtils {

    public static void shareToWhatsapp(Context context,String number, String msg){
        Intent whatsappIntent = new Intent("android.intent.action.MAIN");
        whatsappIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number)+"@s.whatsapp.net");
        whatsappIntent.setAction(Intent.ACTION_SEND);
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, msg);
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.setType("text/plain");
        try {
            context.startActivity(whatsappIntent);
        }catch (ActivityNotFoundException ex){
            Toast.makeText(context,"Sorry whatsapp not installed on your phone",Toast.LENGTH_LONG).show();
        }
    }
}

package com.dailyroutingexersise.allbankbalance.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dailyroutingexersise.allbankbalance.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public final class TransactionActivity extends BaseActivity {
    public ArrayList<String> acnumber_list;
    public String[] bank_full_array;
    public String[] bank_short_list;
    public Msg_Adapter msg_adapter;
    private SharedPreferences sharedPreferences;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ArrayList<String> bank_name_list = new ArrayList<>();
    private ArrayList<Bankmsg_model> bankdata_list = new ArrayList<>();

    @Override
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override
    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override
    public int setView() {
        return R.layout.activity_transaction;
    }

    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public final ArrayList<String> getBank_name_list() {
        return this.bank_name_list;
    }

    public final void setBank_name_list(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bank_name_list = arrayList;
    }

    public final ArrayList<String> getAcnumber_list() {
        ArrayList<String> arrayList = this.acnumber_list;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("acnumber_list");
        return null;
    }

    public final void setAcnumber_list(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.acnumber_list = arrayList;
    }

    public final String[] getBank_short_list() {
        String[] strArr = this.bank_short_list;
        if (strArr != null) {
            return strArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bank_short_list");
        return null;
    }

    public final void setBank_short_list(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.bank_short_list = strArr;
    }

    public final String[] getBank_full_array() {
        String[] strArr = this.bank_full_array;
        if (strArr != null) {
            return strArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bank_full_array");
        return null;
    }

    public final void setBank_full_array(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.bank_full_array = strArr;
    }

    public final ArrayList<Bankmsg_model> getBankdata_list() {
        return this.bankdata_list;
    }

    public final void setBankdata_list(ArrayList<Bankmsg_model> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bankdata_list = arrayList;
    }

    public final Msg_Adapter getMsg_adapter() {
        Msg_Adapter msg_Adapter = this.msg_adapter;
        if (msg_Adapter != null) {
            return msg_Adapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("msg_adapter");
        return null;
    }

    public final void setMsg_adapter(Msg_Adapter msg_Adapter) {
        Intrinsics.checkNotNullParameter(msg_Adapter, "<set-?>");
        this.msg_adapter = msg_Adapter;
    }

    @Override
    public void initview() {
        ((RecyclerView) _$_findCachedViewById(R.id.rv_transaction_list)).setLayoutManager(new LinearLayoutManager(this));
        this.sharedPreferences = getApplication().getSharedPreferences("myPref", 0);
        String[] stringArray = getResources().getStringArray(R.array.bank_full);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.bank_full)");
        setBank_full_array(stringArray);
        String[] stringArray2 = getResources().getStringArray(R.array.bank_short);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "resources.getStringArray(R.array.bank_short)");
        setBank_short_list(stringArray2);
        if (ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") == 0) {
            new MessageTask(this).execute(new Void[0]);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_SMS"}, 123);
        }
        ((ImageView) _$_findCachedViewById(R.id.iv_transaction_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TransactionActivity.m80initview$lambda0(TransactionActivity.this, view);
            }
        });
    }

    public static final void m80initview$lambda0(TransactionActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    public final class MessageTask extends AsyncTask<Void, Void, Cursor> {
        final TransactionActivity this$0;

        public MessageTask(TransactionActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override
        public void onPostExecute(Cursor cursor) {
            this.this$0.setadapter();
            SharedPreferences sharedPreferences = this.this$0.getSharedPreferences();
            Intrinsics.checkNotNull(sharedPreferences);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("lastime", new Date().getTime());
            edit.apply();
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        public Cursor doInBackground(Void... p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            SharedPreferences sharedPreferences = this.this$0.getSharedPreferences();
            Intrinsics.checkNotNull(sharedPreferences);
            Cursor query = this.this$0.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"_id", "address", "date", "body"}, "date> ? ", new String[]{String.valueOf(sharedPreferences.getLong("lastime", 0L))}, null);
            this.this$0.getbankdata(query);
            return query;
        }
    }

    @Override
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        if (i == 123 && grantResults.length > 0 && grantResults[0] == 0 && ContextCompat.checkSelfPermission(this, "android.permission.READ_SMS") == 0) {
            new MessageTask(this).execute(new Void[0]);
        }
    }

    public final void getbankdata(Cursor cursor) {
        Databasehelper databasehelper;
        String str;
        boolean z;
        Databasehelper databasehelper2;
        Date date;
        boolean z2;
        String lowerCase;
        String lowerCase2;
        int i;
        int i2;
        boolean z3;
        String checkpatten;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z4;
        Databasehelper databasehelper3;
        String str7;
        String str8;
        String str9;
        String substring;
        String substring2;
        int i3;
        String substring3;
        Cursor cursor2 = cursor;
        setAcnumber_list(new ArrayList<>());
        Databasehelper databasehelper4 = new Databasehelper(this);
        if (cursor2 != null) {
            Intrinsics.checkNotNull(cursor);
            if (cursor.moveToFirst()) {
                String str10 = "";
                String str11 = "";
                boolean z5 = true;
                while (cursor2.moveToNext()) {
                    String sms_address = cursor2.getString(cursor2.getColumnIndexOrThrow("address"));
                    String sms_body = cursor2.getString(cursor2.getColumnIndexOrThrow("body"));
                    Intrinsics.checkNotNullExpressionValue(sms_body, "sms_body");
                    if (checkmsg(sms_body)) {
                        Intrinsics.checkNotNullExpressionValue(sms_address, "sms_address");
                        String str12 = sms_address;
                        if (!str12.contains("paytm")) {
                            Bankmsg_model bankmsg_model = new Bankmsg_model();
                            String is_bankmsg = is_bankmsg(sms_body);
                            if (is_bankmsg.length() > 3) {
                                is_bankmsg = is_bankmsg.substring(is_bankmsg.length() - 3);
                                Intrinsics.checkNotNullExpressionValue(is_bankmsg, "this as java.lang.String).substring(startIndex)");
                            }
                            bankmsg_model.setac_number(is_bankmsg);
                            boolean z6 = z5;
                            String str13 = str11;
                            Date date2 = new Date(cursor2.getLong(2));
                            bankmsg_model.set_date(date2);
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                            String lowerCase3 = sms_body.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                            if (lowerCase3.contains("credit")) {
                                databasehelper2 = databasehelper4;
                                date = date2;
                            } else {
                                String lowerCase4 = sms_body.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                                databasehelper2 = databasehelper4;
                                date = date2;
                                if (!lowerCase4.contains("credited")) {
                                    String lowerCase5 = sms_body.toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase()");
                                    if (!lowerCase5.contains("credited with")) {
                                        String lowerCase6 = sms_body.toLowerCase();
                                        Intrinsics.checkNotNullExpressionValue(lowerCase6, "this as java.lang.String).toLowerCase()");
                                        if (!lowerCase6.contains("txn")) {
                                            String lowerCase7 = sms_body.toLowerCase();
                                            Intrinsics.checkNotNullExpressionValue(lowerCase7, "this as java.lang.String).toLowerCase()");
                                            if (!lowerCase7.contains("debit")) {
                                                String lowerCase8 = sms_body.toLowerCase();
                                                Intrinsics.checkNotNullExpressionValue(lowerCase8, "this as java.lang.String).toLowerCase()");
                                                if (!lowerCase8.contains("debited")) {
                                                    String lowerCase9 = sms_body.toLowerCase();
                                                    Intrinsics.checkNotNullExpressionValue(lowerCase9, "this as java.lang.String).toLowerCase()");
                                                    if (!lowerCase9.contains("debited with")) {
                                                        String lowerCase10 = sms_body.toLowerCase();
                                                        Intrinsics.checkNotNullExpressionValue(lowerCase10, "this as java.lang.String).toLowerCase()");
                                                    }
                                                }
                                            }
                                        }
                                        bankmsg_model.set_isDebit(true);
                                        z2 = false;
                                        lowerCase = sms_body.toLowerCase();
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                        if (lowerCase.contains("credited")) {
                                            String lowerCase11 = sms_body.toLowerCase();
                                            Intrinsics.checkNotNullExpressionValue(lowerCase11, "this as java.lang.String).toLowerCase()");
                                            if (lowerCase11.contains("debited")) {
                                                String lowerCase12 = sms_body.toLowerCase();
                                                Intrinsics.checkNotNullExpressionValue(lowerCase12, "this as java.lang.String).toLowerCase()");
                                                int indexOf$default = lowerCase12.indexOf("credited");
                                                String lowerCase13 = sms_body.toLowerCase();
                                                Intrinsics.checkNotNullExpressionValue(lowerCase13, "this as java.lang.String).toLowerCase()");
                                                if (indexOf$default > lowerCase13.indexOf("debited")) {
                                                    bankmsg_model.set_isDebit(true);
                                                } else {
                                                    z2 = false;
                                                    bankmsg_model.set_isDebit(false);
                                                }
                                            }
                                            z2 = false;
                                        }
                                        lowerCase2 = sms_body.toLowerCase();
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                                        if (lowerCase2.contains("card")) {
                                            String lowerCase14 = sms_body.toLowerCase();
                                            Intrinsics.checkNotNullExpressionValue(lowerCase14, "this as java.lang.String).toLowerCase()");
                                            if (!lowerCase14.contains("debit card of acct")) {
                                                String lowerCase15 = sms_body.toLowerCase();
                                                Intrinsics.checkNotNullExpressionValue(lowerCase15, "this as java.lang.String).toLowerCase()");
                                                if (!lowerCase15.contains("debit card of a/c")) {
                                                    String lowerCase16 = sms_body.toLowerCase();
                                                    Intrinsics.checkNotNullExpressionValue(lowerCase16, "this as java.lang.String).toLowerCase()");
                                                    if (!lowerCase16.contains("debit card of account")) {
                                                        i = 1;
                                                        bankmsg_model.set_isDebit(true);
                                                        bankmsg_model.set_isCard(true);
                                                        i2 = 0;
                                                        while (i2 < getBank_short_list().length - i) {
                                                            if (!str12.contains(getBank_short_list()[i2])) {
                                                                String lowerCase17 = sms_body.toLowerCase();
                                                                Intrinsics.checkNotNullExpressionValue(lowerCase17, "this as java.lang.String).toLowerCase()");
                                                                String lowerCase18 = getBank_full_array()[i2].toLowerCase();
                                                                Intrinsics.checkNotNullExpressionValue(lowerCase18, "this as java.lang.String).toLowerCase()");
                                                                if (!lowerCase17.contains(lowerCase18) && !sms_body.contains(getBank_short_list()[i2])) {
                                                                    String lowerCase19 = sms_address.toLowerCase();
                                                                    Intrinsics.checkNotNullExpressionValue(lowerCase19, "this as java.lang.String).toLowerCase()");
                                                                    String lowerCase20 = getBank_full_array()[i2].toLowerCase();
                                                                    Intrinsics.checkNotNullExpressionValue(lowerCase20, "this as java.lang.String).toLowerCase()");
                                                                    if (!lowerCase19.contains(lowerCase20)) {
                                                                        i2++;
                                                                        z2 = false;
                                                                        i = 1;
                                                                    }
                                                                }
                                                            }
                                                            z2 = z6;
                                                        }
                                                        if (!this.bank_name_list.contains(getBank_full_array()[i2])) {
                                                            this.bank_name_list.add(getBank_full_array()[i2]);
                                                        }
                                                        if (z2) {
                                                            bankmsg_model.set_smsaddress(getBank_full_array()[i2]);
                                                        }
                                                        if (z2) {
                                                            z3 = z2;
                                                        } else {
                                                            String lowerCase21 = getBank_full_array()[i2].toLowerCase();
                                                            Intrinsics.checkNotNullExpressionValue(lowerCase21, "this as java.lang.String).toLowerCase()");
                                                            if (lowerCase21.contains("paytm")) {
                                                                bankmsg_model.set_smsaddress("Paytm Bank");
                                                            } else {
                                                                bankmsg_model.set_smsaddress(sms_address);
                                                            }
                                                            z3 = true;
                                                        }
                                                        checkpatten = checkpatten(Intrinsics.stringPlus(" ", sms_body));
                                                        String checkpatten2 = checkpatten(Intrinsics.stringPlus(" ", sms_body));
                                                        if (checkpatten != null) {
                                                            String checkpateenmsg = checkpateenmsg(sms_body);
                                                            if (checkpatten.contains(",")) {
                                                                checkpatten = checkpatten.replace(",", "");
                                                            }
                                                            String checknumber_formate = checknumber_formate(b(checkpatten));
                                                            String e = e(sms_body);
                                                            if (e == null) {
                                                                String str14 = sms_body;
                                                                z = z3;
                                                                if (str14.contains("IMPS")
                                                                        || str14.contains("NEFT")
                                                                        || str14.contains("UPI")
                                                                        || str14.contains("towards")) {
                                                                    str7 = "this as java.lang.String).toLowerCase()";
                                                                    str2 = str10;
                                                                    str8 = sms_body;
                                                                    str3 = is_bankmsg;
                                                                } else {
                                                                    str2 = str10;
                                                                    if (!str14.contains(" at")) {
                                                                        str3 = is_bankmsg;
                                                                        str7 = "this as java.lang.String).toLowerCase()";
                                                                        str8 = sms_body;
                                                                        if (!str14.contains("being")) {
                                                                            if (!str14.contains("for")) {
                                                                                Intrinsics.checkNotNull(checkpatten2);
                                                                                Object[] array = str14.split(checkpatten2);
                                                                                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                                String[] strArr = (String[]) array;
                                                                                if (strArr.length == 2) {
                                                                                    if (strArr[1].contains(".")) {
                                                                                        str9 = strArr[1].substring(0, strArr[1].indexOf("."));
                                                                                        Intrinsics.checkNotNullExpressionValue(str9, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                                    } else {
                                                                                        str9 = strArr[1];
                                                                                    }
                                                                                    str13 = str9 == null ? str2 : Intrinsics.stringPlus(str9, ".");
                                                                                }
                                                                            } else {
                                                                                Object[] array2 = str14.split("for");
                                                                                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                                String[] strArr2 = (String[]) array2;
                                                                                if (strArr2.length == 2) {
                                                                                    int i4 = 1;
                                                                                    if (strArr2[1].contains(".")) {
                                                                                        i4 = 1;
                                                                                        substring = strArr2[1].substring(1, strArr2[1].indexOf("."));
                                                                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                                    } else {
                                                                                        substring = strArr2[1].substring(1);
                                                                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                                                                    }
                                                                                    String str15 = substring;
                                                                                    int length = str15.length() - i4;
                                                                                    boolean z7 = false;
                                                                                    int i5 = 0;
                                                                                    while (i5 <= length) {
                                                                                        boolean z8 = Intrinsics.compare((int) str15.charAt(!z7 ? i5 : length), 32) <= 0;
                                                                                        if (z7) {
                                                                                            if (!z8) {
                                                                                                break;
                                                                                            }
                                                                                            length--;
                                                                                        } else if (z8) {
                                                                                            i5++;
                                                                                        } else {
                                                                                            z7 = true;
                                                                                        }
                                                                                    }
                                                                                    str15.subSequence(i5, length + 1).toString();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            Object[] array3 = str14.split("being");
                                                                            Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                            String[] strArr3 = (String[]) array3;
                                                                            if (strArr3.length == 2) {
                                                                                int i6 = 1;
                                                                                if (strArr3[1].contains(".")) {
                                                                                    i6 = 1;
                                                                                    substring2 = strArr3[1].substring(1, strArr3[1].indexOf("."));
                                                                                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                                } else {
                                                                                    substring2 = strArr3[1].substring(1);
                                                                                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                                                                }
                                                                                String str16 = substring2;
                                                                                int length2 = str16.length() - i6;
                                                                                boolean z9 = false;
                                                                                int i7 = 0;
                                                                                while (i7 <= length2) {
                                                                                    boolean z10 = Intrinsics.compare((int) str16.charAt(!z9 ? i7 : length2), 32) <= 0;
                                                                                    if (z9) {
                                                                                        if (!z10) {
                                                                                            break;
                                                                                        }
                                                                                        length2--;
                                                                                    } else if (z10) {
                                                                                        i7++;
                                                                                    } else {
                                                                                        z9 = true;
                                                                                    }
                                                                                }
                                                                                str16.subSequence(i7, length2 + 1).toString();
                                                                            }
                                                                        }
                                                                    } else {
                                                                        String[] array4 = str14.split(" at");
                                                                        Objects.requireNonNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                        String[] strArr4 = (String[]) array4;
                                                                        if (strArr4.length == 2) {
                                                                            str3 = is_bankmsg;
                                                                            if (strArr4[1].contains(".")) {
                                                                                i3 = 1;
                                                                                substring3 = strArr4[1].substring(1,strArr4[1].indexOf("."));
                                                                                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                            } else {
                                                                                i3 = 1;
                                                                                substring3 = strArr4[1].substring(1);
                                                                                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                                                                            }
                                                                            String str17 = substring3;
                                                                            int length3 = str17.length() - i3;
                                                                            boolean z11 = false;
                                                                            int i8 = 0;
                                                                            while (i8 <= length3) {
                                                                                boolean z12 = Intrinsics.compare((int) str17.charAt(!z11 ? i8 : length3), 32) <= 0;
                                                                                if (z11) {
                                                                                    if (!z12) {
                                                                                        break;
                                                                                    }
                                                                                    length3--;
                                                                                } else if (z12) {
                                                                                    i8++;
                                                                                } else {
                                                                                    z11 = true;
                                                                                }
                                                                            }
                                                                            str17.subSequence(i8, length3 + 1).toString();
                                                                        } else {
                                                                            str3 = is_bankmsg;
                                                                        }
                                                                        str7 = "this as java.lang.String).toLowerCase()";
                                                                        str8 = sms_body;
                                                                    }
                                                                }
                                                                e = str13;
                                                            } else {
                                                                str7 = "this as java.lang.String).toLowerCase()";
                                                                str2 = str10;
                                                                z = z3;
                                                                str8 = sms_body;
                                                                str3 = is_bankmsg;
                                                            }
                                                            if (checkpateenmsg != null) {
                                                                Intrinsics.checkNotNull(checkpateenmsg);
                                                                if (checkpateenmsg.contains(",")) {
                                                                    checkpateenmsg = checkpateenmsg.replace(",", "");
                                                                }
                                                                str5 = checknumber_formate(b(checkpateenmsg));
                                                                Log.d("ASD", Intrinsics.stringPlus("Format===", str5));
                                                                bankmsg_model.set_netbal(str5);
                                                                bankmsg_model.set_amount(checknumber_formate);
                                                                bankmsg_model.set_descr(e);
                                                            } else {
                                                                String lowerCase22 = str8.toLowerCase();
                                                                String str18 = str7;
                                                                Intrinsics.checkNotNullExpressionValue(lowerCase22, str18);
                                                                if (!lowerCase22.contains("bal")) {
                                                                    String lowerCase23 = str8.toLowerCase();
                                                                    Intrinsics.checkNotNullExpressionValue(lowerCase23, str18);
                                                                    if (!lowerCase23.contains("balance")) {
                                                                        String lowerCase24 = str8.toLowerCase();
                                                                        Intrinsics.checkNotNullExpressionValue(lowerCase24, str18);
                                                                    }
                                                                }
                                                                String lowerCase25 = str8.toLowerCase();
                                                                Intrinsics.checkNotNullExpressionValue(lowerCase25, str18);
                                                                if (!lowerCase25.contains("netbank")) {
                                                                    String g = g(str8);
                                                                    if (g != null) {
                                                                        bankmsg_model.set_amount(checknumber_formate);
                                                                        bankmsg_model.set_netbal(g);
                                                                    } else {
                                                                        bankmsg_model.set_netbal(checknumber_formate);
                                                                    }
                                                                    bankmsg_model.set_descr(e);
                                                                    str5 = checkpateenmsg;
                                                                }
                                                                bankmsg_model.set_amount(checknumber_formate);
                                                                bankmsg_model.set_descr(e);
                                                                str5 = checkpateenmsg;
                                                            }
                                                            str4 = checknumber_formate;
                                                            str11 = e;
                                                        } else {
                                                            str2 = str10;
                                                            z = z3;
                                                            str3 = is_bankmsg;
                                                            str11 = str13;
                                                            str4 = checkpatten;
                                                            str5 = null;
                                                        }
                                                        if (str4 == null || str5 != null) {
                                                            str6 = str3;
                                                            if (!Intrinsics.areEqual(str6, "NA")) {
                                                                str = str2;
                                                                if (!Intrinsics.areEqual(str6, str)) {
                                                                    String str19 = str6;
                                                                    if (!str19.contains("*") && !str19.contains("#")) {
                                                                        int i9 = 0;
                                                                        while (true) {
                                                                            if (i9 >= this.bankdata_list.size()) {
                                                                                z4 = true;
                                                                                break;
                                                                            }
                                                                            String str20 = this.bankdata_list.get(i9).getac_number();
                                                                            String str21 = this.bankdata_list.get(i9).get_amount();
                                                                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                                                                            Date date3 = this.bankdata_list.get(i9).get_date();
                                                                            Intrinsics.checkNotNull(date3);
                                                                            long seconds = timeUnit.toSeconds(date3.getTime() - date.getTime());
                                                                            if (seconds >= 60 || 0 > seconds || str4 == null || checkpatten2 == null) {
                                                                                databasehelper3 = databasehelper2;
                                                                            } else {
                                                                                String str22 = str20;
                                                                                if ((str22.contains(str19) || str19.contains(str22)) && Intrinsics.areEqual(str4, str21)) {
                                                                                    z4 = false;
                                                                                    break;
                                                                                }
                                                                                databasehelper3 = databasehelper2;
                                                                            }
                                                                            i9++;
                                                                            databasehelper2 = databasehelper3;
                                                                        }
                                                                        if (z4) {
                                                                            this.bankdata_list.add(bankmsg_model);
                                                                            databasehelper = databasehelper2;
                                                                            databasehelper.add_bankdata(bankmsg_model);
                                                                            if (!this.bank_name_list.contains(bankmsg_model.get_smsaddress())) {
                                                                                this.bank_name_list.add(bankmsg_model.get_smsaddress());
                                                                            }
                                                                            z5 = z;
                                                                            if (cursor.moveToNext()) {
                                                                                break;
                                                                            }
                                                                            str10 = str;
                                                                            databasehelper4 = databasehelper;
                                                                            cursor2 = cursor;
                                                                        }
                                                                    }
                                                                }
                                                                databasehelper = databasehelper2;
                                                                z5 = z;
                                                                if (cursor.moveToNext()) {
                                                                }
                                                            }
                                                        }
                                                        str = str2;
                                                        databasehelper = databasehelper2;
                                                        z5 = z;
                                                        if (cursor.moveToNext()) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i = 1;
                                        bankmsg_model.set_isCard(z2);
                                        i2 = 0;
//                                        while (i2 < getBank_short_list().length - i) {
//                                        }
                                        if (!this.bank_name_list.contains(getBank_full_array()[i2])) {
                                        }
                                        if (z2) {
                                        }
                                        if (z2) {
                                        }
                                        checkpatten = checkpatten(Intrinsics.stringPlus(" ", sms_body));
                                        String checkpatten22 = checkpatten(Intrinsics.stringPlus(" ", sms_body));
                                        if (checkpatten != null) {
                                        }
//                                        if (str4 == null) {
//                                        }
//                                        str6 = str3;
//                                        if (!Intrinsics.areEqual(str6, "NA")) {
//                                        }
//                                        str = str2;
//                                        databasehelper = databasehelper2;
//                                        z5 = z;
                                        if (cursor.moveToNext()) {
                                        }
                                    }
                                }
                            }
                            z2 = false;
                            bankmsg_model.set_isDebit(false);
                            lowerCase = sms_body.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                            if (lowerCase.contains("credited")) {
                            }
                            lowerCase2 = sms_body.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                            if (lowerCase2.contains("card")) {
                            }
                            i = 1;
                            bankmsg_model.set_isCard(z2);
                            i2 = 0;
//                            while (i2 < getBank_short_list().length - i) {
//                            }
                            if (!this.bank_name_list.contains(getBank_full_array()[i2])) {
                            }
                            if (z2) {
                            }
                            if (z2) {
                            }
                            checkpatten = checkpatten(Intrinsics.stringPlus(" ", sms_body));
                            String checkpatten222 = checkpatten(Intrinsics.stringPlus(" ", sms_body));
                            if (checkpatten != null) {
                            }
//                            if (str4 == null) {
//                            }
//                            str6 = str3;
//                            if (!Intrinsics.areEqual(str6, "NA")) {
//                            }
//                            str = str2;
//                            databasehelper = databasehelper2;
//                            z5 = z;
                            if (cursor.moveToNext()) {
                            }
                        }
                    }
                    databasehelper = databasehelper4;
                    str = str10;
                    z = z5;
                    str11 = str11;
                    z5 = z;
                    if (cursor.moveToNext()) {
                    }
                }
            }
            SharedPreferences sharedPreferences = this.sharedPreferences;
            Intrinsics.checkNotNull(sharedPreferences);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("isDbLoaded", true);
            edit.apply();
        }
        account_data();
    }

    public final boolean checkmsg(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (lowerCase.contains("otp")) {
            return false;
        }
        Pattern compile = Pattern.compile("(?:[Aa]ccount|[Aa]\\/[Cc]|[Aa][Cc][Cc][Tt]|[Cc][Aa][Rr][Dd] |[Cc]redited|[Dd]ebited)");
        String lowerCase2 = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        if (compile.matcher(lowerCase2).find()) {
            if (Intrinsics.areEqual(is_bankmsg(str), "NA")) {
                return false;
            }
            String lowerCase3 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
            if (lowerCase3.contains("talktime")) {
                return false;
            }
            String lowerCase4 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
            return (lowerCase4.contains("recharge") || is_bankmsg(str).contains("#")) ? false : true;
        } else if (Intrinsics.areEqual(is_bankmsg(str), "NA")) {
            return false;
        } else {
            String lowerCase5 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase()");
            if (!lowerCase5.contains("deposited")) {
                String lowerCase6 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "this as java.lang.String).toLowerCase()");
                if (!lowerCase6.contains("debited")) {
                    String lowerCase7 = str.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "this as java.lang.String).toLowerCase()");
                    if (!lowerCase7.contains("transaction")) {
                        String lowerCase8 = str.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase8, "this as java.lang.String).toLowerCase()");
                        if (!lowerCase8.contains("credited")) {
                            String lowerCase9 = str.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase9, "this as java.lang.String).toLowerCase()");
                            if (!lowerCase9.contains("balance")) {
                                String lowerCase10 = str.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase10, "this as java.lang.String).toLowerCase()");
                                if (!lowerCase10.contains("txn")) {
                                    String lowerCase11 = str.toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase11, "this as java.lang.String).toLowerCase()");
                                    if (!lowerCase11.contains("bal")) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            String lowerCase12 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase12, "this as java.lang.String).toLowerCase()");
            if (lowerCase12.contains("talktime")) {
                return false;
            }
            String lowerCase13 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase13, "this as java.lang.String).toLowerCase()");
            return (lowerCase13.contains("recharge") || is_bankmsg(str).contains( "#")) ? false : true;
        }
    }

    public final String is_bankmsg(String str) {
        String str2 = str.trim();
        Matcher matcher = Pattern.compile("(xx\\d+)|ending\\s*\\d+").matcher(str2);
        Matcher matcher2 = Pattern.compile("[0-9]*[Xx\\*]*[0-9]*[Xx\\*]+[0-9]{3,}").matcher(str2);

        if (matcher2.find()) {
            return str2.substring(matcher2.start(), matcher2.end());
        } else if (matcher.find()) {
            return matcher.group(0);
        } else {
            String lowerCase = str2.toLowerCase();
            if (!lowerCase.contains("account") && !lowerCase.contains("a/c")) {
                String[] strArr = str2.split("\\s");
                int length = strArr.length;
                int i = 1;

                for (int i2 = 1; i2 < length; i2++) {
                    char[] charArray = strArr[i2].toCharArray();
                    boolean isAllDigits = true;

                    for (char c : charArray) {
                        if (!Character.isDigit(c)) {
                            isAllDigits = false;
                            break;
                        }
                    }

                    if (!isAllDigits) {
                        int i5 = i2 - 1;
                        String lowerCase5 = strArr[i5].toLowerCase();

                        if (!lowerCase5.equals("account") && !lowerCase5.equals("a/c")) {
                            if (i2 > i) {
                                String combinedString = strArr[i2 - 2] + strArr[i5];
                                String lowerCase7 = combinedString.toLowerCase();

                                if (!lowerCase7.equals("accountno") && !lowerCase7.equals("a/cno")) {
                                    String lowerCase8 = combinedString.toLowerCase();
                                    if (lowerCase8.equals("accountno") || lowerCase8.equals("a/cno")) {
                                        return strArr[i2];
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }

                        return strArr[i2];
                    }
                    i = 1;
                }

                return "NA";
            }
        }

        return "NA";
    }


    private final String checkpatten(String str) {
        Matcher matcher = Pattern.compile("(?i)(?:(?: rs|inr| mrp)\\.?\\s?)(\\'?\\d+(:?\\,\\d+)?(\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)").matcher(str);
        if (matcher.find()) {
            String substring = str.substring(matcher.start(), matcher.end());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return null;
    }

    public final String checkpateenmsg(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Matcher matcher = Pattern.compile("(?i)(?:(?:balance|bal)\\.?\\s?\\:?)(?:\\s?(?:rs|inr|INR)?)\\.?\\s?\\|?(\\'?\\d+(:?\\,\\d+)?(\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)").matcher(str);
        if (matcher.find()) {
            String substring = str.substring(matcher.start(), matcher.end());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return null;
    }

    public final String checknumber_formate(double d) {
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("en", "IN"));
        numberFormat.setMinimumFractionDigits(2);
        String format = numberFormat.format(d);
        Intrinsics.checkNotNullExpressionValue(format, "instance.format(d2)");
        return format;
    }

    public final double b(String str) {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            int length = charArray.length;
            int i = 0;
            while (i < length) {
                char c = charArray[i];
                i++;
                Character valueOf = Character.valueOf(c);
                if (Character.isDigit(valueOf.charValue()) || Intrinsics.areEqual(String.valueOf(valueOf), ".")) {
                    sb2.append(valueOf.charValue());
                }
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
            if (sb3.indexOf(".") == 0) {
                String sb4 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb4, "sb.toString()");
                sb = sb4.substring(1, sb2.toString().length());
                Intrinsics.checkNotNullExpressionValue(sb, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                sb = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "sb.toString()");
            }
            String str2 = sb;
            if (str2.contains( ",")) {
                sb.replace(",", "");
            }
            if (getnumber(sb, '.') > 1) {
                sb = sb.substring(0, str2.indexOf('.'));
                Intrinsics.checkNotNullExpressionValue(sb, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            if (Intrinsics.areEqual(sb, "")) {
                return 0.0d;
            }
            try {
                return Double.parseDouble(sb);
            } catch (NumberFormatException e) {
                Log.e("error1", Intrinsics.stringPlus("", e.getMessage()));
                return 0.0d;
            }
        }
        return 0.0d;
    }

    public final int getnumber(String str, char c) {
        Intrinsics.checkNotNullParameter(str, "str");
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            if (str.charAt(i) == c) {
                i2++;
            }
            i = i3;
        }
        return i2;
    }

    private final String e(String str) {
        String str2 = "";
        String str3 = str;
        if (str3.contains("Info")) {
            Object[] array = str3.split("Info");
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length != 2) {
                return null;
            }
            if (!strArr[1].contains(".") || strArr[1].length() <= 1) {
                strArr[1] = strArr[1].replace(":", "");
                return strArr[1];
            }
            try {
                String substring = strArr[1].substring(1, strArr[1].indexOf("."));
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String str4 = substring;
                int length = str4.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str4.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                str2 = str4.subSequence(i, length + 1).toString();
            } catch (IndexOutOfBoundsException e) {
                Log.e("error2", Intrinsics.stringPlus("", e.getMessage()));
            }
            return Intrinsics.stringPlus(str2, ".");
        }
        return null;
    }

    private final String g(String str) {
        Matcher matcher = Pattern.compile("(?i)(?:(?: rs|inr| mrp)\\.?\\s?)(\\'?\\d+(:?\\,\\d+)?(\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)").matcher(str);
        if (matcher.find() && matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    private final void account_data() {
        if (this.bankdata_list == null || this.bank_name_list.size() <= 0) {
            return;
        }
        int size = this.bank_name_list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            ArrayList<Bankmsg_model> arrayList = new ArrayList<>();
            if (this.bankdata_list.size() > 0) {
                int size2 = this.bankdata_list.size();
                int i3 = 0;
                while (i3 < size2) {
                    int i4 = i3 + 1;
                    Bankmsg_model bankmsg_model = this.bankdata_list.get(i3);
                    Intrinsics.checkNotNullExpressionValue(bankmsg_model, "bankdata_list[i3]");
                    Bankmsg_model bankmsg_model2 = bankmsg_model;
                    if (Intrinsics.areEqual(bankmsg_model2.get_smsaddress(), this.bank_name_list.get(i))) {
                        arrayList.add(bankmsg_model2);
                    }
                    i3 = i4;
                }
            }
            dataofmsg(arrayList);
            i = i2;
        }
    }

    public final void dataofmsg(ArrayList<Bankmsg_model> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= list.size()) {
                break;
            }
            Bankmsg_model bankmsg_model = list.get(i);
            Intrinsics.checkNotNullExpressionValue(bankmsg_model, "list[i2]");
            Bankmsg_model bankmsg_model2 = bankmsg_model;
            String str = bankmsg_model2.getac_number();
            if (!bankmsg_model2.get_isCard()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                if (getAcnumber_list().size() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= getAcnumber_list().size()) {
                            break;
                        }
                        String str2 = getAcnumber_list().get(i2);
                        Intrinsics.checkNotNullExpressionValue(str2, "acnumber_list[i3]");
                        String str3 = str2;
                        if (str3.length() > 3) {
                            String substring = str3.substring(str3.length() - 3);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            if (str.length() > 4) {
                                String substring2 = str.substring(str.length() - 3);
                                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                if (Intrinsics.areEqual(substring2, substring)) {
                                    z = false;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        i2++;
                    }
                }
                if (z && !getAcnumber_list().contains(str)) {
                    getAcnumber_list().add(str);
                }
            } else if (!arrayList2.contains(str)) {
                arrayList2.add(str);
            }
            i++;
        }
        if (arrayList.size() != 1) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                Log.e("size1", "arrayList2:-" + arrayList2.size() + ",i4:-" + i3);
                int size2 = list.size();
                int i5 = 0;
                while (i5 < size2) {
                    int i6 = i5 + 1;
                    if (i5 < list.size()) {
                        Log.e("size2", "list:-" + list.size() + ",i5:-" + i5);
                        if (Intrinsics.areEqual(list.get(i5).getac_number(), arrayList2.get(i3))) {
                            list.remove(i5);
                        }
                    }
                    i5 = i6;
                }
                i3 = i4;
            }
            return;
        }
        int size3 = arrayList2.size();
        int i7 = 0;
        while (i7 < size3) {
            int i8 = i7 + 1;
            int size4 = list.size();
            int i9 = 0;
            while (i9 < size4) {
                int i10 = i9 + 1;
                Bankmsg_model bankmsg_model3 = list.get(i9);
                Intrinsics.checkNotNullExpressionValue(bankmsg_model3, "list[i7]");
                Bankmsg_model bankmsg_model4 = bankmsg_model3;
                if (Intrinsics.areEqual(bankmsg_model4.getac_number(), arrayList2.get(i7))) {
                    Object obj = arrayList.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj, "arrayList[0]");
                    bankmsg_model4.setac_number((String) obj);
                }
                i9 = i10;
            }
            i7 = i8;
        }
    }

    public final void setadapter() {
        Databasehelper databasehelper = new Databasehelper(this);
        setAcnumber_list(new ArrayList<>());
        this.bankdata_list = databasehelper.getbankdata_list();
        this.bank_name_list = new ArrayList<>();
        int size = this.bankdata_list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Bankmsg_model bankmsg_model = this.bankdata_list.get(i);
            Intrinsics.checkNotNullExpressionValue(bankmsg_model, "bankdata_list.get(i2)");
            Bankmsg_model bankmsg_model2 = bankmsg_model;
            if (!this.bank_name_list.contains(bankmsg_model2.get_smsaddress())) {
                this.bank_name_list.add(bankmsg_model2.get_smsaddress());
            }
            i = i2;
        }
        account_data();
        ArrayList arrayList = new ArrayList();
        int size2 = getAcnumber_list().size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            int i5 = i3 + 1;
            if (i4 == 2) {
                arrayList.add(null);
            }
            arrayList.add(getAcnumber_list().get(i3));
            i4++;
            i3 = i5;
        }
        if (getAcnumber_list().size() != 0) {
            FrameLayout fl_banner = (FrameLayout) _$_findCachedViewById(R.id.fl_banner);
            Intrinsics.checkNotNullExpressionValue(fl_banner, "fl_banner");
        }
        setMsg_adapter(new Msg_Adapter(this, arrayList, this.bankdata_list));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_transaction_list);
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(getMsg_adapter());
        if (getAcnumber_list().size() == 0) {
            ((TextView) _$_findCachedViewById(R.id.tv_no_transaction)).setVisibility(View.VISIBLE);
        }
        ((ProgressBar) _$_findCachedViewById(R.id.pb_transcation)).setVisibility(View.GONE);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_transaction_list)).setVisibility(View.VISIBLE);
        databasehelper.close();
    }

}


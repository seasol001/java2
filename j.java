 public final void getbankdata(android.database.Cursor r33) {
       
            r32 = this;
            r0 = r32
            r1 = r33
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r0.setAcnumber_list(r2)
            com.bankpassbook.all_bank_balance_check.helper.Databasehelper r2 = new com.bankpassbook.all_bank_balance_check.helper.Databasehelper
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3)
            if (r1 == 0) goto L_0x0755
            kotlin.jvm.internal.Intrinsics.checkNotNull(r33)
            boolean r3 = r33.moveToFirst()
            if (r3 == 0) goto L_0x0743
            java.lang.String r3 = ""
            r6 = r3
            r5 = 1
        L_0x0023:
            java.lang.String r7 = "address"
            int r7 = r1.getColumnIndexOrThrow(r7)
            java.lang.String r7 = r1.getString(r7)
            java.lang.String r8 = "body"
            int r8 = r1.getColumnIndexOrThrow(r8)
            java.lang.String r8 = r1.getString(r8)
            java.lang.String r9 = "sms_body"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            boolean r9 = r0.checkmsg(r8)
            if (r9 == 0) goto L_0x072c
            java.lang.String r9 = "sms_address"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = "paytm"
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r12 = 0
            r13 = 2
            r14 = 0
            boolean r11 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r11, (boolean) r12, (int) r13, (java.lang.Object) r14)
            if (r11 != 0) goto L_0x072c
            com.bankpassbook.all_bank_balance_check.model.Bankmsg_model r11 = new com.bankpassbook.all_bank_balance_check.model.Bankmsg_model
            r11.<init>()
            java.lang.String r15 = r0.is_bankmsg(r8)
            int r4 = r15.length()
            r12 = 3
            java.lang.String r14 = "this as java.lang.String).substring(startIndex)"
            if (r4 <= r12) goto L_0x0076
            int r4 = r15.length()
            int r4 = r4 - r12
            java.lang.String r15 = r15.substring(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r14)
        L_0x0076:
            r11.setac_number(r15)
            java.util.Date r4 = new java.util.Date
            r12 = r5
            r17 = r6
            long r5 = r1.getLong(r13)
            r4.<init>(r5)
            r11.set_date(r4)
            java.util.Locale r5 = java.util.Locale.getDefault()
            java.lang.String r6 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r5 = r8.toLowerCase(r5)
            java.lang.String r6 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r6 = "credit"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r18 = r12
            r1 = 0
            r12 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (boolean) r12, (int) r13, (java.lang.Object) r1)
            java.lang.String r6 = "debited"
            java.lang.String r19 = "credited"
            java.lang.String r1 = "this as java.lang.String).toLowerCase()"
            if (r5 != 0) goto L_0x0140
            java.lang.String r5 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r20 = r2
            r2 = r19
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r21 = r4
            r4 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r2, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x0144
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "credited with"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x00dc
            goto L_0x0144
        L_0x00dc:
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "txn"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x013a
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "debit"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x013a
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x013a
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "debited with"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 != 0) goto L_0x013a
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "withdrawn"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r12, (int) r13, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x013e
        L_0x013a:
            r2 = 1
            r11.set_isDebit(r2)
        L_0x013e:
            r2 = 0
            goto L_0x0148
        L_0x0140:
            r20 = r2
            r21 = r4
        L_0x0144:
            r2 = 0
            r11.set_isDebit(r2)
        L_0x0148:
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = r19
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r2, (int) r13, (java.lang.Object) r12)
            if (r4 == 0) goto L_0x01a4
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r6, (boolean) r2, (int) r13, (java.lang.Object) r12)
            if (r4 == 0) goto L_0x01a3
            java.lang.String r2 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r22 = r2
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            java.lang.String r23 = "credited"
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r22, (java.lang.String) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            r22 = r4
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            java.lang.String r23 = "debited"
            int r4 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r22, (java.lang.String) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            if (r2 <= r4) goto L_0x019e
            r2 = 1
            r11.set_isDebit(r2)
            goto L_0x01a3
        L_0x019e:
            r2 = 0
            r11.set_isDebit(r2)
            goto L_0x01a4
        L_0x01a3:
            r2 = 0
        L_0x01a4:
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "card"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x01fa
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "debit card of acct"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x01fa
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "debit card of a/c"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x01fa
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "debit card of account"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x01f2
            goto L_0x01fa
        L_0x01f2:
            r4 = 1
            r11.set_isDebit(r4)
            r11.set_isCard(r4)
            goto L_0x01fe
        L_0x01fa:
            r4 = 1
            r11.set_isCard(r2)
        L_0x01fe:
            r5 = 0
        L_0x01ff:
            java.lang.String[] r6 = r32.getBank_short_list()
            int r6 = r6.length
            int r6 = r6 - r4
            if (r5 < r6) goto L_0x0208
            goto L_0x026c
        L_0x0208:
            java.lang.String[] r4 = r32.getBank_short_list()
            r4 = r4[r5]
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r6 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r4, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x026a
            java.lang.String r4 = r8.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String[] r12 = r32.getBank_full_array()
            r12 = r12[r5]
            java.lang.String r12 = r12.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r12, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x026a
            r4 = r8
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String[] r12 = r32.getBank_short_list()
            r12 = r12[r5]
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r12, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x026a
            java.lang.String r4 = r7.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String[] r12 = r32.getBank_full_array()
            r12 = r12[r5]
            java.lang.String r12 = r12.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r12, (boolean) r2, (int) r13, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x0265
            goto L_0x026a
        L_0x0265:
            int r5 = r5 + 1
            r2 = 0
            r4 = 1
            goto L_0x01ff
        L_0x026a:
            r2 = r18
        L_0x026c:
            java.util.ArrayList<java.lang.String> r4 = r0.bank_name_list
            java.lang.String[] r6 = r32.getBank_full_array()
            r6 = r6[r5]
            boolean r4 = r4.contains(r6)
            if (r4 != 0) goto L_0x0285
            java.util.ArrayList<java.lang.String> r4 = r0.bank_name_list
            java.lang.String[] r6 = r32.getBank_full_array()
            r6 = r6[r5]
            r4.add(r6)
        L_0x0285:
            if (r2 == 0) goto L_0x0290
            java.lang.String[] r4 = r32.getBank_full_array()
            r4 = r4[r5]
            r11.set_smsaddress(r4)
        L_0x0290:
            if (r2 != 0) goto L_0x02b6
            java.lang.String[] r2 = r32.getBank_full_array()
            r2 = r2[r5]
            java.lang.String r2 = r2.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r4 = 0
            r5 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r10, (boolean) r5, (int) r13, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x02b1
            java.lang.String r2 = "Paytm Bank"
            r11.set_smsaddress(r2)
            goto L_0x02b4
        L_0x02b1:
            r11.set_smsaddress(r7)
        L_0x02b4:
            r5 = 1
            goto L_0x02b7
        L_0x02b6:
            r5 = r2
        L_0x02b7:
            java.lang.String r2 = " "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r8)
            java.lang.String r22 = r0.checkpatten(r4)
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r8)
            java.lang.String r2 = r0.checkpatten(r2)
            if (r22 == 0) goto L_0x0654
            java.lang.String r4 = r0.checkpateenmsg(r8)
            r6 = r22
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = ","
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10 = 0
            r12 = 0
            boolean r6 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (java.lang.CharSequence) r9, (boolean) r12, (int) r13, (java.lang.Object) r10)
            if (r6 == 0) goto L_0x02ee
            r25 = 0
            r26 = 4
            r27 = 0
            java.lang.String r23 = ","
            java.lang.String r24 = ""
            java.lang.String r22 = kotlin.text.StringsKt.replace$default((java.lang.String) r22, (java.lang.String) r23, (java.lang.String) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
        L_0x02ee:
            r6 = r22
            double r9 = r0.b(r6)
            java.lang.String r6 = r0.checknumber_formate(r9)
            java.lang.String r9 = r0.e(r8)
            if (r9 != 0) goto L_0x059b
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = "IMPS"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r18 = r5
            r5 = 0
            r12 = 0
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r5, (int) r13, (java.lang.Object) r12)
            if (r10 != 0) goto L_0x0590
            java.lang.String r10 = "NEFT"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r5, (int) r13, (java.lang.Object) r12)
            if (r10 != 0) goto L_0x0590
            java.lang.String r10 = "UPI"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r5, (int) r13, (java.lang.Object) r12)
            if (r10 != 0) goto L_0x0590
            java.lang.String r10 = "towards"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r5, (int) r13, (java.lang.Object) r12)
            if (r10 != 0) goto L_0x0590
            java.lang.String r10 = " at"
            r19 = r3
            r3 = r10
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r3, (boolean) r5, (int) r13, (java.lang.Object) r12)
            java.lang.String r12 = "this as java.lang.String…ing(startIndex, endIndex)"
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            java.lang.String r13 = "."
            if (r3 == 0) goto L_0x03e0
            java.lang.String[] r23 = new java.lang.String[]{r10}
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            r22 = r9
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r22, (java.lang.String[]) r23, (boolean) r24, (int) r25, (int) r26, (java.lang.Object) r27)
            java.util.Collection r3 = (java.util.Collection) r3
            r9 = 0
            java.lang.String[] r10 = new java.lang.String[r9]
            java.lang.Object[] r3 = r3.toArray(r10)
            java.util.Objects.requireNonNull(r3, r5)
            java.lang.String[] r3 = (java.lang.String[]) r3
            int r5 = r3.length
            r10 = 2
            if (r5 != r10) goto L_0x03d8
            r5 = 1
            r16 = r3[r5]
            r5 = r16
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r29 = r15
            r15 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r13, (boolean) r9, (int) r10, (java.lang.Object) r15)
            if (r5 == 0) goto L_0x0396
            r5 = 1
            r9 = r3[r5]
            r3 = r3[r5]
            r22 = r3
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            java.lang.String r23 = "."
            int r3 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r22, (java.lang.String) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            r5 = 1
            java.lang.String r3 = r9.substring(r5, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
            goto L_0x03a0
        L_0x0396:
            r5 = 1
            r3 = r3[r5]
            java.lang.String r3 = r3.substring(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
        L_0x03a0:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r9 = r3.length()
            int r9 = r9 - r5
            r5 = 0
            r10 = 0
        L_0x03a9:
            if (r10 > r9) goto L_0x03ce
            if (r5 != 0) goto L_0x03af
            r12 = r10
            goto L_0x03b0
        L_0x03af:
            r12 = r9
        L_0x03b0:
            char r12 = r3.charAt(r12)
            r13 = 32
            int r12 = kotlin.jvm.internal.Intrinsics.compare((int) r12, (int) r13)
            if (r12 > 0) goto L_0x03be
            r12 = 1
            goto L_0x03bf
        L_0x03be:
            r12 = 0
        L_0x03bf:
            if (r5 != 0) goto L_0x03c8
            if (r12 != 0) goto L_0x03c5
            r5 = 1
            goto L_0x03a9
        L_0x03c5:
            int r10 = r10 + 1
            goto L_0x03a9
        L_0x03c8:
            if (r12 != 0) goto L_0x03cb
            goto L_0x03ce
        L_0x03cb:
            int r9 = r9 + -1
            goto L_0x03a9
        L_0x03ce:
            int r9 = r9 + 1
            java.lang.CharSequence r3 = r3.subSequence(r10, r9)
            r3.toString()
            goto L_0x03da
        L_0x03d8:
            r29 = r15
        L_0x03da:
            r30 = r1
            r31 = r8
            goto L_0x0598
        L_0x03e0:
            r29 = r15
            java.lang.String r3 = "being"
            r10 = r3
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r30 = r1
            r31 = r8
            r1 = 2
            r8 = 0
            r15 = 0
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r8, (int) r1, (java.lang.Object) r15)
            if (r10 == 0) goto L_0x0487
            java.lang.String[] r23 = new java.lang.String[]{r3}
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            r22 = r9
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r22, (java.lang.String[]) r23, (boolean) r24, (int) r25, (int) r26, (java.lang.Object) r27)
            java.util.Collection r1 = (java.util.Collection) r1
            r3 = 0
            java.lang.String[] r8 = new java.lang.String[r3]
            java.lang.Object[] r1 = r1.toArray(r8)
            java.util.Objects.requireNonNull(r1, r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r5 = r1.length
            r8 = 2
            if (r5 != r8) goto L_0x0598
            r5 = 1
            r9 = r1[r5]
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r10 = 0
            boolean r9 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r13, (boolean) r3, (int) r8, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0445
            r3 = r1[r5]
            r1 = r1[r5]
            r22 = r1
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            java.lang.String r23 = "."
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r22, (java.lang.String) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            r5 = 1
            java.lang.String r1 = r3.substring(r5, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            goto L_0x044e
        L_0x0445:
            r1 = r1[r5]
            java.lang.String r1 = r1.substring(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r14)
        L_0x044e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r3 = r1.length()
            int r3 = r3 - r5
            r5 = 0
            r8 = 0
        L_0x0457:
            if (r8 > r3) goto L_0x047c
            if (r5 != 0) goto L_0x045d
            r9 = r8
            goto L_0x045e
        L_0x045d:
            r9 = r3
        L_0x045e:
            char r9 = r1.charAt(r9)
            r10 = 32
            int r9 = kotlin.jvm.internal.Intrinsics.compare((int) r9, (int) r10)
            if (r9 > 0) goto L_0x046c
            r9 = 1
            goto L_0x046d
        L_0x046c:
            r9 = 0
        L_0x046d:
            if (r5 != 0) goto L_0x0476
            if (r9 != 0) goto L_0x0473
            r5 = 1
            goto L_0x0457
        L_0x0473:
            int r8 = r8 + 1
            goto L_0x0457
        L_0x0476:
            if (r9 != 0) goto L_0x0479
            goto L_0x047c
        L_0x0479:
            int r3 = r3 + -1
            goto L_0x0457
        L_0x047c:
            int r3 = r3 + 1
            java.lang.CharSequence r1 = r1.subSequence(r8, r3)
            r1.toString()
            goto L_0x0598
        L_0x0487:
            java.lang.String r1 = "for"
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8 = 0
            r10 = 2
            r15 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r3, (boolean) r15, (int) r10, (java.lang.Object) r8)
            if (r3 == 0) goto L_0x0528
            java.lang.String[] r23 = new java.lang.String[]{r1}
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            r22 = r9
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r22, (java.lang.String[]) r23, (boolean) r24, (int) r25, (int) r26, (java.lang.Object) r27)
            java.util.Collection r1 = (java.util.Collection) r1
            r3 = 0
            java.lang.String[] r8 = new java.lang.String[r3]
            java.lang.Object[] r1 = r1.toArray(r8)
            java.util.Objects.requireNonNull(r1, r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r5 = r1.length
            r8 = 2
            if (r5 != r8) goto L_0x0598
            r5 = 1
            r9 = r1[r5]
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r10 = 0
            boolean r9 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r13, (boolean) r3, (int) r8, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x04e6
            r3 = r1[r5]
            r1 = r1[r5]
            r22 = r1
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            java.lang.String r23 = "."
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r22, (java.lang.String) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            r5 = 1
            java.lang.String r1 = r3.substring(r5, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            goto L_0x04ef
        L_0x04e6:
            r1 = r1[r5]
            java.lang.String r1 = r1.substring(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r14)
        L_0x04ef:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r3 = r1.length()
            int r3 = r3 - r5
            r5 = 0
            r8 = 0
        L_0x04f8:
            if (r8 > r3) goto L_0x051d
            if (r5 != 0) goto L_0x04fe
            r9 = r8
            goto L_0x04ff
        L_0x04fe:
            r9 = r3
        L_0x04ff:
            char r9 = r1.charAt(r9)
            r10 = 32
            int r9 = kotlin.jvm.internal.Intrinsics.compare((int) r9, (int) r10)
            if (r9 > 0) goto L_0x050d
            r9 = 1
            goto L_0x050e
        L_0x050d:
            r9 = 0
        L_0x050e:
            if (r5 != 0) goto L_0x0517
            if (r9 != 0) goto L_0x0514
            r5 = 1
            goto L_0x04f8
        L_0x0514:
            int r8 = r8 + 1
            goto L_0x04f8
        L_0x0517:
            if (r9 != 0) goto L_0x051a
            goto L_0x051d
        L_0x051a:
            int r3 = r3 + -1
            goto L_0x04f8
        L_0x051d:
            int r3 = r3 + 1
            java.lang.CharSequence r1 = r1.subSequence(r8, r3)
            r1.toString()
            goto L_0x0598
        L_0x0528:
            r1 = 1
            java.lang.String[] r3 = new java.lang.String[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r1 = 0
            r3[r1] = r2
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            r22 = r9
            r23 = r3
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r22, (java.lang.String[]) r23, (boolean) r24, (int) r25, (int) r26, (java.lang.Object) r27)
            java.util.Collection r1 = (java.util.Collection) r1
            r3 = 0
            java.lang.String[] r8 = new java.lang.String[r3]
            java.lang.Object[] r1 = r1.toArray(r8)
            java.util.Objects.requireNonNull(r1, r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r5 = r1.length
            r8 = 2
            if (r5 != r8) goto L_0x0598
            r5 = 1
            r9 = r1[r5]
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10 = r13
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 0
            boolean r9 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r3, (int) r8, (java.lang.Object) r14)
            if (r9 == 0) goto L_0x0581
            r3 = r1[r5]
            r1 = r1[r5]
            r22 = r1
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            java.lang.String r23 = "."
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r22, (java.lang.String) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            r5 = 0
            java.lang.String r1 = r3.substring(r5, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            goto L_0x0584
        L_0x0581:
            r3 = 1
            r1 = r1[r3]
        L_0x0584:
            if (r1 != 0) goto L_0x0589
            r1 = r19
            goto L_0x058d
        L_0x0589:
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r13)
        L_0x058d:
            r17 = r1
            goto L_0x0598
        L_0x0590:
            r30 = r1
            r19 = r3
            r31 = r8
            r29 = r15
        L_0x0598:
            r9 = r17
            goto L_0x05a5
        L_0x059b:
            r30 = r1
            r19 = r3
            r18 = r5
            r31 = r8
            r29 = r15
        L_0x05a5:
            if (r4 == 0) goto L_0x05e8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3 = 0
            r5 = 2
            r8 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) r7, (boolean) r8, (int) r5, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x05c8
            r26 = 0
            r27 = 4
            r28 = 0
            java.lang.String r24 = ","
            java.lang.String r25 = ""
            r23 = r4
            java.lang.String r4 = kotlin.text.StringsKt.replace$default((java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (boolean) r26, (int) r27, (java.lang.Object) r28)
        L_0x05c8:
            double r3 = r0.b(r4)
            java.lang.String r1 = r0.checknumber_formate(r3)
            java.lang.String r3 = "Format==="
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            java.lang.String r4 = "ASD"
            android.util.Log.d(r4, r3)
            r11.set_netbal(r1)
            r11.set_amount(r6)
            r11.set_descr(r9)
        L_0x05e4:
            r3 = r6
            r6 = r9
            goto L_0x065f
        L_0x05e8:
            java.lang.String r1 = r31.toLowerCase()
            r3 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r5 = "bal"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7 = 0
            r8 = 2
            r10 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) r5, (boolean) r10, (int) r8, (java.lang.Object) r7)
            if (r1 != 0) goto L_0x0626
            java.lang.String r1 = r31.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r5 = "balance"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) r5, (boolean) r10, (int) r8, (java.lang.Object) r7)
            if (r1 != 0) goto L_0x0626
            java.lang.String r1 = r31.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r5 = "net"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) r5, (boolean) r10, (int) r8, (java.lang.Object) r7)
            if (r1 == 0) goto L_0x064c
        L_0x0626:
            java.lang.String r1 = r31.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r3 = "netbank"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r10, (int) r8, (java.lang.Object) r7)
            if (r1 != 0) goto L_0x064c
            r1 = r31
            java.lang.String r1 = r0.g(r1)
            if (r1 == 0) goto L_0x0648
            r11.set_amount(r6)
            r11.set_netbal(r1)
            goto L_0x064f
        L_0x0648:
            r11.set_netbal(r6)
            goto L_0x064f
        L_0x064c:
            r11.set_amount(r6)
        L_0x064f:
            r11.set_descr(r9)
            r1 = r4
            goto L_0x05e4
        L_0x0654:
            r19 = r3
            r18 = r5
            r29 = r15
            r6 = r17
            r3 = r22
            r1 = 0
        L_0x065f:
            if (r3 != 0) goto L_0x0663
            if (r1 == 0) goto L_0x0727
        L_0x0663:
            java.lang.String r1 = "NA"
            r15 = r29
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x0727
            r1 = r19
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r1)
            if (r4 != 0) goto L_0x0729
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            java.lang.String r4 = "*"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 0
            r7 = 2
            r8 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r15, (java.lang.CharSequence) r4, (boolean) r8, (int) r7, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0729
            java.lang.String r4 = "#"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r15, (java.lang.CharSequence) r4, (boolean) r8, (int) r7, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0729
            r12 = 0
        L_0x068f:
            java.util.ArrayList<com.bankpassbook.all_bank_balance_check.model.Bankmsg_model> r4 = r0.bankdata_list
            int r4 = r4.size()
            if (r12 < r4) goto L_0x0699
            r12 = 1
            goto L_0x06f7
        L_0x0699:
            java.util.ArrayList<com.bankpassbook.all_bank_balance_check.model.Bankmsg_model> r4 = r0.bankdata_list
            java.lang.Object r4 = r4.get(r12)
            com.bankpassbook.all_bank_balance_check.model.Bankmsg_model r4 = (com.bankpassbook.all_bank_balance_check.model.Bankmsg_model) r4
            java.lang.String r4 = r4.getac_number()
            java.util.ArrayList<com.bankpassbook.all_bank_balance_check.model.Bankmsg_model> r5 = r0.bankdata_list
            java.lang.Object r5 = r5.get(r12)
            com.bankpassbook.all_bank_balance_check.model.Bankmsg_model r5 = (com.bankpassbook.all_bank_balance_check.model.Bankmsg_model) r5
            java.lang.String r5 = r5.get_amount()
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.ArrayList<com.bankpassbook.all_bank_balance_check.model.Bankmsg_model> r8 = r0.bankdata_list
            java.lang.Object r8 = r8.get(r12)
            com.bankpassbook.all_bank_balance_check.model.Bankmsg_model r8 = (com.bankpassbook.all_bank_balance_check.model.Bankmsg_model) r8
            java.util.Date r8 = r8.get_date()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            long r8 = r8.getTime()
            long r13 = r21.getTime()
            long r8 = r8 - r13
            long r7 = r7.toSeconds(r8)
            r9 = 60
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x071c
            r9 = 0
            int r13 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r13 > 0) goto L_0x071c
            if (r3 == 0) goto L_0x071c
            if (r2 == 0) goto L_0x071c
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r15, (boolean) r9, (int) r8, (java.lang.Object) r7)
            if (r10 != 0) goto L_0x06f0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r15, (java.lang.CharSequence) r4, (boolean) r9, (int) r8, (java.lang.Object) r7)
            if (r4 == 0) goto L_0x0719
        L_0x06f0:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0719
            r12 = 0
        L_0x06f7:
            if (r12 == 0) goto L_0x0729
            java.util.ArrayList<com.bankpassbook.all_bank_balance_check.model.Bankmsg_model> r2 = r0.bankdata_list
            r2.add(r11)
            r4 = r20
            r4.add_bankdata(r11)
            java.util.ArrayList<java.lang.String> r2 = r0.bank_name_list
            java.lang.String r3 = r11.get_smsaddress()
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x0734
            java.util.ArrayList<java.lang.String> r2 = r0.bank_name_list
            java.lang.String r3 = r11.get_smsaddress()
            r2.add(r3)
            goto L_0x0734
        L_0x0719:
            r4 = r20
            goto L_0x0721
        L_0x071c:
            r4 = r20
            r7 = 0
            r8 = 2
            r9 = 0
        L_0x0721:
            int r12 = r12 + 1
            r20 = r4
            goto L_0x068f
        L_0x0727:
            r1 = r19
        L_0x0729:
            r4 = r20
            goto L_0x0734
        L_0x072c:
            r4 = r2
            r1 = r3
            r18 = r5
            r17 = r6
            r6 = r17
        L_0x0734:
            r5 = r18
            boolean r2 = r33.moveToNext()
            if (r2 != 0) goto L_0x073d
            goto L_0x0743
        L_0x073d:
            r3 = r1
            r2 = r4
            r1 = r33
            goto L_0x0023
        L_0x0743:
            android.content.SharedPreferences r1 = r0.sharedPreferences
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r2 = "isDbLoaded"
            r3 = 1
            r1.putBoolean(r2, r3)
            r1.apply()
        L_0x0755:
            r32.account_data()
            return
       
            }

package com.yss1.one.models;

import java.util.Date;

import com.yss1.one.util.Utils;

public class Man {
String name;
String family;
String otch;
Date birthDay;
String SNILS;
public String getFormattedBirthday() {
	return Utils.getFormattedDate(birthDay);
}
}

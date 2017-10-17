package com.riontech.calendar.utils;

import java.text.SimpleDateFormat;


/**
 * Created by Dhaval Soneji on 26/1/16.
 */
public class CalendarUtils {
    private static final String TAG = CalendarUtils.class.getSimpleName();
    private static final String CALENDAR_DB_FORMAT = "yyyy-MM-dd";
    private static final String CALENDAR_DATE_FORMAT = "MMM dd yyyy";
    private static final String CALENDAR_MONTH_TITLE_FORMAT = "MMMM yyyy";
    private static final String[] NAMES = {"Risco de Gravidez","Menstruação"};
    private static final String[] NAMES01 = {"Risco de Gravidez","Dia de Ovulação"};
    private static final String[] NAMES1 = {"Risco de Gravidez"};
    private static final String[] NAMES2 = {"Menstruação"};
    private static final String[] EVENTS = {"Baixo", "Medio", "Alto"};
    private static final String[] EVENTS0 = {"Baixo"};
    private static final String[] EVENTS01 = {"Medio"};
    private static final String[] EVENTS02 = {"Alto"};
    private static final String[] EVENTS03 = {"Alto", "Dia de Ovulação"};
    private static final String[] EVENTS1 = {"Baixo", "Dia de Menstruação:"};
    private static final String[] EVENTS2 = {"Baixo", "Dia de Menstruação:"};
    private static final String[] EVENTS3 = {"Alto","Dia de Menstruação:"};
    private static final String[] EVENTS_DESCRIPTION1 = {"O risco é baixo", "1"};
    private static final String[] EVENTS_DESCRIPTION2 = {"O risco é baixo", "2"};
    private static final String[] EVENTS_DESCRIPTION3 = {"O risco é baixo","3"};
    private static final String[] EVENTS_DESCRIPTION4 = {"O risco é baixo","4"};
    private static final String[] EVENTS_DESCRIPTION8 = {"O risco é baixo","5"};
    private static final String[] EVENTS_DESCRIPTION9 = {"O risco é baixo","6"};
    private static final String[] EVENTS_DESCRIPTION10 = {"O risco é baixo","7"};
    private static final String[] EVENTS_DESCRIPTION11 = {"O risco é baixo","8"};
    private static final String[] EVENTS_DESCRIPTION12 = {"O risco é baixo","9"};
    private static final String[] EVENTS_DESCRIPTION13 = {"O risco é baixo","10"};
    private static final String[] EVENTS_DESCRIPTION14 = {"O risco é baixo","11"};
    private static final String[] EVENTS_DESCRIPTION15 = {"O risco é baixo","12"};
    private static final String[] EVENTS_DESCRIPTION5 = {"O risco é médio"};
    private static final String[] EVENTS_DESCRIPTION6 = {"O risco é alto", ""};
    private static final String[] EVENTS_DESCRIPTION7 = {"O risco é baixo", ""};

    public static SimpleDateFormat getCalendarDBFormat() {
        return new SimpleDateFormat(CALENDAR_DB_FORMAT);
    }

    public static SimpleDateFormat getCalendarDateFormat() {
        return new SimpleDateFormat(CALENDAR_DATE_FORMAT);
    }

    public static String getCalendarMonthTitleFormat(){
        return CALENDAR_MONTH_TITLE_FORMAT;
    }

    public static String[] getNAMES() {
        return NAMES;
    }
    public static String[] getNAMES01() {
        return NAMES01;
    }
    public static String[] getNAMES1() {
        return NAMES1;
    }
    public static String[] getNAMES2() {
        return NAMES2;
    }

    public static String[] getEVENTS() {
        return EVENTS;
    }
    public static String[] getEVENTS0() {
        return EVENTS0;
    }
    public static String[] getEVENTS01() {
        return EVENTS01;
    }
    public static String[] getEVENTS02() {
        return EVENTS02;
    }
    public static String[] getEVENTS03() {
        return EVENTS03;
    }
    public static String[] getEVENTS1() {
        return EVENTS1;
    }
    public static String[] getEVENTS2() {
        return EVENTS2;
    }
    public static String[] getEVENTS3() {
        return EVENTS3;
    }


    public static String[] getEventsDescription1() {
        return EVENTS_DESCRIPTION1;
    }
    public static String[] getEventsDescription2() {
        return EVENTS_DESCRIPTION2;
    }
    public static String[] getEventsDescription3() {
        return EVENTS_DESCRIPTION3;
    }
    public static String[] getEventsDescription4() {
        return EVENTS_DESCRIPTION4;
    }
    public static String[] getEventsDescription5() {
        return EVENTS_DESCRIPTION5;
    }
    public static String[] getEventsDescription6() { return EVENTS_DESCRIPTION6; }
    public static String[] getEventsDescription7() { return EVENTS_DESCRIPTION7; }
    public static String[] getEventsDescription8() {
        return EVENTS_DESCRIPTION8;
    }
    public static String[] getEventsDescription9() {
        return EVENTS_DESCRIPTION9;
    }
    public static String[] getEventsDescription10() {return EVENTS_DESCRIPTION10; }
    public static String[] getEventsDescription11() {return EVENTS_DESCRIPTION11; }
    public static String[] getEventsDescription12() {return EVENTS_DESCRIPTION12; }
    public static String[] getEventsDescription13() {return EVENTS_DESCRIPTION13; }
    public static String[] getEventsDescription14() {return EVENTS_DESCRIPTION14; }
    public static String[] getEventsDescription15() {return EVENTS_DESCRIPTION15; }

}

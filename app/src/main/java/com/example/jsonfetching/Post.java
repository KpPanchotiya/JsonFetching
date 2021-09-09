package com.example.jsonfetching;

import java.lang.reflect.Array;

public class Post {
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private String counties;
    private int launchYear;
    private Object types;

    public Post(String date, String localName, String name, String countryCode, boolean fixed, boolean global, String counties, int launchYear, Object types) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.global = global;
        this.counties = counties;
        this.launchYear = launchYear;
        this.types = types;
    }

    public String getDate() {
        return date;
    }

    public String getLocalName() {
        return localName;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isGlobal() {
        return global;
    }

    public String getCounties() {
        return counties;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public Object getTypes() {
        return types;
    }
}

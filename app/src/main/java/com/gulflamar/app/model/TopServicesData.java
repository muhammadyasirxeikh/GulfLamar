package com.gulflamar.app.model;

import java.util.List;

public class TopServicesData {

    String SerName;
    List<SingleServiceData> SerData;

    public TopServicesData(String serName, List<SingleServiceData> serData) {
        SerName = serName;
        SerData = serData;
    }

    public String getSerName() {
        return SerName;
    }

    public void setSerName(String serName) {
        SerName = serName;
    }

    public List<SingleServiceData> getSerData() {
        return SerData;
    }

    public void setSerData(List<SingleServiceData> serData) {
        SerData = serData;
    }
}

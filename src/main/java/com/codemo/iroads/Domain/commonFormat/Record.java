package com.codemo.iroads.Domain.commonFormat;

public class Record {

    private double acceX;

    private double acceY;

    private double acceZ;

    private String acceX_raw;

    private String acceY_raw;

    private String acceZ_raw;

    private String magnetX;

    private String magnetY;

    private String magnetZ;

    private String gyroX;

    private String gyroY;

    private String gyroZ;

    private double gpsSpeed;

    private String lat;

    private String lon;

    private String obdRpm;

    private double obdSpeed;

    private long time;


    public double getAcceX() {
        return acceX;
    }

    public void setAcceX(double acceX) {
        this.acceX = acceX;
    }

    public double getAcceY() {
        return acceY;
    }

    public void setAcceY(double acceY) {
        this.acceY = acceY;
    }

    public double getAcceZ() {
        return acceZ;
    }

    public void setAcceZ(double acceZ) {
        this.acceZ = acceZ;
    }

    public String getAcceX_raw() {
        return acceX_raw;
    }

    public void setAcceX_raw(String  acceX_raw) {
        this.acceX_raw = acceX_raw;
    }

    public String  getAcceY_raw() {
        return acceY_raw;
    }

    public void setAcceY_raw(String acceY_raw) {
        this.acceY_raw = acceY_raw;
    }

    public String getAcceZ_raw() {
        return acceZ_raw;
    }

    public void setAcceZ_raw(String acceZ_raw) {
        this.acceZ_raw = acceZ_raw;
    }

    public String getMagnetX() {
        return magnetX;
    }

    public void setMagnetX(String magnetX) {
        this.magnetX = magnetX;
    }

    public String getMagnetY() {
        return magnetY;
    }

    public void setMagnetY(String magnetY) {
        this.magnetY = magnetY;
    }

    public String getMagnetZ() {
        return magnetZ;
    }

    public void setMagnetZ(String magnetZ) {
        this.magnetZ = magnetZ;
    }

    public String getGyroX() {
        return gyroX;
    }

    public void setGyroX(String gyroX) {
        this.gyroX = gyroX;
    }

    public String getGyroY() {
        return gyroY;
    }

    public void setGyroY(String gyroY) {
        this.gyroY = gyroY;
    }

    public String getGyroZ() {
        return gyroZ;
    }

    public void setGyroZ(String gyroZ) {
        this.gyroZ = gyroZ;
    }

    public double getGpsSpeed() {
        return gpsSpeed;
    }

    public void setGpsSpeed(double gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }




    public String getLat() {
        return lat;
    }

    public void setLat(String  lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getObdRpm() {
        return obdRpm;
    }

    public void setObdRpm(String obdRpm) {
        this.obdRpm = obdRpm;
    }

    public double getObdSpeed() {
        return obdSpeed;
    }

    public void setObdSpeed(double obdSpeed) {
        this.obdSpeed = obdSpeed;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}

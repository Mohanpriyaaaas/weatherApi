package com.example.weather.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weatherdata")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datetimeUtc;   // datetime_utc
    private String conds;                // _conds
    private Double dewptm;               // _dewptm
    private Integer fog;                 // _fog
    private Integer hail;                // _hail
    private Double heatindexm;           // _heatindexm
    private Double hum;                  // _hum
    private Double precipm;              // _precipm
    private Double pressurem;            // _pressurem
    private Integer rain;                // _rain
    private Integer snow;                // _snow
    private Double tempm;                // _tempm
    private Integer thunder;             // _thunder
    private Integer tornado;             // _tornado
    private Double vism;                 // _vism
    private Double wdird;                // _wdird
    private String wdire;                // _wdire
    private Double wgustm;               // _wgustm
    private Double windchillm;           // _windchillm
    private Double wspdm;                // _wspdm


    public Long getId() {
        return id;
    }

    public LocalDateTime getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(LocalDateTime datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public String getConds() {
        return conds;
    }

    public void setConds(String conds) {
        this.conds = conds;
    }

    public Double getDewptm() {
        return dewptm;
    }

    public void setDewptm(Double dewptm) {
        this.dewptm = dewptm;
    }

    public Integer getFog() {
        return fog;
    }

    public void setFog(Integer fog) {
        this.fog = fog;
    }

    public Integer getHail() {
        return hail;
    }

    public void setHail(Integer hail) {
        this.hail = hail;
    }

    public Double getHeatindexm() {
        return heatindexm;
    }

    public void setHeatindexm(Double heatindexm) {
        this.heatindexm = heatindexm;
    }

    public Double getHum() {
        return hum;
    }

    public void setHum(Double hum) {
        this.hum = hum;
    }

    public Double getPrecipm() {
        return precipm;
    }

    public void setPrecipm(Double precipm) {
        this.precipm = precipm;
    }

    public Double getPressurem() {
        return pressurem;
    }

    public void setPressurem(Double pressurem) {
        this.pressurem = pressurem;
    }

    public Integer getRain() {
        return rain;
    }

    public void setRain(Integer rain) {
        this.rain = rain;
    }

    public Integer getSnow() {
        return snow;
    }

    public void setSnow(Integer snow) {
        this.snow = snow;
    }

    public Double getTempm() {
        return tempm;
    }

    public void setTempm(Double tempm) {
        this.tempm = tempm;
    }

    public Integer getThunder() {
        return thunder;
    }

    public void setThunder(Integer thunder) {
        this.thunder = thunder;
    }

    public Integer getTornado() {
        return tornado;
    }

    public void setTornado(Integer tornado) {
        this.tornado = tornado;
    }

    public Double getVism() {
        return vism;
    }

    public void setVism(Double vism) {
        this.vism = vism;
    }

    public Double getWdird() {
        return wdird;
    }

    public void setWdird(Double wdird) {
        this.wdird = wdird;
    }

    public String getWdire() {
        return wdire;
    }

    public void setWdire(String wdire) {
        this.wdire = wdire;
    }

    public Double getWgustm() {
        return wgustm;
    }

    public void setWgustm(Double wgustm) {
        this.wgustm = wgustm;
    }

    public Double getWindchillm() {
        return windchillm;
    }

    public void setWindchillm(Double windchillm) {
        this.windchillm = windchillm;
    }

    public Double getWspdm() {
        return wspdm;
    }

    public void setWspdm(Double wspdm) {
        this.wspdm = wspdm;
    }
}
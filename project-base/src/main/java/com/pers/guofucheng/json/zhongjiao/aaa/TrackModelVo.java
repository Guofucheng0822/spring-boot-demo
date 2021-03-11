package com.pers.guofucheng.json.zhongjiao.aaa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TrackModelVo implements Serializable {
    private static final long serialVersionUID = 1750890374621505616L;
    private Integer vehicleid;
    private Integer carId;
    private Date gpstime;
    private Date createdtime;
    private String wid;
    private Integer itransfer;
    private BigDecimal lon;
    private BigDecimal lat;
    private String trackPlace;
    private Integer direction;
    private Integer speed;
    private BigDecimal odometer;
    private BigDecimal odometerInterval;
    private Integer iaccstatus;
    private Integer ilinestatus;
    private Integer ilostatus;
    private String status;
    private Integer alarmStatus;
    private String alarmStatusStr;
    private String additional;

    public TrackModelVo() {
    }

    public Integer getVehicleid() {
        return this.vehicleid;
    }

    public void setVehicleid(Integer vehicleid) {
        this.vehicleid = vehicleid;
    }

    public Date getGpstime() {
        return this.gpstime;
    }

    public void setGpstime(Date gpstime) {
        this.gpstime = gpstime;
    }

    public Date getCreatedtime() {
        return this.createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getWid() {
        return this.wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public Integer getItransfer() {
        return this.itransfer;
    }

    public void setItransfer(Integer itransfer) {
        this.itransfer = itransfer;
    }

    public BigDecimal getLon() {
        return this.lon;
    }

    public double getLonDoubleValue() {
        return this.lon == null ? 0.0D : this.lon.doubleValue();
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return this.lat;
    }

    public double getLatDoubleValue() {
        return this.lat == null ? 0.0D : this.lat.doubleValue();
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public Integer getDirection() {
        return this.direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getSpeed() {
        return this.speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public BigDecimal getOdometer() {
        return this.odometer;
    }

    public void setOdometer(BigDecimal odometer) {
        this.odometer = odometer;
    }

    public Integer getIaccstatus() {
        return this.iaccstatus;
    }

    public void setIaccstatus(Integer iaccstatus) {
        this.iaccstatus = iaccstatus;
    }

    public Integer getIlinestatus() {
        return this.ilinestatus;
    }

    public void setIlinestatus(Integer ilinestatus) {
        this.ilinestatus = ilinestatus;
    }

    public Integer getIlostatus() {
        return this.ilostatus;
    }

    public void setIlostatus(Integer ilostatus) {
        this.ilostatus = ilostatus;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusStr() {
        StringBuilder result = new StringBuilder();
        if (this.iaccstatus != null && this.iaccstatus != 0) {
            if (this.iaccstatus == 1) {
                result.append(",ACC关");
            } else if (this.iaccstatus == 2) {
                result.append(",ACC开");
            }
        }

        if (this.ilostatus != null && this.ilostatus != 0) {
            if (this.ilostatus == 1) {
                result.append(",1D定位");
            } else if (this.ilostatus == 2) {
                result.append(",2D定位");
            } else if (this.ilostatus == 3) {
                result.append(",3D定位");
            }
        }

        if (this.ilinestatus != null && this.ilinestatus != 0) {
            if (this.ilinestatus == 1) {
                result.append(",天线正常");
            } else if (this.ilinestatus == 2) {
                result.append(",天线断开");
            } else if (this.ilinestatus == 3) {
                result.append(",天线短路");
            } else if (this.ilinestatus == 4) {
                result.append(",天线状态异常");
            }
        }

        if (this.status != null) {
            result.append(",").append(this.status);
        }

        return result != null && result.toString().startsWith(",") ? result.substring(1).replaceAll("重车", "门关").replaceAll("空车", "门开") : "";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCarId() {
        return this.carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public BigDecimal getOdometerInterval() {
        return this.odometerInterval;
    }

    public void setOdometerInterval(BigDecimal odometerInterval) {
        this.odometerInterval = odometerInterval;
    }

    public String getAdditional() {
        return this.additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getTrackPlace() {
        return this.trackPlace;
    }

    public void setTrackPlace(String trackPlace) {
        this.trackPlace = trackPlace;
    }

    public Integer getAlarmStatus() {
        return this.alarmStatus;
    }

    public void setAlarmStatus(Integer alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getAlarmStatusStr() {
        return this.alarmStatusStr;
    }

    public void setAlarmStatusStr(String alarmStatusStr) {
        this.alarmStatusStr = alarmStatusStr;
    }
}

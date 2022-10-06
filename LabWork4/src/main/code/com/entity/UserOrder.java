package main.code.com.entity;

import java.sql.Timestamp;

public class UserOrder implements Identifiable {
    private int id;
    private String status;
    private Timestamp startTime;
    private int leaseDuration;
    private int userId;
    private int apartmentId;


    public UserOrder() {

    }


    public UserOrder(int id, String status, Timestamp startTime, int leaseDuration, int userId, int apartmentId) {
        this.id = id;
        this.status = status;
        this.startTime = startTime;
        this.leaseDuration = leaseDuration;
        this.userId = userId;
        this.apartmentId = apartmentId;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public int getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        UserOrder userOrder = (UserOrder) o;
        return id == userOrder.id &&
                startTime.equals(userOrder.startTime) &&
                leaseDuration == userOrder.leaseDuration &&
                userId == userOrder.userId &&
                apartmentId == userOrder.apartmentId &&
                status.equals(userOrder.status);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +  id;
        result = prime * result + leaseDuration;
        result = prime * result + startTime.hashCode();
        result = prime * result + apartmentId;
        result = prime * result + userId;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("UserOrder{");
        result.append("id=").append(id);
        result.append(", leaseDuration='").append(leaseDuration).append('\'');
        result.append(", startTime=").append(startTime);
        result.append(", apartmentId=").append(apartmentId);
        result.append(", userId=").append(userId);
        result.append(", status='").append(status).append('\'');
        result.append('}');
        return result.toString();
    }
}

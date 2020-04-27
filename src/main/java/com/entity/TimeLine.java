package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Administrator
 */
@Entity
@Table(name = "timeline")
public class TimeLine  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String titleId;

    private String userId;

    private String timeStamp;

    private String content;

    private String managerUser;

    private String manageTime;

    private String title;

    private String type;

    private String status;

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId == null ? null : titleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(String managerUser) {
        this.managerUser = managerUser == null ? null : managerUser.trim();
    }

    public String getManageTime() {
        return manageTime;
    }

    public void setManageTime(String manageTime) {
        this.manageTime = manageTime == null ? null : manageTime.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
package com.lh.authority.model;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 页面权限类
 * @editLog
 */
public class PageItem {
    private String caption;
    private String url;
    private String formPic;
    private String formRemark;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormPic() {
        return formPic;
    }

    public void setFormPic(String formPic) {
        this.formPic = formPic;
    }

    public String getFormRemark() {
        return formRemark;
    }

    public void setFormRemark(String formRemark) {
        this.formRemark = formRemark;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}

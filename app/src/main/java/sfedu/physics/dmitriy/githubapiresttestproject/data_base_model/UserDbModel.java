package sfedu.physics.dmitriy.githubapiresttestproject.data_base_model;

import io.realm.RealmObject;

public class UserDbModel extends RealmObject {

    private String login;


    private String htmlURL;

    private byte[] bitmapData;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }

    public byte[] getBitmapData() {
        return bitmapData;
    }

    public void setBitmapData(byte[] bitmapData) {
        this.bitmapData = bitmapData;
    }
}

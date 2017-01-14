package com.example.sheoran.myproject;

public class Details_Database {

    private int _id;
    private String _uname;
    private String _email;
    private String _password;
    private String _confirm_password;

    public Details_Database(String _confirm_password, String _email, String _password, String _uname) {
        this._confirm_password = _confirm_password;
        this._email = _email;
        this._password = _password;
        this._uname = _uname;
    }

    public Details_Database() {

    }

    public Details_Database(String _uname, String _password) {
        this._uname = _uname;
        this._password = _password;
    }

    public String get_confirm_password() {
        return _confirm_password;
    }

    public void set_confirm_password(String _confirm_password) {
        this._confirm_password = _confirm_password;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_uname() {
        return _uname;
    }

    public void set_uname(String _uname) {
        this._uname = _uname;
    }
}

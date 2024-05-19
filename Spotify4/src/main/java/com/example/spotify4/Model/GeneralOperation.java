package com.example.spotify4.Model;

import java.io.IOException;

public interface GeneralOperation {
    void backTo ();
    void logout ();
    void login ();
    void signup() throws IOException;
    void search() throws IOException;
}

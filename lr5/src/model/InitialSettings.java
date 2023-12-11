package model;

import java.io.File;
import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;

public class InitialSettings {
    public String userName;
    public String password;
    public Boolean root;
    public Boolean log;
    public Boolean autotests;

    public InitialSettings() throws IOException
    {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("initialSettings.txt")));

        userName = props.getProperty("userName");
        password = props.getProperty("password");
        root = Boolean.valueOf(props.getProperty("root", "0"));
        log = Boolean.valueOf(props.getProperty("log", "0"));
        autotests = Boolean.valueOf(props.getProperty("autotest", "0"));
    }
}

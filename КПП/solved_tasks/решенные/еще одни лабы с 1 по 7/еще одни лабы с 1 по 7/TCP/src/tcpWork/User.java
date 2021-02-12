package tcpWork;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {
    private static final DateFormat dateFromatter = new SimpleDateFormat("dd.MM.yyyy");
    private static final DateFormat dateParser = dateFromatter;

    private String name;
    private String surName;
    private String sex;
    private Date birthday;

    public User(String name, String surName, String sex, String birthday){
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        try{
            this.birthday = dateParser.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Error: " + e);
        }
    }
    public User(){
        name = "Thomas";
        surName = "Rhythm";
        sex = "Male";
        try {
            birthday = dateParser.parse("18.09.1998");
        } catch (ParseException e) {
            System.out.println("Error: " + e);
        }
    }


    @Override
    public String toString(){
        return name + " " + surName + " " + sex + " " + dateFromatter.format(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

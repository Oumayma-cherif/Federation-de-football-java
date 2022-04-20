/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.MyDB;

/**
 *
 * @author ksaay
 */
public class ServiceInteraction {
     Connection cnx;

    public ServiceInteraction() {
        cnx = MyDB.getInstance().getConnection();
    }
}

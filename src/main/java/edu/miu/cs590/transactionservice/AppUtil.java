package edu.miu.cs590.transactionservice;

import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtil {
    public static String getCurrentUser(){
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

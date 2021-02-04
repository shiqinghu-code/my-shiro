package com.qing.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ShiroApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ShiroApp.class, args);
    }
}



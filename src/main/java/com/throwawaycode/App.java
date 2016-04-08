package com.throwawaycode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        if (args.length>0) {
            String externalPropsPath = args[0];

            System.setProperty("properties.via.commandline", externalPropsPath);
        }

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.throwawaycode");

        SillyService sillyService = applicationContext.getBean(SillyService.class);

        sillyService.makeStuffHappen();


    }
}

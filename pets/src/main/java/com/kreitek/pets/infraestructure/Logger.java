package com.kreitek.pets.infraestructure;

public class Logger {
    private static volatile Logger instance = null;
    static int contador;

    private Logger(){
        if (instance != null){
            throw new RuntimeException("Use getInstance() to create");
        }
    }

    public static Logger getInstance() {
        if (instance == null){
            synchronized (Logger.class){
                if (instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }


    public void debug(String message){
        contador++;
        System.out.printf("[debug][%d] - %s \n", contador, message);
    }
}

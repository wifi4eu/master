package wifi4eu.config;

public enum Enviroment {

    DEV("dev"),
    LOCAL("local");

    private String path;

    Enviroment(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }


}

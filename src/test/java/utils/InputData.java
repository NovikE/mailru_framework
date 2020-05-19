package utils;

public enum InputData {
    HOMEPAGE_URL("https://mail.ru/"),
    LOGINNAME("at_cdp9"),
    PASSWORD("45admin72"),
    SENDTOADRESS("lena.khalopitsa@gmail.com");

    String personalData;

    InputData(String personalData) {
        this.personalData = personalData;
    }

    public String getPersonalData(){
        return personalData;
    }
}

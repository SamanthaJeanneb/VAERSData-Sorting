public class SYMPTOMDATA extends VAERS {
    public int AGE_YRS;
    public String SEX;
    public String VAX_NAME;
    public String RPT_DATE;
    public String SYMPTOM;
    public String DIED;
    public String DATEDIED;
    public String SYMPTOM_TEXT;

    public SYMPTOMDATA(int VAERS_ID,int AGE_YRS, String SEX, String VAX_NAME, String RPT_DATE, String SYMPTOM, String DIED, String DATEDIED, String SYMPTOM_TEXT) {
        super(VAERS_ID);
        this.AGE_YRS = AGE_YRS;
        this.SEX = SEX;
        this.VAX_NAME = VAX_NAME;
        this.RPT_DATE = RPT_DATE;
        this.SYMPTOM = SYMPTOM;
        this.DIED = DIED;
        this.DATEDIED = DATEDIED;
        this.SYMPTOM_TEXT = SYMPTOM_TEXT;
    }
    public String toCSVString() {
        return VAERS_ID + "," + AGE_YRS + "," + SEX + "," + VAX_NAME + "," + RPT_DATE + "," + SYMPTOM + "," + DIED + "," + DATEDIED + "," + SYMPTOM_TEXT;
    }
    @Override
    public String toString() {
        return "SYMPTOMDATA{" +
                "AGE_YRS=" + AGE_YRS +
                ", SEX='" + SEX + '\'' +
                ", VAX_NAME='" + VAX_NAME + '\'' +
                ", RPT_DATE='" + RPT_DATE + '\'' +
                ", SYMPTOM='" + SYMPTOM + '\'' +
                ", DIED='" + DIED + '\'' +
                ", DATEDIED='" + DATEDIED + '\'' +
                '}';
    }
    public String getAgeGroup() {
        int age = this.AGE_YRS;

        if (age < 1) return "<1";
        else if (age <= 3) return "1-3";
        else if (age <= 11) return "4-11";
        else if (age <= 18) return "12-18";
        else if (age <= 30) return "19-30";
        else if (age <= 40) return "31-40";
        else if (age <= 50) return "41-50";
        else if (age <= 60) return "51-60";
        else if (age <= 70) return "61-70";
        else if (age <= 80) return "71-80";
        else return ">80";
    }


    public String getSEX() {
        return SEX;
    }

    public String getVAX_NAME() {
        return VAX_NAME;
    }

    public String getSYMPTOM() {
        return SYMPTOM;
    }

    public String getDIED() {
        return DIED;
    }
}

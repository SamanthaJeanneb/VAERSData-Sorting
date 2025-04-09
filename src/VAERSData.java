import javax.xml.crypto.Data;

public class VAERSData extends VAERS {
    public String RECVDATE;
    public String STATE;
    public double AGE_YRS;
    public String CAGE_YR;
    public String CAGE_MO;
    public String SEX;
    public String RPT_DATE;
    public String SYMPTOM_TEXT;
    public String DIED;
    public String DATEDIED;
    public String L_THREAT;
    public String ER_VISIT;
    public String HOSPITAL;
    public String HOSPDAYS;
    public String X_STAY;
    public String DISABLE;
    public String RECOVD;
    public String VAX_DATE;
    public String ONSET_DATE;
    public String NUMDAYS;
    public String LAB_DATA;
    public String V_ADMINBY;
    public String V_FUNDBY;
    public String OTHER_MEDS;
    public String CUR_ILL;
    public String HISTORY;
    public String PRIOR_VAX;
    public String SPLTTYPE;
    public String FORM_VERS;
    public String TODAYS_DATE;
    public String BIRTH_DEFECT;
    public String OFC_VISIT;
    public String ER_ED_VISIT;
    public String ALLERGIES;

    public VAERSData(int VAERS_ID,String RECVDATE, String STATE, double AGE_YRS, String CAGE_YR, String CAGE_MO,
                     String SEX, String RPT_DATE, String SYMPTOM_TEXT, String DIED, String DATEDIED,
                     String L_THREAT, String ER_VISIT, String HOSPITAL, String HOSPDAYS, String X_STAY,
                     String DISABLE, String RECOVD, String VAX_DATE, String ONSET_DATE, String NUMDAYS,
                     String LAB_DATA, String V_ADMINBY, String V_FUNDBY, String OTHER_MEDS, String CUR_ILL,
                     String HISTORY, String PRIOR_VAX, String SPLTTYPE, String FORM_VERS, String TODAYS_DATE,
                     String BIRTH_DEFECT, String OFC_VISIT, String ER_ED_VISIT, String ALLERGIES) {
        super(VAERS_ID);
        this.RECVDATE = RECVDATE;
        this.STATE = STATE;
        this.AGE_YRS = AGE_YRS;
        this.CAGE_YR = CAGE_YR;
        this.CAGE_MO = CAGE_MO;
        this.SEX = SEX;
        this.RPT_DATE = RPT_DATE;
        this.SYMPTOM_TEXT = SYMPTOM_TEXT;
        this.DIED = DIED;
        this.DATEDIED = DATEDIED;
        this.L_THREAT = L_THREAT;
        this.ER_VISIT = ER_VISIT;
        this.HOSPITAL = HOSPITAL;
        this.HOSPDAYS = HOSPDAYS;
        this.X_STAY = X_STAY;
        this.DISABLE = DISABLE;
        this.RECOVD = RECOVD;
        this.VAX_DATE = VAX_DATE;
        this.ONSET_DATE = ONSET_DATE;
        this.NUMDAYS = NUMDAYS;
        this.LAB_DATA = LAB_DATA;
        this.V_ADMINBY = V_ADMINBY;
        this.V_FUNDBY = V_FUNDBY;
        this.OTHER_MEDS = OTHER_MEDS;
        this.CUR_ILL = CUR_ILL;
        this.HISTORY = HISTORY;
        this.PRIOR_VAX = PRIOR_VAX;
        this.SPLTTYPE = SPLTTYPE;
        this.FORM_VERS = FORM_VERS;
        this.TODAYS_DATE = TODAYS_DATE;
        this.BIRTH_DEFECT = BIRTH_DEFECT;
        this.OFC_VISIT = OFC_VISIT;
        this.ER_ED_VISIT = ER_ED_VISIT;
        this.ALLERGIES = ALLERGIES;
    }


    @Override
    public String toString() {
        return "VAERSData{" +
                "RECVDATE='" + RECVDATE + '\'' +
                ", STATE='" + STATE + '\'' +
                ", AGE_YRS=" + AGE_YRS +
                ", CAGE_YR=" + CAGE_YR +
                ", CAGE_MO='" + CAGE_MO + '\'' +
                ", SEX='" + SEX + '\'' +
                ", RPT_DATE='" + RPT_DATE + '\'' +
                ", SYMPTOM_TEXT='" + SYMPTOM_TEXT + '\'' +
                ", DIED='" + DIED + '\'' +
                ", DATEDIED='" + DATEDIED + '\'' +
                ", L_THREAT='" + L_THREAT + '\'' +
                ", ER_VISIT='" + ER_VISIT + '\'' +
                ", HOSPITAL='" + HOSPITAL + '\'' +
                ", HOSPDAYS='" + HOSPDAYS + '\'' +
                ", X_STAY='" + X_STAY + '\'' +
                ", DISABLE='" + DISABLE + '\'' +
                ", RECOVD='" + RECOVD + '\'' +
                ", VAX_DATE='" + VAX_DATE + '\'' +
                ", ONSET_DATE='" + ONSET_DATE + '\'' +
                ", NUMDAYS=" + NUMDAYS +
                ", LAB_DATA='" + LAB_DATA + '\'' +
                ", V_ADMINBY='" + V_ADMINBY + '\'' +
                ", V_FUNDBY='" + V_FUNDBY + '\'' +
                ", OTHER_MEDS='" + OTHER_MEDS + '\'' +
                ", CUR_ILL='" + CUR_ILL + '\'' +
                ", HISTORY='" + HISTORY + '\'' +
                ", PRIOR_VAX='" + PRIOR_VAX + '\'' +
                ", SPLTTYPE='" + SPLTTYPE + '\'' +
                ", FORM_VERS='" + FORM_VERS + '\'' +
                ", TODAYS_DATE='" + TODAYS_DATE + '\'' +
                ", BIRTH_DEFECT='" + BIRTH_DEFECT + '\'' +
                ", OFC_VISIT='" + OFC_VISIT + '\'' +
                ", ER_ED_VISIT='" + ER_ED_VISIT + '\'' +
                ", ALLERGIES='" + ALLERGIES + '\'' +
                '}';
    }
    public String toCSVString() {
        return RECVDATE + "," + STATE + "," + AGE_YRS + "," + CAGE_YR + "," + CAGE_MO + "," +
                SEX + "," + RPT_DATE + "," + SYMPTOM_TEXT + "," + DIED + "," + DATEDIED + "," +
                L_THREAT + "," + ER_VISIT + "," + HOSPITAL + "," + HOSPDAYS + "," + X_STAY + "," +
                DISABLE + "," + RECOVD + "," + VAX_DATE + "," + ONSET_DATE + "," + NUMDAYS + "," +
                LAB_DATA + "," + V_ADMINBY + "," + V_FUNDBY + "," + OTHER_MEDS + "," + CUR_ILL + "," +
                HISTORY + "," + PRIOR_VAX + "," + SPLTTYPE + "," + FORM_VERS + "," + TODAYS_DATE + "," +
                BIRTH_DEFECT + "," + OFC_VISIT + "," + ER_ED_VISIT + "," + ALLERGIES;
    }

}

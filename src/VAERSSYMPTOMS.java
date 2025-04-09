public class VAERSSYMPTOMS extends VAERS {
    public String SYMPTOM1;
    public String SYMPTOM2;
    public String SYMPTOM3;
    public String SYMPTOM4;
    public String SYMPTOM5;
    public String SYMPTOMVERSION;
    public String SYMPTOMVERSION2;
    public String SYMPTOMVERSION3;
    public String SYMPTOMVERSION4;
    public String SYMPTOMVERSION5;

    public VAERSSYMPTOMS(int VAERS_ID,String SYMPTOM1, String SYMPTOM2, String SYMPTOM3,
                         String SYMPTOM4, String SYMPTOM5, String SYMPTOMVERSION,
                         String SYMPTOMVERSION2, String SYMPTOMVERSION3,
                         String SYMPTOMVERSION4, String SYMPTOMVERSION5) {
        super(VAERS_ID);
        this.SYMPTOM1 = SYMPTOM1;
        this.SYMPTOM2 = SYMPTOM2;
        this.SYMPTOM3 = SYMPTOM3;
        this.SYMPTOM4 = SYMPTOM4;
        this.SYMPTOM5 = SYMPTOM5;
        this.SYMPTOMVERSION = SYMPTOMVERSION;
        this.SYMPTOMVERSION2 = SYMPTOMVERSION2;
        this.SYMPTOMVERSION3 = SYMPTOMVERSION3;
        this.SYMPTOMVERSION4 = SYMPTOMVERSION4;
        this.SYMPTOMVERSION5 = SYMPTOMVERSION5;
    }
    public String toCSVString() {
        return (SYMPTOM1 != null ? SYMPTOM1 : "") + "," +
                (SYMPTOM2 != null ? SYMPTOM2 : "") + "," +
                (SYMPTOM3 != null ? SYMPTOM3 : "") + "," +
                (SYMPTOM4 != null ? SYMPTOM4 : "") + "," +
                (SYMPTOM5 != null ? SYMPTOM5 : "") + "," +
                (SYMPTOMVERSION != null ? SYMPTOMVERSION : "") + "," +
                (SYMPTOMVERSION2 != null ? SYMPTOMVERSION2 : "") + "," +
                (SYMPTOMVERSION3 != null ? SYMPTOMVERSION3 : "") + "," +
                (SYMPTOMVERSION4 != null ? SYMPTOMVERSION4 : "") + "," +
                (SYMPTOMVERSION5 != null ? SYMPTOMVERSION5 : "");
    }
    @Override
    public String toString() {
        return "VAERSSYMPTOMS{" +
                "SYMPTOM1='" + SYMPTOM1 + '\'' +
                ", SYMPTOM2='" + SYMPTOM2 + '\'' +
                ", SYMPTOM3='" + SYMPTOM3 + '\'' +
                ", SYMPTOM4='" + SYMPTOM4 + '\'' +
                ", SYMPTOM5='" + SYMPTOM5 + '\'' +
                ", SYMPTOMVERSION='" + SYMPTOMVERSION + '\'' +
                ", SYMPTOMVERSION2='" + SYMPTOMVERSION2 + '\'' +
                ", SYMPTOMVERSION3='" + SYMPTOMVERSION3 + '\'' +
                ", SYMPTOMVERSION4='" + SYMPTOMVERSION4 + '\'' +
                ", SYMPTOMVERSION5='" + SYMPTOMVERSION5 + '\'' +
                '}';
    }
}

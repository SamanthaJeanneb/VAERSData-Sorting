public class VAERSVAX extends VAERS {
    public String VAX_TYPE;
    public String VAX_MANU;
    public String VAX_LOT;
    public String VAX_DOSE_SERIES;
    public String VAX_ROUTE;
    public String VAX_SITE;
    public String VAX_NAME;

    public VAERSVAX(int VAERS_ID, String VAX_TYPE, String VAX_MANU, String VAX_LOT,
                    String VAX_DOSE_SERIES, String VAX_ROUTE,
                    String VAX_SITE, String VAX_NAME) {
        super(VAERS_ID);
        this.VAX_TYPE = VAX_TYPE;
        this.VAX_MANU = VAX_MANU;
        this.VAX_LOT = VAX_LOT;
        this.VAX_DOSE_SERIES = VAX_DOSE_SERIES;
        this.VAX_ROUTE = VAX_ROUTE;
        this.VAX_SITE = VAX_SITE;
        this.VAX_NAME = VAX_NAME;
    }

    public String toCSVString() {
        return (VAX_TYPE != null ? VAX_TYPE : "") + "," +
                (VAX_MANU != null ? VAX_MANU : "") + "," +
                (VAX_LOT != null ? VAX_LOT : "") + "," +
                (VAX_DOSE_SERIES != null ? VAX_DOSE_SERIES : "") + "," +
                (VAX_ROUTE != null ? VAX_ROUTE : "") + "," +
                (VAX_SITE != null ? VAX_SITE : "") + "," +
                (VAX_NAME != null ? VAX_NAME : "");
    }
    @Override
    public String toString() {
        return "VAERSVAX{" +
                "VAERS_ID=" + VAERS_ID +
                ", VAX_TYPE='" + VAX_TYPE + '\'' +
                ", VAX_MANU='" + VAX_MANU + '\'' +
                ", VAX_LOT='" + VAX_LOT + '\'' +
                ", VAX_DOSE_SERIES='" + VAX_DOSE_SERIES + '\'' +
                ", VAX_ROUTE='" + VAX_ROUTE + '\'' +
                ", VAX_SITE='" + VAX_SITE + '\'' +
                ", VAX_NAME='" + VAX_NAME + '\'' +
                '}';
    }
}

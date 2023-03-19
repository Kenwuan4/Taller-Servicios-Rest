package javeriana.ms.rest.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip implements java.io.Serializable {

    private String id;
    private String name;
    private String startSite;
    private String finishSite;
    private String date;

    public Trip() {

    }

    public Trip(String id, String name, String startSite, String finishSite, String date) {
        this.id = id;
        this.name = name;
        this.startSite = startSite;
        this.finishSite = finishSite;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartSite() {
        return startSite;
    }

    public void setStartSite(String startSite) {
        this.startSite = startSite;
    }

    public String getFinishSite() {
        return finishSite;
    }

    public void setFinishSite(String finishSite) {
        this.finishSite = finishSite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

}

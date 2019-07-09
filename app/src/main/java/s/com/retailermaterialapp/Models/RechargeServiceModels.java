package s.com.retailermaterialapp.Models;

public class RechargeServiceModels {

    public String id;
    public String name;
    public int logo;

    public RechargeServiceModels() {
    }

    public RechargeServiceModels(String id, String name, int logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
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

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

}

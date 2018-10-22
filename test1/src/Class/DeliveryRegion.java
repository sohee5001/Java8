package Class;

import java.util.List;
import Class.Apple;

public class DeliveryRegion {

    String regionName;
    String postNumber;

    List<Apple> appleList;

    public String getPostNumber() {
        return postNumber;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<Apple> getAppleList() {
        return appleList;
    }

    public void setAppleList(List<Apple> appleList) {
        this.appleList = appleList;
    }
}

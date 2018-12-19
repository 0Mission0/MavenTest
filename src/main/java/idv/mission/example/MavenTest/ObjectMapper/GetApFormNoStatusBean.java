package idv.mission.example.MavenTest.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * "STATUS": "0000",
 * "DATA": [
 * {
 *   "isCancel": "Y",
 *   "tableType": "SCHANGE"
 * }
 */
public class GetApFormNoStatusBean {

    @JsonProperty("STATUS")
    private String status;

    @JsonProperty("tableType")
    private String tableType;

    @JsonProperty("isCancel")
    private String isCancel;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        return json;
    }

}
package capstone.videochat.DTO;

public class SelectRoomDTO {

    private String selectId;
    private String uuid;

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectedId) {
        this.selectId = selectedId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

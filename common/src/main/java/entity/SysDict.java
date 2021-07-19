package entity;

/**
 * @Description : TODO
 * @Author : lixiunan
 * @Date : 2021/7/19
 **/
public class SysDict {
    private Long dictId;
    private String status;
    private String value;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

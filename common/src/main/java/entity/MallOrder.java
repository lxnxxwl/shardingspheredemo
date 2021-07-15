package entity;

/**
 * @Description : TODO
 * @Author : lixiunan
 * @Date : 2021/7/14
 **/
public class MallOrder {
    private Long id;
    private String orderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}

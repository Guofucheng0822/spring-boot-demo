package com.pers.guofucheng.pojo;

/**
 * 用户卡片
 *
 * @author guofucheng
 * @date 2020/08/25
 */
public class UserCard {
    /**
     * 主键id
     */
    private int cardId;
    /**
     * 卡的名字
     */
    private String cardName;
    /**
     * 卡年龄
     */
    private int cardUage;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardUage() {
        return cardUage;
    }

    public void setCardUage(int cardUage) {
        this.cardUage = cardUage;
    }

    @Override
    public String toString() {
        return "UserCard{" +
                "cardId=" + cardId +
                ", cardName=" + cardName +
                ", cardUage=" + cardUage +
                '}';
    }
}

package com.ps.gfc.model;

public class ReceiveMessage {
    /**
     * 开发者微信号
     */
    private String toUserName;
    /**
     * 发送方账号(一个openid）
     */
    private String fromUserName;
    /**
     * 消息创建时间（整形）
     */
    private String createTime;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 文本消息内容
     */
    private String content;
    /**
     * 消息ID 64位
     */
    String msgId;
    /**
     * 消息的数据ID 消息来自文章才有
     */
    private String msgDataId;
    /**
     * 多图文时第几篇文章，从1开始 消息如果来自文章才有
     */
    private String idx;
    /**
     * 订阅事件 subscribe 订阅 unsbscribe 取消订阅
     */
    private String event;
    /**
     * 扫码 - ticket
     */
    private String ticket;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(String msgDataId) {
        this.msgDataId = msgDataId;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getReplyTextMsg(String msg) {
        String xml = "<xml>\n"
            + "       <ToUserName><![CDATA[" + getFromUserName() + "]]></ToUserName>\n"
            + "       <FromUserName><![CDATA[" + getToUserName() + "]]></FromUserName>\n"
            + "       <CreateTime>" + System.currentTimeMillis() + "</CreateTime>\n"
            + "       <MsgType><![CDATA[text]]></MsgType>\n"
            + "       <Content><![CDATA[" + msg + "]]></Content>\n"
            + "     </xml>";
        return xml;
    }
}
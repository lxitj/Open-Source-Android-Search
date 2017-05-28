package com.xuzhihui.picsart.bean;


import org.android10.gintonic.annotation.DebugTrace;

/**
 * Created by Jav-Xu on 16/9/4.
 */
public class Image {

    private String name;
    private String time;
    private String url;
    @DebugTrace
    public String getName() {
        return name;
    }
    @DebugTrace
    public void setName(String name) {
        this.name = name;
    }
    @DebugTrace
    public String getTime() {
        return time;
    }
    @DebugTrace
    public void setTime(String time) {
        this.time = time;
    }
    @DebugTrace
    public String getUrl() {
        return url;
    }
    @DebugTrace
    public void setUrl(String url) {
        this.url = url;
    }
}

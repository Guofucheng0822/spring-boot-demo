package com.pers.guofucheng.adapterPattern;

/**
 * 先进的媒体播放器[ vlc 和 mp4 ]
 *
 * @author guofucheng
 * @date 2020/08/06
 */
public interface AdvancedMediaPlayer {
    /**
     * 播放vlc
     *
     * @param fileName 文件名称
     */
    public void playVlc(String fileName);

    /**
     * 播放Mp4
     *
     * @param fileName 文件名称
     */
    public void playMp4(String fileName);
}

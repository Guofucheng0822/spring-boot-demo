package com.pers.guofucheng.adapterPattern;

/**
 * 媒体播放器接口【MP3】
 *
 * @author guofucheng
 * @date 2020/08/06
 */
public interface MediaPlayer {
    /**
     * 播放mp3
     *
     * @param audioType 音频类型
     * @param fileName  文件名称
     */
    void play(String audioType, String fileName);
}

package com.pers.guofucheng.adapterPattern;

/**
 * Vlc播放器
 *
 * @author guofucheng
 * @date 2020/08/06
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("播放vlc格式的fileName: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}

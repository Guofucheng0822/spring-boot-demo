package com.pers.guofucheng.adapterPattern;

/**
 * Mp4播放器
 *
 * @author guofucheng
 * @date 2020/08/06
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

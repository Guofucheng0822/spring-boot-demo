package com.pers.guofucheng.config;

import com.sun.org.apache.bcel.internal.ExceptionConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * SSHHelper
 *
 * @author guofucheng
 * @date 2021/07/13
 */
public class SSHHelper {

    /**
     * 在单独的进程中执行指定的字符串命令。
     *
     * @param command 命令
     */
    public void exec(String command){
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(command);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("执行命令:["+command+"]结果:" + sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 在单独的进程中执行指定命令和变量。
     *
     * @param cmdArray 命令
     */
    public void exec(String [] cmdArray){
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(cmdArray);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("执行命令:["+ Arrays.toString(cmdArray) +"]结果:" + sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

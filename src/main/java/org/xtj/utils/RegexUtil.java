package org.xtj.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegexUtil {

    /**
     * /c?c=0&a=2&p=1&v=1&ci=2188&cp=4674&u=1001388098&f=1%2F6.8.9&t=1623151203&s=1&i=54335&n=193.087&b=0&e=68%2F0&d=0&br=0.26666668
     * => 54335
     */
    public static Integer findRegx(String str){

        Pattern p = Pattern.compile( "i=([\\s\\S]*?)&");

        Matcher m = p.matcher(str);

        String s = "";

        while (m.find())
            s = m.group(0).replace("&","").replace("i","").replace("=","");

        return Integer.parseInt(s);

    }

    /**
     * 获取用户id
     * @param str
     * @return
     */
    public static Integer findUserId(String str){
        Pattern p = Pattern.compile( "u=([\\s\\S]*?)&");
        Matcher m = p.matcher(str);

        String s = "";

        while (m.find())
            s = m.group(0).replace("&","").replace("u","").replace("=","");

        return Integer.parseInt(s);

    }

    public static Float findPlaytime(String str){
        Pattern p = Pattern.compile( "n=([\\s\\S]*?)&");
        Matcher m = p.matcher(str);

        String s = "";

        while (m.find())
            s = m.group(0).replace("&","").replace("n","").replace("=","");

        return Float.parseFloat(s);
    }


    public static void main(String[] args) {

        String s = "/c?a=2&b=0&br=0.4029135&c=0&d=0&e=38f/0&f=3/2.2.0&i=54335&n=0&p=6&s=1&t=1623151259&u=17619&v=1";
        System.out.println(findPlaytime(s));

    }

}

package me.cheonhwa.bookyouthspace.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;


@NoArgsConstructor
@Getter
@Setter
public class MunGongContent {
    //TODO: 이름 바꾸기 ex_ contentAdapter
    public boolean [] contents;

    {
        contents=new boolean[8];
    }


    public String getContentsToCode(){
        String code="";

        for (boolean content : contents) {
            if(content) code +="1";
            else code += "0";
        }
        return code;
    }


    public String getContentNamesToLine() {
        String contentName="";
        if(contents[0]) contentName +="컴퓨터,";
        if(contents[1]) contentName +="포켓볼,";
        if(contents[2]) contentName +="탁구,";
        if(contents[3]) contentName +="보드게임,";
        if(contents[4]) contentName +="휴식공간,";
        if(contents[5]) contentName +="포토존,";
        if(contents[6]) contentName +="PS4,";
        if(contents[7]) contentName +="오락기,";

        return contentName.substring(0,contentName.length()-2); //마지막 쉼표 제거
    }

    public static String[] getContentNamesToList(){
        return new String[]{"컴퓨터" ,"포켓볼", "탁구","보드게임","휴식공간","포토존","PS4","오락기"};
    }
     public void setContentsUsingCode(String contentCode){
         for (int i = 0; i < contentCode.length(); i++)
             contents[i] = contentCode.charAt(i) == '1';

     }
}

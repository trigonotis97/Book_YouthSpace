package me.cheonhwa.bookyouthspace.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Arrays;


@NoArgsConstructor
public class MunGongContent {

    private boolean [] contents = new boolean[6];

    /*
    private boolean computer;

    private boolean pocketBall;

    private boolean pingpong;

    private boolean boardgame;

    private boolean restArea;

    private boolean photoZone;



    @Override
    public String toString() {
        return "MunGongContent{" +
                "computer=" + computer +
                ", pocketBall=" + pocketBall +
                ", pingpong=" + pingpong +
                ", boardgame=" + boardgame +
                ", restArea=" + restArea +
                ", photoZone=" + photoZone +
                '}';
    }
         */
    public String toCode(){
        String code="";

        for (boolean content : contents) {
            if(content) code +="1";
            else code += "0";
        }
        return code;
    }


    public String getContentToName() {
        String contentName="";
        if(contents[0]) contentName +="컴퓨터,";
        if(contents[1]) contentName +="당구,";
        if(contents[2]) contentName +="탁구,";
        if(contents[3]) contentName +="보드게임,";
        if(contents[4]) contentName +="휴식공간,";
        if(contents[5]) contentName +="포토존,";

        return contentName.substring(0,contentName.length()-2); //마지막 쉼표 제거
    }
    public MunGongContent(String contentCode){
        
    }
}
